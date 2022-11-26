package mainPro;

import java.util.*;
import java.io.*;
 
import javax.swing.JFileChooser;
 
public class Devload {
 
	public static String file_input_string="";
    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        JFileChooser jfc=new JFileChooser();
        if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File file=jfc.getSelectedFile();
            Scanner input=new Scanner(file);
            String scanner_string="";
            while(input.hasNext()){
            	String line_string = input.nextLine().toString();
                System.out.println("\n"+line_string); 
                if(line_string.charAt(0)!='%')
                {
                scanner_string = scanner_string+line_string+"\n";
                }
            }
            file_input_string = scanner_string;
            input.close();
        }
        else
            System.out.println("No file is selected!");
    }
 
}