package org.apache.commons.collections4;

import java.util.Collection;
import org.apache.commons.collections4.functors.AllPredicate;
import org.apache.commons.collections4.functors.AndPredicate;
import org.apache.commons.collections4.functors.AnyPredicate;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.ExceptionPredicate;
import org.apache.commons.collections4.functors.FalsePredicate;
import org.apache.commons.collections4.functors.IdentityPredicate;
import org.apache.commons.collections4.functors.InstanceofPredicate;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.apache.commons.collections4.functors.NonePredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.NotPredicate;
import org.apache.commons.collections4.functors.NullIsExceptionPredicate;
import org.apache.commons.collections4.functors.NullIsFalsePredicate;
import org.apache.commons.collections4.functors.NullIsTruePredicate;
import org.apache.commons.collections4.functors.NullPredicate;
import org.apache.commons.collections4.functors.OnePredicate;
import org.apache.commons.collections4.functors.OrPredicate;
import org.apache.commons.collections4.functors.TransformedPredicate;
import org.apache.commons.collections4.functors.TransformerPredicate;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.functors.UniquePredicate;

public class PredicateUtils {
   public static Predicate exceptionPredicate() {
      return ExceptionPredicate.exceptionPredicate();
   }

   public static Predicate truePredicate() {
      return TruePredicate.truePredicate();
   }

   public static Predicate falsePredicate() {
      return FalsePredicate.falsePredicate();
   }

   public static Predicate nullPredicate() {
      return NullPredicate.nullPredicate();
   }

   public static Predicate notNullPredicate() {
      return NotNullPredicate.notNullPredicate();
   }

   public static Predicate equalPredicate(Object value) {
      return EqualPredicate.equalPredicate(value);
   }

   public static Predicate identityPredicate(Object value) {
      return IdentityPredicate.identityPredicate(value);
   }

   public static Predicate instanceofPredicate(Class type) {
      return InstanceofPredicate.instanceOfPredicate(type);
   }

   public static Predicate uniquePredicate() {
      return UniquePredicate.uniquePredicate();
   }

   public static Predicate invokerPredicate(String methodName) {
      return asPredicate(InvokerTransformer.invokerTransformer(methodName));
   }

   public static Predicate invokerPredicate(String methodName, Class[] paramTypes, Object[] args) {
      return asPredicate(InvokerTransformer.invokerTransformer(methodName, paramTypes, args));
   }

   public static Predicate andPredicate(Predicate predicate1, Predicate predicate2) {
      return AndPredicate.andPredicate(predicate1, predicate2);
   }

   public static Predicate allPredicate(Predicate... predicates) {
      return AllPredicate.allPredicate(predicates);
   }

   public static Predicate allPredicate(Collection predicates) {
      return AllPredicate.allPredicate(predicates);
   }

   public static Predicate orPredicate(Predicate predicate1, Predicate predicate2) {
      return OrPredicate.orPredicate(predicate1, predicate2);
   }

   public static Predicate anyPredicate(Predicate... predicates) {
      return AnyPredicate.anyPredicate(predicates);
   }

   public static Predicate anyPredicate(Collection predicates) {
      return AnyPredicate.anyPredicate(predicates);
   }

   public static Predicate eitherPredicate(Predicate predicate1, Predicate predicate2) {
      Predicate onePredicate = onePredicate(predicate1, predicate2);
      return onePredicate;
   }

   public static Predicate onePredicate(Predicate... predicates) {
      return OnePredicate.onePredicate(predicates);
   }

   public static Predicate onePredicate(Collection predicates) {
      return OnePredicate.onePredicate(predicates);
   }

   public static Predicate neitherPredicate(Predicate predicate1, Predicate predicate2) {
      Predicate nonePredicate = nonePredicate(predicate1, predicate2);
      return nonePredicate;
   }

   public static Predicate nonePredicate(Predicate... predicates) {
      return NonePredicate.nonePredicate(predicates);
   }

   public static Predicate nonePredicate(Collection predicates) {
      return NonePredicate.nonePredicate(predicates);
   }

   public static Predicate notPredicate(Predicate predicate) {
      return NotPredicate.notPredicate(predicate);
   }

   public static Predicate asPredicate(Transformer transformer) {
      return TransformerPredicate.transformerPredicate(transformer);
   }

   public static Predicate nullIsExceptionPredicate(Predicate predicate) {
      return NullIsExceptionPredicate.nullIsExceptionPredicate(predicate);
   }

   public static Predicate nullIsFalsePredicate(Predicate predicate) {
      return NullIsFalsePredicate.nullIsFalsePredicate(predicate);
   }

   public static Predicate nullIsTruePredicate(Predicate predicate) {
      return NullIsTruePredicate.nullIsTruePredicate(predicate);
   }

   public static Predicate transformedPredicate(Transformer transformer, Predicate predicate) {
      return TransformedPredicate.transformedPredicate(transformer, predicate);
   }
}
