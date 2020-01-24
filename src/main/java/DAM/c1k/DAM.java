package DAM.c1k;

import graphics.dam.Canvas;
import graphics.dam.CanvasImp;
import maths.dam.Matrix2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class DAM {

    /*
    	<properties>
		<lwjgl.version>3.2.3</lwjgl.version>
		<lwjgl.natives>natives-macos</lwjgl.natives>
	</properties>

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.lwjgl</groupId>
				<artifactId>lwjgl-bom</artifactId>
				<version>${lwjgl.version}</version>
				<scope>import</scope>
				<type>pom</type>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<dependencies>
		<dependency>
			<groupId>org.lwjgl</groupId>
			<artifactId>lwjgl</artifactId>
		</dependency>
		<dependency>
			<groupId>org.lwjgl</groupId>
			<artifactId>lwjgl-glfw</artifactId>
		</dependency>
		<dependency>
			<groupId>org.lwjgl</groupId>
			<artifactId>lwjgl-openal</artifactId>
		</dependency>
		<dependency>
			<groupId>org.lwjgl</groupId>
			<artifactId>lwjgl-opengl</artifactId>
		</dependency>
		<dependency>
			<groupId>org.lwjgl</groupId>
			<artifactId>lwjgl-stb</artifactId>
		</dependency>
		<dependency>
			<groupId>org.lwjgl</groupId>
			<artifactId>lwjgl</artifactId>
			<classifier>${lwjgl.natives}</classifier>
		</dependency>
		<dependency>
			<groupId>org.lwjgl</groupId>
			<artifactId>lwjgl-glfw</artifactId>
			<classifier>${lwjgl.natives}</classifier>
		</dependency>
		<dependency>
			<groupId>org.lwjgl</groupId>
			<artifactId>lwjgl-openal</artifactId>
			<classifier>${lwjgl.natives}</classifier>
		</dependency>
		<dependency>
			<groupId>org.lwjgl</groupId>
			<artifactId>lwjgl-opengl</artifactId>
			<classifier>${lwjgl.natives}</classifier>
		</dependency>
		<dependency>
			<groupId>org.lwjgl</groupId>
			<artifactId>lwjgl-stb</artifactId>
			<classifier>${lwjgl.natives}</classifier>
		</dependency>
	</dependencies>
     */


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

    public static Matrix2D convertToMatrix2D(BufferedImage image) {
        CanvasImp canvas = new CanvasImp() ;
        int width = image.getWidth();
        int height = image.getHeight();
        Matrix2D result = new Matrix2D();
        result.create(width,height);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++)
                result.setValues(row,col,(image.getRGB(row,col))*+1);
        }
        return result;
   }

}
