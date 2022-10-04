package br.edu.ifsp.poo.class6.ex01;

public class SomeClass {

    /**
     * Esse método recebe um numerador inteiro
     * e um denominador interno não nulo.
     * */
    public int div(int a, int b) throws Exception{
        if(b == 0)
            throw new Exception("O denominador não pode ser zero, tonto!");
        return a / b;
    }


}
