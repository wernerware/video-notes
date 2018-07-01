package org.apache.commons.collections4.sequence;

public class InsertCommand extends EditCommand {
   public InsertCommand(Object object) {
      super(object);
   }

   public void accept(CommandVisitor visitor) {
      visitor.visitInsertCommand(this.getObject());
   }
}
