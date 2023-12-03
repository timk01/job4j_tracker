package ru.job4j.hh.hhcontest.labyrinth;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class LabyrinthRawVersion {

    private static class Node {
        int x;
        int y;
        int distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int[] ROW_MOVE = {-1, 0, 0, 1};
    private static final int[] COL_MOVE = {0, -1, 1, 0};

    private static boolean isValid(int[][] mat, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && mat[row][col] == 0 && !visited[row][col];
    }

    public static void main(String[] args) {
        /**
         * КУЧА тестовых данных todo покрыть тестами
         *    int[][] matrix = new int[askNumber()][askNumber()];
         *         int startRow = askNumber();
         *         int startColumn = askNumber();
         *         Node initialNode = new Node(startRow, startColumn, 0);
         *         int endRow = askNumber();
         *         int endColumn = askNumber();
         *         Node finalNode = new Node(endRow, endColumn, 0);
         *         fillArray(matrix);
         *
         *         int[][] matrix = new int[][] {{0, 1, 0}, {0, 1, 0}, {0, 0, 0}};
         *         new int[3][3];
         *         int[][] matrix = new int[][] {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
         *         new int[3][3];
         *         int[][] matrix = new int[][] {{0, 1, 0, 1, 0}, {0, 0, 1, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
         *         new int[4][5]; 12
         *         int startColumn = 0;
         *         int startRow = 0;
         *         int endColumn = 2;
         *         int endRow = 0;
         *
         *         new int[4][5]; 9
         *
         *         int[][] matrixRepresentation = new int[][] {{100, 1, 0, 0, 0}, {0, 0, 1, 1, 0}, {1, 0, 1, 0, 0}, {0, 500, 0, 0, 0}};
         *         System.out.println(Arrays.deepToString(matrixRepresentation));
         *         for (int i = 0; i < matrix.length; i++) {
         *             for (int j = 0; j < matrix[i].length; j++) {
         *                 System.out.print(matrix[i][j] + " ");
         *             }
         *             System.out.println();
         *         }
         */

        int[][] matrix = new int[][] {{0, 1, 0, 1, 0}, {0, 0, 1, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        int startColumn = 4;
        int startRow = 0;
        int endColumn = 0;
        int endRow = 1;

        int[][] matrix2 = new int[4][5];

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        int shortest = findShortestPath(matrix, startRow, startColumn, endRow, endColumn);
        System.out.println(shortest);
    }

    private static int askNumber() {
        return SCANNER.nextInt();
    }

    private static void fillArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = askNumber();
            }
        }
    }

    public static int findShortestPath(int[][] matrix, int startRow, int startColumn, int endRow, int endColumn) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean[][] visitedNode = new boolean[rows][columns];

        Queue<Node> nodesQueue = new ArrayDeque<>();

        visitedNode[startRow][startColumn] = true;
        nodesQueue.add(new Node(startRow, startColumn, 0));

        int minDistance = Integer.MAX_VALUE;

        while (!nodesQueue.isEmpty()) {
            Node node = nodesQueue.poll();

            int currentRow = node.x;
            int currenColumn = node.y;
            int distance = node.distance;

            if (currentRow == endRow && currenColumn == endColumn) {
                minDistance = distance;
                break;
            }

            for (int k = 0; k < 4; k++) {
                if (isValid(matrix, visitedNode, currentRow + ROW_MOVE[k], currenColumn + COL_MOVE[k])) {
                    visitedNode[currentRow + ROW_MOVE[k]][currenColumn + COL_MOVE[k]] = true;
                    nodesQueue.add(
                            new Node(
                                    currentRow + ROW_MOVE[k],
                                    currenColumn + COL_MOVE[k],
                                    distance + 1
                            )
                    );
                }
            }
        }

        if (minDistance != Integer.MAX_VALUE) {
            return minDistance;
        }

        return 0;
    }

}