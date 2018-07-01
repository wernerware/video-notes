package org.apache.commons.collections4.functors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

public class InvokerTransformer implements Transformer {
   private final String iMethodName;
   private final Class[] iParamTypes;
   private final Object[] iArgs;

   public static Transformer invokerTransformer(String methodName) {
      if (methodName == null) {
         throw new NullPointerException("The method to invoke must not be null");
      } else {
         return new InvokerTransformer(methodName);
      }
   }

   public static Transformer invokerTransformer(String methodName, Class[] paramTypes, Object[] args) {
      if (methodName == null) {
         throw new NullPointerException("The method to invoke must not be null");
      } else if (paramTypes == null && args != null || paramTypes != null && args == null || paramTypes != null && args != null && paramTypes.length != args.length) {
         throw new IllegalArgumentException("The parameter types must match the arguments");
      } else {
         return paramTypes != null && paramTypes.length != 0 ? new InvokerTransformer(methodName, paramTypes, args) : new InvokerTransformer(methodName);
      }
   }

   private InvokerTransformer(String methodName) {
      this.iMethodName = methodName;
      this.iParamTypes = null;
      this.iArgs = null;
   }

   public InvokerTransformer(String methodName, Class[] paramTypes, Object[] args) {
      this.iMethodName = methodName;
      this.iParamTypes = paramTypes != null ? (Class[])paramTypes.clone() : null;
      this.iArgs = args != null ? (Object[])args.clone() : null;
   }

   public Object transform(Object input) {
      if (input == null) {
         return null;
      } else {
         try {
            Class cls = input.getClass();
            Method method = cls.getMethod(this.iMethodName, this.iParamTypes);
            return method.invoke(input, this.iArgs);
         } catch (NoSuchMethodException var4) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + input.getClass() + "' does not exist");
         } catch (IllegalAccessException var5) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + input.getClass() + "' cannot be accessed");
         } catch (InvocationTargetException var6) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + input.getClass() + "' threw an exception", var6);
         }
      }
   }
}
