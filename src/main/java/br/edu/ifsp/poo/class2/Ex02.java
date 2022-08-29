package br.edu.ifsp.poo.class2;

import java.util.Scanner;

/*
* Faça um programa que construa dois vetores A e B de 5 posições, lendo e adicionando valores inteiros a esses vetores. Crie um terceiro vetor C, composto pela soma dos elementos de A e B. Por exemplo:

C[0] = A[0] + B[0]
C[1] = A[1] + B[1]
Após isso, escreva o conteúdo do vetor C, separados por vírgula. Qualquer situação fora do domínio de entrada resulta em saída uma “Erro”.

Exemplos de entrada e saída esperada:

Entrada = 2 5 8 34 5                 | Saída = 10, 56, 10, 50, 10
          8 51 2 16 5
Entrada = -10 0 10 20 30         | Saída = 90, 50, 10, -30, -70
          100 50 0 -50 -100
* */
public class Ex02 {

    public static final int ARRAY_SIZE = 5;

    public static void main(String[] args) {
        final int[] firstArray = new int[ARRAY_SIZE];
        final int[] secondArray = new int[ARRAY_SIZE];

        final Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < ARRAY_SIZE; i++) {
            firstArray[i] = scanner.nextInt();
        }
        for (int i = 0; i < ARRAY_SIZE; i++) {
            secondArray[i] = scanner.nextInt();
        }
        String output = "";
        for (int i = 0; i < firstArray.length; i++) {
            final long sum = (long) firstArray[i] + secondArray[i];
            if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
                output = "Erro";
                break;
            }
            output += "" + sum;
            if(i < firstArray.length - 1){
                output += ", ";
            }
        }
        System.out.println(output);
    }
}
