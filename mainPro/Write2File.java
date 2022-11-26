package mainPro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Write2File {

	public static void WriteIn(String content, String path, String Filename)
	{
	    try {
	        String title = Filename;
	        File mkdirsName = new File(path);
	        if(!mkdirsName.exists()){
	            mkdirsName.mkdirs();
	        }
	        File writename = new File(path+"\\"+title+".txt");
	        if(!writename.exists()) {
	            writename.createNewFile();
	        } else {
	            String osName = System.getProperties().getProperty("os.name");
	            if (osName.equals("Linux")) {
	                content = "\r" + content;
	            } else {
	                content = "\r\n" + content;
	            }
	        }

	        BufferedWriter out = new BufferedWriter(new FileWriter(writename,true));
	        out.write(content); 
	        out.flush(); 
	        out.close(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
}
