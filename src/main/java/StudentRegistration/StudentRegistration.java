package StudentRegistration;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.*;
public class StudentRegistration {
    String name, surname, email, pkods, date;
    String Nameregex = "^[A-Za-z]{3,}$";
    String Emailregex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    String PKods = "^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[0-2])\\d{2}-\\d{5}$";
    public void RegistringExceptions(String value, String type){
        switch(type) {
            case "name":
                if(!value.matches(Nameregex)){
                    throw new IllegalArgumentException("Nepareizi ievadits vards!");
                }
                break;
            case "surname":
                if(!value.matches(Nameregex)){
                    throw new IllegalArgumentException("Nepareizi ievadits uzvards!");
                }
                break;
            case "email":
                if(!value.matches(Emailregex)){
                    throw new IllegalArgumentException("Nepareizi ievadits E-pasts!");
                }
                break;
            case "pkods":
                if(!value.matches(PKods)){
                    throw new IllegalArgumentException("Nepareizi ievadits personas kods!");
                }
                break;
        }
    }
    public void Register() {
        Scanner reader = new Scanner(System.in);
         while(true) {
            System.out.println("Ievadiet studenta vardu: ");
            String name = reader.nextLine();
            try {
                this.RegistringExceptions(name, "name");
                this.name = name;
                System.out.println("Vards ir derigs.");
                break;
            } catch (IllegalArgumentException e ) {
                System.out.println(e.getMessage());
            }
        }
        while(true) {
            System.out.println("Ievadiet studenta uzvardu: ");
            String surname = reader.nextLine();
            try {
                this.RegistringExceptions(surname, "surname");
                this.surname = surname;
                System.out.println("Uzvards ir derigs.");
                break;
            } catch (IllegalArgumentException e ) {
                System.out.println(e.getMessage());
            }
        }
        while(true) {
            System.out.println("Ievadiet savu e-pastu: ");
            String email = reader.nextLine();
            try {
                this.RegistringExceptions(email, "email");
                this.email = email;
                System.out.println("E-pasts ir derigs.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while(true) {
            System.out.println("Ievadiet savu personas kodu: ");
            String pkods = reader.nextLine(); 
            try {
                this.RegistringExceptions(pkods, "pkods");
                this.pkods = pkods;
                System.out.println("Personas kods ir ievadits.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Date datums = new Date();
        this. date = datums.toString();
        inputdata.addtocsv(name, surname, email, pkods, date);
    }
    public void Show() {
        String path = "data/data.csv";

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            List<String[]> data = new ArrayList<>();
            String line;
            while((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
            TablePrinter.printTable(data);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    
    }
    public void remove () {
        Scanner input = new Scanner(System.in);
        System.out.println("Ievadiet lietotaja personas kodu:");
        String answer = input.nextLine();
        if(!answer.matches(PKods)) {
            answer = input.nextLine();
            System.out.println("Nepareizi ievadits personas kods!");
            return;
        }
        inputdata.DeleteByPKods(answer);

        
    }
    public void edit () {
        Scanner input = new Scanner(System.in);
        System.out.println("Ievadiet lietotaja personas kodu:");
        String answer = input.nextLine();
        if(!answer.matches(PKods)) {
            System.out.println("Nepareizi ievadits personas kods!");
            return;
        }
        String newName;
        while(true) {
        System.out.println("Ievadiet jauno vardu:");
        newName = input.nextLine();

        try{
            RegistringExceptions(newName, "name");
            this.name = newName;
            System.out.println("vards ir derigs");
            break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String newSurname;
        while(true) {
        System.out.println("Ievadiet jauno uzvardu:");
        newSurname = input.nextLine();

        try{
            RegistringExceptions(newSurname, "surname");
            this.surname = newSurname;
            System.out.println("uzvards ir derigs");
            break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String newEmail;
        while(true) {
        System.out.println("Ievadiet jauno E-pastu:");
        newEmail = input.nextLine();

        try{
            RegistringExceptions(newEmail, "email");
            this.email = newEmail;
            System.out.println("E-pasts ir derigs");
            break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        inputdata.EditByPkods(answer, newName, newSurname, newEmail);    
    }
        
     public static void main(String[] args) {
        StudentRegistration registration = new StudentRegistration();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== STUDENTU SISTEMA ===");
            System.out.println("1 - Reģistret jaunu studentu");
            System.out.println("2 - Paradit visus studentus");
            System.out.println("3 - Dzest studentu pec personas koda");
            System.out.println("4 - Mainīt studenta datus pec personas koda");
            System.out.println("5 - Iziet");
            System.out.print("Izvelieties opciju: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registration.Register();
                    break;
                case "2":
                    registration.Show();
                    break;
                case "3":
                    registration.remove();
                    break;
                case "4":
                    registration.edit();
                    break;
                case "5":
                    System.out.println("Sistema tiek aizverta");
                    System.exit(0);
                default:
                    System.out.println("Nederīga izvēle. Mēģiniet vēlreiz.");
            }
        }   
    } 
    FileHandler inputdata = new FileHandler();
}

