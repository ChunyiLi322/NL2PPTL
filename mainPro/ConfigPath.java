package mainPro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPath {
	
	
    public static String change_path(String pathIn) {
        Properties properties = new Properties();
        // ʹ��ClassLoader����properties�����ļ����ɶ�Ӧ��������
       
        // ʹ��properties�������������
        try {
        	InputStream in = new FileInputStream("/NL2PPTL.properties");
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //��ȡkey��Ӧ��valueֵ
        //String path = properties.getProperty("downloadpath");
        String path = properties.getProperty(pathIn);
        System.out.println("ConfigPath��path:"+path);
		return path;
    }

}

   
    

