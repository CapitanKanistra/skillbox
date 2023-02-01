package src;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    private static  int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "d:/1";
        String dstFolder = "d:/2";

        File srcDir = new File(srcFolder);


        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int first = files.length/4;
        int middle = files.length/2;
        int last = files.length;

        File[] files1 = new File[middle];
        System.arraycopy(files,0,files1,0,files1.length);
        ImageResizer resizer1 = new ImageResizer(files1,newWidth,dstFolder,start);
        resizer1.start();


        File[] files2 = new File[files.length-first];
        System.arraycopy(files,first,files2,0,files2.length);
        ImageResizer resizer2 = new ImageResizer(files2,newWidth,dstFolder,start);
        resizer2.start();

        File[] files3 = new File[files.length-middle];
        System.arraycopy(files,middle,files3,0,files3.length);
        ImageResizer resizer3 = new ImageResizer(files3,newWidth,dstFolder,start);
        resizer3.start();

        File[] files4 = new File[files.length-last];
        System.arraycopy(files,last,files4,0,files4.length);
        ImageResizer resizer4 = new ImageResizer(files3,newWidth,dstFolder,start);
        resizer4.start();





    }
}
