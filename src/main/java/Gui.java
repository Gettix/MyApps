import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Gui {
    public static void chest() throws InterruptedException, IOException {
        System.out.println("           █▀▀▀▀█▄▄▄▄▄▄▄▄▄▄▄█▀▀▀▀█▄▄▄▄▄▄▄▄▄▄▄█▀▀▀▀█");
        System.out.println("           █░░░░█████████████░░░░█████████████░░░░█");
        System.out.println("           █▄▄▄▄█████████████▄▄▄▄█████████████▄▄▄▄█");
        System.out.println("           █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.println("           █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.println("           █▀▀▀▀▀▀▀▀▀▀▀▀▀▀█▀▀▀▀▀▀▀▀█▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
        System.out.println("           █░░░░░░░░░░░░░░█░░░██░░░█░░░░░░░░░░░░░░█");
        System.out.println("           █▄▄▄▄▄▄▄▄▄▄▄▄▄▄█░░░▀▀░░░█▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("           █░░░░████████████▄▄▄▄▄▄████████████░░░░█");
        System.out.println("           █░░░░█████████████▀▀▀▀█████████████░░░░█");
        System.out.println("           █░░░░█████████████░░░░█████████████░░░░█");
        System.out.println("           █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("                   Нажми, чтобы открыть...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        System.out.println("Открываем...");
        SimpleRPG.updateScreen();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("           █▀▀▀▀█▄▄▄▄▄▄▄▄▄▄▄█▀▀▀▀█▄▄▄▄▄▄▄▄▄▄▄█▀▀▀▀█");
        System.out.println("           █░░░░█████████████░░░░█████████████░░░░█");
        System.out.println("           █▄▄▄▄█████████████▄▄▄▄█████████████▄▄▄▄█");
        System.out.println("           █                                      █");
        System.out.println("           █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.println("           █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.println("           █ ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ █");
        System.out.println("           █▄▄▄▄▄▄▄▄▄▄▄▄▄▄█░░░▀▀░░░█▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("           █░░░░████████████▄▄▄▄▄▄████████████░░░░█");
        System.out.println("           █░░░░█████████████▀▀▀▀█████████████░░░░█");
        System.out.println("           █░░░░█████████████░░░░█████████████░░░░█");
        System.out.println("           █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
    }
}
