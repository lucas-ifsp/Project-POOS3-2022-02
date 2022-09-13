package br.edu.ifsp.poo.class4;

public abstract class Figura {

    private final int x;
    private final int y;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double getArea();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
