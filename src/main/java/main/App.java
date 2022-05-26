package main;

import model.Equipe;
import model.Partida;
import model.Set;

import java.util.Scanner;

/**
 * @author ruansioso
 */
public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Partida partida = iniciaPartida();

        Equipe equipeVencedora;
        do {
            readPonto(partida);
        }
        while ((equipeVencedora = partida.getVencedor()) == null);

        System.out.println("O time \"" + equipeVencedora.getNome() + "\" venceu a partida!");
    }

    private static Partida iniciaPartida() {
        System.out.println("+-----------------------------------------------------+");
        System.out.println("| Bem vindo ao sistema gerenciador de Jogos de V�lei! |");
        System.out.println("+-----------------------------------------------------+\n");

        System.out.println("-> Digite o nome do primeiro time:");
        Equipe equipe1 = new Equipe(scanner.next());

        String nomeEquipe2;
        do {
            System.out.println("-> Digite o nome do segundo time:");
            nomeEquipe2 = scanner.next();
            if (nomeEquipe2.equals(equipe1.getNome())) {
                System.out.println("Valor inv�ido! O nome do segundo time deve ser diferente do nome do primeiro.");
            }
        }
        while (nomeEquipe2.equals(equipe1.getNome()));
        Equipe equipe2 = new Equipe(nomeEquipe2);

        return new Partida(equipe1, equipe2);
    }

    private static void readPonto(Partida partida) {
        int numeroSetAtual = partida.getIndexSetAtual();
        showPontuacaoSet(partida, partida.getSet(numeroSetAtual));

        int equipePontuar;
        do {
            System.out.println("Digite 1 para marcar ponto para a equipe \""
                    + partida.getSet(numeroSetAtual).getEquipe1().getEquipe().getNome()
                    + "\" e 2 para marcar ponto para a equipe \""
                    + partida.getSet(numeroSetAtual).getEquipe2().getEquipe().getNome()
                    + "\":");
            equipePontuar = scanner.nextInt();
            if (equipePontuar != 1 && equipePontuar != 2) {
                System.out.println("Valor inv�lido! Informe apenas 1 ou 2.");
            }
        }
        while (equipePontuar != 1 && equipePontuar != 2) ;

        if (equipePontuar == 1) {
            partida.getSet(numeroSetAtual).getEquipe1().addPonto();
        }
        else {
            partida.getSet(numeroSetAtual).getEquipe2().addPonto();
        }
    }

    private static void showPontuacaoSet(Partida partida, Set set) {
        int setsVencidosEquipe1 = partida.getSetsVencidosByEquipe(set.getEquipe1().getEquipe());
        int setsVencidosEquipe2 = partida.getSetsVencidosByEquipe(set.getEquipe2().getEquipe());

        String setsVencidosEquipe1AsString = stringRepeat(" ", 4 - setsVencidosEquipe1) + stringRepeat("x", setsVencidosEquipe1);
        String setsVencidosEquipe2AsString = stringRepeat(" ", 4 - setsVencidosEquipe2) + stringRepeat("x", setsVencidosEquipe2);

        System.out.println("\n+----+----+");
        System.out.println("| " + set.getEquipe1().getPontosAsString() + " | " + set.getEquipe2().getPontosAsString() + " |");
        System.out.println("+----+----+");
        System.out.println("|" + setsVencidosEquipe1AsString + "|" + setsVencidosEquipe2AsString + "|");
        System.out.println("+----+----+\n");
    }

    private static String stringRepeat(String s, int length) {
        return new String(new char[length]).replace("\0", s);
    }

}