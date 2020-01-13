package maths.dam;

public class Matrix2D {
    private int[] cells;
    private int width;
    private int height;

    public Matrix2D() {
        cells = null;
        width = 0;
        height = 0;
    }

    public Matrix2D(int w, int h) {
        create(w, h);
    }

    public void create(int w, int h) {

        cells = new int[w * h];
        width = w;
        height = h;
    }

    public void setValues(int x, int y, int val) {

        cells[getWidth() * y + x] = val;

    }

    public int getValue(int x, int y) {
        int val = cells[getWidth() * y + x];
        return val;
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int[] getValues() {
        return cells;
    }

    private int getPositionOfFirstValue(int row) {

        return row * getWidth();
    }

    private void swapRows(int from, int to) {
        int pFrom = getPositionOfFirstValue(from);
        int pTo = getPositionOfFirstValue(to);
        for (int i = 0; i < getWidth(); i++) {
            int valor1 = pFrom;
            int valor2 = pTo;
            int temp = cells[valor1];
            cells[valor1] = cells[valor2];
            cells[valor2] = temp;
            pFrom++;
            pTo++;

        }
    }

    public void flip() {
        int ghmu = getHeight() - 1;
        for (int i = 0; i < getHeight() << 1; i++) {
            swapRows(i, ghmu);
            ghmu--;
        }
    }

    public void swapP( ) {
        int puntoinverso1 = cells.length - 1;
        int contador = 0 ;

        for (int i = 0; i < cells.length; i++) {
            int valor1 = i;
            int valor2 = puntoinverso1;
            int temp = cells[valor1];
            cells[valor1] = cells[valor2];
            cells[valor2] = temp;

            puntoinverso1--;
            if (puntoinverso1 == i){
                break;
            }
        }

        for (int i = 0; i < getHeight(); i++) {

            int puntoinverso2 = getWidth() - 1;

            for (int j = 0; j < getWidth(); j++) {
                int valor1 = j + contador;
                int valor2 = puntoinverso2 + contador;
                int temp = cells[valor1];
                cells[valor1] = cells[valor2];
                cells[valor2] = temp;

                puntoinverso2--;
                if (puntoinverso2 == j){
                    break;

                }
            }
            contador += getWidth();
        }
    }

}
