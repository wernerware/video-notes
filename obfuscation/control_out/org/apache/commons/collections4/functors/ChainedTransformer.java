package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections4.Transformer;

public class ChainedTransformer implements Transformer, Serializable {
   private static final long serialVersionUID = 3514945074733160196L;
   private final Transformer[] iTransformers;

   public static Transformer chainedTransformer(Transformer... transformers) {
      FunctorUtils.validate(transformers);
      return (Transformer)(transformers.length == 0 ? NOPTransformer.nopTransformer() : new ChainedTransformer(transformers));
   }

   public static Transformer chainedTransformer(Collection transformers) {
      if (transformers == null) {
         throw new NullPointerException("Transformer collection must not be null");
      } else if (transformers.size() == 0) {
         return NOPTransformer.nopTransformer();
      } else {
         Transformer[] cmds = (Transformer[])transformers.toArray(new Transformer[transformers.size()]);
         FunctorUtils.validate(cmds);
         return new ChainedTransformer(false, cmds);
      }
   }

   private ChainedTransformer(boolean clone, Transformer[] transformers) {
      this.iTransformers = clone ? FunctorUtils.copy(transformers) : transformers;
   }

   public ChainedTransformer(Transformer... transformers) {
      this(true, transformers);
   }

   public Object transform(Object object) {
      Transformer[] arr$ = this.iTransformers;
      int len$ = arr$.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         Transformer iTransformer = arr$[i$];
         object = iTransformer.transform(object);
      }

      return object;
   }

   public Transformer[] getTransformers() {
      return FunctorUtils.copy(this.iTransformers);
   }
}
