package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GrowthList extends AbstractSerializableListDecorator {
   private static final long serialVersionUID = -3620001881672L;

   public static GrowthList growthList(List list) {
      return new GrowthList(list);
   }

   public GrowthList() {
      super(new ArrayList());
   }

   public GrowthList(int initialSize) {
      super(new ArrayList(initialSize));
   }

   protected GrowthList(List list) {
      super(list);
   }

   public void add(int index, Object element) {
      int size = this.decorated().size();
      if (index > size) {
         this.decorated().addAll(Collections.nCopies(index - size, (Object)null));
      }

      this.decorated().add(index, element);
   }

   public boolean addAll(int index, Collection coll) {
      int size = this.decorated().size();
      boolean result = false;
      if (index > size) {
         this.decorated().addAll(Collections.nCopies(index - size, (Object)null));
         result = true;
      }

      return this.decorated().addAll(index, coll) | result;
   }

   public Object set(int index, Object element) {
      int size = this.decorated().size();
      if (index >= size) {
         this.decorated().addAll(Collections.nCopies(index - size + 1, (Object)null));
      }

      return this.decorated().set(index, element);
   }
}
