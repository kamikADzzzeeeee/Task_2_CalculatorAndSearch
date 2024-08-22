package yamshikov.sample.search;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Search {

    Scanner scanner = null;

    public Search(Scanner scanner) {
        this.scanner = scanner;
    }


    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    private int arraySize() {
        boolean cylcle = true;
        int arraySize = 0;
        while (cylcle) {
            cylcle = false;
            try {
                arraySize = scanner.nextInt();
            } catch (InputMismatchException exception) {
                cylcle = true;
                scanner.next();
                System.out.println("Неверный формат размерности для массива");
                System.out.println("Введите размерность массива еще раз");
            }
        }
        return arraySize;
    }

    public int getArraySize() {
        return arraySize();
    }

    private String[] readArrayWord(int arraySize) {
        String[] array = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Введите " + (i + 1) + " слово:");
            array[i] = scanner.next();
        }
        return array;
    }

    public String[] setArrayWord(int arraySize) {
        return readArrayWord(arraySize);
    }

    private String maxLenWord(String[] array, int arraySize) {
        int maxLength = array[0].length();
        int maxI = 0;
        for (int i = 1; i < arraySize; i++) {
            if (maxLength < array[i].length()) {
                maxLength = array[i].length();
                maxI = i;
            }
        }
        return array[maxI];
    }

    public String searchMaxLenWord(String[] array, int arraySize) {
        return maxLenWord(array, arraySize);
    }


}
