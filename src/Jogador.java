import java.util.Scanner;

public class Jogador {
    int jogada;
    boolean winner;
    String nome;
    Scanner reader = new Scanner(System.in);


    public Jogador() {
        this.jogada = 0;
        this.winner = false;
        this.nome = "";
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public int removerFosforos() {
        do {
            System.out.println("Quantos fosforos quer tirar? (1 a 4)");
            this.jogada = reader.nextInt();

            if (this.jogada != 1 && this.jogada != 2 && this.jogada != 3 && this.jogada != 4) {
                System.out.println("Escolha invalida...");
            }

        } while (this.jogada != 1 && this.jogada != 2 && this.jogada != 3 && this.jogada != 4);
        return this.jogada;
    }

    public void mudarTurno() {
        System.out.println("////////////////////////////////////////////////");
        System.out.printf("Total de fosforos: %s\n", Fosforos.TOTAL);
        System.out.printf("Jogador: %s\n", this.nome);
        Fosforos.TOTAL -= this.removerFosforos();
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean ganhou() {
        if (Fosforos.TOTAL == 1) {
            this.winner = true;
        }
        return this.winner;
    }
}
