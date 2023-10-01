package supersete;

import java.util.Random;
import java.util.Scanner;

public class SuperSete {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    private int[] palpites = new int[7];
    private int[] sorteados = new int[7];

    private void receberPalpites() {
        for (int i = 0; i < 7; i++) {
            System.out.print("Palpite número " + (i+1) + ": ");
            palpites[i] = sc.nextInt();
            if (palpites[i] > 9) {
                System.out.println("Número inválido");
                i--;
            }
        }
    }

    private void sortearNumeros() {
        for (int i = 0; i < 7; i++) {
            sorteados[i] = rd.nextInt(10);
        }
    }

    private int verificarAcertos() {
        int acertos = 0;
        for (int i = 0; i < 7; i++) {
            if (palpites[i] == sorteados[i]) {
                acertos++;
            }
        }
        return acertos;
    }

    private void exibirNumeros() {
        String linhaPosicao = "Posição: ";
        String linhaPalpites = "Palpites: ";
        String linhaSorteio = "Sorteio: ";
        for (int i = 0; i < 7; i++) {
            linhaPosicao += ("\t" + (i+1));
            linhaPalpites += ("\t" + palpites[i]);
            linhaSorteio += ("\t" + sorteados[i]);
        }
        System.out.println(linhaPosicao);
        System.out.println(linhaPalpites);
        System.out.println(linhaSorteio);
    }

    private void exibirResultado(int acertos) {
        System.out.println(String.format("Você acertou %d números!", acertos));

        if (acertos <= 3) {
            System.out.println("Não ganhou nada!");
        }
        else if (acertos == 4) {
            System.out.println("Ganhou prêmio menor!");
        }
        else if (acertos == 5) {
            System.out.println("Ganhou prêmio 3ª faixa!");
        }
        else if (acertos == 6) {
            System.out.println("Ganhou prêmio 2ª faixa!");
        }
        else if (acertos == 7) {
            System.out.println("Ganhou prêmio máximo!");
        }
    }

    public void executarSuperSete() {
        receberPalpites();
        sortearNumeros();
        exibirNumeros();
        exibirResultado(verificarAcertos());
    }
}
