/* Generated By:JavaCC: Do not edit this line. FormulaParserTokenManager.java */
package formulaParser;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import btree.TreeNode;
import mainPro.ConfigPath;
import mainPro.Write2File;
import stanfordnlp.Demo;
import java.util.ArrayList;
import wordnet.GetWordSynsetsTest;
import pptlsat.PPTLSATRunTime;
import java.util.HashMap;
import DrawTree.DrawStandardizedTree;
import javax.swing.JOptionPane;

/** Token Manager. */
public class FormulaParserTokenManager implements FormulaParserConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x100L) != 0L)
         {
            jjmatchedKind = 40;
            return 7;
         }
         if ((active0 & 0xfffffffee0L) != 0L)
         {
            jjmatchedKind = 40;
            return 25;
         }
         if ((active0 & 0x200000000000L) != 0L)
            return 26;
         return -1;
      case 1:
         if ((active0 & 0x543ffff000L) != 0L)
            return 25;
         if ((active0 & 0xabc0000fe0L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 40;
               jjmatchedPos = 1;
            }
            return 25;
         }
         return -1;
      case 2:
         if ((active0 & 0x2a19f26e00L) != 0L)
            return 25;
         if ((active0 & 0x81c00001e0L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 2;
            return 25;
         }
         return -1;
      case 3:
         if ((active0 & 0x81000001a0L) != 0L)
            return 25;
         if ((active0 & 0xc0000040L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 3;
            return 25;
         }
         return -1;
      case 4:
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 4;
            return 25;
         }
         if ((active0 & 0x40000040L) != 0L)
            return 25;
         return -1;
      case 5:
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 5;
            return 25;
         }
         return -1;
      case 6:
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 6;
            return 25;
         }
         return -1;
      case 7:
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 7;
            return 25;
         }
         return -1;
      case 8:
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 8;
            return 25;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 44:
         return jjStopAtPos(0, 44);
      case 46:
         return jjStartNfaWithStates_0(0, 45, 26);
      case 59:
         return jjStopAtPos(0, 46);
      case 67:
         return jjMoveStringLiteralDfa1_0(0x18000L);
      case 68:
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      case 69:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 72:
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 73:
         return jjMoveStringLiteralDfa1_0(0x2000000L);
      case 74:
         return jjMoveStringLiteralDfa1_0(0x1c000000L);
      case 77:
         return jjMoveStringLiteralDfa1_0(0x80040000L);
      case 78:
         return jjMoveStringLiteralDfa1_0(0x7000L);
      case 80:
         return jjMoveStringLiteralDfa1_0(0x2800000000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x1020020000L);
      case 83:
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x4000000000L);
      case 86:
         return jjMoveStringLiteralDfa1_0(0x1f80000L);
      case 87:
         return jjMoveStringLiteralDfa1_0(0x100000c00L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x220L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x40L);
      default :
         return jjMoveNfa_0(4, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 66:
         if ((active0 & 0x80000L) != 0L)
         {
            jjmatchedKind = 19;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x20000000L) != 0L)
         {
            jjmatchedKind = 29;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x1f20000L);
      case 67:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(1, 16, 25);
         break;
      case 68:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(1, 15, 25);
         else if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(1, 18, 25);
         return jjMoveStringLiteralDfa2_0(active0, 0x800000800L);
      case 74:
         if ((active0 & 0x4000000L) != 0L)
         {
            jjmatchedKind = 26;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x18000000L);
      case 78:
         if ((active0 & 0x1000L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(1, 25, 25);
         return jjMoveStringLiteralDfa2_0(active0, 0x6000L);
      case 79:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 38, 25);
         break;
      case 80:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 36, 25);
         break;
      case 82:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000400L);
      case 84:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(1, 34, 25);
         break;
      case 89:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x80L);
      case 102:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000020L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x100L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 66:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(2, 10, 25);
         break;
      case 68:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(2, 20, 25);
         break;
      case 71:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(2, 21, 25);
         break;
      case 78:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(2, 22, 25);
         break;
      case 80:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(2, 14, 25);
         else if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(2, 23, 25);
         else if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 37, 25);
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000000L);
      case 82:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(2, 28, 25);
         break;
      case 83:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(2, 13, 25);
         else if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(2, 17, 25);
         else if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(2, 27, 25);
         break;
      case 84:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(2, 11, 25);
         else if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(2, 35, 25);
         break;
      case 90:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(2, 24, 25);
         break;
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x20L);
      case 100:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(2, 33, 25);
         break;
      case 102:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(2, 9, 25);
         break;
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x40L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x100L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x80L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 72:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 39, 25);
         break;
      case 101:
         if ((active0 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(3, 5, 25);
         break;
      case 104:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(3, 32, 25);
         break;
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x40L);
      case 110:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(3, 8, 25);
         break;
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000000L);
      case 115:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(3, 7, 25);
         break;
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(4, 6, 25);
         break;
      case 116:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(4, 30, 25);
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 111:
         return jjMoveStringLiteralDfa6_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 114:
         return jjMoveStringLiteralDfa7_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 105:
         return jjMoveStringLiteralDfa8_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 110:
         return jjMoveStringLiteralDfa9_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 103:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(9, 31, 25);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 25;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAddStates(0, 7);
                  }
                  else if ((0xa00000000000L & l) != 0L)
                  {
                     if (kind > 40)
                        kind = 40;
                  }
                  else if (curChar == 46)
                     jjCheckNAddTwoStates(1, 2);
                  if (curChar == 45)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAddTwoStates(14, 13);
                  }
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(1, 2);
                  else if (curChar == 46)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAdd(3);
                  }
                  break;
               case 25:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAddStates(8, 10);
                  }
                  else if (curChar == 45)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAddTwoStates(14, 13);
                  }
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAddStates(8, 10);
                  }
                  else if (curChar == 45)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAddTwoStates(14, 13);
                  }
                  break;
               case 0:
                  if (curChar == 46)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 2:
                  if (curChar != 46)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(3);
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(3);
                  break;
               case 13:
                  if (curChar != 45)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAddTwoStates(14, 13);
                  break;
               case 14:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAddStates(8, 10);
                  break;
               case 15:
                  if (curChar != 37)
                     break;
                  kind = 40;
                  jjCheckNAddTwoStates(14, 13);
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAddStates(0, 7);
                  break;
               case 17:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(17);
                  break;
               case 22:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(22);
                  break;
               case 23:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAddStates(11, 13);
                  break;
               case 24:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(24, 0);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAddTwoStates(14, 13);
                  }
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 11;
                  else if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 25:
               case 13:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAddTwoStates(14, 13);
                  break;
               case 7:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAddTwoStates(14, 13);
                  }
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 5:
                  if (curChar == 101 && kind > 43)
                     kind = 43;
                  break;
               case 6:
                  if (curChar == 117)
                     jjCheckNAdd(5);
                  break;
               case 8:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 9:
                  if (curChar == 115)
                     jjCheckNAdd(5);
                  break;
               case 10:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 12:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 18:
                  if ((0x7fffffeL & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAddTwoStates(18, 19);
                  break;
               case 19:
                  if ((0x7fffffe00000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(19);
                  break;
               case 20:
                  if ((0x7fffffeL & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAddStates(14, 16);
                  break;
               case 21:
                  if ((0x7fffffe00000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAddTwoStates(21, 22);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 25 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   17, 18, 19, 20, 21, 24, 0, 23, 15, 13, 14, 21, 22, 23, 20, 21, 
   23, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, "\157\156\143\145", "\167\150\151\154\145", 
"\154\145\163\163", "\164\165\162\156", "\157\146\146", "\127\122\102", "\127\104\124", 
"\116\116", "\116\116\123", "\116\116\120", "\103\104", "\103\103", "\122\102\123", 
"\115\104", "\126\102", "\126\102\104", "\126\102\107", "\126\102\116", "\126\102\120", 
"\126\102\132", "\111\116", "\112\112", "\112\112\123", "\112\112\122", "\122\102", 
"\123\164\141\162\164", "\115\157\156\151\164\157\162\151\156\147", "\127\151\164\150", 
"\105\156\144", "\104\124", "\120\104\124", "\122\120", "\120\122\120", "\124\117", 
"\110\131\120\110", null, null, null, null, "\54", "\56", "\73", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x7fffffffffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[25];
static private final int[] jjstateSet = new int[50];
static protected char curChar;
/** Constructor. */
public FormulaParserTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public FormulaParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 25; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
