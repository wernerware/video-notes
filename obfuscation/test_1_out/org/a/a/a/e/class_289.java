package org.a.a.a.e;

import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;
import org.a.a.a.class_21;
import org.a.a.a.class_34;

// $FF: renamed from: org.a.a.a.e.x
class class_289 {
   // $FF: renamed from: a (org.a.a.a.an[]) org.a.a.a.an[]
   static APPARENTLY_REALLY_IMPORTANT[] method_673(APPARENTLY_REALLY_IMPORTANT... var0) {
      return var0 == null ? null : (APPARENTLY_REALLY_IMPORTANT[])((APPARENTLY_REALLY_IMPORTANT[])var0.clone());
   }

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.an
   static APPARENTLY_REALLY_IMPORTANT method_674(APPARENTLY_REALLY_IMPORTANT var0) {
      return var0;
   }

   // $FF: renamed from: b (org.a.a.a.an[]) void
   static void method_675(APPARENTLY_REALLY_IMPORTANT... var0) {
      if (var0 == null) {
         throw new NullPointerException("The predicate array must not be null");
      } else {
         for(int var1 = 0; var1 < var0.length; ++var1) {
            if (var0[var1] == null) {
               throw new NullPointerException("The predicate array must not contain a null predicate, index " + var1 + " was null");
            }
         }

      }
   }

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.an[]
   static APPARENTLY_REALLY_IMPORTANT[] method_676(Collection var0) {
      if (var0 == null) {
         throw new NullPointerException("The predicate collection must not be null");
      } else {
         APPARENTLY_REALLY_IMPORTANT[] var1 = new APPARENTLY_REALLY_IMPORTANT[var0.size()];
         int var2 = 0;

         for(Iterator var3 = var0.iterator(); var3.hasNext(); ++var2) {
            APPARENTLY_REALLY_IMPORTANT var4 = (APPARENTLY_REALLY_IMPORTANT)var3.next();
            var1[var2] = var4;
            if (var1[var2] == null) {
               throw new NullPointerException("The predicate collection must not contain a null predicate, index " + var2 + " was null");
            }
         }

         return var1;
      }
   }

   // $FF: renamed from: a (org.a.a.a.g[]) org.a.a.a.g[]
   static class_34[] method_677(class_34... var0) {
      return var0 == null ? null : (class_34[])((class_34[])var0.clone());
   }

   // $FF: renamed from: b (org.a.a.a.g[]) void
   static void method_678(class_34... var0) {
      if (var0 == null) {
         throw new NullPointerException("The closure array must not be null");
      } else {
         for(int var1 = 0; var1 < var0.length; ++var1) {
            if (var0[var1] == null) {
               throw new NullPointerException("The closure array must not contain a null closure, index " + var1 + " was null");
            }
         }

      }
   }

   // $FF: renamed from: a (org.a.a.a.g) org.a.a.a.g
   static class_34 method_679(class_34 var0) {
      return var0;
   }

   // $FF: renamed from: a (org.a.a.a.aI[]) org.a.a.a.aI[]
   static class_21[] method_680(class_21... var0) {
      return var0 == null ? null : (class_21[])((class_21[])var0.clone());
   }

   // $FF: renamed from: b (org.a.a.a.aI[]) void
   static void method_681(class_21... var0) {
      if (var0 == null) {
         throw new NullPointerException("The transformer array must not be null");
      } else {
         for(int var1 = 0; var1 < var0.length; ++var1) {
            if (var0[var1] == null) {
               throw new NullPointerException("The transformer array must not contain a null transformer, index " + var1 + " was null");
            }
         }

      }
   }

   // $FF: renamed from: a (org.a.a.a.aI) org.a.a.a.aI
   static class_21 method_682(class_21 var0) {
      return var0;
   }
}
