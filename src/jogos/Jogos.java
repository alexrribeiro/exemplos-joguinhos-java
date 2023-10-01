package jogos;

import java.util.Scanner;

public class Jogos {
    public static void main(String[] args) {
        ParOuImpar pi = new ParOuImpar();
        PedraPapelTesoura pp = new PedraPapelTesoura();

        Scanner sc = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println("Selecione um jogo: \n[1] Par ou ímpar \n[2] Pedra, Papel, Tesoura \n[0] Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> pi.jogar();
                case 2 -> pp.jogar();
                case 0 -> System.exit(0);
                default -> System.out.println("Nenhuma opção válida foi digitada!");
            }
        }
    }
}
