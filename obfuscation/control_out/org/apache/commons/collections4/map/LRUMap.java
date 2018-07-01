package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.BoundedMap;

public class LRUMap extends AbstractLinkedMap implements BoundedMap, Serializable, Cloneable {
   private static final long serialVersionUID = -612114643488955218L;
   protected static final int DEFAULT_MAX_SIZE = 100;
   private transient int maxSize;
   private boolean scanUntilRemovable;

   public LRUMap() {
      this(100, 0.75F, false);
   }

   public LRUMap(int maxSize) {
      this(maxSize, 0.75F);
   }

   public LRUMap(int maxSize, int initialSize) {
      this(maxSize, initialSize, 0.75F);
   }

   public LRUMap(int maxSize, boolean scanUntilRemovable) {
      this(maxSize, 0.75F, scanUntilRemovable);
   }

   public LRUMap(int maxSize, float loadFactor) {
      this(maxSize, loadFactor, false);
   }

   public LRUMap(int maxSize, int initialSize, float loadFactor) {
      this(maxSize, initialSize, loadFactor, false);
   }

   public LRUMap(int maxSize, float loadFactor, boolean scanUntilRemovable) {
      this(maxSize, maxSize, loadFactor, scanUntilRemovable);
   }

   public LRUMap(int maxSize, int initialSize, float loadFactor, boolean scanUntilRemovable) {
      super(initialSize, loadFactor);
      if (maxSize < 1) {
         throw new IllegalArgumentException("LRUMap max size must be greater than 0");
      } else if (initialSize > maxSize) {
         throw new IllegalArgumentException("LRUMap initial size must not be greather than max size");
      } else {
         this.maxSize = maxSize;
         this.scanUntilRemovable = scanUntilRemovable;
      }
   }

   public LRUMap(Map map) {
      this(map, false);
   }

   public LRUMap(Map map, boolean scanUntilRemovable) {
      this(map.size(), 0.75F, scanUntilRemovable);
      this.putAll(map);
   }

   public Object get(Object key) {
      return this.get(key, true);
   }

   public Object get(Object key, boolean updateToMRU) {
      AbstractLinkedMap.LinkEntry entry = this.getEntry(key);
      if (entry == null) {
         return null;
      } else {
         if (updateToMRU) {
            this.moveToMRU(entry);
         }

         return entry.getValue();
      }
   }

   protected void moveToMRU(AbstractLinkedMap.LinkEntry entry) {
      if (entry.after != this.header) {
         ++this.modCount;
         if (entry.before == null) {
            throw new IllegalStateException("Entry.before is null. Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
         }

         entry.before.after = entry.after;
         entry.after.before = entry.before;
         entry.after = this.header;
         entry.before = this.header.before;
         this.header.before.after = entry;
         this.header.before = entry;
      } else if (entry == this.header) {
         throw new IllegalStateException("Can't move header to MRU (please report this to dev@commons.apache.org)");
      }

   }

   protected void updateEntry(AbstractHashedMap.HashEntry entry, Object newValue) {
      this.moveToMRU((AbstractLinkedMap.LinkEntry)entry);
      entry.setValue(newValue);
   }

   protected void addMapping(int hashIndex, int hashCode, Object key, Object value) {
      if (this.isFull()) {
         AbstractLinkedMap.LinkEntry reuse = this.header.after;
         boolean removeLRUEntry = false;
         if (!this.scanUntilRemovable) {
            removeLRUEntry = this.removeLRU(reuse);
         } else {
            while(reuse != this.header && reuse != null) {
               if (this.removeLRU(reuse)) {
                  removeLRUEntry = true;
                  break;
               }

               reuse = reuse.after;
            }

            if (reuse == null) {
               throw new IllegalStateException("Entry.after=null, header.after" + this.header.after + " header.before" + this.header.before + " key=" + key + " value=" + value + " size=" + this.size + " maxSize=" + this.maxSize + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
            }
         }

         if (removeLRUEntry) {
            if (reuse == null) {
               throw new IllegalStateException("reuse=null, header.after=" + this.header.after + " header.before" + this.header.before + " key=" + key + " value=" + value + " size=" + this.size + " maxSize=" + this.maxSize + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
            }

            this.reuseMapping(reuse, hashIndex, hashCode, key, value);
         } else {
            super.addMapping(hashIndex, hashCode, key, value);
         }
      } else {
         super.addMapping(hashIndex, hashCode, key, value);
      }

   }

   protected void reuseMapping(AbstractLinkedMap.LinkEntry param1, int param2, int param3, Object param4, Object param5) {
      // $FF: Couldn't be decompiled
   }

   protected boolean removeLRU(AbstractLinkedMap.LinkEntry entry) {
      return true;
   }

   public boolean isFull() {
      return this.size >= this.maxSize;
   }

   public int maxSize() {
      return this.maxSize;
   }

   public boolean isScanUntilRemovable() {
      return this.scanUntilRemovable;
   }

   public LRUMap clone() {
      return (LRUMap)super.clone();
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      this.doWriteObject(out);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.doReadObject(in);
   }

   protected void doWriteObject(ObjectOutputStream out) throws IOException {
      out.writeInt(this.maxSize);
      super.doWriteObject(out);
   }

   protected void doReadObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      this.maxSize = in.readInt();
      super.doReadObject(in);
   }
}
