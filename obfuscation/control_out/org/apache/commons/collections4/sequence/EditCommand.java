package org.apache.commons.collections4.sequence;

public abstract class EditCommand {
   private final Object object;

   protected EditCommand(Object object) {
      this.object = object;
   }

   protected Object getObject() {
      return this.object;
   }

   public abstract void accept(CommandVisitor var1);
}
