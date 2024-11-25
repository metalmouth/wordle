import java.io.*;
import java.util.ArrayList;

public class Model {
    private final String fileName;
    ArrayList<String> lines = new ArrayList<>();

    public Model(String fileName) {
        this.fileName = fileName;
        readLines();
    }

    public void readLines() {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> handleLines() {
        return lines;
    }

}