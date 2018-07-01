package org.a.a.a.e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.a.a.a.class_32;
import org.a.a.a.class_427;

// $FF: renamed from: org.a.a.a.e.W
class class_267 implements class_32 {
   // $FF: renamed from: a java.io.Serializable
   private final Serializable field_400;

   private class_267(Serializable var1) {
      this.field_400 = var1;
   }

   // $FF: renamed from: b () java.io.Serializable
   public Serializable method_633() {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream(512);
      ByteArrayInputStream var2 = null;

      Serializable var5;
      try {
         ObjectOutputStream var3 = new ObjectOutputStream(var1);
         var3.writeObject(this.field_400);
         var2 = new ByteArrayInputStream(var1.toByteArray());
         ObjectInputStream var4 = new ObjectInputStream(var2);
         var5 = (Serializable)var4.readObject();
      } catch (ClassNotFoundException var18) {
         throw new class_427(var18);
      } catch (IOException var19) {
         throw new class_427(var19);
      } finally {
         try {
            if (var2 != null) {
               var2.close();
            }
         } catch (IOException var17) {
            ;
         }

         try {
            var1.close();
         } catch (IOException var16) {
            ;
         }

      }

      return var5;
   }

   // $FF: renamed from: a () java.lang.Object
   // $FF: synthetic method
   public Object method_67() {
      return this.method_633();
   }

   // $FF: synthetic method
   class_267(Serializable var1, class_269 var2) {
      this(var1);
   }
}
