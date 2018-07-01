package org.apache.commons.collections4.functors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;

public class InstantiateFactory implements Factory {
   private final Class iClassToInstantiate;
   private final Class[] iParamTypes;
   private final Object[] iArgs;
   private transient Constructor iConstructor = null;

   public static Factory instantiateFactory(Class classToInstantiate, Class[] paramTypes, Object[] args) {
      if (classToInstantiate == null) {
         throw new NullPointerException("Class to instantiate must not be null");
      } else if (paramTypes == null && args != null || paramTypes != null && args == null || paramTypes != null && args != null && paramTypes.length != args.length) {
         throw new IllegalArgumentException("Parameter types must match the arguments");
      } else {
         return paramTypes != null && paramTypes.length != 0 ? new InstantiateFactory(classToInstantiate, paramTypes, args) : new InstantiateFactory(classToInstantiate);
      }
   }

   public InstantiateFactory(Class classToInstantiate) {
      this.iClassToInstantiate = classToInstantiate;
      this.iParamTypes = null;
      this.iArgs = null;
      this.findConstructor();
   }

   public InstantiateFactory(Class classToInstantiate, Class[] paramTypes, Object[] args) {
      this.iClassToInstantiate = classToInstantiate;
      this.iParamTypes = (Class[])paramTypes.clone();
      this.iArgs = (Object[])args.clone();
      this.findConstructor();
   }

   private void findConstructor() {
      try {
         this.iConstructor = this.iClassToInstantiate.getConstructor(this.iParamTypes);
      } catch (NoSuchMethodException var2) {
         throw new IllegalArgumentException("InstantiateFactory: The constructor must exist and be public ");
      }
   }

   public Object create() {
      if (this.iConstructor == null) {
         this.findConstructor();
      }

      try {
         return this.iConstructor.newInstance(this.iArgs);
      } catch (InstantiationException var2) {
         throw new FunctorException("InstantiateFactory: InstantiationException", var2);
      } catch (IllegalAccessException var3) {
         throw new FunctorException("InstantiateFactory: Constructor must be public", var3);
      } catch (InvocationTargetException var4) {
         throw new FunctorException("InstantiateFactory: Constructor threw an exception", var4);
      }
   }
}
