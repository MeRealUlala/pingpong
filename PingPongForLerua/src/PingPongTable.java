public class PingPongTable {
    private int[][] table;

    public void createTable(int x, int y) {
        table = new int[y][x];
        int i = 0;
        int j = 0;
        while (j < y) {
            while (i < x) {
                table[j][i] = i < (x / 2) ? 1 : 2;
                i++;
            }
            i = 0;
            j++;
        }
    }

    public int[][] getTable() {
        return table;
    }
}