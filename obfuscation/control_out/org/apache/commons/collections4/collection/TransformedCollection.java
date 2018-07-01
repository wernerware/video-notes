package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.Transformer;

public class TransformedCollection extends AbstractCollectionDecorator {
   private static final long serialVersionUID = 8692300188161871514L;
   protected final Transformer transformer;

   public static TransformedCollection transformingCollection(Collection coll, Transformer transformer) {
      return new TransformedCollection(coll, transformer);
   }

   public static TransformedCollection transformedCollection(Collection collection, Transformer transformer) {
      TransformedCollection decorated = new TransformedCollection(collection, transformer);
      if (collection.size() > 0) {
         Object[] values = (Object[])collection.toArray();
         collection.clear();
         Object[] arr$ = values;
         int len$ = values.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            Object value = arr$[i$];
            decorated.decorated().add(transformer.transform(value));
         }
      }

      return decorated;
   }

   protected TransformedCollection(Collection coll, Transformer transformer) {
      super(coll);
      if (transformer == null) {
         throw new NullPointerException("Transformer must not be null");
      } else {
         this.transformer = transformer;
      }
   }

   protected Object transform(Object object) {
      return this.transformer.transform(object);
   }

   protected Collection transform(Collection coll) {
      List list = new ArrayList(coll.size());
      Iterator i$ = coll.iterator();

      while(i$.hasNext()) {
         Object item = i$.next();
         list.add(this.transform(item));
      }

      return list;
   }

   public boolean add(Object object) {
      return this.decorated().add(this.transform(object));
   }

   public boolean addAll(Collection coll) {
      return this.decorated().addAll(this.transform(coll));
   }
}
