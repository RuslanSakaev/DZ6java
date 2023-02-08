
import java.util.*;

public class WaveAlgorithm {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 },
                { 0, 0, 1, 1 },
                { 0, 1, 1, 0 } };
        int row = matrix.length;
        int col = matrix[0].length;
        // Проходим по всем ячейкам матрицы и присваиваем каждой ячейке индекс
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = -1; // -1 - означает непосещенную ячейку
                } else {
                    matrix[i][j] = Integer.MAX_VALUE; // Посещенные ячейки присваиваем максимально возможное
                                                      // целочисленное значение
                }
            }
        }
        // Задаем ячейку стартового положения (x=0, y=0)
        int x = 0;
        int y = 0;
        // Зададим стоимость шага (cost)
        int cost = 1;
        // Начинаем алгоритм с точки (x=0, y=0) и устанавливаем стоимость равную 0
        matrix[x][y] = 0;
        // Зададим стороны: left, right, up and down.
        int left = y - 1;
        int right = y + 1;
        int up = x - 1;
        int down = x + 1;
        // Создадим FIFO-очередь (Queue) с точкой (x=0, y=0) и установим visited[][]
        // true.
        boolean[][] visited = new boolean[row][col]; // visited[][] - true/false - был/не был посещен.
        Queue<Point> queue = new LinkedList<Point>(); // FIFO-очередь.
        queue.add(new Point(x, y)); // Добавляем точку (x=0, y=0) в FIFO-очередь.
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point p = queue.remove(); // Удаляем точку p c FIFO-очередь.
            // проверка всех 4 возможных движений из текущей ячейки px, py и обновление
            // значения стоимости для каждого допустимого движения.
            if (isValid(p.x + 1, p.y, row, col) && !visited[p.x + 1][p.y]) {// движение вниз
                queue.add(new Point(p.x + 1, p.y)); // добавить в очередь
                visited[p.x + 1][p.y] = true; // отметить как
            }
        }
    }
}