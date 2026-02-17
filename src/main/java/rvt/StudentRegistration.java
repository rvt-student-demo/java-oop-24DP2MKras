package rvt;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class StudentRegistration {
    String name;
    String surname;
    String email;
    String pkods;
    String date;
    String Nameregex = "^[A-Za-z]{3,}$";
    String Emailregex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    String PKods = "^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[0-2])\\d{2}-\\d{5}$";
    public void NameRegistration(String name){
        if(!name.matches(Nameregex)) {
            throw new IllegalArgumentException("Varda jabut vismaz 3 simboli un var saturet tikai burtus.");
        }
    }
    public void SurnameRegistration(String surname){
        if(!surname.matches(Nameregex)) {
            throw new IllegalArgumentException("Uzvarda jabut vismaz 3 simboli un var saturet tikai burtus.");
        }
    }
    public void EmailRegistration(String email){
        if(!email.matches(Emailregex)) {
            throw new IllegalArgumentException("Nepareizs e-pasta formats. Ludzu ievadiet e-pastu sada formata: example@domain.com.");
        }
    }
    public void PKodsRegistration(String pkods) {
        if(!pkods.matches(PKods)) {
            throw new IllegalArgumentException("Nepareizs personas kods. Sads personas kods neeksiste!");
        }
    }
    public static void main(String[] args) {
        StudentRegistration registration = new StudentRegistration();
        Scanner reader = new Scanner(System.in);
        Date datums = new Date();
        while(true) {
            System.out.println("Ievadiet studenta vardu: ");
            String name = reader.nextLine();
            try {
                registration.NameRegistration(name);
                registration.name = name;
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
                registration.SurnameRegistration(surname);
                registration.surname = surname;
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
                registration.EmailRegistration(email);
                registration.email = email;
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
                registration.PKodsRegistration(pkods);
                registration.pkods = pkods;
                System.out.println("Personas kods ir ievadits.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(datums);
        registration.date = datums.toString();
        registration.inputdata.addtocsv(
            registration.name,
            registration.surname,
            registration.email,
            registration.pkods,
            registration.date
        );   
    }
    csvFileWriter inputdata = new csvFileWriter();

    class csvFileWriter{
        public void addtocsv(String name, String surname, String email, String pkods, String date) {

            String csvLine = name + ", " + surname + ", " + email + ", " + pkods + ", "+ date + "\n";
            Path path = Paths.get("java-oop-24DP2MKras", "data", "data.csv");
            try {
    Files.createDirectories(path.getParent()); // ALWAYS create folder first
    Files.writeString(
        path,
        csvLine,
        StandardOpenOption.CREATE,
        StandardOpenOption.APPEND
    );
    System.out.println("Studentu dati veiksmigi saglabati CSV faila!");
    System.out.println("Saved to: " + path.toAbsolutePath());
} catch (IOException e) {
    e.printStackTrace(); // show real error
}
    }}}
    
