import java.util.Random;
import java.util.Scanner;

public class Fosforos {
    static Art fosforos = new Art();
    static Scanner leitor = new Scanner(System.in);

    static Random moeda = new Random();
    static boolean face;

    static boolean pcFirst = false;
    static int TOTAL;

    public static void main(String[] args) {
        boolean progTerminado = false;

        while (!progTerminado) {
            try {
                int escolha = 1;
                TOTAL = 21;

                fosforos.Ascii();
                System.out.println("================================================");
                System.out.println("Bem vindo ao jogo dos 21 fosforos!");
                System.out.println("Escolha uma opcao para comecar:");
                System.out.println("1 - Jogador VS Jogador");
                System.out.println("2 - Jogador VS PC (Dificuldade: Facil)");
                System.out.println("3 - Jogador VS PC (Dificuldade: Dificil)");
                System.out.println("0 - Sair");
                System.out.println("================================================");
                escolha = leitor.nextInt();
                leitor.nextLine();

                switch (escolha) {
                    case 1 -> {
                        Jogador p1 = new Jogador();
                        System.out.println("Introduza o nome do 1o Jogador");
                        p1.setNome(leitor.nextLine());
                        leitor = new Scanner(System.in);


                        Jogador p2 = new Jogador();
                        System.out.println("Introduza o nome do 2o Jogador");
                        p2.setNome(leitor.nextLine());
                        leitor = new Scanner(System.in);

                        moedaAoAr(p1, p2);
                    }
                    case 2 -> {
                        Jogador p1 = new Jogador();
                        System.out.println("Introduza o nome do 1o Jogador");
                        p1.setNome(leitor.nextLine());
                        leitor = new Scanner(System.in);

                        Computador pc = new Computador(true);

                        moedaAoAr(p1, pc);


                    }
                    case 3 -> {
                        Jogador p1 = new Jogador();
                        System.out.println("Introduza o nome do 1o Jogador");
                        p1.setNome(leitor.nextLine());
                        leitor = new Scanner(System.in);

                        Computador pc = new Computador(false);

                        moedaAoAr(p1, pc);

                    }
                    case 0 -> progTerminado = true;
                }
            } catch (Exception e) {
                System.out.println("Opcao invalida");
                leitor = new Scanner(System.in);
            }
        }
    }

    private static void JogoDe21(Jogador j1, Jogador j2, Computador c) {
        //
    }

    //Overload
    private static void JogoDe21(Jogador j1, Jogador j2) {
        boolean aJogar = true;


        while (aJogar) {

            j1.mudarTurno();

            if (j1.ganhou()) {
                break;
            } else if (TOTAL < 1) {
                j2.setWinner(true);
                break;
            }

            j2.mudarTurno();

            if (j2.ganhou()) {
                break;
            } else if (TOTAL < 1) {
                j1.setWinner(true);
                break;
            }

        }
        if (j1.winner) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.printf("Jogador %s Ganhou!\n", j1.nome);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        } else {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.printf("Jogador %s Ganhou!\n", j2.nome);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    private static void JogoDe21(Jogador j1, Computador c) {
        boolean aJogar = true;


        while (aJogar) {

            j1.mudarTurno();

            if (j1.ganhou()) {
                break;
            } else if (TOTAL < 1) {
                c.setWinner(true);
                break;
            }


            c.comportamentoPC(j1);

            if (c.ganhou()) {
                break;
            } else if (TOTAL < 1) {
                j1.setWinner(true);
                break;
            }


        }

        if (c.winner) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.printf(" %s Ganhou!\n", c.nome);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        } else {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.printf("Jogador %s Ganhou!\n", j1.nome);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    private static void JogoDe21(Computador c, Jogador j1) {
        boolean aJogar = true;
        pcFirst = true;


        while (aJogar) {


            c.comportamentoPC(j1);

            if (c.ganhou()) {
                break;
            } else if (TOTAL < 1) {
                j1.setWinner(true);
                break;
            }

            j1.mudarTurno();

            if (j1.ganhou()) {
                break;
            } else if (TOTAL < 1) {
                c.setWinner(true);
                break;
            }


        }

        if (j1.winner) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.printf("Jogador %s Ganhou!\n", j1.nome);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        } else {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.printf("%s Ganhou!\n", c.nome);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    //coin flip
    public static void moedaAoAr(Jogador j1, Jogador j2, Computador c) {
        //
    }

    //overload
    public static void moedaAoAr(Jogador j1, Jogador j2) {
        face = moeda.nextBoolean();
        if (face) {
            JogoDe21(j1, j2);
        } else {
            JogoDe21(j2, j1);
        }
    }

    public static void moedaAoAr(Jogador j1, Computador c) {
        face = moeda.nextBoolean();
        if (face) {
            JogoDe21(j1, c);
        } else {
            JogoDe21(c, j1);
        }
    }
}
