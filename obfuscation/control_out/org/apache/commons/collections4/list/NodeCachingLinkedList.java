package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

public class NodeCachingLinkedList extends AbstractLinkedList implements Serializable {
   private static final long serialVersionUID = 6897789178562232073L;
   private static final int DEFAULT_MAXIMUM_CACHE_SIZE = 20;
   private transient AbstractLinkedList.Node firstCachedNode;
   private transient int cacheSize;
   private int maximumCacheSize;

   public NodeCachingLinkedList() {
      this(20);
   }

   public NodeCachingLinkedList(Collection coll) {
      super(coll);
      this.maximumCacheSize = 20;
   }

   public NodeCachingLinkedList(int maximumCacheSize) {
      this.maximumCacheSize = maximumCacheSize;
      this.init();
   }

   protected int getMaximumCacheSize() {
      return this.maximumCacheSize;
   }

   protected void setMaximumCacheSize(int maximumCacheSize) {
      this.maximumCacheSize = maximumCacheSize;
      this.shrinkCacheToMaximumSize();
   }

   protected void shrinkCacheToMaximumSize() {
      while(this.cacheSize > this.maximumCacheSize) {
         this.getNodeFromCache();
      }

   }

   protected AbstractLinkedList.Node getNodeFromCache() {
      if (this.cacheSize == 0) {
         return null;
      } else {
         AbstractLinkedList.Node cachedNode = this.firstCachedNode;
         this.firstCachedNode = cachedNode.next;
         cachedNode.next = null;
         --this.cacheSize;
         return cachedNode;
      }
   }

   protected boolean isCacheFull() {
      return this.cacheSize >= this.maximumCacheSize;
   }

   protected void addNodeToCache(AbstractLinkedList.Node node) {
      if (!this.isCacheFull()) {
         AbstractLinkedList.Node nextCachedNode = this.firstCachedNode;
         node.previous = null;
         node.next = nextCachedNode;
         node.setValue((Object)null);
         this.firstCachedNode = node;
         ++this.cacheSize;
      }
   }

   protected AbstractLinkedList.Node createNode(Object value) {
      AbstractLinkedList.Node cachedNode = this.getNodeFromCache();
      if (cachedNode == null) {
         return super.createNode(value);
      } else {
         cachedNode.setValue(value);
         return cachedNode;
      }
   }

   protected void removeNode(AbstractLinkedList.Node node) {
      super.removeNode(node);
      this.addNodeToCache(node);
   }

   protected void removeAllNodes() {
      int numberOfNodesToCache = Math.min(this.size, this.maximumCacheSize - this.cacheSize);
      AbstractLinkedList.Node node = this.header.next;

      for(int currentIndex = 0; currentIndex < numberOfNodesToCache; ++currentIndex) {
         AbstractLinkedList.Node oldNode = node;
         node = node.next;
         this.addNodeToCache(oldNode);
      }

      super.removeAllNodes();
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      this.doWriteObject(out);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.doReadObject(in);
   }
}
