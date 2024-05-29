import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class WrongAge extends Exception {
    public WrongAge(String message) {
      super(message);
    }
  }

class Main {
  public static void main(String[] args) {
    try {
      Service service = new Service();
      Scanner scanner = new Scanner(System.in);
      while (true) {
        System.out.println("Wybierz opcję:");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wyświetl wszystkich studentów z pliku");
        System.out.println("3. Wyjście");

        String opcja = scanner.nextLine();
        switch (opcja) {
          case "1":
            System.out.println("Podaj imie studenta:");
            String imie = scanner.nextLine();
            System.out.println("Podaj nazwisko studenta:");
            String nazwisko = scanner.nextLine();
            System.out.println("Podaj wiek studenta:");
            int wiek = scanner.nextInt();
            scanner.nextLine();
            if (wiek <= 0) {
              try {
                throw new WrongAge("Niepoprawny wiek:");
              } catch (WrongAge e) {
                System.out.println("Błąd: " + e.getMessage());
              }
            } else {
              System.out.println("Podaj date urodzenia studenta:");
              String data = scanner.nextLine();
              service.addStudent(new Student(imie, nazwisko, wiek, data));
            }
            break;
          case "2":
            var students = service.getStudents();
            for (Student student : students) {
              System.out.println(student.ToString());
            }
            break;
          case "3":
            System.out.println("Wyjście z programu.");
            return;
          default:
            System.out.println("Niepoprawna opcja. Wybierz ponownie.");
        }
      }
    } catch (IOException e) {
    }
  }
}