package RallyRacing;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        String carNum = scanner.nextLine();

        String [][] matrix = new String[matrixSize][matrixSize];
        readRoute(scanner, matrixSize, matrix);

        String command = scanner.nextLine();

        int km = 0;
        int row = 0;
        int column = 0;
        matrix[row][column] = "C";
        int [] tunnelIndex = new int[2];
        boolean finish = false;

        while (!command.equals("End")){

            switch (command){
                case "left":
                    if (matrix[row][column - 1].equals(".")) {
                        km = moveLeft(km, column, matrix[row]);
                        column -= 1;
                    } else if (matrix[row][column - 1].equals("F")){
                        km = moveLeft(km, column, matrix[row]);
                        finish = true;
                    } else if (matrix[row][column - 1].equals("T")){
                        km = moveLeft(km, column, matrix[row]);

                        tunnelIndex = findTunnel(matrix, row, column);
                        row = tunnelIndex[0];
                        column = tunnelIndex[1];

                        km = goThroughTunnel(tunnelIndex,matrix, row, column, km);
                    }
                    break;
                case "right":
                    if (matrix[row][column + 1].equals(".")) {
                        km = moveRight(km, column, matrix[row]);
                        column += 1;
                    } else if (matrix[row][column + 1].equals("F")){
                        km = moveRight(km, column, matrix[row]);
                        finish = true;
                    } else if (matrix[row][column + 1].equals("T")){
                        km = moveRight(km, column, matrix[row]);

                        tunnelIndex = findTunnel(matrix, row, column);
                        row = tunnelIndex[0];
                        column = tunnelIndex[1];

                        km = goThroughTunnel(tunnelIndex,matrix, row, column, km);
                    }
                    break;
                case "up":
                    if (matrix[row - 1][column].equals(".")) {
                        km = moveUp(matrix, km, row, column);
                        row -= 1;
                    } else if (matrix[row - 1][column].equals("F")){
                        km = moveUp(matrix, km, row, column);
                        finish = true;
                    } else if(matrix[row - 1][column].equals("T")){
                        km = moveUp(matrix, km, row, column);

                        tunnelIndex = findTunnel(matrix, row, column);
                        row = tunnelIndex[0];
                        column = tunnelIndex[1];

                        km = goThroughTunnel(tunnelIndex,matrix, row, column, km);

                    }
                    break;
                case "down":
                    if (matrix[row + 1][column].equals(".")) {
                        km = moveDown(matrix, km, row, column);
                        row += 1;
                    } else if (matrix[row + 1][column].equals("F")){
                        km = moveDown(matrix, km, row, column);
                        finish = true;
                    } else if (matrix[row + 1][column].equals("T")){
                        km = moveDown(matrix, km, row, column);

                        tunnelIndex = findTunnel(matrix, row, column);
                        row = tunnelIndex[0];
                        column = tunnelIndex[1];

                        km = goThroughTunnel(tunnelIndex,matrix, row, column, km);
                    }
                    break;
            }

            if (finish){
                break;
            } else {
                command = scanner.nextLine();
            }
        }

        printResult(carNum, km, finish);

        printRoute(matrix);

    }

    private static void printRoute(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j].replaceAll("\\s",""));
            }
            System.out.println();
        }
    }

    private static void printResult(String carNum, int km, boolean finish) {
        if (!finish){
            System.out.printf("Racing car %s DNF.\n", carNum);
        } else{
            System.out.printf("Racing car %s finished the stage!\n", carNum);
        }

        System.out.printf("Distance covered %d km.\n", km);
    }

    private static void readRoute(Scanner scanner, int matrixSize, String[][] matrix) {
        for (int i = 0; i < matrixSize; i++) {
            String [] route = scanner.nextLine().split(" ");
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = route[j];
            }
        }
    }

    private static int moveDown(String[][] matrix, int km, int row, int column) {
        matrix[row + 1][column] = matrix[row][column];
        matrix[row][column] = ".";
        return km += 10;
    }

    private static int moveUp(String[][] matrix, int km, int row, int column) {
        matrix[row - 1][column] = matrix[row][column];
        matrix[row][column] = ".";
        return km+= 10;
    }

    private static int moveRight(int km, int column, String[] matrix) {
        matrix[column + 1] = matrix[column];
        matrix[column] = ".";
        return km+= 10;
    }

    private static int moveLeft(int km, int column, String[] matrix) {
        matrix[column - 1] = matrix[column];
        matrix[column] = ".";
        return km += 10;
    }

    private static int goThroughTunnel(int[] tunnelIndex, String[][] matrix, int row, int column, int km){
        tunnelIndex = findTunnel(matrix, row, column - 1);
        matrix[row][column] = ".";
        matrix[tunnelIndex[0]][tunnelIndex[1]] = "C";
        return km += 20;
    }

    private static int [] findTunnel(String [][] matrix, int row, int column) {
        int [] index = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("T")){
                    if (i != row && j != column){
                        index[0] = i;
                        index[1] = j;
                    } else if (i == row && j != column){
                        index[0] = i;
                        index[1] = j;
                    } else if (i != row && j == column){
                        index[0] = i;
                        index[1] = j;
                    }
                }
            }
        }
        return index;
    }

}
