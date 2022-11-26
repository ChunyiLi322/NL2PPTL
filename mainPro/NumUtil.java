package mainPro;

/**
*lichunyi  补充
*用来处理字符串中包含数字成分
*如果想修改，systemout注释放开调试

* 
* 主体思路为
*   （1）第一层循环判断第一个数字的开始位置，第二个循环判断第一个数字的结束位置。count表示句子中一共存在几个数字,如果0个数字就直接返回原句子
* 		(2)使用string builder将其中的数字替换
* 			(3)递归(1)(2)步骤，替换第二个数字，直到count=0
* 				(4)返回处理后的句子
* 
* 调用此类  输入为待处理的string  返回为处理好的string
* 方法为  处理好的字符串 = object.getNumeric(str) 
* 
 */

public class NumUtil {
	
	

	
	
	 public static final String[] enNum = { // 基本数词表
	 "zero", "one", "tow", "three", "four", "five", "six", "seven", "eight",
	   "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
	   "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
	   "twenty", "", "", "", "", "", "", "", "", "", "thirty", "", "", "",
	   "", "", "", "", "", "", "fourty", "", "", "", "", "", "", "", "",
	   "", "fifty", "", "", "", "", "", "", "", "", "", "sixty", "", "",
	   "", "", "", "", "", "", "", "seventy", "", "", "", "", "", "", "",
	   "", "", "eighty", "", "", "", "", "", "", "", "", "", "ninety" };

	 public static final String[] enUnit = { "hundred", "thousand", "million",
	   "billion", "trillion", "quintillion" }; // 单位表

	 
	 /**
	 *
	 *用来测试的Main函数
	 *
	 */

//	 public static void main(String[] args) {
//	  System.out.println(analyze(133)); // 测试数据
//	  String str = "my number is 15, 14 a.";
//	  System.out.println((int)str.charAt(0)+" "+(int)str.charAt(13)+" "+(int)str.charAt(14)+" "+(int)str.charAt(15));
//	  System.out.println(getNumeric(str));
//	 }
	 
	 

	  public static int count =0;
	 
	 public static String getNumeric(String str) {
	     str=str.trim();
	     String str2= "";
	     int[] begin = new int[4];
	     int[] end = new int[4];
	     int j =0;
	     count = 0;
	     
	         for(int i=0;i<str.length()-1;i++)
	         {
	        	// System.out.println("i循环第:"+i);
	        	 //System.out.println("i表示的字母为:"+str.charAt(i));
	             if(i<str.length()-1 && str.charAt(i)>=48 && str.charAt(i)<=57)
	             {
	                 begin[count] = i;
	                 //System.out.println("第"+count+"个begin:"+begin[count]);
	                 for(j=i;j<str.length()-1;j++)
	                 {	     
	                	// System.out.println("j:"+j);
	                	// System.out.println("str:"+str.charAt(j));
	        	             if(str.charAt(j)<48 || str.charAt(j)>57)
	        	                {
	        	                 end[count] = j-1;               
	        	                // System.out.println("第"+count+"个end:"+end[count]);      	                 
	        	                 count++;
	        	                 break;
	                	        }
	                 
	                 }
	                 
	                 if(j<str.length()-1)
	                 {
	                 i = j;
	                // System.out.println("i被赋值为:"+i);
	                 }
	                 
	             }
	        }
	         if(begin[0]==0)
	         {
	        	 return str;
	         }
	     
	         for(int k=begin[0];k<end[0]+1;k++){
	        	 str2 += str.charAt(k);
	         }    
        	 System.out.println("str2值为"+str2);
        	 
        	 StringBuilder str3 = new StringBuilder(str);     
        	 str3.replace(begin[0], end[0]+1, analyze(Integer.parseInt(str2)));
        	// System.out.println("str3值为"+str3);
        	 String str4 = str3.toString();
			if(begin[1]!=0)
        	 {
        		 str4  = getNumeric(str3.toString());
        	 }
        	 
           	 
	     return str4;
	 }
	 
	 

	 public static String analyze(long num) { // long型参数，
	  return analyze(String.valueOf(num)); // 因为long型有极限，所以以字符串参数方法为主
	 }

	 public static String analyze(String num) { // 数字字符串参数
	  // 判断字符串是否为数字
	  if (!num.matches("\\d+")) {
	   return String.format("%s is not number", num);
	  }

	  num = num.replaceAll("^[0]*([1-9]*)", "$1"); // 把字符串前面的0去掉

	  if (num.length() == 0) { // 如果长度为0，则原串都是0
	   return enNum[0];
	  } else if (num.length() > 9) { // 如果大于9，即大于999999999，题目限制条件
	   return "too big";
	  }

	  // 按3位分割分组
	  int count = (num.length() % 3 == 0) ? num.length() / 3
	    : num.length() / 3 + 1;
	  if (count > enUnit.length) {
	   return "too big";
	  } // 判断组单位是否超过，
	  // 可以根据需求适当追加enUnit
	  String[] group = new String[count];
	  for (int i = num.length(), j = group.length - 1; i > 0; i -= 3) {
	   group[j--] = num.substring(Math.max(i - 3, 0), i);
	  }

	  StringBuilder buf = new StringBuilder(); // 结果保存
	  for (int i = 0; i < count; i++) { // 遍历分割的组
	   int v = Integer.valueOf(group[i]);
	   if (v >= 100) { // 因为按3位分割，所以这里不会有超过999的数
	    buf.append(enNum[v / 100]).append(" ").append(enUnit[0])
	      .append(" ");
	    v = v % 100; // 获取百位，并得到百位以后的数
	    if (v != 0) {
	     buf.append("and ");
	    } // 如果百位后的数不为0，则追加and
	   }
	   if (v != 0) { // 前提是v不为0才作解析
	    if (v < 20 || v % 10 == 0) { // 如果小于20或10的整数倍，直接取基本数词表的单词
	     buf.append(enNum[v]).append(" ");
	    } else { // 否则取10位数词，再取个位数词
	     buf.append(enNum[v - v % 10]).append(" ");
	     buf.append(enNum[v % 10]).append(" ");
	    }
	    if (i != count - 1) { // 百位以上的组追加相应的单位
	     buf.append(enUnit[count - 1 - i]).append(" ");
	    }
	   }
	  }

	  return buf.toString().trim(); // 返回值
	 }
	}