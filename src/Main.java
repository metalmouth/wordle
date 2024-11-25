import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Model m1 = new Model("words.txt");
        View v1 = new View();
        Controller c1 = new Controller(m1,v1);
        c1.openWindow();

    }
}




