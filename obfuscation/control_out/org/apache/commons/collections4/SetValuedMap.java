package org.apache.commons.collections4;

import java.util.Set;

public interface SetValuedMap extends MultiValuedMap {
   Set get(Object var1);

   Set remove(Object var1);
}
