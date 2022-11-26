package mainPro;

/**
*lichunyi  ����
*���������ַ����а������ֳɷ�
*������޸ģ�systemoutע�ͷſ�����

* 
* ����˼·Ϊ
*   ��1����һ��ѭ���жϵ�һ�����ֵĿ�ʼλ�ã��ڶ���ѭ���жϵ�һ�����ֵĽ���λ�á�count��ʾ������һ�����ڼ�������,���0�����־�ֱ�ӷ���ԭ����
* 		(2)ʹ��string builder�����е������滻
* 			(3)�ݹ�(1)(2)���裬�滻�ڶ������֣�ֱ��count=0
* 				(4)���ش����ľ���
* 
* ���ô���  ����Ϊ�������string  ����Ϊ����õ�string
* ����Ϊ  ����õ��ַ��� = object.getNumeric(str) 
* 
 */

public class NumUtil {
	
	

	
	
	 public static final String[] enNum = { // �������ʱ�
	 "zero", "one", "tow", "three", "four", "five", "six", "seven", "eight",
	   "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
	   "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
	   "twenty", "", "", "", "", "", "", "", "", "", "thirty", "", "", "",
	   "", "", "", "", "", "", "fourty", "", "", "", "", "", "", "", "",
	   "", "fifty", "", "", "", "", "", "", "", "", "", "sixty", "", "",
	   "", "", "", "", "", "", "", "seventy", "", "", "", "", "", "", "",
	   "", "", "eighty", "", "", "", "", "", "", "", "", "", "ninety" };

	 public static final String[] enUnit = { "hundred", "thousand", "million",
	   "billion", "trillion", "quintillion" }; // ��λ��

	 
	 /**
	 *
	 *�������Ե�Main����
	 *
	 */

//	 public static void main(String[] args) {
//	  System.out.println(analyze(133)); // ��������
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
	        	// System.out.println("iѭ����:"+i);
	        	 //System.out.println("i��ʾ����ĸΪ:"+str.charAt(i));
	             if(i<str.length()-1 && str.charAt(i)>=48 && str.charAt(i)<=57)
	             {
	                 begin[count] = i;
	                 //System.out.println("��"+count+"��begin:"+begin[count]);
	                 for(j=i;j<str.length()-1;j++)
	                 {	     
	                	// System.out.println("j:"+j);
	                	// System.out.println("str:"+str.charAt(j));
	        	             if(str.charAt(j)<48 || str.charAt(j)>57)
	        	                {
	        	                 end[count] = j-1;               
	        	                // System.out.println("��"+count+"��end:"+end[count]);      	                 
	        	                 count++;
	        	                 break;
	                	        }
	                 
	                 }
	                 
	                 if(j<str.length()-1)
	                 {
	                 i = j;
	                // System.out.println("i����ֵΪ:"+i);
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
        	 System.out.println("str2ֵΪ"+str2);
        	 
        	 StringBuilder str3 = new StringBuilder(str);     
        	 str3.replace(begin[0], end[0]+1, analyze(Integer.parseInt(str2)));
        	// System.out.println("str3ֵΪ"+str3);
        	 String str4 = str3.toString();
			if(begin[1]!=0)
        	 {
        		 str4  = getNumeric(str3.toString());
        	 }
        	 
           	 
	     return str4;
	 }
	 
	 

	 public static String analyze(long num) { // long�Ͳ�����
	  return analyze(String.valueOf(num)); // ��Ϊlong���м��ޣ��������ַ�����������Ϊ��
	 }

	 public static String analyze(String num) { // �����ַ�������
	  // �ж��ַ����Ƿ�Ϊ����
	  if (!num.matches("\\d+")) {
	   return String.format("%s is not number", num);
	  }

	  num = num.replaceAll("^[0]*([1-9]*)", "$1"); // ���ַ���ǰ���0ȥ��

	  if (num.length() == 0) { // �������Ϊ0����ԭ������0
	   return enNum[0];
	  } else if (num.length() > 9) { // �������9��������999999999����Ŀ��������
	   return "too big";
	  }

	  // ��3λ�ָ����
	  int count = (num.length() % 3 == 0) ? num.length() / 3
	    : num.length() / 3 + 1;
	  if (count > enUnit.length) {
	   return "too big";
	  } // �ж��鵥λ�Ƿ񳬹���
	  // ���Ը��������ʵ�׷��enUnit
	  String[] group = new String[count];
	  for (int i = num.length(), j = group.length - 1; i > 0; i -= 3) {
	   group[j--] = num.substring(Math.max(i - 3, 0), i);
	  }

	  StringBuilder buf = new StringBuilder(); // �������
	  for (int i = 0; i < count; i++) { // �����ָ����
	   int v = Integer.valueOf(group[i]);
	   if (v >= 100) { // ��Ϊ��3λ�ָ�������ﲻ���г���999����
	    buf.append(enNum[v / 100]).append(" ").append(enUnit[0])
	      .append(" ");
	    v = v % 100; // ��ȡ��λ�����õ���λ�Ժ����
	    if (v != 0) {
	     buf.append("and ");
	    } // �����λ�������Ϊ0����׷��and
	   }
	   if (v != 0) { // ǰ����v��Ϊ0��������
	    if (v < 20 || v % 10 == 0) { // ���С��20��10����������ֱ��ȡ�������ʱ�ĵ���
	     buf.append(enNum[v]).append(" ");
	    } else { // ����ȡ10λ���ʣ���ȡ��λ����
	     buf.append(enNum[v - v % 10]).append(" ");
	     buf.append(enNum[v % 10]).append(" ");
	    }
	    if (i != count - 1) { // ��λ���ϵ���׷����Ӧ�ĵ�λ
	     buf.append(enUnit[count - 1 - i]).append(" ");
	    }
	   }
	  }

	  return buf.toString().trim(); // ����ֵ
	 }
	}