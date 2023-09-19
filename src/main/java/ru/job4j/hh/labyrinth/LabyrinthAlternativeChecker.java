package ru.job4j.hh.labyrinth;

public class LabyrinthAlternativeChecker {
    public static void main(String[] args) {
        int rows = 2;
        int columns = 3;
        int x = 0;
        int y = 0;
        int[][] neighbours = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] neighbour : neighbours) {
            int nx = x + neighbour[0];
            int ny = x + neighbour[1];

            if ((nx >= 0 && nx <= rows) && (ny >= 0 && ny <= columns)) {
                //+2 проверки
                // 1) ЭТА точка лабиринта - туда вообще можно идти, т.е. matrix[nx][ny] == 0
                // 2) а не были мы там ранее, т.е. !visited[nx][ny]
                System.out.println("nx " + nx);
                System.out.println("ny " + ny);
                //помечаем как виситед, в очередь
            }

        }

    }
}
