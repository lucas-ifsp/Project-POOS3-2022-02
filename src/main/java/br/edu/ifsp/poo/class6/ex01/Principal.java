package br.edu.ifsp.poo.class6.ex01;

public class Principal {

    public static void main(String[] args) {
        SomeClass someObject = new SomeClass();
        final int result;
        try {
            result = someObject.div(5, 0);
            System.out.println(result);
        } catch (Exception e) { //test com pipe e shadowing
            System.out.println("Infinity");
        }
    }
}
