package org.a.a.a;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.a.a.a.f.class_448;

// $FF: renamed from: org.a.a.a.u
public class class_384 implements Iterable {
   // $FF: renamed from: a java.lang.Iterable
   private final Iterable field_675;

   // $FF: renamed from: a () org.a.a.a.u
   public static class_384 method_1107() {
      return class_402.field_709;
   }

   // $FF: renamed from: a (java.lang.Object) org.a.a.a.u
   public static class_384 method_1108(Object var0) {
      return method_1110(class_401.method_1215(new class_448(var0, false)));
   }

   // $FF: renamed from: a (java.lang.Object[]) org.a.a.a.u
   public static class_384 method_1109(Object... var0) {
      return method_1110(Arrays.asList(var0));
   }

   // $FF: renamed from: a (java.lang.Iterable) org.a.a.a.u
   public static class_384 method_1110(Iterable var0) {
      class_402.method_1274(var0);
      return var0 instanceof class_384 ? (class_384)var0 : new class_384(var0);
   }

   class_384() {
      this.field_675 = this;
   }

   private class_384(Iterable var1) {
      this.field_675 = var1;
   }

   // $FF: renamed from: b (java.lang.Object[]) org.a.a.a.u
   public class_384 method_1111(Object... var1) {
      return this.method_1112(Arrays.asList(var1));
   }

   // $FF: renamed from: b (java.lang.Iterable) org.a.a.a.u
   public class_384 method_1112(Iterable var1) {
      return method_1110(class_402.method_1237(this.field_675, var1));
   }

   // $FF: renamed from: c (java.lang.Iterable) org.a.a.a.u
   public class_384 method_1113(Iterable var1) {
      return method_1110(class_402.method_1241(this.field_675, var1));
   }

   // $FF: renamed from: a (java.lang.Iterable, java.util.Comparator) org.a.a.a.u
   public class_384 method_1114(Iterable var1, Comparator var2) {
      return method_1110(class_402.method_1242(var2, this.field_675, var1));
   }

   // $FF: renamed from: b () org.a.a.a.u
   public class_384 method_1115() {
      return method_1110(this.method_1136());
   }

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.u
   public class_384 method_1116(class_1 var1) {
      return method_1110(class_402.method_1243(this.field_675, var1));
   }

   // $FF: renamed from: a (long) org.a.a.a.u
   public class_384 method_1117(long var1) {
      return method_1110(class_402.method_1244(this.field_675, var1));
   }

   // $FF: renamed from: c () org.a.a.a.u
   public class_384 method_1118() {
      return method_1110(class_402.method_1245(this.field_675));
   }

   // $FF: renamed from: d () org.a.a.a.u
   public class_384 method_1119() {
      return method_1110(class_402.method_1246(this.field_675));
   }

   // $FF: renamed from: b (long) org.a.a.a.u
   public class_384 method_1120(long var1) {
      return method_1110(class_402.method_1247(this.field_675, var1));
   }

   // $FF: renamed from: a (org.a.a.a.aI) org.a.a.a.u
   public class_384 method_1121(class_21 var1) {
      return method_1110(class_402.method_1248(this.field_675, var1));
   }

   // $FF: renamed from: e () org.a.a.a.u
   public class_384 method_1122() {
      return method_1110(class_402.method_1249(this.field_675));
   }

   // $FF: renamed from: f () org.a.a.a.u
   public class_384 method_1123() {
      return method_1110(class_402.method_1250(this.field_675));
   }

   // $FF: renamed from: d (java.lang.Iterable) org.a.a.a.u
   public class_384 method_1124(Iterable var1) {
      return method_1110(class_402.method_1251(this.field_675, var1));
   }

   // $FF: renamed from: a (java.lang.Iterable[]) org.a.a.a.u
   public class_384 method_1125(Iterable... var1) {
      return method_1110(class_402.method_1252(this.field_675, var1));
   }

   public Iterator iterator() {
      return this.field_675.iterator();
   }

   // $FF: renamed from: g () java.util.Enumeration
   public Enumeration method_1126() {
      return class_401.method_1214(this.iterator());
   }

   // $FF: renamed from: b (org.a.a.a.an) boolean
   public boolean method_1127(class_1 var1) {
      return class_402.method_1258(this.field_675, var1);
   }

   // $FF: renamed from: c (org.a.a.a.an) boolean
   public boolean method_1128(class_1 var1) {
      return class_402.method_1259(this.field_675, var1);
   }

   // $FF: renamed from: h () boolean
   public boolean method_1129() {
      return class_402.method_1261(this.field_675);
   }

   // $FF: renamed from: b (java.lang.Object) boolean
   public boolean method_1130(Object var1) {
      return class_402.method_1262(this.field_675, var1);
   }

   // $FF: renamed from: a (org.a.a.a.g) void
   public void method_1131(class_34 var1) {
      class_402.method_1254(this.field_675, var1);
   }

   // $FF: renamed from: a (int) java.lang.Object
   public Object method_1132(int var1) {
      return class_402.method_1265(this.field_675, var1);
   }

   // $FF: renamed from: i () int
   public int method_1133() {
      return class_402.method_1266(this.field_675);
   }

   // $FF: renamed from: a (java.util.Collection) void
   public void method_1134(Collection var1) {
      if (var1 == null) {
         throw new NullPointerException("Collection must not be null");
      } else {
         class_415.method_1362(var1, this.field_675);
      }
   }

   // $FF: renamed from: a (java.lang.Class) java.lang.Object[]
   public Object[] method_1135(Class var1) {
      return class_401.method_1219(this.iterator(), var1);
   }

   // $FF: renamed from: j () java.util.List
   public List method_1136() {
      return class_402.method_1270(this.field_675);
   }

   public String toString() {
      return class_402.method_1271(this.field_675);
   }
}
