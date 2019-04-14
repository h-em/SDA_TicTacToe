import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x;
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Numele primului jucator: ");
            String player1Name = scanner.nextLine();
            System.out.print("\nNumele celui de-al doilea jucator: ");
            String player2Name = scanner.nextLine();

            //construiesc jucatorii
            Player player1 = new Player(player1Name);
            Player player2 = new Player(player2Name);

            //construiesc jocul
            MyTicTacToe myTicTacToe = new MyTicTacToe(player1, player2);
            myTicTacToe.playGame();//playGame este metoda de instanta, nu de clasa!

            System.out.println("doriti sa reluati jocul?   0- Da  1-NU");
             x = scanner.nextInt();
        } while(x==0);

    }
}

