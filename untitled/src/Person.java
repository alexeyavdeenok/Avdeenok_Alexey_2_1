public class Person {
    private String name;
    private String gender;
    private int age;
    private double height;
    private double weight;

    public Person() {
        setName("None");
        setGender("None");
        setAge(0);
        setHeight(0);
        setWeight(0);
    }
    public Person(String name, String gender, int age, double height, double weight) {
        setName(name);
        setGender(gender);
        setAge(age);
        setHeight(height);
        setWeight(weight);
    }
    @Override
    public String toString() {
        return "\nИмя: " + this.name +
                "\nПол: " + this.gender +
                "\nВозраст: " + this.age +
                "\nРост: " + this.height +
                "\nВес: " + this.weight;
    }
    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Имя не введено");
        }
        else {
            this.name = name;
        }
    }
    public String getName() {
        return this.name;
    }
    public void setGender(String gender) {
        String gendercheck = gender.toLowerCase();
        switch (gendercheck) {
            case "мужской":
                this.gender = gender;
                break;
            case "женский":
                this.gender = gender;
                break;
            case "none":
                this.gender = gender;
                break;
            default:
                System.out.println("Введен недопустимый пол");
            }

    }
    public String getGender() {
        return this.gender;
    }
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
        else {
            this.age = -1;
            System.out.println("Введен недопустимый возраст");
        }
    }
    public int getAge() {
        return this.age;
    }
    public void setHeight(double height) {
        if (height >= 36 && height <= 251 || height == 0) {
            this.height = height / 100;
        }
        else {
            System.out.println("Ввведен недопустимый возраст");
        }
    }
    public double getHeight() {
        return this.height * 100;
    }
    public void setWeight(double weight) {
        if (weight >= 3.0 && weight <= 300 || weight == 0) {
            this.weight = weight;
        }
        else {
            System.out.println("Введен недопустимый вес");
        }
    }
    public double getWeight() {
        return this.weight;
    }
    public String indexMas() {
        if (this.height == 0) {
            return "Индекс массы тела вычислить нельзя";
        }
        double masIndex = this.weight / (this.height * this.height);
        if (masIndex < 16.5) {
            return "Большой недовес";
        }
        else if (masIndex >= 16.5 && masIndex < 18.5) {
            return "Недовес";
        }
        else if (masIndex >= 18.5 && masIndex < 25.0) {
            return "Нормальный вес";
        }
        else if (masIndex >= 25.0 && masIndex < 30.0) {
            return "Избыточный вес";
        }
        else if (masIndex >= 30 && masIndex < 35) {
            return "Ожирение";
        }
        else if (masIndex >= 35 && masIndex < 40) {
            return "Сильное ожирение";
        }
        else {
            return "Супер ожирение";
        }
    }
}

