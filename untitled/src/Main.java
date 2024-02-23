import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<Person> list = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Создать пустой объект");
            System.out.println("2. Создать объект используя ручной ввод");
            System.out.println("3. Редактировать объект по индексу");
            System.out.println("4. Вывод в консоль информации о всех объектах");
            System.out.println("5. Выполнение алгоритма и вывод результата");
            System.out.println("6. Сортировка объектов по выбранному полю");
            System.out.println("7. Завершение работы программы");

            int choice = 0;
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                input.next();
            }
            switch (choice) {
                case 1:
                    Person human = new Person();
                    list.add(human);
                    System.out.println("Пустой объект добавлен");
                    break;
                case 2:
                    if (createObject()) {
                        System.out.println("Объект добавлен");
                        break;
                    }
                    else {
                        System.out.println("Объект не добавлен, попробуйте снова");
                    }
                case 3:
                case 4:
                    printObject();
                    break;
                case 5:
                case 6:
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }

    private static boolean createObject() {
        System.out.println("Введите имя: ");
        String name = input.next();
        System.out.println("Выберите пол (мужской / женский)");
        String gender = input.next();

        int age = 500;
        double height = 500.0;
        double weight = 500.0;

        System.out.println("Введите возраст:");
        if (input.hasNextInt()) {
            age = input.nextInt();
        }
        System.out.println("Введите рост в сантиметрах:");
        if (input.hasNextDouble()) {
            height = input.nextDouble();
        }
        System.out.println("Введите вес в килограммах:");
        if (input.hasNextDouble()) {
            weight = input.nextDouble();
        }
        Person person = new Person(name, gender, age, height, weight);
        if (objectCheck(person)) {
            list.add(person);
            return true;
        }
        else {
            return false;
        }


    }
    private static boolean objectCheck(Person person) {
        int flag = 0;
        if (person.getGender() == null) {
            flag++;
        }
        if (person.getAge() == 500 || person.getAge() == -1) {
            flag++;
        }
        if (person.getHeight() == 0.0 || person.getHeight() == 500.0) {
            flag++;
        }
        if (person.getWeight() == 0.0 || person.getWeight() == 500.0) {
            flag++;
        }
        return flag == 0;
    }
    private static void printObject() {
        for (Person i: list) {
            System.out.println(i);
        }
    }
}