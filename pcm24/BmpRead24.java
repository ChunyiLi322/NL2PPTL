package pcm24;

import java.awt.Color;  
import java.awt.Graphics;  
import java.io.IOException;  
  

public class BmpRead24 extends javax.swing.JFrame {  
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
  
    /** 
     * λͼ�Ŀ� 
     */  
    private static int width;  
  
    /** 
     * λͼ�ĸ� 
     */  
    private static int height;  
  
    /** 
     * λͼ��������,��һ�����ص������������������� 
     */  
    private static int[][] red, green, blue;  
  
    Graphics g;  
  
    public static void main(String args[]) {  
        BmpRead24 bmp = new BmpRead24();  
        bmp.init();  
    }  
  
    public void init() {  
        try {  
            // ͨ��bmp�ļ���ַ�����ļ�����������  
            java.io.FileInputStream fin = new java.io.FileInputStream(  
            		 System.getProperty("user.dir")+"\\src\\pptlsatfile\\lnfg.bmp");  
  
            // �����ļ����������󴴽�ԭʼ�����������  
            // ����ȿ�����ԭʼ��������������ȡ���ݣ�Ҳ�����û�������������ȡ�������ٶ���ȽϿ�㡣  
//          java.io.DataInputStream bis = new java.io.DataInputStream(fin);  
  
            java.io.BufferedInputStream bis = new java.io.BufferedInputStream(  
                    fin);  
  
            // ���������ֽ��������õ��ļ�ͷ����Ϣͷ������  
            byte[] array1 = new byte[14];  
            bis.read(array1, 0, 14);  
  
            byte[] array2 = new byte[40];  
            bis.read(array2, 0, 40);  
  
            // ����bmp�ļ������ݣ������ֽ�����ת��Ϊint����  
            // ͨ������õ�λͼ���ݵĿ�͸�  
            width = ChangeInt(array2, 7);  
            height = ChangeInt(array2, 11);  
  
            // ���ÿ��Խ�����λͼ���ݶ�ȡ��byte����ķ���  
            getInf(bis);  
  
            fin.close();  
            bis.close();  
  
            // ����BMP��������ʾͼ��  
            showUI();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * ʵ�ֿɽ��ĸ��ֽڷ���int���ݵķ��� 
     *  
     * @param array2 
     *            �洢�ֽڵ��ֽ����� 
     * @param start 
     *            ��ʼ�ֽ� 
     * @return ���ط�����int���� 
     */  
    public int ChangeInt(byte[] array2, int start) {  
        // ��Ϊchar,byte,short��Щ�������;������������Զ�תΪ��int�����࣬  
        // ����array2[start]&0xff��ʵ����˼����ͨ��&0xff���ַ�����ת��Ϊ��int���ݣ�Ȼ���ڽ���λ���㡣  
        // ������Ҫע�����<<�����ȼ����&�ߣ����Ա���������š�  
  
        int i = (int) ((array2[start] & 0xff) << 24)  
                | ((array2[start - 1] & 0xff) << 16)  
                | ((array2[start - 2] & 0xff) << 8)  
                | (array2[start - 3] & 0xff);  
        return i;  
    }  
  
    /** 
     * �õ�λͼ���ݵ�int���� 
     *  
     * @param dis 
     *            �������������� 
     */  
    public void getInf(java.io.BufferedInputStream bis) {  
        // �����鿪�ٿռ�  
        red = new int[height][width];  
        green = new int[height][width];  
        blue = new int[height][width];  
  
        // ͨ������õ�ÿ�м������Ҫ�����ַ�����  
        // ΪʲôҪ��䣿������Ϊwindowsϵͳ��ɨ�����ݵ�ʱ��ÿ�ж��ǰ���4���ֽڵı�������ȡ�ġ�  
        // ��ΪͼƬ����ÿ�����ص���ɡ���ÿ�����ص㶼����3����ɫ���������ɵģ���ÿ������ռ��1���ֽڡ�  
        // ������ڴ�洢��ʵ��ͼƬ����ÿ�еĳ�����width*3��  
        int skip_width = 0;  
        int m = width * 3 % 4;  
        if (m != 0) {  
            skip_width = 4 - m;  
        }  
  
        // ͨ��������������ֵ  
        // ������Ҫע�⣬��Ϊ����bmp�ı����ʽ��  
        // λͼ������height��ֵ����������Ļ�:  
        // ��ô���ݾ��ǰ����µ��ϣ������ҵ�˳�������档�����֮Ϊ����λͼ��  
        // ��֮���ǰ����ϵ��£������ҵ�˳�������档������֮Ϊ����λͼ��  
        for (int i = height - 1; i >= 0; i--) {  
            for (int j = 0; j < width; j++) {  
                try {  
                    // ���������ʱ��һ��Ҫע�Ȿ����������RGB����ʾ��  
                    // �����ڴ洢��ʱ������windows��С�δ洢���������ڴ�����BGR˳��  
                    blue[i][j] = bis.read();  
                    green[i][j] = bis.read();  
                    red[i][j] = bis.read();  
  
                    // ����һ��Ҫ֪������ʵϵͳ�ڸ�λͼ������������0��ʱ�򣬶��Ǽ���ÿ�е����  
                    // ����������ʹ��dis.skipBytes�������������ʱ��ȴ��һ��Ҫ�����һ�С�  
                    // ϵͳ��������ݵ�ʱ���������ϼ��˱�ǡ�  
                    // ����dis.skipBytes�����������ֻҪ�����ˣ���ôϵͳ�ͻ��Զ�����ȡ������ݡ�  
                    if (j == 0) {  
                        bis.skip(skip_width);  
                    }  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
  
    public void showUI() {  
        // �Դ�������Խ�������  
        this.setTitle("BMP����");//���ñ���  
        this.setSize(width, height);//���ô����С  
        this.setDefaultCloseOperation(3);//����رգ������Զ��˳���  
        this.setResizable(false);//���ô����С�����Ե���  
        this.setLocationRelativeTo(null);//���ô����������Ļ�м�  
  
        //�����Լ���panel����������ʾͼ�Ρ�  
        //��Ϊ�����ͼƬ���õ���������ʾʱ����Ϊjframe��һ��������������������ж��paint������������paint��ʱ��ử���Σ�  
        //��panel��ֻ�軭һ�Ρ�  
        MyPanel panel = new MyPanel();  
        java.awt.Dimension di = new java.awt.Dimension(width, height);//����panel��С  
        panel.setPreferredSize(di);  
        this.add(panel);//�������panel  
        this.setVisible(true);//ʹ����ɼ���  
    }  
  
    public class MyPanel extends javax.swing.JPanel {  
        /** 
         *  
         */  
        private static final long serialVersionUID = 1L;  
  
        /** 
         * ��дpaint���� 
         */  
        public void paint(Graphics g) {  
            // ��仰��д�ɲ�д����Ϊ��仰��������jframe��contentPane�ġ�   
            // �����������Ѿ������涨����contentPane�ķ�����  
            super.paint(g);  
            for (int i = 0; i < height; i++) {  
                for (int j = 0; j < width; j++) {  
                    g.setColor(new Color(red[i][j], green[i][j], blue[i][j]));  
                    // ������ﻭ��Ļ����ǲ���ʹ������ע�͵��ķ����ģ����еĻ����ף��Լ����԰�  
                    // ��Ϊϵͳ�ڻ���Բ��ʱ�����Ȼ�����Բ�����о��Ρ������εı߿�պ���ռ��һ�����ص㡣  
                    // ���Ҳ�ͳ����ˣ�jdk api��˵g.drawOval�����ص���width+1,height+1��  
                    // ����ף����и��õ���⣬��������ǡ���ӭ����������  
//                     g.fillOval(j, i, 1, 1);  
                    g.fillRect(j, i, 1, 1);// �������ʹ�û�����κη�����������������������  
                }  
            }  
        }  
    }  
}  