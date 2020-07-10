import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class ReadingFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test1");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        String[] notepadText = line.split("\\,");
        scanner.close();

        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < notepadText.length; i++) {
            String s = notepadText[i];
            Integer integer = Integer.valueOf(s); //конвертировать string  в int
            number.add(integer); //добавление значений в динамический массив number
        }

        // System.out.print(number);

        Collections.sort(number);

        System.out.print(number);
        System.out.print("\n");

        Collections.reverse(number);
        System.out.print(number);

    }

}
