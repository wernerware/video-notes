package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class HashBag extends AbstractMapBag implements Serializable {
   private static final long serialVersionUID = -6561115435802554013L;

   public HashBag() {
      super(new HashMap());
   }

   public HashBag(Collection coll) {
      this();
      this.addAll(coll);
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      super.doWriteObject(out);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      super.doReadObject(new HashMap(), in);
   }
}
