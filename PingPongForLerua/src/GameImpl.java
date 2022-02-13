import java.util.Random;
import java.util.Scanner;

public class GameImpl implements Game {
    private static GameImpl game = new GameImpl();
    private static PingPongTable pingPongTable = new PingPongTable();
    private static TablePoint tablePoint = new TablePoint();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
        game.run();
    }

    @Override
    public void run() {
        System.out.println("Введите длину стола -> x = ");
        int x = scanner.nextInt();
        while (x % 2 != 0 || x <= 0) {
            System.out.println("Введите четную длину стола -> x = ");
            x = scanner.nextInt();
        }
        System.out.println("Введите ширину стола -> y = ");
        int y = scanner.nextInt();
        pingPongTable.createTable(x, y);
        int[][] table = pingPongTable.getTable();
        PlayerImpl player1 = new PlayerImpl(1);
        PlayerImpl player2 = new PlayerImpl(2);
        int queue = random.nextInt(2) + 1;
        while (player1.getCountPoints() < 11 && player2.getCountPoints() < 11) {
            if (queue == player1.getId()) {
                tablePoint.checkHit(table, player1, player2);
                queue = player2.getId();
                System.out.printf("Кол-во очков игрока 1 ->%d\n", player1.getCountPoints());
            } else if (queue == player2.getId()) {
                tablePoint.checkHit(table, player2, player1);
                queue = player1.getId();
                System.out.printf("Кол-во очков игрока 2 ->%d\n", player2.getCountPoints());
            }
        }
        scanner.close();
    }
}
