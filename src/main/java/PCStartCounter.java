import java.io.*;
import java.util.Date;

public class PCStartCounter {

    public static void main(String[] args) throws IOException {
        Date date = new Date();
        String inputFileName = "C:\\Users\\Александр\\PCStartCount.txt";
        BufferedReader settingsReader = new BufferedReader(new FileReader(inputFileName));
        String line;
        int count = 0;
        String[] split;
        while ((line = settingsReader.readLine()) != null) {
            split = line.split(" ");
            count = Integer.parseInt(split[0]);
        }


        String diffS = "" + (count + 1) + " | Дата запуска: " + date + " | Пользователь: " + System.getenv("USERNAME");

        try {
            File file = new File("C:\\Users\\Александр\\PCStartCount.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(diffS.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
