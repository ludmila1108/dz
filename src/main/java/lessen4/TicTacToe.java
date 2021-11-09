package lessen4;

import java.util.Random;
import java.util.Scanner;


class TicTacToe {
    static final int SIZE = 3;

    static final char DON_EMPTY = '•';
    static final char DON_HUMAN = 'X';
    static final char DON_AI = '0';

    static final String HEADER_FIRST_SYMBOL = "❤";
    static final String SPACE_MAP = " ";

    static final char[][] MAP = new char[SIZE][SIZE];
    static final Random random = new Random();
    static final Scanner in = new Scanner(System.in);
    static int turnsCount;

    public static void turnGame() {
        do {
            System.out.println("\n\n игра начинается");
            initMap();
            printMap();
            playGeme();
        } while (isContinueGame());
        endGeme();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DON_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHederWap();
        printBadyMap();
    }



    private static void printHederWap() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void printBadyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void playGeme() {
        while (true) {
            humanTurn();
            printMap();
            if(checrEnd(DON_HUMAN)) {
                break;
            }
            aiTurn();
            printMap();
            if(checrEnd(DON_AI)) {
                break;
            }
        }

        //пойти на следующий ход
    }

    private static void humanTurn() {
        System.out.print("\nХод человека");
        int romNumber;
        int colomnNumber;


        do {
            romNumber = getValidNumber() - 1;
            colomnNumber = getValidNumber() - 1;
            if (isCellFree(romNumber,colomnNumber)){
                break;
            } else {
                System.out.println("\nВы выбрали занятую ячейку");
            }
        } while (true);


        MAP[romNumber][colomnNumber] = DON_HUMAN;
        turnsCount++;
    }

    private static int getValidNumber() {
        do {
            System.out.print("Введите координату");
            if (in.hasNext()) {
                int n = in.nextInt();
                if (isNamberValid(n)) {
                    System.out.println("координата " + n + " принята");
                    return n;
                }
                System.out.println("\nПроверьте значение координаты .Должны быть от 1 до" +
                        SIZE);

            } else {
                System.out.println("\nВвод допускает лишь целые числа");
                in.next();
            }
        } while (true);
    }

    private static boolean isNamberValid(int n) {
        return n >= 1 && n <= SIZE;
    }
    private static boolean isCellFree(int romNumber, int colomnNumber) {
        return MAP[romNumber][colomnNumber] == DON_EMPTY;
    }
    private static boolean checrEnd(char symbol) {
        if (checrWin(symbol)){
            if (symbol == DON_HUMAN) {
                System.out.println("\nУра!вы победили");
            } else {
                System.out.println("\nВостания близко.ИИ победил..");
            }
            return true;
        }
        if (checrDreaw()){
            System.out.println("\nНечья");
            return true;
        }
        return false;
    }

    private static boolean checrWin(char symbol) {
        if(MAP[0][0] == symbol && MAP[0][1] == symbol && MAP[0][2] == symbol) {
            return true;
        }
        if(MAP[1][0] == symbol && MAP[1][1] == symbol && MAP[1][2] == symbol) {
            return true;
        }
        if(MAP[2][0] == symbol && MAP[2][1] == symbol && MAP[2][2] == symbol) {
            return true;
        }
        if(MAP[0][0] == symbol && MAP[1][0] == symbol && MAP[2][0] == symbol) {
            return true;
        }
        if(MAP[0][1] == symbol && MAP[1][1] == symbol && MAP[2][1] == symbol) {
            return true;
        }
        if(MAP[0][2] == symbol && MAP[1][2] == symbol && MAP[2][2] == symbol) {
            return true;
        }
        if(MAP[0][0] == symbol && MAP[1][1] == symbol && MAP[2][2] == symbol) {
            return true;
        }
        if(MAP[2][0] == symbol && MAP[1][1] == symbol && MAP[0][2] == symbol) {
            return true;
        }
        return false;

    }
    private static boolean checrDreaw() {
        return turnsCount ==SIZE * SIZE;
    }

    private static void aiTurn() {
        System.out.print("\nХод компьютера");
        int romNumber;
        int colomnNumber;

        do {
            romNumber = random.nextInt(SIZE) ;
            colomnNumber =random.nextInt(SIZE) ;

        } while ( !isCellFree(romNumber,colomnNumber));


        MAP[romNumber][colomnNumber] = DON_AI;
        turnsCount++;

    }

    private static boolean isContinueGame() {
        System.out.println("\nХотите продолжить? y\\n") ;
        return switch (in.next()){
            case "y", "yes","+","да","конечно"  ->  true;
            default  -> false ;
        };

    }
    private static void endGeme() {
        System.out.println("\n возвращайся ");
    }

}







