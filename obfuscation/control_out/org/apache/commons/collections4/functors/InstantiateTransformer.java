package org.apache.commons.collections4.functors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

public class InstantiateTransformer implements Transformer {
   private static final Transformer NO_ARG_INSTANCE = new InstantiateTransformer();
   private final Class[] iParamTypes;
   private final Object[] iArgs;

   public static Transformer instantiateTransformer() {
      return NO_ARG_INSTANCE;
   }

   public static Transformer instantiateTransformer(Class[] paramTypes, Object[] args) {
      if (paramTypes == null && args != null || paramTypes != null && args == null || paramTypes != null && args != null && paramTypes.length != args.length) {
         throw new IllegalArgumentException("Parameter types must match the arguments");
      } else {
         return paramTypes != null && paramTypes.length != 0 ? new InstantiateTransformer(paramTypes, args) : new InstantiateTransformer();
      }
   }

   private InstantiateTransformer() {
      this.iParamTypes = null;
      this.iArgs = null;
   }

   public InstantiateTransformer(Class[] paramTypes, Object[] args) {
      this.iParamTypes = paramTypes != null ? (Class[])paramTypes.clone() : null;
      this.iArgs = args != null ? (Object[])args.clone() : null;
   }

   public Object transform(Class input) {
      try {
         if (input == null) {
            throw new FunctorException("InstantiateTransformer: Input object was not an instanceof Class, it was a null object");
         } else {
            Constructor con = input.getConstructor(this.iParamTypes);
            return con.newInstance(this.iArgs);
         }
      } catch (NoSuchMethodException var3) {
         throw new FunctorException("InstantiateTransformer: The constructor must exist and be public ");
      } catch (InstantiationException var4) {
         throw new FunctorException("InstantiateTransformer: InstantiationException", var4);
      } catch (IllegalAccessException var5) {
         throw new FunctorException("InstantiateTransformer: Constructor must be public", var5);
      } catch (InvocationTargetException var6) {
         throw new FunctorException("InstantiateTransformer: Constructor threw an exception", var6);
      }
   }
}
