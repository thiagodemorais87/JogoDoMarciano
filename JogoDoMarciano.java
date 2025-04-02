import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class JogoDoMarciano {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Integer> recordes = new ArrayList<>();

        System.out.println("Bem-vindo ao Jogo do Marciano!");
        System.out.println("História: Um marciano escondeu um número entre 1 e 100. Descubra qual é!");

        boolean jogarNovamente;

        do {
            int numeroMarciano = random.nextInt(100) + 1;
            int tentativas = 0;
            int limiteTentativas = 10;

            System.out.println("Você tem " + limiteTentativas + " tentativas. Boa sorte!");

            while (true) {
                System.out.print("Digite seu palpite (1 a 100): ");
                int palpite = scanner.nextInt();
                tentativas++;

                if (palpite == numeroMarciano) {
                    System.out.println("Parabéns! Você acertou o número " + numeroMarciano + " em " + tentativas + " tentativas!");
                    recordes.add(tentativas);
                    Collections.sort(recordes);
                    System.out.println("Melhores jogadas: " + recordes);
                    break;
                } else if (palpite < numeroMarciano) {
                    System.out.println("Errado! O número é maior.");
                    if (Math.abs(numeroMarciano - palpite) > 20) {
                        System.out.println("Dica: Você está muito longe!");
                    }
                } else {
                    System.out.println("Errado! O número é menor.");
                    if (Math.abs(numeroMarciano - palpite) > 20) {
                        System.out.println("Dica: Você está muito longe!");
                    }
                }

                System.out.println("Tentativa " + tentativas + " de " + limiteTentativas);

                if (tentativas >= limiteTentativas) {
                    System.out.println("Que pena! Você não acertou o número. O número correto era: " + numeroMarciano);
                    break;
                }
            }

            if (tentativas <= 3) {
                System.out.println("Impressionante! Você é um verdadeiro caçador de marcianos!");
            } else if (tentativas <= 6) {
                System.out.println("Boa! Você encontrou o número sem muito esforço.");
            } else {
                System.out.println("Ufa! Foi por pouco, mas você conseguiu!");
            }

            System.out.print("Deseja jogar novamente? (s/n): ");
            jogarNovamente = scanner.next().equalsIgnoreCase("s");

        } while (jogarNovamente);

        System.out.println("Obrigado por jogar! Até a próxima!");
        scanner.close();
    }
}
