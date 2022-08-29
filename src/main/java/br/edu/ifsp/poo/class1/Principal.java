package br.edu.ifsp.poo.class1;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        final int input = Integer.parseInt(scanner.nextLine());

        System.out.println(input + " é " + ((input % 2 == 0) ? "par." : "ímpar."));
    }
}
