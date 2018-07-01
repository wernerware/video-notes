package org.apache.commons.collections4;

import org.apache.commons.collections4.bag.CollectionBag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.PredicatedBag;
import org.apache.commons.collections4.bag.PredicatedSortedBag;
import org.apache.commons.collections4.bag.SynchronizedBag;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.collections4.bag.TransformedBag;
import org.apache.commons.collections4.bag.TransformedSortedBag;
import org.apache.commons.collections4.bag.TreeBag;
import org.apache.commons.collections4.bag.UnmodifiableBag;
import org.apache.commons.collections4.bag.UnmodifiableSortedBag;

public class BagUtils {
   public static final Bag EMPTY_BAG = UnmodifiableBag.unmodifiableBag(new HashBag());
   public static final Bag EMPTY_SORTED_BAG = UnmodifiableSortedBag.unmodifiableSortedBag(new TreeBag());

   public static Bag synchronizedBag(Bag bag) {
      return SynchronizedBag.synchronizedBag(bag);
   }

   public static Bag unmodifiableBag(Bag bag) {
      return UnmodifiableBag.unmodifiableBag(bag);
   }

   public static Bag predicatedBag(Bag bag, Predicate predicate) {
      return PredicatedBag.predicatedBag(bag, predicate);
   }

   public static Bag transformingBag(Bag bag, Transformer transformer) {
      return TransformedBag.transformingBag(bag, transformer);
   }

   public static Bag collectionBag(Bag bag) {
      return CollectionBag.collectionBag(bag);
   }

   public static SortedBag synchronizedSortedBag(SortedBag bag) {
      return SynchronizedSortedBag.synchronizedSortedBag(bag);
   }

   public static SortedBag unmodifiableSortedBag(SortedBag bag) {
      return UnmodifiableSortedBag.unmodifiableSortedBag(bag);
   }

   public static SortedBag predicatedSortedBag(SortedBag bag, Predicate predicate) {
      return PredicatedSortedBag.predicatedSortedBag(bag, predicate);
   }

   public static SortedBag transformingSortedBag(SortedBag bag, Transformer transformer) {
      return TransformedSortedBag.transformingSortedBag(bag, transformer);
   }

   public static Bag emptyBag() {
      return EMPTY_BAG;
   }

   public static SortedBag emptySortedBag() {
      return (SortedBag)EMPTY_SORTED_BAG;
   }
}
