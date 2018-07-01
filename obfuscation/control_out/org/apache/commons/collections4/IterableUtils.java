package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.ReverseListIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;

public class IterableUtils {
   static final FluentIterable EMPTY_ITERABLE = new FluentIterable() {
      public Iterator iterator() {
         return IteratorUtils.emptyIterator();
      }
   };

   public static Iterable emptyIterable() {
      return EMPTY_ITERABLE;
   }

   public static Iterable chainedIterable(Iterable a, Iterable b) {
      return chainedIterable(a, b);
   }

   public static Iterable chainedIterable(Iterable a, Iterable b, Iterable c) {
      return chainedIterable(a, b, c);
   }

   public static Iterable chainedIterable(Iterable a, Iterable b, Iterable c, Iterable d) {
      return chainedIterable(a, b, c, d);
   }

   public static Iterable chainedIterable(final Iterable... iterables) {
      checkNotNull(iterables);
      return new FluentIterable() {
         public Iterator iterator() {
            return new LazyIteratorChain() {
               protected Iterator nextIterator(int count) {
                  return count > iterables.length ? null : iterables[count - 1].iterator();
               }
            };
         }
      };
   }

   public static Iterable collatedIterable(final Iterable a, final Iterable b) {
      checkNotNull(a, b);
      return new FluentIterable() {
         public Iterator iterator() {
            return IteratorUtils.collatedIterator((Comparator)null, a.iterator(), b.iterator());
         }
      };
   }

   public static Iterable collatedIterable(final Comparator comparator, final Iterable a, final Iterable b) {
      checkNotNull(a, b);
      return new FluentIterable() {
         public Iterator iterator() {
            return IteratorUtils.collatedIterator(comparator, a.iterator(), b.iterator());
         }
      };
   }

