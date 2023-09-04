import java.util.Scanner;

public class Jogos {
    public static void main(String[] args) {
        ParOuImpar pi = new ParOuImpar();
        PedraPapelTesoura pp = new PedraPapelTesoura();

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (true) {
            System.out.println("Selecione um jogo: \n[1] Par ou ímpar \n[2] Pedra, Papel, Tesoura \n[0] Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    pi.jogar();
                    break;
                case 2:
                    pp.jogar();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Nenhuma opção válida foi digitada!");
            }
        }
    }
}
