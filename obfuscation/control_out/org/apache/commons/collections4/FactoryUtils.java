package org.apache.commons.collections4;

import org.apache.commons.collections4.functors.ConstantFactory;
import org.apache.commons.collections4.functors.ExceptionFactory;
import org.apache.commons.collections4.functors.InstantiateFactory;
import org.apache.commons.collections4.functors.PrototypeFactory;

public class FactoryUtils {
   public static Factory exceptionFactory() {
      return ExceptionFactory.exceptionFactory();
   }

   public static Factory nullFactory() {
      return ConstantFactory.constantFactory((Object)null);
   }

   public static Factory constantFactory(Object constantToReturn) {
      return ConstantFactory.constantFactory(constantToReturn);
   }

   public static Factory prototypeFactory(Object prototype) {
      return PrototypeFactory.prototypeFactory(prototype);
   }

   public static Factory instantiateFactory(Class classToInstantiate) {
      return InstantiateFactory.instantiateFactory(classToInstantiate, (Class[])null, (Object[])null);
   }

   public static Factory instantiateFactory(Class classToInstantiate, Class[] paramTypes, Object[] args) {
      return InstantiateFactory.instantiateFactory(classToInstantiate, paramTypes, args);
   }
}
