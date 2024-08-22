package yamshikov.sample.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private Scanner scanner = null;

    public Calculator (Scanner scanner) {
        this.scanner = scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Метод для получения результата из двух цифр и операции между ними
     * @param n1 первая цифра в формате double
     * @param n2 втораая цифра в формате double
     * @param operation операция в строковом виде
     * @return - число в формате double
     */
    private double getAnswer(double n1, double n2, String operation) {
        double result = 0;
        switch (operation) {
            case ("+"):
                result = n1+n2;
                break;
            case ("-"):
                result = n1-n2;
                break;
            case ("/"):
                try {
                    result = n1 / n2;
                }catch (ArithmeticException exception) {
                    System.out.println("Ошибка при вычислении!");
                }
                break;
            case ("*"):
                result = n1*n2;
                break;
        }
        return result;
    }

    /**
     * Метод для определения и проверки введенного числа в консоль
     * @return - число в формате double
     */
    private double checkNumber() {
        boolean cycle = true;
        double number = 0;
        while (cycle) {
            cycle = false;
            try {
                number = scanner.nextDouble();
            } catch (InputMismatchException exception) {
                cycle = true;
                scanner.next();
                System.out.println("Вы ввели неверный формат числа");
                System.out.println("Введите число еще раз");
            } catch (Exception exception) {
                System.out.println("Неизвестное исключение:");
                System.out.println(exception.getMessage());
            }
        }
        return number;
    }

    /**
     * Метод для определения и проверки введенной операции в консоль
     * @return - число в формате double
     */
    private String checkOperation() {
        boolean cycle = true;
        String operation = "";
        String allOperation = "+ - * /";
        while (cycle) {
            operation = scanner.next();
            for (String op : allOperation.split(" ")) {
                if (op.equals(operation)) {
                    cycle = false;
                    break;
                }
            }

            if (cycle) {
                System.out.println("Вы ввели неверную операцию...");
                System.out.println("Введите операцию еще раз (+, -, /, *):");
            }

        }
        return operation;
    }

    public double getNumber(){
        return checkNumber();
    }

    public String getOperation(){
        return checkOperation();
    }

    public double calculateAnswer(double n1, double n2, String op){
        return getAnswer(n1, n2, op);
    }



}
