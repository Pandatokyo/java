import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class HomeWork4 {

    private static char[][] map;
    private final static int MAP_SIZE = 3;
    private final static int DOTS_COUNT_TO_WIN = 3;
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';
    private final static char DOT_EMPTY = '•';
    private static final Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        init();
        print();
        while (true) {
            humanTurn();
            print();
            if (checkWin(DOT_X)) {
                System.out.println("Вы выиграли");
                break;
            }
            if (checkDraw()) {
                System.out.println("Ничья");
                break;
            }
            computerTurn();
            print();
            if (checkWin(DOT_O)) {
                System.out.println("Выиграл ИИ");
                break;
            }
            if (checkDraw()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static boolean checkWin(char playerDot) {
        int first_diagonal, second_diagonal, horizontal_dots, vertical_dots;
        for (int i = 0; i < MAP_SIZE; i++) {
            horizontal_dots = 0;
            vertical_dots = 0;
            for (int j = 0; j < MAP_SIZE; j++) { //проверка горизонтальных линий
                if (map[i][j] == playerDot) {horizontal_dots++;}
                else if (map[i][j] != playerDot && horizontal_dots < DOTS_COUNT_TO_WIN) {horizontal_dots = 0;}
                if (map[j][i] == playerDot) {vertical_dots++;}   //проверка вертикальных линий
                else if (map[j][i] != playerDot && vertical_dots < DOTS_COUNT_TO_WIN) {vertical_dots = 0;}
            }
            if (horizontal_dots >= DOTS_COUNT_TO_WIN || vertical_dots >= DOTS_COUNT_TO_WIN) {
                return true;
            }
        }

        for (int j = 0; j < MAP_SIZE; j++) { //проверка главной оси
            first_diagonal = 0;
            for (int i = 0; i < MAP_SIZE; i++) {
                int k = j + i;
                if (k < MAP_SIZE) {
                    if (map[i][k] == playerDot) {
                        first_diagonal++;
                    } else if (map[i][k] != playerDot && first_diagonal < DOTS_COUNT_TO_WIN) {
                        first_diagonal = 0;
                    }
                }
                if (first_diagonal >= DOTS_COUNT_TO_WIN) {
                    return true;
                }
            }
        }
        for (int j = 1; j < MAP_SIZE; j++) {  // проверяем главную диагональ вниз
            first_diagonal = 0;
            for (int i = 0; i < MAP_SIZE; i++) {
                int k = j + i;
                if (k < MAP_SIZE) {
                    if (map[k][i] == playerDot) {
                        first_diagonal++;
                    } else {
                        first_diagonal = 0;
                    }
                }
                if (first_diagonal >= DOTS_COUNT_TO_WIN) {
                    return true;
                }
            }
        }
        for (int j = 0; j < MAP_SIZE; j++) {
            second_diagonal = 0;
            for (int i = 0; i < MAP_SIZE; i++) { // проверка побочной диагонали вниз
                int k = (MAP_SIZE - 1) - i;
                int l = j + i;
                if (k >= 0 && l < MAP_SIZE) {
                    if (map[l][k] == playerDot) {second_diagonal++;}
                    else if (map[l][k] != playerDot && second_diagonal < DOTS_COUNT_TO_WIN) {second_diagonal = 0;}
                }
                if (second_diagonal >= DOTS_COUNT_TO_WIN) {
                    return true;
                }
            }
        }
        for (int j = 1; j < MAP_SIZE; j++) {
            second_diagonal = 0;
            for (int i = 0; i < MAP_SIZE; i++) { // проверка побочной диагонали влево
                int k = (MAP_SIZE - 1) - j - i;
                if (k >= 0) {
                    if (map[i][k] == playerDot) {second_diagonal++;}
                    else if (second_diagonal < DOTS_COUNT_TO_WIN) {second_diagonal = 0;}
                }
                if (second_diagonal >= DOTS_COUNT_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDraw() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void computerTurn() {
        int x,y;
        /* Видимо, здесь можно реализовать ход компьютера следующим образом:
        считать количество точек игрока в ряду, как в методе проверки победы
        и когда счетчик достигает DOTS_TO_WIN - 1, то при возможности (так, чтобы
        точка не уходила за лимиты поля) ставить точку там, где она должна быть для
        победы игрока. Не очень понял как это реализовать, кроме как сделать много
        циклов, что скорее всего бесполезно.
         */
        do {
            x = random.nextInt(MAP_SIZE);
            y = random.nextInt(MAP_SIZE);
        } while (!cellValidation(x + 1, y + 1, DOT_O));
        map[x][y] = DOT_O;
    }

    private static void humanTurn() {
        int x,y;
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    x = sc.nextInt();
                } else {
                    System.out.println("Неверный ввод координаты Х");
                    sc.nextLine();
                    continue;
                }
                if (sc.hasNextInt()) {
                    y = sc.nextInt();
                    break;
                } else {
                    System.out.println("Неверный ввод координаты Y");
                    sc.nextLine();
                }
            }
        } while (!cellValidation(x, y, DOT_X));
        map[x - 1][y - 1] = DOT_X;
    }

    private static boolean cellValidation(int x, int y, char dot) {
        if (x < 1 || x > MAP_SIZE || y < 1 || y > MAP_SIZE) {
            System.out.println("Неверное положение точки");
            return false;
        }
        boolean check = map[x - 1][y - 1] == DOT_EMPTY;

        if (check) {
            return check;
        } else {
            if (dot == DOT_X) {
                System.out.println("Точка не пустая");
            }
            return false;
        }
    }

    private static void print() {
        for (int i = 0; i < map.length + 1; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print((i) + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void init() {
        map = new char[MAP_SIZE][MAP_SIZE];
        for (char[] chars : map) {
            Arrays.fill(chars, DOT_EMPTY);
        }
    }
}
