package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.Predicate;

public class PredicatedMap extends AbstractInputCheckedMapDecorator implements Serializable {
   private static final long serialVersionUID = 7412622456128415156L;
   protected final Predicate keyPredicate;
   protected final Predicate valuePredicate;

   public static PredicatedMap predicatedMap(Map map, Predicate keyPredicate, Predicate valuePredicate) {
      return new PredicatedMap(map, keyPredicate, valuePredicate);
   }

   protected PredicatedMap(Map map, Predicate keyPredicate, Predicate valuePredicate) {
      super(map);
      this.keyPredicate = keyPredicate;
      this.valuePredicate = valuePredicate;
      Iterator it = map.entrySet().iterator();

      while(it.hasNext()) {
         Entry entry = (Entry)it.next();
         this.validate(entry.getKey(), entry.getValue());
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

   protected void validate(Object key, Object value) {
      if (this.keyPredicate != null && !this.keyPredicate.evaluate(key)) {
         throw new IllegalArgumentException("Cannot add key - Predicate rejected it");
      } else if (this.valuePredicate != null && !this.valuePredicate.evaluate(value)) {
         throw new IllegalArgumentException("Cannot add value - Predicate rejected it");
      }
   }

   protected Object checkSetValue(Object value) {
      if (!this.valuePredicate.evaluate(value)) {
         throw new IllegalArgumentException("Cannot set value - Predicate rejected it");
      } else {
         return value;
      }
   }

   protected boolean isSetValueChecking() {
      return this.valuePredicate != null;
   }

   public Object put(Object key, Object value) {
      this.validate(key, value);
      return this.map.put(key, value);
   }

   public void putAll(Map mapToCopy) {
      Iterator i$ = mapToCopy.entrySet().iterator();

      while(i$.hasNext()) {
         Entry entry = (Entry)i$.next();
         this.validate(entry.getKey(), entry.getValue());
      }

      super.putAll(mapToCopy);
   }
}
