import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MyTicTacToe {

    public static final char SYMBOL_X = 'X';
    public static final char SYMBOL_0 = '0';
    public static final char EMPTY = ' ';

    public static final int GAME_SIZE = 3;

    char[][] game = new char[GAME_SIZE][GAME_SIZE];

    Player player1;
    Player player2;

    public MyTicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void showGame() {
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initBoard() {
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                game[i][j] = '.';
            }
        }
    }

    public Move readMove() {
        System.out.println(" Mutarea ta este: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arrayOfString = s.split("-");
        Move mutare = new Move(Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1]));
        return mutare;
    }


    public boolean isWin(char simbol, Move move) {
        int liniaCurenta = move.getLine();
        int colanaCurenta = move.getColumn();
        return (game[liniaCurenta][0] == simbol     // 3-in-the-row
                && game[liniaCurenta][1] == simbol
                && game[liniaCurenta][2] == simbol
                || game[0][colanaCurenta] == simbol     // 3-in-the-column
                && game[1][colanaCurenta] == simbol
                && game[2][colanaCurenta] == simbol
                || liniaCurenta == colanaCurenta            // 3-in-the-diagonal
                && game[0][0] == simbol
                && game[1][1] == simbol
                && game[2][2] == simbol
                || liniaCurenta + colanaCurenta == 2  // 3-in-the-opposite-diagonal
                && game[0][2] == simbol
                && game[1][1] == simbol
                && game[2][0] == simbol);
    }

    public void makeMove(Move move, char symbol) {
        game[move.getLine()][move.getColumn()] = symbol;
    }

    public void playGame() {
        boolean isWin;
        do {
        initBoard();
        System.out.println("Incepe jocul.");
        showGame();

        Player currentPlayer = player1;
        char currentSymbol = SYMBOL_X;
        int nrMoves = 0;
            isWin= false;


            while (isWin == false && nrMoves < 9) {

                //citiesc mutarea
                System.out.print("Player " + currentPlayer.name + "(" + currentSymbol + ")");
                Move move = readMove();
                //validez mutarea
                if (move.getLine() >= 0 && move.getLine() < GAME_SIZE
                        && move.getColumn() >= 0 && move.getColumn() < GAME_SIZE
                        && game[move.getLine()][move.getColumn()] == '.') {

                    //efectuiez mutarea
                    makeMove(move, currentSymbol);
                    showGame();
                    //numar mutare
                    nrMoves++;
                    //schimb player-ul

                    //System.out.println(isWin(currentSymbol, move));
                    //testez daca avem stare de WIN
                    if (nrMoves >= (2 * GAME_SIZE - 1)) {
                        isWin = isWin(currentSymbol, move);

                        if (isWin) {
                            //afisez mesaj corespunzator
                            System.out.println(currentPlayer.name + " a castigat!");
                        }
                    }
                    if (currentPlayer.equals(player1)) {
                        currentPlayer = player2;
                        currentSymbol = SYMBOL_0;
                    } else {
                        currentPlayer = player1;
                        currentSymbol = SYMBOL_X;
                    }

                } else {
                    System.out.println("Pozitia este ocupata sau nu ati introdus corect pozitia");
                }


            }
            if(nrMoves==9) {
                System.out.println("nu a castigat nimeni - jocul se reia");
            }
        } while (!isWin);

    }

}
