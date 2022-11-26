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
     * 位图的宽 
     */  
    private static int width;  
  
    /** 
     * 位图的高 
     */  
    private static int height;  
  
    /** 
     * 位图数据数组,即一个像素的三个分量的数据数组 
     */  
    private static int[][] red, green, blue;  
  
    Graphics g;  
  
    public static void main(String args[]) {  
        BmpRead24 bmp = new BmpRead24();  
        bmp.init();  
    }  
  
    public void init() {  
        try {  
            // 通过bmp文件地址创建文件输入流对象  
            java.io.FileInputStream fin = new java.io.FileInputStream(  
            		 System.getProperty("user.dir")+"\\src\\pptlsatfile\\lnfg.bmp");  
  
            // 根据文件输入流对象创建原始数据输入对象  
            // 这里既可以用原始数据输入流来读取数据，也可以用缓冲输入流来读取，后者速度相比较快点。  
//          java.io.DataInputStream bis = new java.io.DataInputStream(fin);  
  
            java.io.BufferedInputStream bis = new java.io.BufferedInputStream(  
                    fin);  
  
            // 建立两个字节数组来得到文件头和信息头的数据  
            byte[] array1 = new byte[14];  
            bis.read(array1, 0, 14);  
  
            byte[] array2 = new byte[40];  
            bis.read(array2, 0, 40);  
  
            // 翻译bmp文件的数据，即将字节数据转化为int数据  
            // 通过翻译得到位图数据的宽和高  
            width = ChangeInt(array2, 7);  
            height = ChangeInt(array2, 11);  
  
            // 调用可以将整个位图数据读取成byte数组的方法  
            getInf(bis);  
  
            fin.close();  
            bis.close();  
  
            // 创建BMP对象来显示图画  
            showUI();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * 实现可将四个字节翻译int数据的方法 
     *  
     * @param array2 
     *            存储字节的字节数组 
     * @param start 
     *            起始字节 
     * @return 返回翻译后的int数据 
     */  
    public int ChangeInt(byte[] array2, int start) {  
        // 因为char,byte,short这些数据类型经过运算符后会自动转为成int数据类，  
        // 所以array2[start]&0xff的实际意思就是通过&0xff将字符数据转化为正int数据，然后在进行位运算。  
        // 这里需要注意的是<<的优先级别比&高，所以必须加上括号。  
  
        int i = (int) ((array2[start] & 0xff) << 24)  
                | ((array2[start - 1] & 0xff) << 16)  
                | ((array2[start - 2] & 0xff) << 8)  
                | (array2[start - 3] & 0xff);  
        return i;  
    }  
  
    /** 
     * 得到位图数据的int数组 
     *  
     * @param dis 
     *            数据输入流对象 
     */  
    public void getInf(java.io.BufferedInputStream bis) {  
        // 给数组开辟空间  
        red = new int[height][width];  
        green = new int[height][width];  
        blue = new int[height][width];  
  
        // 通过计算得到每行计算机需要填充的字符数。  
        // 为什么要填充？这是因为windows系统在扫描数据的时候，每行都是按照4个字节的倍数来读取的。  
        // 因为图片是由每个像素点组成。而每个像素点都是由3个颜色分量来构成的，而每个分量占据1个字节。  
        // 因此在内存存储中实际图片数据每行的长度是width*3。  
        int skip_width = 0;  
        int m = width * 3 % 4;  
        if (m != 0) {  
            skip_width = 4 - m;  
        }  
  
        // 通过遍历给数组填值  
        // 这里需要注意，因为根据bmp的保存格式。  
        // 位图数据中height的值如果是正数的话:  
        // 那么数据就是按从下到上，从左到右的顺序来保存。这个称之为倒向位图。  
        // 反之就是按从上到下，从左到右的顺序来保存。这个则称之为正向位图。  
        for (int i = height - 1; i >= 0; i--) {  
            for (int j = 0; j < width; j++) {  
                try {  
                    // 这里遍历的时候，一定要注意本来像素是有RGB来表示，  
                    // 但是在存储的时候由于windows是小段存储，所以在内存中是BGR顺序。  
                    blue[i][j] = bis.read();  
                    green[i][j] = bis.read();  
                    red[i][j] = bis.read();  
  
                    // 这里一定要知道，其实系统在给位图数据中添加填充0的时候，都是加在每行的最后。  
                    // 但是我们在使用dis.skipBytes（）这个方法的时候，却不一定要在最后一列。  
                    // 系统在填充数据的时候，在数据上加了标记。  
                    // 所以dis.skipBytes（）这个方法只要调用了，那么系统就会自动不读取填充数据。  
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
        // 对窗体的属性进行设置  
        this.setTitle("BMP解析");//设置标题  
        this.setSize(width, height);//设置窗体大小  
        this.setDefaultCloseOperation(3);//点击关闭，程序自动退出。  
        this.setResizable(false);//设置窗体大小不可以调节  
        this.setLocationRelativeTo(null);//设置窗体出现在屏幕中间  
  
        //创建自己的panel，用其来显示图形。  
        //因为如果将图片设置到窗体上显示时，因为jframe是一个复合组件，上面的组件有多个paint方法，所以在paint的时候会画两次，  
        //而panel是只需画一次。  
        MyPanel panel = new MyPanel();  
        java.awt.Dimension di = new java.awt.Dimension(width, height);//设置panel大小  
        panel.setPreferredSize(di);  
        this.add(panel);//窗体添加panel  
        this.setVisible(true);//使窗体可见。  
    }  
  
    public class MyPanel extends javax.swing.JPanel {  
        /** 
         *  
         */  
        private static final long serialVersionUID = 1L;  
  
        /** 
         * 重写paint方法 
         */  
        public void paint(Graphics g) {  
            // 这句话可写可不写，因为这句话是用来画jframe的contentPane的。   
            // 而这里我们已经在下面定义了contentPane的方法了  
            super.paint(g);  
            for (int i = 0; i < height; i++) {  
                for (int j = 0; j < width; j++) {  
                    g.setColor(new Color(red[i][j], green[i][j], blue[i][j]));  
                    // 如果这里画点的话，是不能使用下面注释掉的方法的，不行的话，亲，自己试试吧  
                    // 因为系统在画椭圆的时候，是先画出椭圆的外切矩形。而矩形的边框刚好是占据一个像素点。  
                    // 因此也就出现了，jdk api中说g.drawOval的像素点是width+1,height+1。  
                    // 如果亲，你有更好的理解，请告诉我们。欢迎交流！！！  
//                     g.fillOval(j, i, 1, 1);  
                    g.fillRect(j, i, 1, 1);// 这里可以使用画点的任何方法，除了上面那种特例。  
                }  
            }  
        }  
    }  
}  