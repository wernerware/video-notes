package org.apache.commons.collections4.map;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections4.set.AbstractSetDecorator;

abstract class AbstractInputCheckedMapDecorator extends AbstractMapDecorator {
   protected AbstractInputCheckedMapDecorator() {
   }

   protected AbstractInputCheckedMapDecorator(Map map) {
      super(map);
   }

   protected abstract Object checkSetValue(Object var1);

   protected boolean isSetValueChecking() {
      return true;
   }

   public Set entrySet() {
      return (Set)(this.isSetValueChecking() ? new AbstractInputCheckedMapDecorator.EntrySet(this.map.entrySet(), this) : this.map.entrySet());
   }

   private class MapEntry extends AbstractMapEntryDecorator {
      private final AbstractInputCheckedMapDecorator parent;

      protected MapEntry(Entry entry, AbstractInputCheckedMapDecorator parent) {
         super(entry);
         this.parent = parent;
      }

      public Object setValue(Object value) {
         value = this.parent.checkSetValue(value);
         return this.getMapEntry().setValue(value);
      }
   }

   private class EntrySetIterator extends AbstractIteratorDecorator {
      private final AbstractInputCheckedMapDecorator parent;

      protected EntrySetIterator(Iterator iterator, AbstractInputCheckedMapDecorator parent) {
         super(iterator);
         this.parent = parent;
      }

      public Entry next() {
         Entry entry = (Entry)this.getIterator().next();
         return AbstractInputCheckedMapDecorator.this.new MapEntry(entry, this.parent);
      }
   }

   private class EntrySet extends AbstractSetDecorator {
      private static final long serialVersionUID = 4354731610923110264L;
      private final AbstractInputCheckedMapDecorator parent;

      protected EntrySet(Set set, AbstractInputCheckedMapDecorator parent) {
         super(set);
         this.parent = parent;
      }

      public Iterator iterator() {
         return AbstractInputCheckedMapDecorator.this.new EntrySetIterator(this.decorated().iterator(), this.parent);
      }

      public Object[] toArray() {
         Object[] array = this.decorated().toArray();

         for(int i = 0; i < array.length; ++i) {
            array[i] = AbstractInputCheckedMapDecorator.this.new MapEntry((Entry)array[i], this.parent);
         }

         return array;
      }

      public Object[] toArray(Object[] array) {
         Object[] result = array;
         if (array.length > 0) {
            result = (Object[])((Object[])Array.newInstance(array.getClass().getComponentType(), 0));
         }

         result = this.decorated().toArray(result);

         for(int i = 0; i < result.length; ++i) {
            result[i] = AbstractInputCheckedMapDecorator.this.new MapEntry((Entry)result[i], this.parent);
         }

         if (result.length > array.length) {
            return (Object[])result;
         } else {
            System.arraycopy(result, 0, array, 0, result.length);
            if (array.length > result.length) {
               array[result.length] = null;
            }

            return array;
         }
      }
   }
}
