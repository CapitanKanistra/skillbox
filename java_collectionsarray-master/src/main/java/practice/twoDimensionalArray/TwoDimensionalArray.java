package practice.twoDimensionalArray;

public class TwoDimensionalArray {


    public static final char SYMBOL = 'X';


    public static char[][] getTwoDimensionalArray(int size) {


        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        char[][] symbol = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                symbol[i][j] = (i == j) || (i + j == size - 1) ? SYMBOL : ' ';
            }
            System.out.println(symbol[i]);
        }

        return symbol;
    }
}

