// В калькулятор добавьте возможность отменить последнюю операцию.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class task3 {
    public static void fileWriter(String inputString) {
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/task3.txt");
            FileWriter x = new FileWriter(pathFile, true);
            x.append(inputString + "\n");
            x.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Stack<Double> calculator(Stack<Double> stack, Double number1, Double number2, String sign) {
        String result = new String();
        switch (sign) {
            case "+":
                result = String.format("%f %s %f = %f", number1, sign, number2, number1 + number2);
                stack.push(number1 + number2);
                break;
            case "-":
                result = String.format("%f %s %f = %f", number1, sign, number2, number1 - number2);
                stack.push(number1 - number2);
                break;
            case "*":
                result = String.format("%f %s %f = %f", number1, sign, number2, number1 * number2);
                stack.push(number1 * number2);
                break;
            case "/":
                if (number2 != 0) {
                    stack.push(number1 / number2);
                    result = String.format("%f %s %f = %f", number1, sign, number2, number1 / number2);
                    break;
                } else
                    result = String.format("%f %s %f = Деление на ноль невозможно! Операция не выполнена!", number1, sign, number2);
                stack.push(number1);
                break;
        }
        System.out.println(result);
        fileWriter(result);
        return stack;
    }

    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>();
        String choice = "";
        Scanner input = new Scanner(System.in);
        System.out.printf("Введите первое число: ");
        Double number1 = input.nextDouble();
        stack.push(number1);
        while (true) {
            System.out.printf("Введите знак действия: ");
            String sign = input.next();
            System.out.printf("Введите второе число: ");
            Double number2 = input.nextDouble();

            calculator(stack, number1, number2, sign);

            System.out.println("\nЕсли хотите отменить последнюю операцию, введите '<'\nЕсли хотите продолжить считать с полученного значения, введите '>'\nЕсли хотите продолжить считать новый пример, введите '+'\nВведите '-' для выхода");
            choice = input.next();
            if (choice.equals("<")) {
                stack.pop();
                number1 = stack.peek();
                System.out.println("\nПервое число: " + stack.peek());
            }
            if (choice.equals(">")) {
                number1 = stack.peek();
                System.out.println("\nПервое число: " + stack.peek());
            }
            if (choice.equals("+")) {
                System.out.printf("\nВведите первое число: ");
                number1 = input.nextDouble();
                stack.push(number1);
                continue;
            }
            if (choice.equals("-")) {
                System.out.printf("\nКонец ");
                break;
            }
        }
        input.close();
    }
}