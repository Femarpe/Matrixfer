
import graphics.dam.Canvas;
import maths.dam.Matrix2D;

public class Game {

    public void startGame(){

        Matrix2D m = new Matrix2D(1000, 1000);
        int bg = Canvas.toARGB(255, 255, 255, 255);
        int fg = Canvas.toARGB(255, 255, 255, 0);
        int fg2 = Canvas.toARGB(255, 255, 255, 255);
        int fg3 = Canvas.toARGB(255, 0, 0, 0);
        Canvas canvas = new Canvas();

        int x = 0;
        int xojo = 0;
        int y = 0;
        int yojo = 0;
        boolean xt = true;
        while (true) {
            canvas.clear(m, bg);
            canvas.fillCircle(m, fg, 150 + x, 150 + y, 100);
            canvas.fillCircle(m, fg2, 120+ x, 100 + y, 25);
            canvas.fillCircle(m, fg2, 180+ x, 100 + y, 25);
            canvas.fillCircle(m, fg3, 120+ xojo, 100 + yojo, 10);
            canvas.fillCircle(m, fg3, 180+ xojo, 100 + yojo, 10);
            canvas.fillRectangle(m, fg2, 135+ x, 135 + y, 30, 15);
            canvas.fillRectangle(m, fg2, 135+ x, 175 + y, 30, 15);
            canvas.fillRectangle(m, fg2, 100+ x, 175 + y, 30, 15);
            canvas.fillRectangle(m, fg2, 170+ x, 175 + y, 30, 15);
            canvas.fillRectangle(m, fg2, 70+ x, 160 + y, 30, 15);
            canvas.fillRectangle(m, fg2, 200+ x, 160 + y, 30, 15);
            if (x == 700){
                x-=5;
                xojo = x - 5;
            } else if (dam.c1k.Window.isPressedKey(68) == true) {
                x+=5;
                xojo = x + 5;
            }

            if (x == 0){
                x+=5;
                xojo = x + 5;
            } else if (dam.c1k.Window.isPressedKey(65) == true){
                x-=5;
                xojo = x - 5;
            }

            if (y == 10){
                y+=5;
                yojo = y + 5;
            } else if (dam.c1k.Window.isPressedKey(87) == true){
                y-=5;
                yojo = y - 5;
            }

            if (y == 990){
                y-=5;
                yojo = y - 5;
            } else if (dam.c1k.Window.isPressedKey(83) == true) {
                y+=5;
                yojo = y + 5;
            }


            m.swapP();
            dam.c1k.Window.showImage(m.getWidth(), m.getHeight(), m.getValues());

        }
        //DAM.saveImage(new File("C:\\users\\kurur\\desktop\\imgprog\\risason.png"), m.getValues(), m.getWidth(), m.getHeight(), null);
    }
}
