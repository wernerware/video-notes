package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface MultiSet extends Collection {
   int getCount(Object var1);

   int setCount(Object var1, int var2);

   boolean add(Object var1);

   int add(Object var1, int var2);

   boolean remove(Object var1);

   int remove(Object var1, int var2);

   Set uniqueSet();

   Set entrySet();

   Iterator iterator();

   int size();

   boolean containsAll(Collection var1);

   boolean removeAll(Collection var1);

   boolean retainAll(Collection var1);

   boolean equals(Object var1);

   int hashCode();

   public interface Entry {
      Object getElement();

      int getCount();

      boolean equals(Object var1);

      int hashCode();
   }
}
