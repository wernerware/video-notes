package org.apache.commons.collections4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils {
   public static final Collection EMPTY_COLLECTION = UnmodifiableCollection.unmodifiableCollection(new ArrayList());

   public static Collection emptyCollection() {
      return EMPTY_COLLECTION;
   }

   public static Collection emptyIfNull(Collection collection) {
      return collection == null ? EMPTY_COLLECTION : collection;
   }

   public static Collection union(Iterable a, Iterable b) {
      CollectionUtils.SetOperationCardinalityHelper helper = new CollectionUtils.SetOperationCardinalityHelper(a, b);
      Iterator i$ = helper.iterator();

      while(i$.hasNext()) {
         Object obj = i$.next();
         helper.setCardinality(obj, helper.max(obj));
      }

      return helper.list();
   }

   public static Collection intersection(Iterable a, Iterable b) {
      CollectionUtils.SetOperationCardinalityHelper helper = new CollectionUtils.SetOperationCardinalityHelper(a, b);
      Iterator i$ = helper.iterator();

      while(i$.hasNext()) {
         Object obj = i$.next();
         helper.setCardinality(obj, helper.min(obj));
      }

      return helper.list();
   }

   public static Collection disjunction(Iterable a, Iterable b) {
      CollectionUtils.SetOperationCardinalityHelper helper = new CollectionUtils.SetOperationCardinalityHelper(a, b);
      Iterator i$ = helper.iterator();

      while(i$.hasNext()) {
         Object obj = i$.next();
         helper.setCardinality(obj, helper.max(obj) - helper.min(obj));
      }

      return helper.list();
   }

   public static Collection subtract(Iterable a, Iterable b) {
      Predicate p = TruePredicate.truePredicate();
      return subtract(a, b, p);
   }

   public static Collection subtract(Iterable a, Iterable b, Predicate p) {
      ArrayList list = new ArrayList();
      HashBag bag = new HashBag();
      Iterator i$ = b.iterator();

      Object element;
      while(i$.hasNext()) {
         element = i$.next();
         if (p.evaluate(element)) {
            bag.add(element);
         }
      }

      i$ = a.iterator();

      while(i$.hasNext()) {
         element = i$.next();
         if (!bag.remove(element, 1)) {
            list.add(element);
         }
      }

      return list;
   }

   public static boolean containsAll(Collection coll1, Collection coll2) {
      if (coll2.isEmpty()) {
         return true;
      } else {
         Iterator it = coll1.iterator();
         Set elementsAlreadySeen = new HashSet();
         Iterator i$ = coll2.iterator();

         boolean foundCurrentElement;
         label43:
         do {
            Object nextElement;
            do {
               if (!i$.hasNext()) {
                  return true;
               }

               nextElement = i$.next();
            } while(elementsAlreadySeen.contains(nextElement));

            foundCurrentElement = false;

            while(true) {
               if (!it.hasNext()) {
                  continue label43;
               }

               Object p = it.next();
               elementsAlreadySeen.add(p);
               if (nextElement == null) {
                  if (p == null) {
                     break;
                  }
               } else if (nextElement.equals(p)) {
                  break;
               }
            }

            foundCurrentElement = true;
         } while(foundCurrentElement);

         return false;
      }
   }

   public static boolean containsAny(Collection coll1, Collection coll2) {
      Iterator i$;
      Object aColl1;
      if (coll1.size() < coll2.size()) {
         i$ = coll1.iterator();

         while(i$.hasNext()) {
            aColl1 = i$.next();
            if (coll2.contains(aColl1)) {
               return true;
            }
         }
      } else {
         i$ = coll2.iterator();

         while(i$.hasNext()) {
            aColl1 = i$.next();
            if (coll1.contains(aColl1)) {
               return true;
            }
         }
      }

      return false;
   }

   public static Map getCardinalityMap(Iterable coll) {
      Map count = new HashMap();
      Iterator i$ = coll.iterator();

      while(i$.hasNext()) {
         Object obj = i$.next();
         Integer c = (Integer)count.get(obj);
         if (c == null) {
            count.put(obj, 1);
         } else {
            count.put(obj, c + 1);
         }
      }

      return count;
   }

   public static boolean isSubCollection(Collection a, Collection b) {
      CollectionUtils.CardinalityHelper helper = new CollectionUtils.CardinalityHelper(a, b);
      Iterator i$ = a.iterator();

      Object obj;
      do {
         if (!i$.hasNext()) {
            return true;
         }

         obj = i$.next();
      } while(helper.freqA(obj) <= helper.freqB(obj));

      return false;
   }

   public static boolean isProperSubCollection(Collection a, Collection b) {
      return a.size() < b.size() && isSubCollection(a, b);
   }

   public static boolean isEqualCollection(Collection a, Collection b) {
      if (a.size() != b.size()) {
         return false;
      } else {
         CollectionUtils.CardinalityHelper helper = new CollectionUtils.CardinalityHelper(a, b);
         if (helper.cardinalityA.size() != helper.cardinalityB.size()) {
            return false;
         } else {
            Iterator i$ = helper.cardinalityA.keySet().iterator();

            Object obj;
            do {
               if (!i$.hasNext()) {
                  return true;
               }

               obj = i$.next();
            } while(helper.freqA(obj) == helper.freqB(obj));

            return false;
         }
      }
   }

   public static boolean isEqualCollection(Collection a, Collection b, final Equator equator) {
      if (equator == null) {
         throw new NullPointerException("Equator must not be null.");
      } else if (a.size() != b.size()) {
         return false;
      } else {
         Transformer transformer = new Transformer() {
            public CollectionUtils.EquatorWrapper transform(Object input) {
               return new CollectionUtils.EquatorWrapper(equator, input);
            }
         };
         return isEqualCollection(collect((Iterable)a, transformer), collect((Iterable)b, transformer));
      }
   }

   /** @deprecated */
   @Deprecated
   public static int cardinality(Object obj, Iterable coll) {
      if (coll == null) {
         throw new NullPointerException("coll must not be null.");
      } else {
         return IterableUtils.frequency(coll, obj);
      }
   }

   /** @deprecated */
   @Deprecated
   public static Object find(Iterable collection, Predicate predicate) {
      return predicate != null ? IterableUtils.find(collection, predicate) : null;
   }

   /** @deprecated */
   @Deprecated
   public static Closure forAllDo(Iterable collection, Closure closure) {
      if (closure != null) {
         IterableUtils.forEach(collection, closure);
      }

      return closure;
   }

   /** @deprecated */
   @Deprecated
   public static Closure forAllDo(Iterator iterator, Closure closure) {
      if (closure != null) {
         IteratorUtils.forEach(iterator, closure);
      }

      return closure;
   }

   /** @deprecated */
   @Deprecated
   public static Object forAllButLastDo(Iterable collection, Closure closure) {
      return closure != null ? IterableUtils.forEachButLast(collection, closure) : null;
   }

   /** @deprecated */
   @Deprecated
   public static Object forAllButLastDo(Iterator iterator, Closure closure) {
      return closure != null ? IteratorUtils.forEachButLast(iterator, closure) : null;
   }

   public static boolean filter(Iterable collection, Predicate predicate) {
      boolean result = false;
      if (collection != null && predicate != null) {
         Iterator it = collection.iterator();

         while(it.hasNext()) {
            if (!predicate.evaluate(it.next())) {
               it.remove();
               result = true;
            }
         }
      }

      return result;
   }

   public static boolean filterInverse(Iterable collection, Predicate predicate) {
      return filter(collection, predicate == null ? null : PredicateUtils.notPredicate(predicate));
   }

   public static void transform(Collection collection, Transformer transformer) {
      if (collection != null && transformer != null) {
         if (collection instanceof List) {
            List list = (List)collection;
            ListIterator it = list.listIterator();

            while(it.hasNext()) {
               it.set(transformer.transform(it.next()));
            }
         } else {
            Collection resultCollection = collect((Iterable)collection, transformer);
            collection.clear();
            collection.addAll(resultCollection);
         }
      }

   }

   /** @deprecated */
   @Deprecated
   public static int countMatches(Iterable input, Predicate predicate) {
      return predicate == null ? 0 : (int)IterableUtils.countMatches(input, predicate);
   }

   /** @deprecated */
   @Deprecated
   public static boolean exists(Iterable input, Predicate predicate) {
      return predicate == null ? false : IterableUtils.matchesAny(input, predicate);
   }

   /** @deprecated */
   @Deprecated
   public static boolean matchesAll(Iterable input, Predicate predicate) {
      return predicate == null ? false : IterableUtils.matchesAll(input, predicate);
   }

   public static Collection select(Iterable inputCollection, Predicate predicate) {
      Collection answer = inputCollection instanceof Collection ? new ArrayList(((Collection)inputCollection).size()) : new ArrayList();
      return select(inputCollection, predicate, answer);
   }

   public static Collection select(Iterable inputCollection, Predicate predicate, Collection outputCollection) {
      if (inputCollection != null && predicate != null) {
         Iterator i$ = inputCollection.iterator();

         while(i$.hasNext()) {
            Object item = i$.next();
            if (predicate.evaluate(item)) {
               outputCollection.add(item);
            }
         }
      }

      return outputCollection;
   }

   public static Collection select(Iterable inputCollection, Predicate predicate, Collection outputCollection, Collection rejectedCollection) {
      if (inputCollection != null && predicate != null) {
         Iterator i$ = inputCollection.iterator();

         while(i$.hasNext()) {
            Object element = i$.next();
            if (predicate.evaluate(element)) {
               outputCollection.add(element);
            } else {
               rejectedCollection.add(element);
            }
         }
      }

      return outputCollection;
   }

   public static Collection selectRejected(Iterable inputCollection, Predicate predicate) {
      Collection answer = inputCollection instanceof Collection ? new ArrayList(((Collection)inputCollection).size()) : new ArrayList();
      return selectRejected(inputCollection, predicate, answer);
   }

   public static Collection selectRejected(Iterable inputCollection, Predicate predicate, Collection outputCollection) {
      if (inputCollection != null && predicate != null) {
         Iterator i$ = inputCollection.iterator();

         while(i$.hasNext()) {
            Object item = i$.next();
            if (!predicate.evaluate(item)) {
               outputCollection.add(item);
            }
         }
      }

      return outputCollection;
   }

   public static Collection collect(Iterable inputCollection, Transformer transformer) {
      Collection answer = inputCollection instanceof Collection ? new ArrayList(((Collection)inputCollection).size()) : new ArrayList();
      return collect((Iterable)inputCollection, transformer, answer);
   }

   public static Collection collect(Iterator inputIterator, Transformer transformer) {
      return collect((Iterator)inputIterator, transformer, new ArrayList());
   }

   public static Collection collect(Iterable inputCollection, Transformer transformer, Collection outputCollection) {
      return inputCollection != null ? collect(inputCollection.iterator(), transformer, outputCollection) : outputCollection;
   }

   public static Collection collect(Iterator inputIterator, Transformer transformer, Collection outputCollection) {
      if (inputIterator != null && transformer != null) {
         while(inputIterator.hasNext()) {
            Object item = inputIterator.next();
            Object value = transformer.transform(item);
            outputCollection.add(value);
         }
      }

      return outputCollection;
   }

   public static boolean addIgnoreNull(Collection collection, Object object) {
      if (collection == null) {
         throw new NullPointerException("The collection must not be null");
      } else {
         return object != null && collection.add(object);
      }
   }

   public static boolean addAll(Collection collection, Iterable iterable) {
      return iterable instanceof Collection ? collection.addAll((Collection)iterable) : addAll(collection, iterable.iterator());
   }

   public static boolean addAll(Collection collection, Iterator iterator) {
      boolean changed;
      for(changed = false; iterator.hasNext(); changed |= collection.add(iterator.next())) {
         ;
      }

      return changed;
   }

   public static boolean addAll(Collection collection, Enumeration enumeration) {
      boolean changed;
      for(changed = false; enumeration.hasMoreElements(); changed |= collection.add(enumeration.nextElement())) {
         ;
      }

      return changed;
   }

   public static boolean addAll(Collection collection, Object[] elements) {
      boolean changed = false;
      Object[] arr$ = elements;
      int len$ = elements.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         Object element = arr$[i$];
         changed |= collection.add(element);
      }

      return changed;
   }

   /** @deprecated */
   @Deprecated
   public static Object get(Iterator iterator, int index) {
      return IteratorUtils.get(iterator, index);
   }

   static void checkIndexBounds(int index) {
      if (index < 0) {
         throw new IndexOutOfBoundsException("Index cannot be negative: " + index);
      }
   }

   /** @deprecated */
   @Deprecated
   public static Object get(Iterable iterable, int index) {
      return IterableUtils.get(iterable, index);
   }

   public static Object get(Object object, int index) {
      int i = index;
      if (index < 0) {
         throw new IndexOutOfBoundsException("Index cannot be negative: " + index);
      } else if (object instanceof Map) {
         Map map = (Map)object;
         Iterator iterator = map.entrySet().iterator();
         return IteratorUtils.get(iterator, index);
      } else if (object instanceof Object[]) {
         return ((Object[])((Object[])object))[index];
      } else {
         Iterator iterator;
         if (object instanceof Iterator) {
            iterator = (Iterator)object;
            return IteratorUtils.get(iterator, index);
         } else if (object instanceof Iterable) {
            Iterable iterable = (Iterable)object;
            return IterableUtils.get(iterable, index);
         } else if (object instanceof Collection) {
            iterator = ((Collection)object).iterator();
            return IteratorUtils.get(iterator, index);
         } else if (object instanceof Enumeration) {
            Enumeration it = (Enumeration)object;
            return EnumerationUtils.get(it, index);
         } else if (object == null) {
            throw new IllegalArgumentException("Unsupported object type: null");
         } else {
            try {
               return Array.get(object, i);
            } catch (IllegalArgumentException var5) {
               throw new IllegalArgumentException("Unsupported object type: " + object.getClass().getName());
            }
         }
      }
   }

   public static Entry get(Map map, int index) {
      checkIndexBounds(index);
      return (Entry)get((Iterable)map.entrySet(), index);
   }

   public static int size(Object object) {
      if (object == null) {
         return 0;
      } else {
         int total = 0;
         if (object instanceof Map) {
            total = ((Map)object).size();
         } else if (object instanceof Collection) {
            total = ((Collection)object).size();
         } else if (object instanceof Iterable) {
            total = IterableUtils.size((Iterable)object);
         } else if (object instanceof Object[]) {
            total = ((Object[])((Object[])object)).length;
         } else if (object instanceof Iterator) {
            total = IteratorUtils.size((Iterator)object);
         } else if (object instanceof Enumeration) {
            Enumeration it = (Enumeration)object;

            while(it.hasMoreElements()) {
               ++total;
               it.nextElement();
            }
         } else {
            try {
               total = Array.getLength(object);
            } catch (IllegalArgumentException var3) {
               throw new IllegalArgumentException("Unsupported object type: " + object.getClass().getName());
            }
         }

         return total;
      }
   }

   public static boolean sizeIsEmpty(Object object) {
      if (object == null) {
         return true;
      } else if (object instanceof Collection) {
         return ((Collection)object).isEmpty();
      } else if (object instanceof Iterable) {
         return IterableUtils.isEmpty((Iterable)object);
      } else if (object instanceof Map) {
         return ((Map)object).isEmpty();
      } else if (object instanceof Object[]) {
         return ((Object[])((Object[])object)).length == 0;
      } else if (object instanceof Iterator) {
         return !((Iterator)object).hasNext();
      } else if (object instanceof Enumeration) {
         return !((Enumeration)object).hasMoreElements();
      } else {
         try {
            return Array.getLength(object) == 0;
         } catch (IllegalArgumentException var2) {
            throw new IllegalArgumentException("Unsupported object type: " + object.getClass().getName());
         }
      }
   }

   public static boolean isEmpty(Collection coll) {
      return coll == null || coll.isEmpty();
   }

   public static boolean isNotEmpty(Collection coll) {
      return !isEmpty(coll);
   }

   public static void reverseArray(Object[] array) {
      int i = 0;

      for(int j = array.length - 1; j > i; ++i) {
         Object tmp = array[j];
         array[j] = array[i];
         array[i] = tmp;
         --j;
      }

   }

   public static boolean isFull(Collection coll) {
      if (coll == null) {
         throw new NullPointerException("The collection must not be null");
      } else if (coll instanceof BoundedCollection) {
         return ((BoundedCollection)coll).isFull();
      } else {
         try {
            BoundedCollection bcoll = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(coll);
            return bcoll.isFull();
         } catch (IllegalArgumentException var2) {
            return false;
         }
      }
   }

   public static int maxSize(Collection coll) {
      if (coll == null) {
         throw new NullPointerException("The collection must not be null");
      } else if (coll instanceof BoundedCollection) {
         return ((BoundedCollection)coll).maxSize();
      } else {
         try {
            BoundedCollection bcoll = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(coll);
            return bcoll.maxSize();
         } catch (IllegalArgumentException var2) {
            return -1;
         }
      }
   }

   public static List collate(Iterable a, Iterable b) {
      return collate(a, b, ComparatorUtils.naturalComparator(), true);
   }

   public static List collate(Iterable a, Iterable b, boolean includeDuplicates) {
      return collate(a, b, ComparatorUtils.naturalComparator(), includeDuplicates);
   }

   public static List collate(Iterable a, Iterable b, Comparator c) {
      return collate(a, b, c, true);
   }

   public static List collate(Iterable a, Iterable b, Comparator c, boolean includeDuplicates) {
      if (a != null && b != null) {
         if (c == null) {
            throw new NullPointerException("The comparator must not be null");
         } else {
            int totalSize = a instanceof Collection && b instanceof Collection ? Math.max(1, ((Collection)a).size() + ((Collection)b).size()) : 10;
            Iterator iterator = new CollatingIterator(c, a.iterator(), b.iterator());
            if (includeDuplicates) {
               return IteratorUtils.toList(iterator, totalSize);
            } else {
               ArrayList mergedList = new ArrayList(totalSize);

               Object item;
               for(Object lastItem = null; iterator.hasNext(); lastItem = item) {
                  item = iterator.next();
                  if (lastItem == null || !lastItem.equals(item)) {
                     mergedList.add(item);
                  }
               }

               mergedList.trimToSize();
               return mergedList;
            }
         }
      } else {
         throw new NullPointerException("The collections must not be null");
      }
   }

   public static Collection permutations(Collection collection) {
      PermutationIterator it = new PermutationIterator(collection);
      LinkedList result = new LinkedList();

      while(it.hasNext()) {
         result.add(it.next());
      }

      return result;
   }

   public static Collection retainAll(Collection collection, Collection retain) {
      return ListUtils.retainAll(collection, retain);
   }

   public static Collection retainAll(Iterable collection, Iterable retain, final Equator equator) {
      Transformer transformer = new Transformer() {
         public CollectionUtils.EquatorWrapper transform(Object input) {
            return new CollectionUtils.EquatorWrapper(equator, input);
         }
      };
      Set retainSet = (Set)collect((Iterable)retain, transformer, new HashSet());
      List list = new ArrayList();
      Iterator i$ = collection.iterator();

      while(i$.hasNext()) {
         Object element = i$.next();
         if (retainSet.contains(new CollectionUtils.EquatorWrapper(equator, element))) {
            list.add(element);
         }
      }

      return list;
   }

   public static Collection removeAll(Collection collection, Collection remove) {
      return ListUtils.removeAll(collection, remove);
   }

   public static Collection removeAll(Iterable collection, Iterable remove, final Equator equator) {
      Transformer transformer = new Transformer() {
         public CollectionUtils.EquatorWrapper transform(Object input) {
            return new CollectionUtils.EquatorWrapper(equator, input);
         }
      };
      Set removeSet = (Set)collect((Iterable)remove, transformer, new HashSet());
      List list = new ArrayList();
      Iterator i$ = collection.iterator();

      while(i$.hasNext()) {
         Object element = i$.next();
         if (!removeSet.contains(new CollectionUtils.EquatorWrapper(equator, element))) {
            list.add(element);
         }
      }

      return list;
   }

   /** @deprecated */
   @Deprecated
   public static Collection synchronizedCollection(Collection collection) {
      return SynchronizedCollection.synchronizedCollection(collection);
   }

   /** @deprecated */
   @Deprecated
   public static Collection unmodifiableCollection(Collection collection) {
      return UnmodifiableCollection.unmodifiableCollection(collection);
   }

   public static Collection predicatedCollection(Collection collection, Predicate predicate) {
      return PredicatedCollection.predicatedCollection(collection, predicate);
   }

   public static Collection transformingCollection(Collection collection, Transformer transformer) {
      return TransformedCollection.transformingCollection(collection, transformer);
   }

   public static Object extractSingleton(Collection collection) {
      if (collection == null) {
         throw new NullPointerException("Collection must not be null.");
      } else if (collection.size() != 1) {
         throw new IllegalArgumentException("Can extract singleton only when collection size == 1");
      } else {
         return collection.iterator().next();
      }
   }

   private static class EquatorWrapper {
      private final Equator equator;
      private final Object object;

      public EquatorWrapper(Equator equator, Object object) {
         this.equator = equator;
         this.object = object;
      }

      public Object getObject() {
         return this.object;
      }

      public boolean equals(Object obj) {
         if (!(obj instanceof CollectionUtils.EquatorWrapper)) {
            return false;
         } else {
            CollectionUtils.EquatorWrapper otherObj = (CollectionUtils.EquatorWrapper)obj;
            return this.equator.equate(this.object, otherObj.getObject());
         }
      }

      public int hashCode() {
         return this.equator.hash(this.object);
      }
   }

   private static class SetOperationCardinalityHelper extends CollectionUtils.CardinalityHelper implements Iterable {
      private final Set elements = new HashSet();
      private final List newList;

      public SetOperationCardinalityHelper(Iterable a, Iterable b) {
         super(a, b);
         CollectionUtils.addAll(this.elements, (Iterable)a);
         CollectionUtils.addAll(this.elements, (Iterable)b);
         this.newList = new ArrayList(this.elements.size());
      }

      public Iterator iterator() {
         return this.elements.iterator();
      }

      public void setCardinality(Object obj, int count) {
         for(int i = 0; i < count; ++i) {
            this.newList.add(obj);
         }

      }

      public Collection list() {
         return this.newList;
      }
   }

   private static class CardinalityHelper {
      final Map cardinalityA;
      final Map cardinalityB;

      public CardinalityHelper(Iterable a, Iterable b) {
         this.cardinalityA = CollectionUtils.getCardinalityMap(a);
         this.cardinalityB = CollectionUtils.getCardinalityMap(b);
      }

      public final int max(Object obj) {
         return Math.max(this.freqA(obj), this.freqB(obj));
      }

      public final int min(Object obj) {
         return Math.min(this.freqA(obj), this.freqB(obj));
      }

      public int freqA(Object obj) {
         return this.getFreq(obj, this.cardinalityA);
      }

      public int freqB(Object obj) {
         return this.getFreq(obj, this.cardinalityB);
      }

      private final int getFreq(Object obj, Map freqMap) {
         Integer count = (Integer)freqMap.get(obj);
         return count != null ? count : 0;
      }
   }
}
