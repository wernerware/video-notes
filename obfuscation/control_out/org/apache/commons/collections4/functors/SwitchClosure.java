package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

public class SwitchClosure implements Closure, Serializable {
   private static final long serialVersionUID = 3518477308466486130L;
   private final Predicate[] iPredicates;
   private final Closure[] iClosures;
   private final Closure iDefault;

   public static Closure switchClosure(Predicate[] predicates, Closure[] closures, Closure defaultClosure) {
      FunctorUtils.validate(predicates);
      FunctorUtils.validate(closures);
      if (predicates.length != closures.length) {
         throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
      } else if (predicates.length == 0) {
         return defaultClosure == null ? NOPClosure.nopClosure() : defaultClosure;
      } else {
         return new SwitchClosure(predicates, closures, defaultClosure);
      }
   }

   public static Closure switchClosure(Map predicatesAndClosures) {
      if (predicatesAndClosures == null) {
         throw new NullPointerException("The predicate and closure map must not be null");
      } else {
         Closure defaultClosure = (Closure)predicatesAndClosures.remove((Object)null);
         int size = predicatesAndClosures.size();
         if (size == 0) {
            return defaultClosure == null ? NOPClosure.nopClosure() : defaultClosure;
         } else {
            Closure[] closures = new Closure[size];
            Predicate[] preds = new Predicate[size];
            int i = 0;

            for(Iterator i$ = predicatesAndClosures.entrySet().iterator(); i$.hasNext(); ++i) {
               Entry entry = (Entry)i$.next();
               preds[i] = (Predicate)entry.getKey();
               closures[i] = (Closure)entry.getValue();
            }

            return new SwitchClosure(false, preds, closures, defaultClosure);
         }
      }
   }

   private SwitchClosure(boolean clone, Predicate[] predicates, Closure[] closures, Closure defaultClosure) {
      this.iPredicates = clone ? FunctorUtils.copy(predicates) : predicates;
      this.iClosures = clone ? FunctorUtils.copy(closures) : closures;
      this.iDefault = defaultClosure == null ? NOPClosure.nopClosure() : defaultClosure;
   }

   public SwitchClosure(Predicate[] predicates, Closure[] closures, Closure defaultClosure) {
      this(true, predicates, closures, defaultClosure);
   }

   public void execute(Object input) {
      for(int i = 0; i < this.iPredicates.length; ++i) {
         if (this.iPredicates[i].evaluate(input)) {
            this.iClosures[i].execute(input);
            return;
         }
      }

      this.iDefault.execute(input);
   }

   public Predicate[] getPredicates() {
      return FunctorUtils.copy(this.iPredicates);
   }

   public Closure[] getClosures() {
      return FunctorUtils.copy(this.iClosures);
   }

   public Closure getDefaultClosure() {
      return this.iDefault;
   }
}
