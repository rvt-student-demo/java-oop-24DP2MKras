package StudentRegistration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class FileHandler {
        public void addtocsv(String name, String surname, String email, String pkods, String date) {
            String csvLine = name + "," + surname + "," + email + "," + pkods + ","+ date + "\n";
            Path path = Paths.get("data", "data.csv");
            try {
    Files.createDirectories(path.getParent());
    Files.writeString(
        path,
        csvLine,
        StandardOpenOption.CREATE,
        StandardOpenOption.APPEND
    );
    System.out.println("Studentu dati veiksmigi saglabati CSV faila!");
    System.out.println("Saved to: " + path.toAbsolutePath());
} catch (IOException e) {
    e.printStackTrace();
} }
public void DeleteByPKods(String answer) {
    Path path = Paths.get("data", "data.csv");

    try {
        List<String> lines = Files.readAllLines(path);
        Iterator<String> iterator = lines.iterator();
        boolean found = false;

        while(iterator.hasNext()) {
            String line = iterator.next();
            String[] parts = line.split(",");

            if(parts.length > 3 && parts[3].trim().equals(answer.trim())) {
                iterator.remove();
                found = true;
            }
        }
    if(found) {
    Files.write(path, (String.join("\n", lines) + "\n").getBytes());
        System.out.println("Lietotajs veiksmigi izdzests!");
    } else {
        System.out.println("Lietotajs ar so personas kodu netika atrasts!");
    }
    } catch(IOException e) {
        System.out.println("Kluda dzesot lietotaju!");
        e.printStackTrace();
    }

}
public void EditByPkods(String pkods, String newName, String newSurname, String newEmail) {
    Path path = Paths.get("data", "data.csv");

    try {
        List<String> lines = Files.readAllLines(path);

        boolean found = false;

        for(int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");

            
            if(parts.length > 3 && parts[3].trim().equals(pkods.trim())) {
                found = true;

                String oldDate = parts[4].trim();

                String updatedLine = newName + "," + newSurname + "," + newEmail + "," + pkods + "," + oldDate;
                
                lines.set(i, updatedLine);
                break;
            }
        }
        if(found) {
            Files.write(path, lines);
            System.out.println("Lietotajs veiksmigi saglabats");
        } else {
            System.out.println("Lietotajs netika atrasts");
        }
    } catch(IOException e) {

    }
}

}