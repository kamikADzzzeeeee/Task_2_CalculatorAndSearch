package yamshikov.sample;

import yamshikov.sample.calculator.Calculator;
import yamshikov.sample.search.Search;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задачи (1 - калькулятор, 2 - массив строк)");
        int numberTask = checkNumberTask(scanner);
        if (numberTask==1) {
            System.out.println("----------\nКАЛЬКУЛЯТОР");
            startCalculator(scanner);
        } else if (numberTask == 2) {
            System.out.println("----------\nПОИСК САМОГО ДЛИННОГО СЛОВА");
            startSearchingWord(scanner);
        }


    }

    public static void startCalculator(Scanner scanner) {
        Calculator calculator = new Calculator(scanner);
        System.out.println("Введите первое число:");
        double n1 = calculator.getNumber();
        System.out.println("Введите второе число:");
        double n2 = calculator.getNumber();
        System.out.println("Введите операцию для калькулятора (+, -, /, *):");
        String op = calculator.getOperation();
        double answer = calculator.calculateAnswer(n1, n2, op);
        System.out.printf("Ответ:\n%.2f%s%.2f=%.4f", n1, op, n2, answer);
    }

    public static void startSearchingWord(Scanner scanner) {
        Search search = new Search(scanner);
        System.out.println("Введите размерность массива:");
        int size = search.getArraySize();
        System.out.println("Введите слова в массив:");
        String[] array = search.setArrayWord(size);
        String word = search.searchMaxLenWord(array, size);
        System.out.println("Самое длинное слово:");
        System.out.println(word + "[" + word.length() + "]");
    }

    private static int checkNumberTask(Scanner scanner) {
        boolean cylcle = true;
        int numberTask = 0;
        while (cylcle) {
            cylcle = false;
            try {
                numberTask = scanner.nextInt();
                if (!((numberTask == 1)||(numberTask == 2))){
                    System.out.println("Задач с таким номером нет");
                    System.out.println("Введите номер задачи еще раз:");
                    cylcle = true;
                }
            } catch (InputMismatchException exception) {
                cylcle = true;
                scanner.next();
                System.out.println("Неверный формат номер для задачи");
                System.out.println("Введите номер задачи еще раз:");
            }
        }
        return numberTask;
    }

}
