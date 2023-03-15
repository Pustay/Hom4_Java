/*  Реализуйте очередь с помощью LinkedList со следующими методами:
    enqueue() - помещает элемент в конец очереди,
    dequeue() - возвращает первый элемент из очереди и удаляет его,
    first() - возвращает первый элемент из очереди, не удаляя.
*/
import java.util.LinkedList;
import java.util.Scanner;

public class task2 {
    public static LinkedList<Integer> enqueue(LinkedList<Integer> list_number) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Введите число, которое будет помещено в конец очереди: ");
        Integer number = input.nextInt();
        list_number.add(number);
        System.out.printf("Теперь очередь выглядит так:\n");
        System.out.println(list_number);
        return list_number;
    }

    public static LinkedList<Integer> dequeue(LinkedList<Integer> list_number) {
        System.out.println(list_number.get(0));
        list_number.remove(list_number.get(0));
        System.out.printf("Теперь очередь выглядит так:\n");
        System.out.println(list_number);
        return list_number;
    }

    public static LinkedList<Integer> first(LinkedList<Integer> list_number) {
        System.out.println(list_number.get(0));
        System.out.printf("Теперь очередь выглядит так:\n");
        System.out.println(list_number);
        return list_number;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list_number = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.printf(
                    "1. enqueue - помещает элемент в конец очереди,\n2. dequeue - возвращает первый элемент из очереди и удаляет его,\n3. first - возвращает первый элемент из очереди, не удаляя.\n4. - выход из программы.\nВведите номер необходимого метода: ");
            String choice = input.next();
            if (choice.equals("1")) {
                enqueue(list_number);
            }
            if (choice.equals("2")) {
                dequeue(list_number);
            }
            if (choice.equals("3")) {
                first(list_number);
            }
            if (choice.equals("4")) {
                break;
            }
        }
        input.close();
        System.out.printf("Конец");
    }
}