package org.apache.commons.collections4.list;

import java.util.List;
import org.apache.commons.collections4.Factory;

public class LazyList extends AbstractSerializableListDecorator {
   private static final long serialVersionUID = -1708388017160694542L;
   private final Factory factory;

   public static LazyList lazyList(List list, Factory factory) {
      return new LazyList(list, factory);
   }

   protected LazyList(List list, Factory factory) {
      super(list);
      if (factory == null) {
         throw new IllegalArgumentException("Factory must not be null");
      } else {
         this.factory = factory;
      }
   }

   public Object get(int index) {
      int size = this.decorated().size();
      Object object;
      if (index < size) {
         object = this.decorated().get(index);
         if (object == null) {
            object = this.factory.create();
            this.decorated().set(index, object);
            return object;
         } else {
            return object;
         }
      } else {
         for(int i = size; i < index; ++i) {
            this.decorated().add((Object)null);
         }

         object = this.factory.create();
         this.decorated().add(object);
         return object;
      }
   }

   public List subList(int fromIndex, int toIndex) {
      List sub = this.decorated().subList(fromIndex, toIndex);
      return new LazyList(sub, this.factory);
   }
}
