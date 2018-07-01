package org.apache.commons.collections4.sequence;

public interface CommandVisitor {
   void visitInsertCommand(Object var1);

   void visitKeepCommand(Object var1);

   void visitDeleteCommand(Object var1);
}
