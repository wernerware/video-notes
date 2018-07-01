package org.a.a.a.i;

// $FF: renamed from: org.a.a.a.i.G
public enum class_491 {
   // $FF: renamed from: a org.a.a.a.i.G
   field_896(0),
   // $FF: renamed from: b org.a.a.a.i.G
   field_897(1),
   // $FF: renamed from: c org.a.a.a.i.G
   field_898(2);

   // $FF: renamed from: d int
   public final int field_899;

   // $FF: renamed from: a (int) org.a.a.a.i.G
   public static class_491 method_1585(int var0) {
      switch(var0) {
      case 0:
         return field_896;
      case 1:
         return field_897;
      case 2:
         return field_898;
      default:
         throw new IllegalArgumentException();
      }
   }

   private class_491(int var3) {
      this.field_899 = var3;
   }
}
