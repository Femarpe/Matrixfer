package c1k.dam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class DAM {

    public static BufferedImage createImageFromArray(int[] pixels, int width, int height) {
        BufferedImage pixelImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixelImage.setRGB(0, 0, width, height, pixels, 0, width);
        return pixelImage;
    }

    public static boolean saveImage(File path, BufferedImage image, String format) {
        if (format == null)
            format = "png";
        try {
            ImageIO.write(image, format, path);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(DAM.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean saveImage(File path, int[] image, int width, int height, String format) {
        return DAM.saveImage(path, DAM.createImageFromArray(image, width, height), format);
    }

    private static int[][] convertToMatrix2D(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] result = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++)
                result[row][col] = image.getRGB(col, row);
        }
        return result;
    }
}