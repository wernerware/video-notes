package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;

public abstract class AbstractSerializableListDecorator extends AbstractListDecorator {
   private static final long serialVersionUID = 2684959196747496299L;

   protected AbstractSerializableListDecorator(List list) {
      super(list);
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.decorated());
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.setCollection((Collection)in.readObject());
   }
}
