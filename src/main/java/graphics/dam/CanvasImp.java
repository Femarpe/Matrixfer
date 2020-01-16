package graphics.dam;

import maths.dam.Helpers;
import maths.dam.Matrix2D;

public class CanvasImp implements Canvas {
    public static final int BLUE_DISPALCEMENT = 16;
    public static final int GREEN_DISPALCEMENT = 8;
    public static final int RED_DISPALCEMENT = 0;
    public static final int ALPHA_DISPALCEMENT = 24;
    @Override
    public int toARGB(int a, int r, int g, int b){
        int result;
        if (b > 255){ b = 255;} else if (b < 0){b = 0;}
        result = (b << BLUE_DISPALCEMENT);
        if (g > 255){ g = 255;} else if (g < 0){g = 0;}
        result |= (g << GREEN_DISPALCEMENT);
        if (r > 255){ r = 255;} else if (r < 0){r = 0;}
        result |= (r << RED_DISPALCEMENT);
        if (a > 255){ a = 255;} else if (a < 0){a = 0;}
        result |= (a << ALPHA_DISPALCEMENT);
        return result ;
    }
    @Override
    public void clear(Matrix2D img, int color){
        if (img == null){
            return;
        }

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                img.setValues(x, y, color);
            }
        }
    }
    @Override
    public void fillRectangle(Matrix2D img, int color, double x, double y, int w, int h){
        int hr = (int) (y + h);
        int wr = (int) (x + w);

        if ( hr > img.getHeight()){
            hr = img.getHeight();
        } else if ( y < 0){
            y = 0;
        }
        if ( wr > img.getWidth()){
            wr = img.getWidth();
        } else if ( x < 0){
            x = 0;
        }

        for (int iY = (int) y; iY < hr ; iY++) {
            for (int iX = (int) x; iX < wr ; iX++) {
                img.setValues(iX, iY, color);

            }
        }
    }
    @Override
    public void fillCircle(Matrix2D img, int color, double x, double y, int r){
        Helpers helpers = new Helpers();

        for (int iy = (int) (y - r); iy < y + r; iy++) {
            for (int ix = (int) (x - r); ix < x + r; ix++) {

                double distancia = helpers.computeDistance2D(ix, x, iy, y);


                if (distancia < r)
                img.setValues(ix, iy, color);

            }
        }
    }
}

