package org.apache.commons.collections4.sequence;

public class KeepCommand extends EditCommand {
   public KeepCommand(Object object) {
      super(object);
   }

   public void accept(CommandVisitor visitor) {
      visitor.visitKeepCommand(this.getObject());
   }
}
