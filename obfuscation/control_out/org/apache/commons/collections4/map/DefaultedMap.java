package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

public class DefaultedMap extends AbstractMapDecorator implements Serializable {
   private static final long serialVersionUID = 19698628745827L;
   private final Transformer value;

   public static DefaultedMap defaultedMap(Map map, Object defaultValue) {
      return new DefaultedMap(map, ConstantTransformer.constantTransformer(defaultValue));
   }

   public static DefaultedMap defaultedMap(Map map, Factory factory) {
      if (factory == null) {
         throw new IllegalArgumentException("Factory must not be null");
      } else {
         return new DefaultedMap(map, FactoryTransformer.factoryTransformer(factory));
      }
   }

   public static Map defaultedMap(Map map, Transformer transformer) {
      if (transformer == null) {
         throw new IllegalArgumentException("Transformer must not be null");
      } else {
         return new DefaultedMap(map, transformer);
      }
   }

   public DefaultedMap(Object defaultValue) {
      this(ConstantTransformer.constantTransformer(defaultValue));
   }

   public DefaultedMap(Transformer defaultValueTransformer) {
      this(new HashMap(), defaultValueTransformer);
   }

   protected DefaultedMap(Map map, Transformer defaultValueTransformer) {
      super(map);
      if (defaultValueTransformer == null) {
         throw new NullPointerException("Transformer must not be null.");
      } else {
         this.value = defaultValueTransformer;
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
      return !this.map.containsKey(key) ? this.value.transform(key) : this.map.get(key);
   }
}
