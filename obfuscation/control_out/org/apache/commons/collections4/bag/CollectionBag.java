package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.Bag;

public final class CollectionBag extends AbstractBagDecorator {
   private static final long serialVersionUID = -2560033712679053143L;

   public static Bag collectionBag(Bag bag) {
      return new CollectionBag(bag);
   }

   public CollectionBag(Bag bag) {
      super(bag);
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.decorated());
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.setCollection((Collection)in.readObject());
   }

   public boolean containsAll(Collection coll) {
      Iterator e = coll.iterator();

      do {
         if (!e.hasNext()) {
            return true;
         }
      } while(this.contains(e.next()));

      return false;
   }

   public boolean add(Object object) {
      return this.add(object, 1);
   }

   public boolean addAll(Collection coll) {
      boolean changed = false;

      boolean added;
      for(Iterator i = coll.iterator(); i.hasNext(); changed = changed || added) {
         added = this.add(i.next(), 1);
      }

      return changed;
   }

   public boolean remove(Object object) {
      return this.remove(object, 1);
   }

   public boolean removeAll(Collection coll) {
      if (coll == null) {
         return this.decorated().removeAll((Collection)null);
      } else {
         boolean result = false;

         boolean changed;
         for(Iterator i = coll.iterator(); i.hasNext(); result = result || changed) {
            Object obj = i.next();
            changed = this.remove(obj, this.getCount(obj));
         }

         return result;
      }
   }

   public boolean retainAll(Collection coll) {
      if (coll != null) {
         boolean modified = false;
         Iterator e = this.iterator();

         while(e.hasNext()) {
            if (!coll.contains(e.next())) {
               e.remove();
               modified = true;
            }
         }

         return modified;
      } else {
         return this.decorated().retainAll((Collection)null);
      }
   }

   public boolean add(Object object, int count) {
      this.decorated().add(object, count);
      return true;
   }
}
