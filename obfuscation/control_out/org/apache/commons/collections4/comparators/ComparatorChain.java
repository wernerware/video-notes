package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ComparatorChain implements Comparator, Serializable {
   private static final long serialVersionUID = -721644942746081630L;
   private final List comparatorChain;
   private BitSet orderingBits;
   private boolean isLocked;

   public ComparatorChain() {
      this(new ArrayList(), new BitSet());
   }

   public ComparatorChain(Comparator comparator) {
      this(comparator, false);
   }

   public ComparatorChain(Comparator comparator, boolean reverse) {
      this.orderingBits = null;
      this.isLocked = false;
      this.comparatorChain = new ArrayList(1);
      this.comparatorChain.add(comparator);
      this.orderingBits = new BitSet(1);
      if (reverse) {
         this.orderingBits.set(0);
      }

   }

   public ComparatorChain(List list) {
      this(list, new BitSet(list.size()));
   }

   public ComparatorChain(List list, BitSet bits) {
      this.orderingBits = null;
      this.isLocked = false;
      this.comparatorChain = list;
      this.orderingBits = bits;
   }

   public void addComparator(Comparator comparator) {
      this.addComparator(comparator, false);
   }

   public void addComparator(Comparator comparator, boolean reverse) {
      this.checkLocked();
      this.comparatorChain.add(comparator);
      if (reverse) {
         this.orderingBits.set(this.comparatorChain.size() - 1);
      }

   }

   public void setComparator(int index, Comparator comparator) throws IndexOutOfBoundsException {
      this.setComparator(index, comparator, false);
   }

   public void setComparator(int index, Comparator comparator, boolean reverse) {
      this.checkLocked();
      this.comparatorChain.set(index, comparator);
      if (reverse) {
         this.orderingBits.set(index);
      } else {
         this.orderingBits.clear(index);
      }

   }

   public void setForwardSort(int index) {
      this.checkLocked();
      this.orderingBits.clear(index);
   }

   public void setReverseSort(int index) {
      this.checkLocked();
      this.orderingBits.set(index);
   }

   public int size() {
      return this.comparatorChain.size();
   }

   public boolean isLocked() {
      return this.isLocked;
   }

   private void checkLocked() {
      if (this.isLocked) {
         throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
      }
   }

   private void checkChainIntegrity() {
      if (this.comparatorChain.size() == 0) {
         throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
      }
   }

   public int compare(Object o1, Object o2) throws UnsupportedOperationException {
      if (!this.isLocked) {
         this.checkChainIntegrity();
         this.isLocked = true;
      }

      Iterator comparators = this.comparatorChain.iterator();

      for(int comparatorIndex = 0; comparators.hasNext(); ++comparatorIndex) {
         Comparator comparator = (Comparator)comparators.next();
         int retval = comparator.compare(o1, o2);
         if (retval != 0) {
            if (this.orderingBits.get(comparatorIndex)) {
               if (retval > 0) {
                  retval = -1;
               } else {
                  retval = 1;
               }
            }

            return retval;
         }
      }

      return 0;
   }

   public int hashCode() {
      int hash = 0;
      if (null != this.comparatorChain) {
         hash ^= this.comparatorChain.hashCode();
      }

      if (null != this.orderingBits) {
         hash ^= this.orderingBits.hashCode();
      }

      return hash;
   }

   public boolean equals(Object object) {
      if (this == object) {
         return true;
      } else if (null == object) {
         return false;
      } else if (!object.getClass().equals(this.getClass())) {
         return false;
      } else {
         boolean var10000;
         label48: {
            label32: {
               ComparatorChain chain = (ComparatorChain)object;
               if (null == this.orderingBits) {
                  if (null != chain.orderingBits) {
                     break label32;
                  }
               } else if (!this.orderingBits.equals(chain.orderingBits)) {
                  break label32;
               }

               if (null == this.comparatorChain) {
                  if (null == chain.comparatorChain) {
                     break label48;
                  }
               } else if (this.comparatorChain.equals(chain.comparatorChain)) {
                  break label48;
               }
            }

            var10000 = false;
            return var10000;
         }

         var10000 = true;
         return var10000;
      }
   }
}
