import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        int rows = Input_Validation.inputNum("Введите количество строк поля. ", iScanner);
        int columns = Input_Validation.inputNum("Введите количество столбцов поля. ", iScanner);
        int walls = Input_Validation.inputNum("Введите количество стен. ", iScanner);
        while (!Input_Validation.Walls(rows, columns, walls)) {
            System.out.println("Количество стен превышает количество ячеек.");
            System.out.printf("Количество стен должно быть в диапазоне от 0 до %d.\n", rows * columns - 2);
            walls = Input_Validation.inputNum("Введите количество стен: ", iScanner);
        }

        int startRow = Input_Validation.inputNum("Введите индекс строки старта. ", iScanner);
        while (!Input_Validation.isRigthIndex(startRow, rows)) {
            System.out.println("Номер строки не может быть больше количества строк.");
            System.out.printf("Введите число от 1 до %d.\n", rows);
            startRow = Input_Validation.inputNum("Введите номер строки: ", iScanner);
        }

        int startColumn = Input_Validation.inputNum("Введите индекс столбца старта. ", iScanner);
        while (!Input_Validation.isRigthIndex(startColumn, columns)) {
            System.out.println("Номер столбца не может быть больше количества столбцов.");
            System.out.printf("Введите число от 1 до %d.\n", columns);
            startColumn = Input_Validation.inputNum("Введите номер столбца: ", iScanner);
        }

        int finishRow = Input_Validation.inputNum("Введите индекс строки финиша. ", iScanner);
        while (!Input_Validation.isRigthIndex(finishRow, rows)) {
            System.out.println("Номер строки не может быть больше количества строк.");
            System.out.printf("Введите число от 1 до %d.\n", rows);
            finishRow = Input_Validation.inputNum("Введите номер строки: ", iScanner);
        }

        int finishColumn = Input_Validation.inputNum("Введите индекс столбца финиша. ", iScanner);
        while (!Input_Validation.isRigthIndex(finishColumn, columns)) {
            System.out.println("Номер столбца не может быть больше количества столбцов.");
            System.out.printf("Введите число от 1 до %d.\n", rows);
            finishColumn = Input_Validation.inputNum("Введите номер столбца: ", iScanner);
        }

        iScanner.close();

        int[][] field = WaveAlgorithm.createField(rows, columns);
        WaveAlgorithm.Walls(field, walls);

        field[startRow][startColumn] = 1;
        field[finishRow][finishColumn] = -2;

        int[] finish = new int[]{finishRow, finishColumn};

        int step = WaveAlgorithm.drawRoutes(field);
        System.out.println();

        if (Input_Validation.isRoute(field, finish)) {
            int[][] coordinates = WaveAlgorithm.writingRoute(field, finish, step);
            WaveAlgorithm.ReverseArray(coordinates);
            System.out.println();
            System.out.println("Пошаговый маршрут c координатами каждой точки: ");
            WaveAlgorithm.show2dArrayWith2Col(coordinates);
            System.out.println("\nКратчайший путь составляет " + step + " ходов" );
            WaveAlgorithm.elementsColoring(field, coordinates);
        } else {
            Array.show2dArray(field);
            System.out.println("Построить маршрут невозможно.");
        }
    }

}