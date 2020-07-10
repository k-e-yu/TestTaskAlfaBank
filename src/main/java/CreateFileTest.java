import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class CreateFileTest {

    public static void creatFileTest(String fileName, String text) throws IOException {
        File file1 = new File(fileName);

        try {
            // если файл не существует, то создаем его
            if (!file1.exists()) {
                file1.createNewFile();
            }
        } catch (IOException ex) {
        }
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(text);
            fileWriter.flush();
        }

        FileReader fileReader1 = new FileReader(fileName);

        Scanner scan = new Scanner(fileReader1);

        int i = 1;

        while (scan.hasNextLine()) {
            System.out.println(i + " : " + scan.nextLine());
            i++;
        }

        fileReader1.close();


    }
}