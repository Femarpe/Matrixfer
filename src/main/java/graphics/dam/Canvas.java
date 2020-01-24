package graphics.dam;

import maths.dam.Matrix2D;

public interface Canvas {

    int toARGB(int a, int r, int g, int b);

    void clear(Matrix2D img, int color);

    void fillRectangle(Matrix2D img, int color, double x, double y, int w, int h);

    void fillCircle(Matrix2D img, int color, double x, double y, int r);

    void drawImage(Matrix2D img, Matrix2D m, double x, double y);
}
