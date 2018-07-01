package org.apache.commons.collections4;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.functors.DefaultEquator;
import org.apache.commons.collections4.list.FixedSizeList;
import org.apache.commons.collections4.list.LazyList;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.list.TransformedList;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.commons.collections4.sequence.CommandVisitor;
import org.apache.commons.collections4.sequence.EditScript;
import org.apache.commons.collections4.sequence.SequencesComparator;

public class ListUtils {
   public static List emptyIfNull(List list) {
      return list == null ? Collections.emptyList() : list;
   }

   public static List defaultIfNull(List list, List defaultList) {
      return list == null ? defaultList : list;
   }

   public static List intersection(List list1, List list2) {
      List result = new ArrayList();
      List smaller = list1;
      List larger = list2;
      if (list1.size() > list2.size()) {
         smaller = list2;
         larger = list1;
      }

      HashSet hashSet = new HashSet(smaller);
      Iterator i$ = larger.iterator();

      while(i$.hasNext()) {
         Object e = i$.next();
         if (hashSet.contains(e)) {
            result.add(e);
            hashSet.remove(e);
         }
      }

      return result;
   }

   public static List subtract(List list1, List list2) {
      ArrayList result = new ArrayList();
      HashBag bag = new HashBag(list2);
      Iterator i$ = list1.iterator();

      while(i$.hasNext()) {
         Object e = i$.next();
         if (!bag.remove(e, 1)) {
            result.add(e);
         }
      }

      return result;
   }

   public static List sum(List list1, List list2) {
      return subtract(union(list1, list2), intersection(list1, list2));
   }

   public static List union(List list1, List list2) {
      ArrayList result = new ArrayList(list1);
      result.addAll(list2);
      return result;
   }

   public static List select(Collection inputCollection, Predicate predicate) {
      return (List)CollectionUtils.select(inputCollection, predicate, new ArrayList(inputCollection.size()));
   }

   public static List selectRejected(Collection inputCollection, Predicate predicate) {
      return (List)CollectionUtils.selectRejected(inputCollection, predicate, new ArrayList(inputCollection.size()));
   }

   public static boolean isEqualList(Collection list1, Collection list2) {
      if (list1 == list2) {
         return true;
      } else if (list1 != null && list2 != null && list1.size() == list2.size()) {
         Iterator it1 = list1.iterator();
         Iterator it2 = list2.iterator();
         Object obj1 = null;
         Object obj2 = null;

         while(true) {
            if (it1.hasNext() && it2.hasNext()) {
               obj1 = it1.next();
               obj2 = it2.next();
               if (obj1 == null) {
                  if (obj2 == null) {
                     continue;
                  }
               } else if (obj1.equals(obj2)) {
                  continue;
               }

               return false;
            }

            return !it1.hasNext() && !it2.hasNext();
         }
      } else {
         return false;
      }
   }

