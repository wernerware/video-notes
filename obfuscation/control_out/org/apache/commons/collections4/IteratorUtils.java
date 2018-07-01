package org.apache.commons.collections4;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.ArrayIterator;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.BoundedIterator;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyListIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.iterators.EnumerationIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.FilterListIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.IteratorEnumeration;
import org.apache.commons.collections4.iterators.IteratorIterable;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.LoopingListIterator;
import org.apache.commons.collections4.iterators.NodeListIterator;
import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.apache.commons.collections4.iterators.ObjectArrayListIterator;
import org.apache.commons.collections4.iterators.ObjectGraphIterator;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.apache.commons.collections4.iterators.PushbackIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.apache.commons.collections4.iterators.SkippingIterator;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.iterators.ZippingIterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class IteratorUtils {
   public static final ResettableIterator EMPTY_ITERATOR;
   public static final ResettableListIterator EMPTY_LIST_ITERATOR;
   public static final OrderedIterator EMPTY_ORDERED_ITERATOR;
   public static final MapIterator EMPTY_MAP_ITERATOR;
   public static final OrderedMapIterator EMPTY_ORDERED_MAP_ITERATOR;
   private static final String DEFAULT_TOSTRING_PREFIX = "[";
   private static final String DEFAULT_TOSTRING_SUFFIX = "]";
   private static final String DEFAULT_TOSTRING_DELIMITER = ", ";

   public static ResettableIterator emptyIterator() {
      return EmptyIterator.resettableEmptyIterator();
   }

   public static ResettableListIterator emptyListIterator() {
      return EmptyListIterator.resettableEmptyListIterator();
   }

   public static OrderedIterator emptyOrderedIterator() {
      return EmptyOrderedIterator.emptyOrderedIterator();
   }

   public static MapIterator emptyMapIterator() {
      return EmptyMapIterator.emptyMapIterator();
   }

   public static OrderedMapIterator emptyOrderedMapIterator() {
      return EmptyOrderedMapIterator.emptyOrderedMapIterator();
   }

   public static ResettableIterator singletonIterator(Object object) {
      return new SingletonIterator(object);
   }

   public static ListIterator singletonListIterator(Object object) {
      return new SingletonListIterator(object);
   }

   public static ResettableIterator arrayIterator(Object... array) {
      return new ObjectArrayIterator(array);
   }

   public static ResettableIterator arrayIterator(Object array) {
      return new ArrayIterator(array);
   }

   public static ResettableIterator arrayIterator(Object[] array, int start) {
      return new ObjectArrayIterator(array, start);
   }

   public static ResettableIterator arrayIterator(Object array, int start) {
      return new ArrayIterator(array, start);
   }

   public static ResettableIterator arrayIterator(Object[] array, int start, int end) {
      return new ObjectArrayIterator(array, start, end);
   }

   public static ResettableIterator arrayIterator(Object array, int start, int end) {
      return new ArrayIterator(array, start, end);
   }

   public static ResettableListIterator arrayListIterator(Object... array) {
      return new ObjectArrayListIterator(array);
   }

   public static ResettableListIterator arrayListIterator(Object array) {
      return new ArrayListIterator(array);
   }

   public static ResettableListIterator arrayListIterator(Object[] array, int start) {
      return new ObjectArrayListIterator(array, start);
   }

   public static ResettableListIterator arrayListIterator(Object array, int start) {
      return new ArrayListIterator(array, start);
   }

   public static ResettableListIterator arrayListIterator(Object[] array, int start, int end) {
      return new ObjectArrayListIterator(array, start, end);
   }

   public static ResettableListIterator arrayListIterator(Object array, int start, int end) {
      return new ArrayListIterator(array, start, end);
   }

   public static BoundedIterator boundedIterator(Iterator iterator, long max) {
      return boundedIterator(iterator, 0L, max);
   }

   public static BoundedIterator boundedIterator(Iterator iterator, long offset, long max) {
      return new BoundedIterator(iterator, offset, max);
   }

   public static Iterator unmodifiableIterator(Iterator iterator) {
      return UnmodifiableIterator.unmodifiableIterator(iterator);
   }

   public static ListIterator unmodifiableListIterator(ListIterator listIterator) {
      return UnmodifiableListIterator.umodifiableListIterator(listIterator);
   }

   public static MapIterator unmodifiableMapIterator(MapIterator mapIterator) {
      return UnmodifiableMapIterator.unmodifiableMapIterator(mapIterator);
   }

   public static Iterator chainedIterator(Iterator iterator1, Iterator iterator2) {
      return new IteratorChain(iterator1, iterator2);
   }

   public static Iterator chainedIterator(Iterator... iterators) {
      return new IteratorChain(iterators);
   }

   public static Iterator chainedIterator(Collection iterators) {
      return new IteratorChain(iterators);
   }

   public static Iterator collatedIterator(Comparator comparator, Iterator iterator1, Iterator iterator2) {
      Comparator comp = comparator == null ? ComparatorUtils.NATURAL_COMPARATOR : comparator;
      return new CollatingIterator(comp, iterator1, iterator2);
   }

   public static Iterator collatedIterator(Comparator comparator, Iterator... iterators) {
      Comparator comp = comparator == null ? ComparatorUtils.NATURAL_COMPARATOR : comparator;
      return new CollatingIterator(comp, iterators);
   }

   public static Iterator collatedIterator(Comparator comparator, Collection iterators) {
      Comparator comp = comparator == null ? ComparatorUtils.NATURAL_COMPARATOR : comparator;
      return new CollatingIterator(comp, iterators);
   }

   public static Iterator objectGraphIterator(Object root, Transformer transformer) {
      return new ObjectGraphIterator(root, transformer);
   }

   public static Iterator transformedIterator(Iterator iterator, Transformer transform) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else if (transform == null) {
         throw new NullPointerException("Transformer must not be null");
      } else {
         return new TransformIterator(iterator, transform);
      }
   }

   public static Iterator filteredIterator(Iterator iterator, Predicate predicate) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new FilterIterator(iterator, predicate);
      }
   }

   public static ListIterator filteredListIterator(ListIterator listIterator, Predicate predicate) {
      if (listIterator == null) {
         throw new NullPointerException("ListIterator must not be null");
      } else if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new FilterListIterator(listIterator, predicate);
      }
   }

   public static ResettableIterator loopingIterator(Collection coll) {
      if (coll == null) {
         throw new NullPointerException("Collection must not be null");
      } else {
         return new LoopingIterator(coll);
      }
   }

   public static ResettableListIterator loopingListIterator(List list) {
      if (list == null) {
         throw new NullPointerException("List must not be null");
      } else {
         return new LoopingListIterator(list);
      }
   }

   public static NodeListIterator nodeListIterator(NodeList nodeList) {
      if (nodeList == null) {
         throw new NullPointerException("NodeList must not be null");
      } else {
         return new NodeListIterator(nodeList);
      }
   }

   public static NodeListIterator nodeListIterator(Node node) {
      if (node == null) {
         throw new NullPointerException("Node must not be null");
      } else {
         return new NodeListIterator(node);
      }
   }

   public static Iterator peekingIterator(Iterator iterator) {
      return PeekingIterator.peekingIterator(iterator);
   }

   public static Iterator pushbackIterator(Iterator iterator) {
      return PushbackIterator.pushbackIterator(iterator);
   }

   public static SkippingIterator skippingIterator(Iterator iterator, long offset) {
      return new SkippingIterator(iterator, offset);
   }

   public static ZippingIterator zippingIterator(Iterator a, Iterator b) {
      return new ZippingIterator(a, b);
   }

   public static ZippingIterator zippingIterator(Iterator a, Iterator b, Iterator c) {
      return new ZippingIterator(a, b, c);
   }

   public static ZippingIterator zippingIterator(Iterator... iterators) {
      return new ZippingIterator(iterators);
   }

   public static Iterator asIterator(Enumeration enumeration) {
      if (enumeration == null) {
         throw new NullPointerException("Enumeration must not be null");
      } else {
         return new EnumerationIterator(enumeration);
      }
   }

   public static Iterator asIterator(Enumeration enumeration, Collection removeCollection) {
      if (enumeration == null) {
         throw new NullPointerException("Enumeration must not be null");
      } else if (removeCollection == null) {
         throw new NullPointerException("Collection must not be null");
      } else {
         return new EnumerationIterator(enumeration, removeCollection);
      }
   }

   public static Enumeration asEnumeration(Iterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         return new IteratorEnumeration(iterator);
      }
   }

   public static Iterable asIterable(Iterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         return new IteratorIterable(iterator, false);
      }
   }

   public static Iterable asMultipleUseIterable(Iterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         return new IteratorIterable(iterator, true);
      }
   }

   public static ListIterator toListIterator(Iterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         return new ListIteratorWrapper(iterator);
      }
   }

   public static Object[] toArray(Iterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         List list = toList(iterator, 100);
         return list.toArray();
      }
   }

   public static Object[] toArray(Iterator iterator, Class arrayClass) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else if (arrayClass == null) {
         throw new NullPointerException("Array class must not be null");
      } else {
         List list = toList(iterator, 100);
         Object[] array = (Object[])((Object[])Array.newInstance(arrayClass, list.size()));
         return list.toArray(array);
      }
   }

   public static List toList(Iterator iterator) {
      return toList(iterator, 10);
   }

   public static List toList(Iterator iterator, int estimatedSize) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else if (estimatedSize < 1) {
         throw new IllegalArgumentException("Estimated size must be greater than 0");
      } else {
         ArrayList list = new ArrayList(estimatedSize);

         while(iterator.hasNext()) {
            list.add(iterator.next());
         }

         return list;
      }
   }

   public static Iterator getIterator(Object obj) {
      if (obj == null) {
         return emptyIterator();
      } else if (obj instanceof Iterator) {
         return (Iterator)obj;
      } else if (obj instanceof Iterable) {
         return ((Iterable)obj).iterator();
      } else if (obj instanceof Object[]) {
         return new ObjectArrayIterator((Object[])((Object[])obj));
      } else if (obj instanceof Enumeration) {
         return new EnumerationIterator((Enumeration)obj);
      } else if (obj instanceof Map) {
         return ((Map)obj).values().iterator();
      } else if (obj instanceof NodeList) {
         return new NodeListIterator((NodeList)obj);
      } else if (obj instanceof Node) {
         return new NodeListIterator((Node)obj);
      } else if (obj instanceof Dictionary) {
         return new EnumerationIterator(((Dictionary)obj).elements());
      } else if (obj.getClass().isArray()) {
         return new ArrayIterator(obj);
      } else {
         try {
            Method method = obj.getClass().getMethod("iterator", (Class[])null);
            if (Iterator.class.isAssignableFrom(method.getReturnType())) {
               Iterator it = (Iterator)method.invoke(obj, (Object[])null);
               if (it != null) {
                  return it;
               }
            }
         } catch (RuntimeException var3) {
            ;
         } catch (NoSuchMethodException var4) {
            ;
         } catch (IllegalAccessException var5) {
            ;
         } catch (InvocationTargetException var6) {
            ;
         }

         return singletonIterator(obj);
      }
   }

   public static void forEach(Iterator iterator, Closure closure) {
      if (closure == null) {
         throw new NullPointerException("Closure must not be null");
      } else {
         if (iterator != null) {
            while(iterator.hasNext()) {
               Object element = iterator.next();
               closure.execute(element);
            }
         }

      }
   }

   public static Object forEachButLast(Iterator iterator, Closure closure) {
      if (closure == null) {
         throw new NullPointerException("Closure must not be null.");
      } else {
         if (iterator != null) {
            while(iterator.hasNext()) {
               Object element = iterator.next();
               if (!iterator.hasNext()) {
                  return element;
               }

               closure.execute(element);
            }
         }

         return null;
      }
   }

   public static Object find(Iterator iterator, Predicate predicate) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         if (iterator != null) {
            while(iterator.hasNext()) {
               Object element = iterator.next();
               if (predicate.evaluate(element)) {
                  return element;
               }
            }
         }

         return null;
      }
   }

   public static int indexOf(Iterator iterator, Predicate predicate) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         if (iterator != null) {
            for(int index = 0; iterator.hasNext(); ++index) {
               Object element = iterator.next();
               if (predicate.evaluate(element)) {
                  return index;
               }
            }
         }

         return -1;
      }
   }

   public static boolean matchesAny(Iterator iterator, Predicate predicate) {
      return indexOf(iterator, predicate) != -1;
   }

   public static boolean matchesAll(Iterator iterator, Predicate predicate) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         if (iterator != null) {
            while(iterator.hasNext()) {
               Object element = iterator.next();
               if (!predicate.evaluate(element)) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public static boolean isEmpty(Iterator iterator) {
      return iterator == null || !iterator.hasNext();
   }

   public static boolean contains(Iterator iterator, Object object) {
      return matchesAny(iterator, EqualPredicate.equalPredicate(object));
   }

   public static Object get(Iterator iterator, int index) {
      int i = index;
      CollectionUtils.checkIndexBounds(index);

      while(iterator.hasNext()) {
         --i;
         if (i == -1) {
            return iterator.next();
         }

         iterator.next();
      }

      throw new IndexOutOfBoundsException("Entry does not exist: " + i);
   }

   public static int size(Iterator iterator) {
      int size = 0;
      if (iterator != null) {
         while(iterator.hasNext()) {
            iterator.next();
            ++size;
         }
      }

      return size;
   }

   public static String toString(Iterator iterator) {
      return toString(iterator, TransformerUtils.stringValueTransformer(), ", ", "[", "]");
   }

   public static String toString(Iterator iterator, Transformer transformer) {
      return toString(iterator, transformer, ", ", "[", "]");
   }

   public static String toString(Iterator iterator, Transformer transformer, String delimiter, String prefix, String suffix) {
      if (transformer == null) {
         throw new NullPointerException("transformer may not be null");
      } else if (delimiter == null) {
         throw new NullPointerException("delimiter may not be null");
      } else if (prefix == null) {
         throw new NullPointerException("prefix may not be null");
      } else if (suffix == null) {
         throw new NullPointerException("suffix may not be null");
      } else {
         StringBuilder stringBuilder = new StringBuilder(prefix);
         if (iterator != null) {
            while(iterator.hasNext()) {
               Object element = iterator.next();
               stringBuilder.append((String)transformer.transform(element));
               stringBuilder.append(delimiter);
            }

            if (stringBuilder.length() > prefix.length()) {
               stringBuilder.setLength(stringBuilder.length() - delimiter.length());
            }
         }

         stringBuilder.append(suffix);
         return stringBuilder.toString();
      }
   }

   static {
      EMPTY_ITERATOR = EmptyIterator.RESETTABLE_INSTANCE;
      EMPTY_LIST_ITERATOR = EmptyListIterator.RESETTABLE_INSTANCE;
      EMPTY_ORDERED_ITERATOR = EmptyOrderedIterator.INSTANCE;
      EMPTY_MAP_ITERATOR = EmptyMapIterator.INSTANCE;
      EMPTY_ORDERED_MAP_ITERATOR = EmptyOrderedMapIterator.INSTANCE;
   }
}
