package br.edu.ifsp.poo.class4;

public class Triangulo extends Figura{
    private final double  lado1;
    private final double  lado2;
    private final double lado3;

    public Triangulo(int x, int y, double lado1, double lado2, double lado3) {
        super(x, y);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public double getArea() {
        double p = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(p * (p - lado1) * (p - lado2) * (p - lado3));
    }

    @Override
    public String toString() {
        return "Triangulo: " +
                " Lado 1 = " + lado1 +
                " | Lado 2 = " + lado2 +
                " | Lado 3 = " + lado3 +
                " | Área = " + getArea();
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }
}
