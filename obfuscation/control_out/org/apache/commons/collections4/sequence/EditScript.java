package org.apache.commons.collections4.sequence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditScript {
   private final List commands = new ArrayList();
   private int lcsLength = 0;
   private int modifications = 0;

   public void append(KeepCommand command) {
      this.commands.add(command);
      ++this.lcsLength;
   }

   public void append(InsertCommand command) {
      this.commands.add(command);
      ++this.modifications;
   }

   public void append(DeleteCommand command) {
      this.commands.add(command);
      ++this.modifications;
   }

   public void visit(CommandVisitor visitor) {
      Iterator i$ = this.commands.iterator();

      while(i$.hasNext()) {
         EditCommand command = (EditCommand)i$.next();
         command.accept(visitor);
      }

   }

   public int getLCSLength() {
      return this.lcsLength;
   }

   public int getModifications() {
      return this.modifications;
   }
}
