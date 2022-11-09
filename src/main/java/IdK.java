import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class IdK {

    public static String[] ads = new String[30];
    public static int position = 13;

    public  static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*System.out.println("Введите процент: ");
        String a = reader.readLine();
        int b = Integer.parseInt(a);
        while (b < 100) {
            for(int g = 0; g < 25; g++) {
                System.out.println(" ");
            }
            Random random = new Random();
            int what = random.nextInt(5) + 1;
            b += what;
            int what2 = random.nextInt(3) + 1;
            String c = "" + b;
            String[] am = c.split("");
            int ami = Integer.parseInt(am[0]);
            String load = "" + "/".repeat(Math.max(0, ami)) +
                    "-".repeat(Math.max(0, (10 - ami)));
            System.out.println(load + "   [" + c + "%]");
            TimeUnit.SECONDS.sleep(what2);*/
        for (int u = 0; u < 30; u++) {
            System.out.print("   Ввод: ");
            String where = reader.readLine();
            switch (where) {
                case "d":
                    display(0, 0, 0, 1);
                break;

                case "w":
                    display(1, 0, 0, 0);
                break;

                case "a":
                    display(0, 1, 0, 0);
                break;

                case "s":
                    display(0, 0, 1, 0);
            }

        }
    //}
    }

    public static void display(int w, int a, int s, int d) {
        for(int t = 0; t < 25; t++) {
            System.out.println(" ");
        }
        if (d == 1) {
            int new_position = position + 1;
            position++;
            for (int i = 0; i < 30; i++) {
                if (i == new_position) {
                    ads[i] = " #";
                } else {
                    ads[i] = " -";
                }
            }
            int show = 0;
            for (int i = 0; i < 30; i++) {
                if (show == 6) {
                    System.out.println("");
                    show = 0;
                }
                System.out.print(ads[i]);
                show++;
            }
        } else if(w == 1) {
            int new_position = position - 6;
            position -= 6;
            for (int i = 0; i < 30; i++) {
                if (i == new_position) {
                    ads[i] = " #";
                } else {
                    ads[i] = " -";
                }
            }
            int show = 0;
            for (int i = 0; i < 30; i++) {
                if (show == 6) {
                    System.out.println("");
                    show = 0;
                }
                System.out.print(ads[i]);
                show++;
            }
        } else if(a == 1){
            int new_position = position - 1;
            position--;
            for (int i = 0; i < 30; i++) {
                if (i == new_position) {
                    ads[i] = " #";
                } else {
                    ads[i] = " -";
                }
            }
            int show = 0;
            for (int i = 0; i < 30; i++) {
                if (show == 6) {
                    System.out.println("");
                    show = 0;
                }
                System.out.print(ads[i]);
                show++;
            }
        } else {
            int new_position = position + 6;
            position += 6;
            for (int i = 0; i < 30; i++) {
                if (i == new_position) {
                    ads[i] = " #";
                } else {
                    ads[i] = " -";
                }
            }
            int show = 0;
            for (int i = 0; i < 30; i++) {
                if (show == 6) {
                    System.out.println("");
                    show = 0;
                }
                System.out.print(ads[i]);
                show++;
            }
        }
    }
}
