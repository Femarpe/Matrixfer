import graphics.dam.Canvas;
import maths.dam.Matrix2D;

public class Personaje {
    int vida = 100;
    int danyo = 1;

    int amarillo = Canvas.toARGB(255, 255, 255, 0);
    int blanco = Canvas.toARGB(255, 255, 255, 255);
    int rojo = Canvas.toARGB(250, 255, 0, 0);
    int negro = Canvas.toARGB(255, 0, 0, 0);
    int gris = Canvas.toARGB(255, 100, 100, 100);

    Canvas canvas = new Canvas();

    public void pintarCarax (Matrix2D m, int x, int y, int xojo, int yojo ) {

        canvas.fillCircle(m, amarillo, 150 + x, 150 + y, 200);
        canvas.fillCircle(m, blanco, 120 + x, 100 + y, 25);
        canvas.fillCircle(m, blanco, 180 + x, 100 + y, 25);
        canvas.fillCircle(m, negro, 120 + xojo, 100 + yojo, 10);
        canvas.fillCircle(m, negro, 180 + xojo, 100 + yojo, 10);
        canvas.fillRectangle(m, blanco, 135 + x, 135 + y, 30, 15);
        canvas.fillRectangle(m, blanco, 135 + x, 175 + y, 30, 15);
        canvas.fillRectangle(m, blanco, 100 + x, 175 + y, 30, 15);
        canvas.fillRectangle(m, blanco, 170 + x, 175 + y, 30, 15);
        canvas.fillRectangle(m, blanco, 70 + x, 160 + y, 30, 15);
        canvas.fillRectangle(m, blanco, 200 + x, 160 + y, 30, 15);
    }

    public void pintarCaraRaton (Matrix2D m, int x, int y, int xojo, int yojo ) {


        canvas.fillCircle(m, gris, 150 + x, 150 + y, 60);
        canvas.fillCircle(m, gris, 120 + x, 100 + y, 30);
        canvas.fillCircle(m, gris, 180 + x, 100 + y, 30);
        canvas.fillCircle(m, blanco, 120 + x, 100 + y, 25);
        canvas.fillCircle(m, blanco, 180 + x, 100 + y, 25);
        canvas.fillCircle(m, negro, 120 + xojo, 100 + yojo, 10);
        canvas.fillCircle(m, negro, 180 + xojo, 100 + yojo, 10);
        canvas.fillRectangle(m, negro, 135 + x, 135 + y, 30, 15);
        canvas.fillRectangle(m, blanco, 135 + x, 175 + y, 30, 15);
        canvas.fillRectangle(m, blanco, 100 + x, 160 + y, 30, 15);
        canvas.fillRectangle(m, blanco, 170 + x, 160 + y, 30, 15);
    }

    public void pintarCaraMalGato(Matrix2D m, int mx, int my, int mxojo, int myojo ) {


        canvas.fillCircle(m, rojo, 850 + mx, 850 + my, 100);
        canvas.fillCircle(m, blanco, 820 + mx, 800 + my, 25);
        canvas.fillCircle(m, blanco, 880 + mx, 800 + my, 25);
        canvas.fillCircle(m, negro, 820 + mxojo, 800 + myojo, 10);
        canvas.fillCircle(m, negro, 880 + mxojo, 800 + myojo, 10);
        canvas.fillRectangle(m, blanco, 835 + mx, 835 + my, 30, 15);
        canvas.fillRectangle(m, negro, 835 + mx, 845 + my, 30, 15);
        canvas.fillRectangle(m, blanco, 835 + mx, 875 + my, 30, 15);
        canvas.fillRectangle(m, blanco, 800 + mx, 875 + my, 30, 15);
        canvas.fillRectangle(m, blanco, 870 + mx, 875 + my, 30, 15);
        canvas.fillRectangle(m, blanco, 770 + mx, 860 + my, 30, 15);
        canvas.fillRectangle(m, blanco, 900 + mx, 860 + my, 30, 15);
    }

    public int getVida() {
        return vida;
    }

    public int getDanyo() {
        return danyo;
    }
}
