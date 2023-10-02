package jogos;

import java.util.Random;
import java.util.Scanner;

public class ParOuImpar {
    private String decisaoDoUsuario;
    private int numeroDoUsuario;
    private int numeroDoComputador;
    private int restoNecessario;
    private String vencedor;
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    public ParOuImpar() {}

    public void jogar() {
        String continuar = "S";

        do {
            if (continuar.equalsIgnoreCase("S")) {
                System.out.println(executarJogo());
            } else if (!continuar.equalsIgnoreCase("N")) {
                System.out.println("Valor inválido!");
            }
            System.out.println("Jogar novamente? \nPressione [S] para SIM ou [N] para NÃO.");
            continuar = sc.next();
        } while (!continuar.equalsIgnoreCase("N"));
    }

    private String executarJogo() {
        String mensagem;

        receberDecisaoDoUsuario();
        receberNumeroDoUsuario();
        gerarNumeroDoComputador();
        verificarVencedor();

        if (vencedor.equals("Usuário")) {
            mensagem = "Parabéns! Você venceu!";
        } else {
            mensagem = "Que pena! Você perdeu!";
        }

        return mensagem;
    }

    private void receberDecisaoDoUsuario() {
        restoNecessario = 2;
        while (restoNecessario == 2) {
            System.out.println("Par ou ímpar? \nDigite [P] para PAR ou [I] para ÍMPAR: ");
            decisaoDoUsuario = sc.next();
            if (decisaoDoUsuario.equalsIgnoreCase("P")) {
                restoNecessario = 0;
                System.out.println("Você escolheu par");
            } else if (decisaoDoUsuario.equalsIgnoreCase("I")) {
                restoNecessario = 1;
                System.out.println("Você escolheu impar");
            } else {
                restoNecessario = 2;
                System.out.println("Valor inválido!");
            }
        }
    }

    private void receberNumeroDoUsuario () {
        do {
            System.out.println("Digite um número entre 0 e 5: ");
            numeroDoUsuario = sc.nextInt();
            if (numeroDoUsuario >= 0 && numeroDoUsuario <= 5) {
                System.out.println("Você escolheu número " + numeroDoUsuario);
            } else {
                System.out.println("Número inválido!");
            }
        } while (numeroDoUsuario < 0 || numeroDoUsuario > 5);
    }

    private void gerarNumeroDoComputador() {
        numeroDoComputador = r.nextInt(6);
        System.out.println("Computador escolheu " + numeroDoComputador);
    }

    private String verificarVencedor() {
        if (restoNecessario == (numeroDoUsuario + numeroDoComputador) % 2) {
            vencedor = "Usuário";
        } else {
            vencedor = "Computador";
        }
        return vencedor;
    }
}
