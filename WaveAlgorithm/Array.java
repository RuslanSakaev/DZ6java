public class Array {
    static void show2dArray(int[][] array) {
        for (int i = 0; i < array[0].length * 8; i++)
            System.out.print("_");
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j != array[i].length - 1)
                    System.out.printf("| %d\t", array[i][j]);
                else
                    System.out.printf("| %d\t|", array[i][j]);
            }
            System.out.println();
            for (int k = 0; k < array[0].length * 8 + 1; k++) {
                if (k % 8 == 0)
                    System.out.print("|");
                else
                    System.out.print("_");
            }
            System.out.println();
        }
    }
}
