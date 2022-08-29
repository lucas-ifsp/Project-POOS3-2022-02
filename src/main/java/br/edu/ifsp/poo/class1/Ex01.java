package br.edu.ifsp.poo.class1;

import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        final int numberOfBooks = Integer.parseInt(s.nextLine());
        final String bestPlan = getBestPlan(numberOfBooks);
        System.out.println(bestPlan);
    }

    private static String getBestPlan(int i) {
        if(i < 0) return "Erro";

        double a = 0.25 * i + 7.5;
        double b = 0.5 * i + 2.5;

        if (a == b) return "Indiferente";
        if (a < b) return "Criterio A";
        return "Criterio B";
    }
}
