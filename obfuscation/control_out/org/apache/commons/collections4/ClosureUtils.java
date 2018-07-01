package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.ExceptionClosure;
import org.apache.commons.collections4.functors.ForClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.apache.commons.collections4.functors.NOPClosure;
import org.apache.commons.collections4.functors.SwitchClosure;
import org.apache.commons.collections4.functors.TransformerClosure;
import org.apache.commons.collections4.functors.WhileClosure;

public class ClosureUtils {
   public static Closure exceptionClosure() {
      return ExceptionClosure.exceptionClosure();
   }

   public static Closure nopClosure() {
      return NOPClosure.nopClosure();
   }

   public static Closure asClosure(Transformer transformer) {
      return TransformerClosure.transformerClosure(transformer);
   }

   public static Closure forClosure(int count, Closure closure) {
      return ForClosure.forClosure(count, closure);
   }

   public static Closure whileClosure(Predicate predicate, Closure closure) {
      return WhileClosure.whileClosure(predicate, closure, false);
   }

   public static Closure doWhileClosure(Closure closure, Predicate predicate) {
      return WhileClosure.whileClosure(predicate, closure, true);
   }

   public static Closure invokerClosure(String methodName) {
      return asClosure(InvokerTransformer.invokerTransformer(methodName));
   }

   public static Closure invokerClosure(String methodName, Class[] paramTypes, Object[] args) {
      return asClosure(InvokerTransformer.invokerTransformer(methodName, paramTypes, args));
   }

   public static Closure chainedClosure(Closure... closures) {
      return ChainedClosure.chainedClosure(closures);
   }

   public static Closure chainedClosure(Collection closures) {
      return ChainedClosure.chainedClosure(closures);
   }

   public static Closure ifClosure(Predicate predicate, Closure trueClosure) {
      return IfClosure.ifClosure(predicate, trueClosure);
   }

   public static Closure ifClosure(Predicate predicate, Closure trueClosure, Closure falseClosure) {
      return IfClosure.ifClosure(predicate, trueClosure, falseClosure);
   }

   public static Closure switchClosure(Predicate[] predicates, Closure[] closures) {
      return SwitchClosure.switchClosure(predicates, closures, (Closure)null);
   }

   public static Closure switchClosure(Predicate[] predicates, Closure[] closures, Closure defaultClosure) {
      return SwitchClosure.switchClosure(predicates, closures, defaultClosure);
   }

   public static Closure switchClosure(Map predicatesAndClosures) {
      return SwitchClosure.switchClosure(predicatesAndClosures);
   }

   public static Closure switchMapClosure(Map objectsAndClosures) {
      if (objectsAndClosures == null) {
         throw new NullPointerException("The object and closure map must not be null");
      } else {
         Closure def = (Closure)objectsAndClosures.remove((Object)null);
         int size = objectsAndClosures.size();
         Closure[] trs = new Closure[size];
         Predicate[] preds = new Predicate[size];
         int i = 0;

         for(Iterator i$ = objectsAndClosures.entrySet().iterator(); i$.hasNext(); ++i) {
            Entry entry = (Entry)i$.next();
            preds[i] = EqualPredicate.equalPredicate(entry.getKey());
            trs[i] = (Closure)entry.getValue();
         }

         return switchClosure(preds, trs, def);
      }
   }
}
