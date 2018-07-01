package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

public class LazyMap extends AbstractMapDecorator implements Serializable {
   private static final long serialVersionUID = 7990956402564206740L;
   protected final Transformer factory;

   public static LazyMap lazyMap(Map map, Factory factory) {
      return new LazyMap(map, factory);
   }

   public static LazyMap lazyMap(Map map, Transformer factory) {
      return new LazyMap(map, factory);
   }

   protected LazyMap(Map map, Factory factory) {
      super(map);
      if (factory == null) {
         throw new NullPointerException("Factory must not be null");
      } else {
         this.factory = FactoryTransformer.factoryTransformer(factory);
      }
   }

   protected LazyMap(Map map, Transformer factory) {
      super(map);
      if (factory == null) {
         throw new NullPointerException("Factory must not be null");
      } else {
         this.factory = factory;
      }
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.map);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.map = (Map)in.readObject();
   }

   public Object get(Object key) {
      if (!this.map.containsKey(key)) {
         Object value = this.factory.transform(key);
         this.map.put(key, value);
         return value;
      } else {
         return this.map.get(key);
      }
   }
}