   public static Iterable filteredIterable(final Iterable iterable, final Predicate predicate) {
      checkNotNull(iterable);
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null.");
      } else {
         return new FluentIterable() {
            public Iterator iterator() {
               return IteratorUtils.filteredIterator(IterableUtils.emptyIteratorIfNull(iterable), predicate);
            }
         };
      }
   }

   public static Iterable boundedIterable(final Iterable iterable, final long maxSize) {
      checkNotNull(iterable);
      if (maxSize < 0L) {
         throw new IllegalArgumentException("MaxSize parameter must not be negative.");
      } else {
         return new FluentIterable() {
            public Iterator iterator() {
               return IteratorUtils.boundedIterator(iterable.iterator(), maxSize);
            }
         };
      }
   }

   public static Iterable loopingIterable(final Iterable iterable) {
      checkNotNull(iterable);
      return new FluentIterable() {
         public Iterator iterator() {
            return new LazyIteratorChain() {
               protected Iterator nextIterator(int count) {
                  return IterableUtils.isEmpty(iterable) ? null : iterable.iterator();
               }
            };
         }
      };
   }

   public static Iterable reversedIterable(final Iterable iterable) {
      checkNotNull(iterable);
      return new FluentIterable() {
         public Iterator iterator() {
            List list = iterable instanceof List ? (List)iterable : IteratorUtils.toList(iterable.iterator());
            return new ReverseListIterator(list);
         }
      };
   }

   public static Iterable skippingIterable(final Iterable iterable, final long elementsToSkip) {
      checkNotNull(iterable);
      if (elementsToSkip < 0L) {
         throw new IllegalArgumentException("ElementsToSkip parameter must not be negative.");
      } else {
         return new FluentIterable() {
            public Iterator iterator() {
               return IteratorUtils.skippingIterator(iterable.iterator(), elementsToSkip);
            }
         };
      }
   }

   public static Iterable transformedIterable(final Iterable iterable, final Transformer transformer) {
      checkNotNull(iterable);
      if (transformer == null) {
         throw new NullPointerException("Transformer must not be null.");
      } else {
         return new FluentIterable() {
            public Iterator iterator() {
               return IteratorUtils.transformedIterator(iterable.iterator(), transformer);
            }
         };
      }
   }

   public static Iterable uniqueIterable(final Iterable iterable) {
      checkNotNull(iterable);
      return new FluentIterable() {
         public Iterator iterator() {
            return new UniqueFilterIterator(iterable.iterator());
         }
      };
   }

   public static Iterable unmodifiableIterable(Iterable iterable) {
      checkNotNull(iterable);
      return (Iterable)(iterable instanceof IterableUtils.UnmodifiableIterable ? iterable : new IterableUtils.UnmodifiableIterable(iterable));
   }

   public static Iterable zippingIterable(final Iterable a, final Iterable b) {
      checkNotNull(a);
      checkNotNull(b);
      return new FluentIterable() {
         public Iterator iterator() {
            return IteratorUtils.zippingIterator(a.iterator(), b.iterator());
         }
      };
   }

   public static Iterable zippingIterable(final Iterable first, final Iterable... others) {
      checkNotNull(first);
      checkNotNull(others);
      return new FluentIterable() {
         public Iterator iterator() {
            Iterator[] iterators = new Iterator[others.length + 1];
            iterators[0] = first.iterator();

            for(int i = 0; i < others.length; ++i) {
               iterators[i + 1] = others[i].iterator();
            }

            return IteratorUtils.zippingIterator(iterators);
         }
      };
   }

   public static Iterable emptyIfNull(Iterable iterable) {
      return iterable == null ? emptyIterable() : iterable;
   }

   public static void forEach(Iterable iterable, Closure closure) {
      IteratorUtils.forEach(emptyIteratorIfNull(iterable), closure);
   }

   public static Object forEachButLast(Iterable iterable, Closure closure) {
      return IteratorUtils.forEachButLast(emptyIteratorIfNull(iterable), closure);
   }

   public static Object find(Iterable iterable, Predicate predicate) {
      return IteratorUtils.find(emptyIteratorIfNull(iterable), predicate);
   }

   public static int indexOf(Iterable iterable, Predicate predicate) {
      return IteratorUtils.indexOf(emptyIteratorIfNull(iterable), predicate);
   }

   public static boolean matchesAll(Iterable iterable, Predicate predicate) {
      return IteratorUtils.matchesAll(emptyIteratorIfNull(iterable), predicate);
   }

   public static boolean matchesAny(Iterable iterable, Predicate predicate) {
      return IteratorUtils.matchesAny(emptyIteratorIfNull(iterable), predicate);
   }

   public static long countMatches(Iterable input, Predicate predicate) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null.");
      } else {
         return (long)size(filteredIterable(emptyIfNull(input), predicate));
      }
   }

   public static boolean isEmpty(Iterable iterable) {
      return iterable instanceof Collection ? ((Collection)iterable).isEmpty() : IteratorUtils.isEmpty(emptyIteratorIfNull(iterable));
   }

   public static boolean contains(Iterable iterable, Object object) {
      return iterable instanceof Collection ? ((Collection)iterable).contains(object) : IteratorUtils.contains(emptyIteratorIfNull(iterable), object);
   }

   public static boolean contains(Iterable iterable, Object object, Equator equator) {
      if (equator == null) {
         throw new NullPointerException("Equator must not be null.");
      } else {
         return matchesAny(iterable, EqualPredicate.equalPredicate(object, equator));
      }
   }

   public static int frequency(Iterable iterable, Object obj) {
      if (iterable instanceof Set) {
         return ((Set)iterable).contains(obj) ? 1 : 0;
      } else {
         return iterable instanceof Bag ? ((Bag)iterable).getCount(obj) : size(filteredIterable(emptyIfNull(iterable), EqualPredicate.equalPredicate(obj)));
      }
   }

   public static Object get(Iterable iterable, int index) {
      CollectionUtils.checkIndexBounds(index);
      return iterable instanceof List ? ((List)iterable).get(index) : IteratorUtils.get(emptyIteratorIfNull(iterable), index);
   }

   public static int size(Iterable iterable) {
      return iterable instanceof Collection ? ((Collection)iterable).size() : IteratorUtils.size(emptyIteratorIfNull(iterable));
   }

   public static List partition(Iterable iterable, Predicate predicate) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null.");
      } else {
         Factory factory = FactoryUtils.instantiateFactory(ArrayList.class);
         Predicate[] predicates = new Predicate[]{predicate};
         return partition(iterable, factory, predicates);
      }
   }

   public static List partition(Iterable iterable, Predicate... predicates) {
      Factory factory = FactoryUtils.instantiateFactory(ArrayList.class);
      return partition(iterable, factory, predicates);
   }

   public static List partition(Iterable iterable, Factory partitionFactory, Predicate... predicates) {
      if (iterable == null) {
         Iterable empty = emptyIterable();
         return partition(empty, partitionFactory, predicates);
      } else if (predicates == null) {
         throw new NullPointerException("Predicates must not be null.");
      } else {
         Predicate[] arr$ = predicates;
         int numberOfPartitions = predicates.length;

         for(int i$ = 0; i$ < numberOfPartitions; ++i$) {
            Predicate p = arr$[i$];
            if (p == null) {
               throw new NullPointerException("Predicate must not be null.");
            }
         }

         if (predicates.length < 1) {
            Collection singlePartition = (Collection)partitionFactory.create();
            CollectionUtils.addAll(singlePartition, iterable);
            return Collections.singletonList(singlePartition);
         } else {
            int numberOfPredicates = predicates.length;
            numberOfPartitions = numberOfPredicates + 1;
            List partitions = new ArrayList(numberOfPartitions);

            for(int i = 0; i < numberOfPartitions; ++i) {
               partitions.add(partitionFactory.create());
            }

            Iterator i$ = iterable.iterator();

            while(i$.hasNext()) {
               Object element = i$.next();
               boolean elementAssigned = false;

               for(int i = 0; i < numberOfPredicates; ++i) {
                  if (predicates[i].evaluate(element)) {
                     ((Collection)partitions.get(i)).add(element);
                     elementAssigned = true;
                     break;
                  }
               }

               if (!elementAssigned) {
                  ((Collection)partitions.get(numberOfPredicates)).add(element);
               }
            }

            return partitions;
         }
      }
   }

   public static List toList(Iterable iterable) {
      return IteratorUtils.toList(emptyIteratorIfNull(iterable));
   }

   public static String toString(Iterable iterable) {
      return IteratorUtils.toString(emptyIteratorIfNull(iterable));
   }

   public static String toString(Iterable iterable, Transformer transformer) {
      if (transformer == null) {
         throw new NullPointerException("Transformer must not be null.");
      } else {
         return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer);
      }
   }

   public static String toString(Iterable iterable, Transformer transformer, String delimiter, String prefix, String suffix) {
      return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer, delimiter, prefix, suffix);
   }

   static void checkNotNull(Iterable iterable) {
      if (iterable == null) {
         throw new NullPointerException("Iterable must not be null.");
      }
   }

   static void checkNotNull(Iterable... iterables) {
      if (iterables == null) {
         throw new NullPointerException("Iterables must not be null.");
      } else {
         Iterable[] arr$ = iterables;
         int len$ = iterables.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            Iterable iterable = arr$[i$];
            checkNotNull(iterable);
         }

      }
   }

   private static Iterator emptyIteratorIfNull(Iterable iterable) {
      return (Iterator)(iterable != null ? iterable.iterator() : IteratorUtils.emptyIterator());
   }

   private static final class UnmodifiableIterable extends FluentIterable {
      private final Iterable unmodifiable;

      public UnmodifiableIterable(Iterable iterable) {
         this.unmodifiable = iterable;
      }

      public Iterator iterator() {
         return IteratorUtils.unmodifiableIterator(this.unmodifiable.iterator());
      }
   }
}
