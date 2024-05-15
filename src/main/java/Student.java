public class Student {
  private String Name;
  private int Age;
  private String Surname;

  public Student(String name, String surname, int age) {
    Name = name;
    Surname = surname;
    Age = age;
  }

  public String ToString() {
    return Name + " " + Surname + " " + Age;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 3) {
      return new Student("Parse Error", "Parse Error", -1);
    }
    return new Student(data[0], data[1], Integer.parseInt(data[2]));
  }
}