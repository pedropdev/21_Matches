import java.util.Random;
import java.util.Scanner;

public class Computador {
    int jogada;
    boolean winner;
    boolean modoFacil;

    String nome;
    static Random numFosforos = new Random();

    static int tracker;

    public Computador(boolean modoFacil) {
        this.jogada = 0;
        this.winner = false;
        this.modoFacil = modoFacil;
        this.nome = "PC";
    }


    public int removerFosforosRand() {
        this.jogada = numFosforos.nextInt(1, 5);
        return this.jogada;
    }


    /**
     * Remove fosforos de modo a complementar para 5 a soma das duas jogadas(PC/Jogador)
     *
     * @param j1 jogadaor com quem ta a jogar
     * @return Jogada do PC
     */
    public int removerFosforosImpossivel(Jogador j1) {
        //PC segundo a jogar OU voltou a entrar em posição para jogar em complemento.
        if (!Fosforos.pcFirst) {
            tracker = 0;
            this.jogada = 0;
            if (j1.jogada == 0) {
                this.jogada = numFosforos.nextInt(1, 5);
            } else {
                tracker = this.jogada + j1.jogada;
                if (tracker == 5) {
                    this.jogada = numFosforos.nextInt(1, 5);
                } else if (tracker < 5) {
                    this.jogada = 5 - tracker;
                } else {
                    this.jogada = 10 - tracker;
                }
            }
            //PC primeiro a jogar E ja jogou pelo menos 1 vez
        } else if (this.jogada != 0) {
            tracker = this.jogada + j1.jogada;
            if (tracker == 5) {
                this.jogada = numFosforos.nextInt(1, 5);
            } else if (tracker < 5) {
                this.jogada = 5 - tracker;
                Fosforos.pcFirst = false;
            } else {
                this.jogada = 10 - tracker;
                Fosforos.pcFirst = false;
            }
            //PC primeiro a jogar
        } else {
            this.jogada = numFosforos.nextInt(1, 5);
        }
        return this.jogada;
    }


    public void comportamentoPC(Jogador j1) {
        System.out.println("////////////////////////////////////////////////");
        System.out.printf("Total de fosforos: %s\n", Fosforos.TOTAL);
        System.out.printf("Jogador: %s\n", this.nome);
        if (this.modoFacil) {
            Fosforos.TOTAL -= this.removerFosforosRand();
            System.out.printf("O PC removeu %s fosforos.\n", this.jogada);
        } else {
            Fosforos.TOTAL -= this.removerFosforosImpossivel(j1);
            System.out.printf("O PC removeu %s fosforos.\n", this.jogada);
        }
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