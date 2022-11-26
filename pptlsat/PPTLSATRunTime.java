package pptlsat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import edu.stanford.nlp.parser.nndep.Config;
import mainPro.ConfigPath;
public class PPTLSATRunTime {
	public boolean flag=false;// ��ʽ�Ƿ�����
	public void pptlsat(String formula) {//
		String cmdStr = "pptlsat.exe  \""+formula+"\"";
		System.out.println("cmdStr:"+ cmdStr);
		 /**
		   ����jar�������ⲿ���õķ�ʽ
		 */
		 String path = ConfigPath.change_path("downloadpath");
		 String filePath = path;
		 File fileDecision = new File(filePath+"\\decision.txt");
		 if (fileDecision.exists()) {
			//fileDecision.delete();
				System.out.println("�ļ�����");
			}
		 String cmdStr2 = "dot -Tpng "+ filePath +"\\lnfg.dot -o "+ filePath +"\\lnfg.bmp";
		 File  myfile =new File(filePath);
		 String[] command = { "cmd", "/c", cmdStr};
		 String[] command2 = { "cmd", "/c", cmdStr2};

	        try {
	        	Process ps = Runtime.getRuntime().exec(command,null,myfile);
	        	Process ps2 = Runtime.getRuntime().exec(cmdStr2);
	        	int   retval   = ps.waitFor();  //�ȴ�exe  ִ�����
	        	int   retval2   = ps2.waitFor();  //�ȴ�exe  ִ�����
	        	 System.out.println("ok retval");
	        	 System.out.println("ok retval2");
	        	 if(retval<0) {
	        		 flag=false;
	        	 }else {
	        		 flag=true;
	        	 }
//	            }
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	        	System.out.println("no");
	        	 flag=false;
	            e.printStackTrace();
	        }
	}
	
	public String check() {
		String path = ConfigPath.change_path("downloadpath");
		  String filePath = path;
		  File file = new File(filePath+"\\decision.txt");
		  StringBuilder result = new StringBuilder();
		  if(!flag) {
			  return null;
		  }
		  
	        try{
	            BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
	            String s = null;
	            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
	                result.append(System.lineSeparator()+s);
	            }
	            br.close();    
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        String decision=result.toString();
	        //.out.println("check�е�decision"+decision);

	        return decision;
	}
	 public static void main(String args [])
	    {
		 PPTLSATRunTime pPTLSATRunTime=new PPTLSATRunTime();
		 //pPTLSATRunTime.pptlsat("( ( ( P1 ) -> ( Q2 ) ) ; ( <>R ) ) ; ( ( S ) -> ( fin(T) ) )");//
		 pPTLSATRunTime.pptlsat("!(( P1 ) -> ()( P2 ));!(<>P3);!(<>P4)");
		 pPTLSATRunTime.check();
	    }
}
