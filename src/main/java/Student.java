public class Student {
  private String Name;
  private String Surname;
  private int Age;
  private String BirthDate;
  
  public Student(String name, String surname, int age, String birthDate) {
    Name = name;
    Surname = surname;
    Age = age;
    BirthDate = birthDate;
  }

  
  public String ToString() {
    return Name + " " + Surname + " " + Age + " " + BirthDate;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 4) {
return new Student("Parse Error", "Parse Error", -1, "Parse Error");
    }
return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
  }
}