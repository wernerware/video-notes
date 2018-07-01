package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.PredicatedBag;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.multiset.HashMultiSet;
import org.apache.commons.collections4.multiset.PredicatedMultiSet;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.set.PredicatedSet;

public class PredicatedCollection extends AbstractCollectionDecorator {
   private static final long serialVersionUID = -5259182142076705162L;
   protected final Predicate predicate;

   public static PredicatedCollection.Builder builder(Predicate predicate) {
      return new PredicatedCollection.Builder(predicate);
   }

   public static PredicatedCollection.Builder notNullBuilder() {
      return new PredicatedCollection.Builder(NotNullPredicate.notNullPredicate());
   }

   public static PredicatedCollection predicatedCollection(Collection coll, Predicate predicate) {
      return new PredicatedCollection(coll, predicate);
   }

   protected PredicatedCollection(Collection coll, Predicate predicate) {
      super(coll);
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null.");
      } else {
         this.predicate = predicate;
         Iterator i$ = coll.iterator();

         while(i$.hasNext()) {
            Object item = i$.next();
            this.validate(item);
         }

      }
   }

   protected void validate(Object object) {
      if (!this.predicate.evaluate(object)) {
         throw new IllegalArgumentException("Cannot add Object '" + object + "' - Predicate '" + this.predicate + "' rejected it");
      }
   }

   public boolean add(Object object) {
      this.validate(object);
      return this.decorated().add(object);
   }

   public boolean addAll(Collection coll) {
      Iterator i$ = coll.iterator();

      while(i$.hasNext()) {
         Object item = i$.next();
         this.validate(item);
      }

      return this.decorated().addAll(coll);
   }

   public static class Builder {
      private final Predicate predicate;
      private final List accepted = new ArrayList();
      private final List rejected = new ArrayList();

      public Builder(Predicate predicate) {
         if (predicate == null) {
            throw new NullPointerException("Predicate must not be null");
         } else {
            this.predicate = predicate;
         }
      }

      public PredicatedCollection.Builder add(Object item) {
         if (this.predicate.evaluate(item)) {
            this.accepted.add(item);
         } else {
            this.rejected.add(item);
         }

         return this;
      }

      public PredicatedCollection.Builder addAll(Collection items) {
         if (items != null) {
            Iterator i$ = items.iterator();

            while(i$.hasNext()) {
               Object item = i$.next();
               this.add(item);
            }
         }

         return this;
      }

      public List createPredicatedList() {
         return this.createPredicatedList(new ArrayList());
      }

      public List createPredicatedList(List list) {
         if (list == null) {
            throw new NullPointerException("List must not be null.");
         } else {
            List predicatedList = PredicatedList.predicatedList(list, this.predicate);
            predicatedList.addAll(this.accepted);
            return predicatedList;
         }
      }

      public Set createPredicatedSet() {
         return this.createPredicatedSet(new HashSet());
      }

      public Set createPredicatedSet(Set set) {
         if (set == null) {
            throw new NullPointerException("Set must not be null.");
         } else {
            PredicatedSet predicatedSet = PredicatedSet.predicatedSet(set, this.predicate);
            predicatedSet.addAll(this.accepted);
            return predicatedSet;
         }
      }

      public MultiSet createPredicatedMultiSet() {
         return this.createPredicatedMultiSet(new HashMultiSet());
      }

      public MultiSet createPredicatedMultiSet(MultiSet multiset) {
         if (multiset == null) {
            throw new NullPointerException("MultiSet must not be null.");
         } else {
            PredicatedMultiSet predicatedMultiSet = PredicatedMultiSet.predicatedMultiSet(multiset, this.predicate);
            predicatedMultiSet.addAll(this.accepted);
            return predicatedMultiSet;
         }
      }

      public Bag createPredicatedBag() {
         return this.createPredicatedBag(new HashBag());
      }

      public Bag createPredicatedBag(Bag bag) {
         if (bag == null) {
            throw new NullPointerException("Bag must not be null.");
         } else {
            PredicatedBag predicatedBag = PredicatedBag.predicatedBag(bag, this.predicate);
            predicatedBag.addAll(this.accepted);
            return predicatedBag;
         }
      }

      public Queue createPredicatedQueue() {
         return this.createPredicatedQueue(new LinkedList());
      }

      public Queue createPredicatedQueue(Queue queue) {
         if (queue == null) {
            throw new NullPointerException("queue must not be null");
         } else {
            PredicatedQueue predicatedQueue = PredicatedQueue.predicatedQueue(queue, this.predicate);
            predicatedQueue.addAll(this.accepted);
            return predicatedQueue;
         }
      }

      public Collection rejectedElements() {
         return Collections.unmodifiableCollection(this.rejected);
      }
   }
}
