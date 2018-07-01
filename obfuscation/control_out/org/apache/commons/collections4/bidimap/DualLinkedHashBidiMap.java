package org.apache.commons.collections4.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.collections4.BidiMap;

public class DualLinkedHashBidiMap extends AbstractDualBidiMap implements Serializable {
   private static final long serialVersionUID = 721969328361810L;

   public DualLinkedHashBidiMap() {
      super(new LinkedHashMap(), new LinkedHashMap());
   }

   public DualLinkedHashBidiMap(Map map) {
      super(new LinkedHashMap(), new LinkedHashMap());
      this.putAll(map);
   }

   protected DualLinkedHashBidiMap(Map normalMap, Map reverseMap, BidiMap inverseBidiMap) {
      super(normalMap, reverseMap, inverseBidiMap);
   }

   protected BidiMap createBidiMap(Map normalMap, Map reverseMap, BidiMap inverseBidiMap) {
      return new DualLinkedHashBidiMap(normalMap, reverseMap, inverseBidiMap);
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.normalMap);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.normalMap = new LinkedHashMap();
      this.reverseMap = new LinkedHashMap();
      Map map = (Map)in.readObject();
      this.putAll(map);
   }
}
