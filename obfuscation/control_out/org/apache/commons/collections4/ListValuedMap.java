package org.apache.commons.collections4;

import java.util.List;

public interface ListValuedMap extends MultiValuedMap {
   List get(Object var1);

   List remove(Object var1);
}
