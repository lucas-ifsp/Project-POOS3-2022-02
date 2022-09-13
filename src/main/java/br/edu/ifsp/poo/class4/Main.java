package br.edu.ifsp.poo.class4;

public class Main {
    public static void main(String[] args) {
        Triangulo t1 = new Triangulo(0, 0, 3, 4, 5);
        Circulo c1 = new Circulo(1, 1, 1);
        Retangulo r1 = new Retangulo(2, 1, 3, 4);

        Figura[] figuras = new Figura[3];
        figuras[0] = t1;
        figuras[1] = c1;
        figuras[2] = r1;

        double soma = 0.0;

        for (Figura figura : figuras) {
            soma += figura.getArea();
        }

        System.out.println(soma);

        System.out.println(t1.getArea());
        System.out.println(c1.getArea());
        System.out.println(r1.getArea());
    }
}
