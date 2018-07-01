package org.apache.commons.collections4.sequence;

import java.util.List;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.functors.DefaultEquator;

public class SequencesComparator {
   private final List sequence1;
   private final List sequence2;
   private final Equator equator;
   private final int[] vDown;
   private final int[] vUp;

   public SequencesComparator(List sequence1, List sequence2) {
      this(sequence1, sequence2, DefaultEquator.defaultEquator());
   }

   public SequencesComparator(List sequence1, List sequence2, Equator equator) {
      this.sequence1 = sequence1;
      this.sequence2 = sequence2;
      this.equator = equator;
      int size = sequence1.size() + sequence2.size() + 2;
      this.vDown = new int[size];
      this.vUp = new int[size];
   }

   public EditScript getScript() {
      EditScript script = new EditScript();
      this.buildScript(0, this.sequence1.size(), 0, this.sequence2.size(), script);
      return script;
   }

   private SequencesComparator.Snake buildSnake(int start, int diag, int end1, int end2) {
      int end;
      for(end = start; end - diag < end2 && end < end1 && this.equator.equate(this.sequence1.get(end), this.sequence2.get(end - diag)); ++end) {
         ;
      }

      return new SequencesComparator.Snake(start, end, diag);
   }

   private SequencesComparator.Snake getMiddleSnake(int start1, int end1, int start2, int end2) {
      int m = end1 - start1;
      int n = end2 - start2;
      if (m != 0 && n != 0) {
         int delta = m - n;
         int sum = n + m;
         int offset = (sum % 2 == 0 ? sum : sum + 1) / 2;
         this.vDown[1 + offset] = start1;
         this.vUp[1 + offset] = end1 + 1;

         for(int d = 0; d <= offset; ++d) {
            int k;
            int i;
            int x;
            int y;
            for(k = -d; k <= d; k += 2) {
               i = k + offset;
               if (k != -d && (k == d || this.vDown[i - 1] >= this.vDown[i + 1])) {
                  this.vDown[i] = this.vDown[i - 1] + 1;
               } else {
                  this.vDown[i] = this.vDown[i + 1];
               }

               x = this.vDown[i];

               for(y = x - start1 + start2 - k; x < end1 && y < end2 && this.equator.equate(this.sequence1.get(x), this.sequence2.get(y)); ++y) {
                  ++x;
                  this.vDown[i] = x;
               }

               if (delta % 2 != 0 && delta - d <= k && k <= delta + d && this.vUp[i - delta] <= this.vDown[i]) {
                  return this.buildSnake(this.vUp[i - delta], k + start1 - start2, end1, end2);
               }
            }

            for(k = delta - d; k <= delta + d; k += 2) {
               i = k + offset - delta;
               if (k != delta - d && (k == delta + d || this.vUp[i + 1] > this.vUp[i - 1])) {
                  this.vUp[i] = this.vUp[i - 1];
               } else {
                  this.vUp[i] = this.vUp[i + 1] - 1;
               }

               x = this.vUp[i] - 1;

               for(y = x - start1 + start2 - k; x >= start1 && y >= start2 && this.equator.equate(this.sequence1.get(x), this.sequence2.get(y)); --y) {
                  this.vUp[i] = x--;
               }

               if (delta % 2 == 0 && -d <= k && k <= d && this.vUp[i] <= this.vDown[i + delta]) {
                  return this.buildSnake(this.vUp[i], k + start1 - start2, end1, end2);
               }
            }
         }

         throw new RuntimeException("Internal Error");
      } else {
         return null;
      }
   }

   private void buildScript(int start1, int end1, int start2, int end2, EditScript script) {
      SequencesComparator.Snake middle = this.getMiddleSnake(start1, end1, start2, end2);
      int i;
      if (middle != null && (middle.getStart() != end1 || middle.getDiag() != end1 - end2) && (middle.getEnd() != start1 || middle.getDiag() != start1 - start2)) {
         this.buildScript(start1, middle.getStart(), start2, middle.getStart() - middle.getDiag(), script);

         for(i = middle.getStart(); i < middle.getEnd(); ++i) {
            script.append(new KeepCommand(this.sequence1.get(i)));
         }

         this.buildScript(middle.getEnd(), end1, middle.getEnd() - middle.getDiag(), end2, script);
      } else {
         i = start1;
         int j = start2;

         while(true) {
            while(i < end1 || j < end2) {
               if (i < end1 && j < end2 && this.equator.equate(this.sequence1.get(i), this.sequence2.get(j))) {
                  script.append(new KeepCommand(this.sequence1.get(i)));
                  ++i;
                  ++j;
               } else if (end1 - start1 > end2 - start2) {
                  script.append(new DeleteCommand(this.sequence1.get(i)));
                  ++i;
               } else {
                  script.append(new InsertCommand(this.sequence2.get(j)));
                  ++j;
               }
            }

            return;
         }
      }
   }

   private static class Snake {
      private final int start;
      private final int end;
      private final int diag;

      public Snake(int start, int end, int diag) {
         this.start = start;
         this.end = end;
         this.diag = diag;
      }

      public int getStart() {
         return this.start;
      }

      public int getEnd() {
         return this.end;
      }

      public int getDiag() {
         return this.diag;
      }
   }
}
