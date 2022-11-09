import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class WeekManager {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = 1;
        System.out.println("Добрый день!");
        System.out.println("Введите количество занятий: ");
        int todo = Integer.parseInt(reader.readLine());
        String[] todos = new String[todo];

        for(int i = 0; i < todo; i++) {
            System.out.println("\n" + "Введите занятие: ");
            String affairs = reader.readLine();
            todos[i] = affairs;
        }
        System.out.println("\n" + "Введите количество дней: ");
        int days = Integer.parseInt(reader.readLine());
        System.out.println("\n" + "Введите максимальное количество занятий в день: ");
        int MaxAffairs = Integer.parseInt(reader.readLine());
        Random random = new Random();


        int eventsOn = 0;
        System.out.println("\n" + "Включить челленджи? (y/n)");
        String answer = reader.readLine();
        String[] challenges = new String[3];
        if(answer.equals("y")) {
            eventsOn = 1;
            for(int g = 0; g < 3; g++) {
                System.out.println("\n" + "Введите челлендж: ");
                String challenge = reader.readLine();
                challenges[g] = challenge;
            }
        }


        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        for(int b = 0; b < days; b++) {
            if(eventsOn == 1) {
                int challengeTrue = random.nextInt(5);
                if (challengeTrue == 1) {
                    int whatChallengeIs = random.nextInt(3);
                    System.out.println("\n" + "День " + a + ":" + "     " + "Челлендж: " + challenges[whatChallengeIs]);
                } else {
                    System.out.println("\n" + "День " + a + ":");
                }
            } else {
                System.out.println("\n" + "День " + a + ":");
            }
            int AffairsInDay = random.nextInt(MaxAffairs) + 1;
            for(int c = 0; c < AffairsInDay; c++) {
                int td = random.nextInt(todo);
                String t = todos[td];
                System.out.println(t);
            }
            a++;
        }
    }
}
