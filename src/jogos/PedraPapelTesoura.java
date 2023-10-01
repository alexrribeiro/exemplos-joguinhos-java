package jogos;

import java.util.Random;
import java.util.Scanner;

public class PedraPapelTesoura {
    int escolhaDoUsuario = 0;
    String escolhaUsuarioStr;
    int escolhaDoComputador;
    String escolhaComputadorStr;
    int placarUsuario = 0;
    int placarComputador = 0;
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public PedraPapelTesoura() {}

    void jogar() {
        do {
            executarJogo();
            if (placarUsuario == 5) {
                System.out.println("Você venceu o jogo!");
            } else if (placarComputador == 5) {
                System.out.println("O computador venceu o jogo!");
            }
        } while (placarUsuario < 5 && placarComputador < 5);
    }
    void executarJogo() {
        String mensagem = "";
        String eu = receberEscolhaDoUsuario();
        String ec = gerarEscolhaDoComputador();

        if (eu.equals(ec)) {
            System.out.println("Empatou! Não houve vencedor na rodada!");
        } else if (eu.equals("Papel") && ec.equals("Pedra") ||
                eu.equals("Pedra") && ec.equals("Tesoura") ||
                eu.equals("Tesoura") && ec.equals("Papel")) {
            System.out.println("Você venceu esta rodada!");
            placarUsuario++;
        } else if (ec.equals("Papel") && eu.equals("Pedra") ||
                ec.equals("Pedra") && eu.equals("Tesoura") ||
                ec.equals("Tesoura") && eu.equals("Papel")) {
            System.out.println("Você perdeu esta rodada!");
            placarComputador++;
        }
        System.out.println(String.format("Você: %d x %d Computador", placarUsuario, placarComputador));
    }

    String receberEscolhaDoUsuario() {
        escolhaDoUsuario = 0;
        while (escolhaDoUsuario < 1 || escolhaDoUsuario > 3) {
            System.out.println("Pedra, papel ou tesoura? \nPressione [1] para PEDRA, [2] para PAPEL ou [3] para TESOURA");
            escolhaDoUsuario = sc.nextInt();
            escolhaUsuarioStr = traduzirEscolha(escolhaDoUsuario);
        }
        System.out.println("Você escolheu: " + escolhaUsuarioStr);
        return escolhaUsuarioStr;
    }

    String gerarEscolhaDoComputador() {
        escolhaDoComputador = rd.nextInt(3) + 1;
        escolhaComputadorStr = traduzirEscolha(escolhaDoComputador);
        System.out.println("O computador escolheu: " + escolhaComputadorStr);
        return escolhaComputadorStr;
    }

    String traduzirEscolha(int escolha) {
        String opcao = "";

        switch (escolha) {
            case 1:
                opcao = "Pedra";
                break;
            case 2:
                opcao = "Papel";
                break;
            case 3:
                opcao = "Tesoura";
                break;
            default:
                System.out.println("Escolha inválida!");
                break;
        }
        return opcao;
    }
}
