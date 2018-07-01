package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.Transformer;

public class TransformedMap extends AbstractInputCheckedMapDecorator implements Serializable {
   private static final long serialVersionUID = 7023152376788900464L;
   protected final Transformer keyTransformer;
   protected final Transformer valueTransformer;

   public static TransformedMap transformingMap(Map map, Transformer keyTransformer, Transformer valueTransformer) {
      return new TransformedMap(map, keyTransformer, valueTransformer);
   }

   public static TransformedMap transformedMap(Map map, Transformer keyTransformer, Transformer valueTransformer) {
      TransformedMap decorated = new TransformedMap(map, keyTransformer, valueTransformer);
      if (map.size() > 0) {
         Map transformed = decorated.transformMap(map);
         decorated.clear();
         decorated.decorated().putAll(transformed);
      }

      return decorated;
   }

   protected TransformedMap(Map map, Transformer keyTransformer, Transformer valueTransformer) {
      super(map);
      this.keyTransformer = keyTransformer;
      this.valueTransformer = valueTransformer;
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.map);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.map = (Map)in.readObject();
   }

   protected Object transformKey(Object object) {
      return this.keyTransformer == null ? object : this.keyTransformer.transform(object);
   }

   protected Object transformValue(Object object) {
      return this.valueTransformer == null ? object : this.valueTransformer.transform(object);
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

   protected boolean isSetValueChecking() {
      return this.valueTransformer != null;
   }

   public Object put(Object key, Object value) {
      key = this.transformKey(key);
      value = this.transformValue(value);
      return this.decorated().put(key, value);
   }

   public void putAll(Map mapToCopy) {
      mapToCopy = this.transformMap(mapToCopy);
      this.decorated().putAll(mapToCopy);
   }
}
