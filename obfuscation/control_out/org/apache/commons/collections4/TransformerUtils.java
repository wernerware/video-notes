package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.functors.ChainedTransformer;
import org.apache.commons.collections4.functors.CloneTransformer;
import org.apache.commons.collections4.functors.ClosureTransformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.ExceptionTransformer;
import org.apache.commons.collections4.functors.FactoryTransformer;
import org.apache.commons.collections4.functors.IfTransformer;
import org.apache.commons.collections4.functors.InstantiateTransformer;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.apache.commons.collections4.functors.MapTransformer;
import org.apache.commons.collections4.functors.NOPTransformer;
import org.apache.commons.collections4.functors.PredicateTransformer;
import org.apache.commons.collections4.functors.StringValueTransformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

public class TransformerUtils {
   public static Transformer exceptionTransformer() {
      return ExceptionTransformer.exceptionTransformer();
   }

   public static Transformer nullTransformer() {
      return ConstantTransformer.nullTransformer();
   }

   public static Transformer nopTransformer() {
      return NOPTransformer.nopTransformer();
   }

   public static Transformer cloneTransformer() {
      return CloneTransformer.cloneTransformer();
   }

   public static Transformer constantTransformer(Object constantToReturn) {
      return ConstantTransformer.constantTransformer(constantToReturn);
   }

   public static Transformer asTransformer(Closure closure) {
      return ClosureTransformer.closureTransformer(closure);
   }

   public static Transformer asTransformer(Predicate predicate) {
      return PredicateTransformer.predicateTransformer(predicate);
   }

   public static Transformer asTransformer(Factory factory) {
      return FactoryTransformer.factoryTransformer(factory);
   }

   public static Transformer chainedTransformer(Transformer... transformers) {
      return ChainedTransformer.chainedTransformer(transformers);
   }

   public static Transformer chainedTransformer(Collection transformers) {
      return ChainedTransformer.chainedTransformer(transformers);
   }

   public static Transformer ifTransformer(Predicate predicate, Transformer trueTransformer) {
      return IfTransformer.ifTransformer(predicate, trueTransformer);
   }

   public static Transformer ifTransformer(Predicate predicate, Transformer trueTransformer, Transformer falseTransformer) {
      return IfTransformer.ifTransformer(predicate, trueTransformer, falseTransformer);
   }

   /** @deprecated */
   @Deprecated
   public static Transformer switchTransformer(Predicate predicate, Transformer trueTransformer, Transformer falseTransformer) {
      return SwitchTransformer.switchTransformer(new Predicate[]{predicate}, new Transformer[]{trueTransformer}, falseTransformer);
   }

   public static Transformer switchTransformer(Predicate[] predicates, Transformer[] transformers) {
      return SwitchTransformer.switchTransformer(predicates, transformers, (Transformer)null);
   }

   public static Transformer switchTransformer(Predicate[] predicates, Transformer[] transformers, Transformer defaultTransformer) {
      return SwitchTransformer.switchTransformer(predicates, transformers, defaultTransformer);
   }

   public static Transformer switchTransformer(Map predicatesAndTransformers) {
      return SwitchTransformer.switchTransformer(predicatesAndTransformers);
   }

   public static Transformer switchMapTransformer(Map objectsAndTransformers) {
      if (objectsAndTransformers == null) {
         throw new NullPointerException("The object and transformer map must not be null");
      } else {
         Transformer def = (Transformer)objectsAndTransformers.remove((Object)null);
         int size = objectsAndTransformers.size();
         Transformer[] trs = new Transformer[size];
         Predicate[] preds = new Predicate[size];
         int i = 0;

         Entry entry;
         for(Iterator i$ = objectsAndTransformers.entrySet().iterator(); i$.hasNext(); trs[i++] = (Transformer)entry.getValue()) {
            entry = (Entry)i$.next();
            preds[i] = EqualPredicate.equalPredicate(entry.getKey());
         }

         return switchTransformer(preds, trs, def);
      }
   }

   public static Transformer instantiateTransformer() {
      return InstantiateTransformer.instantiateTransformer();
   }

   public static Transformer instantiateTransformer(Class[] paramTypes, Object[] args) {
      return InstantiateTransformer.instantiateTransformer(paramTypes, args);
   }

   public static Transformer mapTransformer(Map map) {
      return MapTransformer.mapTransformer(map);
   }

   public static Transformer invokerTransformer(String methodName) {
      return InvokerTransformer.invokerTransformer(methodName, (Class[])null, (Object[])null);
   }

   public static Transformer invokerTransformer(String methodName, Class[] paramTypes, Object[] args) {
      return InvokerTransformer.invokerTransformer(methodName, paramTypes, args);
   }

   public static Transformer stringValueTransformer() {
      return StringValueTransformer.stringValueTransformer();
   }
}
