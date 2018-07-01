package org.apache.commons.collections4.splitmap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.Put;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.LinkedMap;

public class TransformedSplitMap extends AbstractIterableGetMapDecorator implements Put, Serializable {
   private static final long serialVersionUID = 5966875321133456994L;
   private final Transformer keyTransformer;
   private final Transformer valueTransformer;

   public static TransformedSplitMap transformingMap(Map map, Transformer keyTransformer, Transformer valueTransformer) {
      return new TransformedSplitMap(map, keyTransformer, valueTransformer);
   }

   protected TransformedSplitMap(Map map, Transformer keyTransformer, Transformer valueTransformer) {
      super(map);
      if (keyTransformer == null) {
         throw new NullPointerException("KeyTransformer must not be null.");
      } else {
         this.keyTransformer = keyTransformer;
         if (valueTransformer == null) {
            throw new NullPointerException("ValueTransformer must not be null.");
         } else {
            this.valueTransformer = valueTransformer;
         }
      }
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.decorated());
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.map = (Map)in.readObject();
   }

   protected Object transformKey(Object object) {
      return this.keyTransformer.transform(object);
   }

   protected Object transformValue(Object object) {
      return this.valueTransformer.transform(object);
   }

   protected Map transformMap(Map map) {
      if (map.isEmpty()) {
         return map;
      } else {
         Map result = new LinkedMap(map.size());
         Iterator i$ = map.entrySet().iterator();

         while(i$.hasNext()) {
            Entry entry = (Entry)i$.next();
            result.put(this.transformKey(entry.getKey()), this.transformValue(entry.getValue()));
         }

         return result;
      }
   }

   protected Object checkSetValue(Object value) {
      return this.valueTransformer.transform(value);
   }

   public Object put(Object key, Object value) {
      return this.decorated().put(this.transformKey(key), this.transformValue(value));
   }

   public void putAll(Map mapToCopy) {
      this.decorated().putAll(this.transformMap(mapToCopy));
   }

   public void clear() {
      this.decorated().clear();
   }
}
