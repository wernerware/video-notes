package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.SortedBag;

public class TreeBag extends AbstractMapBag implements SortedBag, Serializable {
   private static final long serialVersionUID = -7740146511091606676L;

   public TreeBag() {
      super(new TreeMap());
   }

   public TreeBag(Comparator comparator) {
      super(new TreeMap(comparator));
   }

   public TreeBag(Collection coll) {
      this();
      this.addAll(coll);
   }

   public boolean add(Object object) {
      if (this.comparator() == null && !(object instanceof Comparable)) {
         if (object == null) {
            throw new NullPointerException();
         } else {
            throw new IllegalArgumentException("Objects of type " + object.getClass() + " cannot be added to " + "a naturally ordered TreeBag as it does not implement Comparable");
         }
      } else {
         return super.add(object);
      }
   }

   public Object first() {
      return this.getMap().firstKey();
   }

   public Object last() {
      return this.getMap().lastKey();
   }

   public Comparator comparator() {
      return this.getMap().comparator();
   }

   protected SortedMap getMap() {
      return (SortedMap)super.getMap();
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.comparator());
      super.doWriteObject(out);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      Comparator comp = (Comparator)in.readObject();
      super.doReadObject(new TreeMap(comp), in);
   }
}
