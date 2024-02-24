import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
          } else {
            System.out.println("Объект не добавлен, попробуйте снова");
            break;
          }
        case 3:
          if (list.isEmpty()) {
            System.out.println("Нет объектов для изменения");
            break;
          }
          if (changeObject()) {
            System.out.println("Вы завершили изменение");
            break;
          } else {
            System.out.println("Неверный индекс");
          }
          break;
        case 4:
          if (list.isEmpty()) {
            System.out.println("Объекты не созданы");
            break;
          } else {
            printObject();
            break;
          }
        case 5:
          if (list.isEmpty()) {
            System.out.println("Объекты не созданы, алгоритм выполнить нельзя");
            break;
          }
          if (doAlgoritm()) {
            break;
          } else {
            System.out.println("Неверный индекс");
            break;
          }
        case 6:
          sortList();
          break;
        case 7:
          System.out.println("Программа завершена");
          System.exit(0);
          break;
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
    } else {
      return false;
    }
  }

  private static boolean objectCheck(Person person) { // проверка создания объекта
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
    for (Person i : list) {
      System.out.println("Индекс объекта: " + list.indexOf(i));
      System.out.println(i);
    }
  }

  private static boolean changeObject() {
    printObject();
    System.out.println("Введите индекс объекта для изменения полей: ");
    int index;
    if (input.hasNextInt()) {
      index = input.nextInt();
    } else {
      input.next();
      return false;
    }
    if (index < 0 || index >= list.size()) {
      return false;
    }
    Person person = list.get(index);
    while (true) {
      System.out.println("1. Изменить имя");
      System.out.println("2. Изменить гендер");
      System.out.println("3. Изменить возраст");
      System.out.println("4. Изменить рост");
      System.out.println("5. Изменить вес");
      System.out.println("6. Завершить изменение объекта");
      int choice = 0;
      if (input.hasNextInt()) {
        choice = input.nextInt();
      }
      switch (choice) {
        case 1:
          System.out.println("Введите имя:");
          String name = input.next();
          person.setName(name);
          break;
        case 2:
          System.out.println("Введите гендер:");
          String gender = input.next();
          person.setGender(gender);
          break;
        case 3:
          System.out.println("Введите возраст:");
          int age = 500;
          if (input.hasNextInt()) {
            age = input.nextInt();
          }
          person.setAge(age);
          break;
        case 4:
          System.out.println("Введите рост:");
          double height = 500.0;
          if (input.hasNextDouble()) {
            height = input.nextDouble();
          }
          person.setHeight(height);
          break;
        case 5:
          System.out.println("Введите вес:");
          double weight = 500.0;
          if (input.hasNextDouble()) {
            weight = input.nextDouble();
          }
          person.setWeight(weight);
          break;
        case 6:
          return true;
        default:
          System.out.println("Ошибка ввода");
      }
    }
  }

  private static boolean doAlgoritm() {
    printObject();
    System.out.println("Введите индекс объекта для выполнения алгоритма: ");
    int index;
    if (input.hasNextInt()) {
      index = input.nextInt();
    } else {
      input.next();
      return false;
    }
    if (index < 0 || index >= list.size()) {
      return false;
    }
    Person person = list.get(index);
    System.out.println("Телосложение исходя из индекса массы тела: " + person.indexMas());
    return true;
  }

  private static void sortList() {
    System.out.println("Выберите поле для сортировки:");
    System.out.println("1. Имя");
    System.out.println("2. Гендер");
    System.out.println("3. Возраст");
    System.out.println("4. Рост");
    System.out.println("5. Вес");
    int choice = 0;
    if (input.hasNextInt()) {
      choice = input.nextInt();
    }
    switch (choice) {
      case 1:
        Collections.sort(
            list,
            new Comparator<Person>() {
              @Override
              public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
              }
            });
        System.out.println("Список отсортирован");
        break;
      case 2:
        Collections.sort(
            list,
            new Comparator<Person>() {
              @Override
              public int compare(Person p1, Person p2) {
                return p1.getGender().compareTo(p2.getGender());
              }
            });
        System.out.println("Список отсортирован");
        break;
      case 3:
        Collections.sort(
            list,
            new Comparator<Person>() {
              @Override
              public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
              }
            });
        System.out.println("Список отсортирован");
        break;
      case 4:
        Collections.sort(
            list,
            new Comparator<Person>() {
              @Override
              public int compare(Person p1, Person p2) {
                return Double.compare(p1.getHeight(), p2.getHeight());
              }
            });
        System.out.println("Список отсортирован");
        break;
      case 5:
        Collections.sort(
            list,
            new Comparator<Person>() {
              @Override
              public int compare(Person p1, Person p2) {
                return Double.compare(p1.getWeight(), p2.getWeight());
              }
            });
        System.out.println("Список отсортирован");
        break;
      default:
        System.out.println("Ошибка ввода");
    }
  }
}
