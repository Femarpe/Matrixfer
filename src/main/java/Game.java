
import DAM.c1k.DAM;
import graphics.dam.Canvas;
import graphics.dam.CanvasImp;
import maths.dam.Helpers;
import maths.dam.Matrix2D;

import javax.swing.*;
import java.io.File;

public class Game {
    public void movimientos(){

    }

    public void startGame() {
        CanvasImp canvas = new CanvasImp();
        Matrix2D m = new Matrix2D(1000, 1000);
        int background = canvas.toARGB(255, 255, 255, 255);
        canvas.clear(m, background);
        Personaje p = new Personaje();


        double velocidadjugador = 10;
        double x = 0;
        double xojo = 0;
        double y = 0;
        double yojo = 0;
        double vida = p.getVida();
        boolean ratonvive = true;

        double velocidadGato = 7;
        double mx = 0;
        double my = 0;
        double mxojo = 0;
        double myojo = 0;
        double damage = p.getDanyo();
        boolean xt = true;


        double dis = 965;
        Helpers helpers = new Helpers();

        //while (true) {
        for (int i = 0; i < 1500; i++) {


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
            dis = helpers.computeDistance2D(x, mx + 700, y, my + 700);
            //System.out.println(helpers.computeDistance2D(x, mx + 700, y, my + 700));
            if (dis < 160) {
                vida -= damage;
                System.out.println("te quedan " + vida + " puntos de vida");
                /*
                x = 0;
                xojo = 0;
                mx = 0;
                mxojo = 0;
                y = 0;
                yojo = 0;
                my = 0;
                myojo = 0;
                */
            }


            m.swapP();
            dam.c1k.Window.showImage(m.getWidth(), m.getHeight(), m.getValues());
            if (vida <= 0) {
                ratonvive = false;
                break;
            }
        }
        if (ratonvive == false) {
            JOptionPane.showMessageDialog(null, "ha ganao el gatico");
        } else {
            JOptionPane.showMessageDialog(null,"Gana el raton mamadisimo");
        }
        DAM.saveImage(new File("C:\\users\\kurur\\desktop\\imgprog\\partida.png"), m.getValues(), m.getWidth(), m.getHeight(), null);
    }
}
