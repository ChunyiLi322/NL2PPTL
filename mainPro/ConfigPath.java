package mainPro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPath {
	
	
    public static String change_path(String pathIn) {
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
       
        // 使用properties对象加载输入流
        try {
        	InputStream in = new FileInputStream("/NL2PPTL.properties");
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //获取key对应的value值
        //String path = properties.getProperty("downloadpath");
        String path = properties.getProperty(pathIn);
        System.out.println("ConfigPath中path:"+path);
		return path;
    }

}

   
    