   public static int hashCodeForList(Collection list) {
      if (list == null) {
         return 0;
      } else {
         int hashCode = 1;

         Object obj;
         for(Iterator it = list.iterator(); it.hasNext(); hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode())) {
            obj = it.next();
         }

         return hashCode;
      }
   }

   public static List retainAll(Collection collection, Collection retain) {
      List list = new ArrayList(Math.min(collection.size(), retain.size()));
      Iterator i$ = collection.iterator();

      while(i$.hasNext()) {
         Object obj = i$.next();
         if (retain.contains(obj)) {
            list.add(obj);
         }
      }

      return list;
   }

   public static List removeAll(Collection collection, Collection remove) {
      List list = new ArrayList();
      Iterator i$ = collection.iterator();

      while(i$.hasNext()) {
         Object obj = i$.next();
         if (!remove.contains(obj)) {
            list.add(obj);
         }
      }

      return list;
   }

   public static List synchronizedList(List list) {
      return Collections.synchronizedList(list);
   }

   public static List unmodifiableList(List list) {
      return UnmodifiableList.unmodifiableList(list);
   }

   public static List predicatedList(List list, Predicate predicate) {
      return PredicatedList.predicatedList(list, predicate);
   }

   public static List transformedList(List list, Transformer transformer) {
      return TransformedList.transformingList(list, transformer);
   }

   public static List lazyList(List list, Factory factory) {
      return LazyList.lazyList(list, factory);
   }

   public static List fixedSizeList(List list) {
      return FixedSizeList.fixedSizeList(list);
   }

   public static int indexOf(List list, Predicate predicate) {
      if (list != null && predicate != null) {
         for(int i = 0; i < list.size(); ++i) {
            Object item = list.get(i);
            if (predicate.evaluate(item)) {
               return i;
            }
         }
      }

      return -1;
   }

   public static List longestCommonSubsequence(List a, List b) {
      return longestCommonSubsequence(a, b, DefaultEquator.defaultEquator());
   }

   public static List longestCommonSubsequence(List a, List b, Equator equator) {
      if (a != null && b != null) {
         if (equator == null) {
            throw new NullPointerException("Equator must not be null");
         } else {
            SequencesComparator comparator = new SequencesComparator(a, b, equator);
            EditScript script = comparator.getScript();
            ListUtils.LcsVisitor visitor = new ListUtils.LcsVisitor();
            script.visit(visitor);
            return visitor.getSubSequence();
         }
      } else {
         throw new NullPointerException("List must not be null");
      }
   }

   public static String longestCommonSubsequence(CharSequence a, CharSequence b) {
      if (a != null && b != null) {
         List lcs = longestCommonSubsequence((List)(new ListUtils.CharSequenceAsList(a)), (List)(new ListUtils.CharSequenceAsList(b)));
         StringBuilder sb = new StringBuilder();
         Iterator i$ = lcs.iterator();

         while(i$.hasNext()) {
            Character ch = (Character)i$.next();
            sb.append(ch);
         }

         return sb.toString();
      } else {
         throw new NullPointerException("CharSequence must not be null");
      }
   }

   public static List partition(List list, int size) {
      if (list == null) {
         throw new NullPointerException("List must not be null");
      } else if (size <= 0) {
         throw new IllegalArgumentException("Size must be greater than 0");
      } else {
         return new ListUtils.Partition(list, size);
      }
   }

   private static class Partition extends AbstractList {
      private final List list;
      private final int size;

      private Partition(List list, int size) {
         this.list = list;
         this.size = size;
      }

      public List get(int index) {
         int listSize = this.size();
         if (listSize < 0) {
            throw new IllegalArgumentException("negative size: " + listSize);
         } else if (index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " must not be negative");
         } else if (index >= listSize) {
            throw new IndexOutOfBoundsException("Index " + index + " must be less than size " + listSize);
         } else {
            int start = index * this.size;
            int end = Math.min(start + this.size, this.list.size());
            return this.list.subList(start, end);
         }
      }

      public int size() {
         return (this.list.size() + this.size - 1) / this.size;
      }

      public boolean isEmpty() {
         return this.list.isEmpty();
      }

      // $FF: synthetic method
      Partition(List x0, int x1, Object x2) {
         this(x0, x1);
      }
   }

   private static final class CharSequenceAsList extends AbstractList {
      private final CharSequence sequence;

      public CharSequenceAsList(CharSequence sequence) {
         this.sequence = sequence;
      }

      public Character get(int index) {
         return this.sequence.charAt(index);
      }

      public int size() {
         return this.sequence.length();
      }
   }

   private static final class LcsVisitor implements CommandVisitor {
      private ArrayList sequence = new ArrayList();

      public void visitInsertCommand(Object object) {
      }

      public void visitDeleteCommand(Object object) {
      }

      public void visitKeepCommand(Object object) {
         this.sequence.add(object);
      }

      public List getSubSequence() {
         return this.sequence;
      }
   }
}
