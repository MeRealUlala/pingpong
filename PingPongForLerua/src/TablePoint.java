
public class TablePoint {
    public void checkHit(int[][] table, PlayerImpl player, PlayerImpl enemy) {
        int point = player.hit(table);
        int xPoint = point % table[0].length;
        int yPoint = point / table[0].length;
        int value = table[yPoint][xPoint];
        if (value != player.getId()) {
            player.addPoint();
            System.out.printf("Игрок %d попал. ", player.getId());
            System.out.printf("Координата точки: x = %d, y = %d\n", xPoint, yPoint);
        } else {
            enemy.addPoint();
            System.out.printf("Игрок %d не попал. ", player.getId());
            System.out.printf("Координата точки: x = %d, y = %d\n", xPoint, yPoint);
        }
    }
}
