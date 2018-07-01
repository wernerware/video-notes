package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.iterators.SingletonIterator;

public class FluentIterable implements Iterable {
   private final Iterable iterable;

   public static FluentIterable empty() {
      return IterableUtils.EMPTY_ITERABLE;
   }

   public static FluentIterable of(Object singleton) {
      return of(IteratorUtils.asIterable(new SingletonIterator(singleton, false)));
   }

   public static FluentIterable of(Object... elements) {
      return of((Iterable)Arrays.asList(elements));
   }

   public static FluentIterable of(Iterable iterable) {
      IterableUtils.checkNotNull(iterable);
      return iterable instanceof FluentIterable ? (FluentIterable)iterable : new FluentIterable(iterable);
   }

   FluentIterable() {
      this.iterable = this;
   }

   private FluentIterable(Iterable iterable) {
      this.iterable = iterable;
   }

   public FluentIterable append(Object... elements) {
      return this.append((Iterable)Arrays.asList(elements));
   }

   public FluentIterable append(Iterable other) {
      return of(IterableUtils.chainedIterable(this.iterable, other));
   }

   public FluentIterable collate(Iterable other) {
      return of(IterableUtils.collatedIterable(this.iterable, other));
   }

   public FluentIterable collate(Iterable other, Comparator comparator) {
      return of(IterableUtils.collatedIterable(comparator, this.iterable, other));
   }

   public FluentIterable eval() {
      return of((Iterable)this.toList());
   }

   public FluentIterable filter(Predicate predicate) {
      return of(IterableUtils.filteredIterable(this.iterable, predicate));
   }

   public FluentIterable limit(long maxSize) {
      return of(IterableUtils.boundedIterable(this.iterable, maxSize));
   }

   public FluentIterable loop() {
      return of(IterableUtils.loopingIterable(this.iterable));
   }

   public FluentIterable reverse() {
      return of(IterableUtils.reversedIterable(this.iterable));
   }

   public FluentIterable skip(long elementsToSkip) {
      return of(IterableUtils.skippingIterable(this.iterable, elementsToSkip));
   }

   public FluentIterable transform(Transformer transformer) {
      return of(IterableUtils.transformedIterable(this.iterable, transformer));
   }

   public FluentIterable unique() {
      return of(IterableUtils.uniqueIterable(this.iterable));
   }

   public FluentIterable unmodifiable() {
      return of(IterableUtils.unmodifiableIterable(this.iterable));
   }

   public FluentIterable zip(Iterable other) {
      return of(IterableUtils.zippingIterable(this.iterable, other));
   }

   public FluentIterable zip(Iterable... others) {
      return of(IterableUtils.zippingIterable(this.iterable, others));
   }

   public Iterator iterator() {
      return this.iterable.iterator();
   }

   public Enumeration asEnumeration() {
      return IteratorUtils.asEnumeration(this.iterator());
   }

   public boolean allMatch(Predicate predicate) {
      return IterableUtils.matchesAll(this.iterable, predicate);
   }

   public boolean anyMatch(Predicate predicate) {
      return IterableUtils.matchesAny(this.iterable, predicate);
   }

   public boolean isEmpty() {
      return IterableUtils.isEmpty(this.iterable);
   }

   public boolean contains(Object object) {
      return IterableUtils.contains(this.iterable, object);
   }

   public void forEach(Closure closure) {
      IterableUtils.forEach(this.iterable, closure);
   }

   public Object get(int position) {
      return IterableUtils.get(this.iterable, position);
   }

   public int size() {
      return IterableUtils.size(this.iterable);
   }

   public void copyInto(Collection collection) {
      if (collection == null) {
         throw new NullPointerException("Collection must not be null");
      } else {
         CollectionUtils.addAll(collection, this.iterable);
      }
   }

   public Object[] toArray(Class arrayClass) {
      return IteratorUtils.toArray(this.iterator(), arrayClass);
   }

   public List toList() {
      return IterableUtils.toList(this.iterable);
   }

   public String toString() {
      return IterableUtils.toString(this.iterable);
   }
}
