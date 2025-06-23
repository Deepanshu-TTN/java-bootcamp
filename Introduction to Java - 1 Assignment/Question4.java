public class Question4 {
    public static void main(String[] args) {
        int[][] arr = {
                { 2, 5, 1 },
                { 4, 2 },
                { 3, 1, 5, 6 }
        };
        printRowSum(arr);
        printColumnSum(arr);
    }

    private static void printRowSum(int[][] arr) {
        int numberOfRows = arr.length;
        for (int row = 0; row < numberOfRows; row++) {
            int sum = 0;
            for (int item = 0; item < arr[row].length; item++)
                sum += arr[row][item];
            System.out.println("Sum of row " + row + " is: " + sum);
        }
    }

    private static void printColumnSum(int[][] arr) {
        int maxCols = arr[0].length;
        for (int i = 1; i < arr.length; i++) {
            maxCols = Math.max(maxCols, arr[i].length);
        }

        for (int column = 0; column < maxCols; column++) {
            int sum = 0;
            for (int row = 0; row < arr.length; row++) {
                if (arr[row].length > column)
                    sum += arr[row][column];
            }
            System.out.println("Sum of column " + column + " is: " + sum);
        }
    }
}