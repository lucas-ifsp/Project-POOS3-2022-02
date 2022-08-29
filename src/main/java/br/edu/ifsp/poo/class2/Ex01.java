package br.edu.ifsp.poo.class2;

import java.util.Scanner;

/*
* Faça um programa que leia dados inteiros da temperatura diária durante uma semana, armazenando em um vetor. Na sequência, escreva quantos dias dessa semana a temperatura esteve acima da média. As sete temperaturas devem ser lidas na mesma linha, separada por espaço.

Exemplos de entrada e saída esperada:

Exemplo 1: Entrada = 2 2 2 2 2 2 3 | Saída = 1
Exemplo 2: Entrada = 21 10 13 34 30 21 34 | Saída = 3
Exemplo 3: Entrada = 2 2 2 2 2 2 1| Saída = 6
Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
* */
public class Ex01 {

    public static final int DAYS_IN_WEEK = 7;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] temperatures = new int[DAYS_IN_WEEK];
        int sumOfTemperatures = 0;

        for(int i = 0; i < DAYS_IN_WEEK; i++){
            temperatures[i] = scanner.nextInt();
            sumOfTemperatures += temperatures[i];
        }

        double averageTemperature = (double) sumOfTemperatures / DAYS_IN_WEEK;
        int daysAboveAverage = 0;

        for(int temperature : temperatures){
            if(temperature > averageTemperature){
                daysAboveAverage = daysAboveAverage + 1;
            }
        }
        System.out.println(daysAboveAverage);
    }
}
