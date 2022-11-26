package mainPro;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class UploadFile {
	public static int[] toArrayByRandomAccessFile(String name) {
        // ʹ��ArrayList���洢ÿ�ж�ȡ�����ַ���
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File file = new File(name);
            RandomAccessFile fileR = new RandomAccessFile(file,"r");
            // ���ж�ȡ�ַ���
            String str = null;
            while ((str = fileR.readLine())!= null) {
                arrayList.add(str);
            }
            fileR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ��ArrayList�д洢���ַ������д��� 
        int length = arrayList.size();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            String s = arrayList.get(i);
            array[i] = Integer.parseInt(s);
        }
        // ��������
        return array;
    }
	
	
	 public static void main(String[] args) {
	 String UploadFile_path= ConfigPath.change_path("UploadFile");
	 
	 
	 }
	 
}
