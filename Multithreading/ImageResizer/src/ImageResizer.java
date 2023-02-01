package src;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer extends Thread {

    private File[] files;
    private int newWidth;
    private String dstFolder;
    private Long start;

    public ImageResizer(File[] files, int newWidth, String dstFolder, Long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }



    @Override
    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }


                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );


                /*BufferedImage newImage = new BufferedImage(
                        newWidth, newHeight, BufferedImage.TYPE_INT_RGB);*///не нать


                BufferedImage scaledImg = Scalr.resize(image, Scalr.Mode.AUTOMATIC,
                        newWidth, newHeight);

/*                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < newWidth; x++) {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        scaledImg.setRGB(x, y, rgb);
                    }
                }*///вроде тоже

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(scaledImg, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Время выполнения: " + (System.currentTimeMillis() - start));

    }
}
