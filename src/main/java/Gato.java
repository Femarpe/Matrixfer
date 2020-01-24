import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gato extends Personaje{
    BufferedImage img = ImageIO.read(new File("C:\\users\\kurur\\desktop\\imgprog\\partida.png"));

    public Gato() throws IOException {
    }

}
