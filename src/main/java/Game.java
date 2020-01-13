
import graphics.dam.Canvas;
import maths.dam.Matrix2D;

public class Game {

    public void startGame() {
        Canvas canvas = new Canvas();
        Matrix2D m = new Matrix2D(1000, 1000);
        int background = Canvas.toARGB(255, 255, 255, 255);
        canvas.clear(m, background);


        int velocidadjugador = 10;
        int x = 0;
        int xojo = 0;
        int y = 0;
        int yojo = 0;

        int velocidadGato = 7;
        int mx = 0;
        int my = 0;
        int mxojo = 0;
        int myojo = 0;
        boolean xt = true;


        Personaje p = new Personaje();


        while (true) {
            canvas.clear(m, background);

            /**jugador*/
            //p.pintarCarax(m,x,y,xojo,yojo);
            p.pintarCaraRaton(m, x, y, xojo, yojo);


            if (x <= 0) {
                x += velocidadjugador;
                xojo = x + velocidadjugador;
            } else if (dam.c1k.Window.isPressedKey(65) == true) {
                x -= velocidadjugador;
                xojo = x - velocidadjugador;
            }

            if (x >= 700) {
                x -= velocidadjugador;
                xojo = x - velocidadjugador;
            } else if (dam.c1k.Window.isPressedKey(68) == true) {
                x += velocidadjugador;
                xojo = x + velocidadjugador;
            }

            if (y <= 0) {
                y += velocidadjugador;
                yojo = y + velocidadjugador;
            } else if (dam.c1k.Window.isPressedKey(87) == true) {
                y -= velocidadjugador;
                yojo = y - velocidadjugador;
            }

            if (y >= 700) {
                y -= velocidadjugador;
                yojo = y - velocidadjugador;
            } else if (dam.c1k.Window.isPressedKey(83) == true) {
                y += velocidadjugador;
                yojo = y + velocidadjugador;
            }

            /**Gato*/

            p.pintarCaraMalGato(m, mx, my, mxojo, myojo);

            if (mx <= -700) {
                mx += velocidadGato;
                mxojo = mx + velocidadGato;
            } else if (dam.c1k.Window.isPressedKey(263) == true) {
                mx -= velocidadGato;
                mxojo = mx - velocidadGato;
            }

            if (mx >= 0) {
                mx -= velocidadGato;
                mxojo = x - velocidadGato;
            } else if (dam.c1k.Window.isPressedKey(262) == true) {
                mx += velocidadGato;
                mxojo = mx + velocidadGato;
            }

            if (my <= -700) {
                my += velocidadGato;
                myojo = my + velocidadGato;
            } else if (dam.c1k.Window.isPressedKey(265) == true) {
                my -= velocidadGato;
                myojo = my - velocidadGato;
            }

            if (my >= 0) {
                my -= velocidadGato;
                myojo = my - velocidadGato;
            } else if (dam.c1k.Window.isPressedKey(264) == true) {
                my += velocidadGato;
                myojo = my + velocidadGato;
            }

            m.swapP();
            dam.c1k.Window.showImage(m.getWidth(), m.getHeight(), m.getValues());

        }
        //DAM.saveImage(new File("C:\\users\\kurur\\desktop\\imgprog\\risason.png"), m.getValues(), m.getWidth(), m.getHeight(), null);
    }
}
