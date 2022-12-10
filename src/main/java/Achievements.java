import java.io.*;

public class Achievements {

    public static String path = "E:\\projects\\Viselica\\src\\main\\java\\Achievements.txt";
    public static int floor50 = 0; // Подняться на 50 этаж
    public static int floor100 = 0; // Подняться на 100 этаж
    public static int kill25enemy = 0; // Убить 25 врагов

    public static int collect100gold = 0; // Собрать 100 золотых
    public static int collectFullTeam = 0; // Собрать команду из 3 персонажей

    public static void checkAchievements() {
        if(SimpleRPG.room_count >= 2) {
            if(floor50 != 1) {
                floor50 = 1;
                System.out.println(SimpleRPG.green + "[Достижение] Подняться на 50 этаж" + SimpleRPG.reset);
            }
        }
        if(SimpleRPG.enemy_deaths >= 25) {
            if(kill25enemy != 1) {
                kill25enemy = 1;
                System.out.println(SimpleRPG.green + "[Достижение] Убить 25 врагов" + SimpleRPG.reset);
            }
        }
        if(SimpleRPG.room_count >= 100) {
            if(floor100 != 1) {
                floor100 = 1;
                System.out.println(SimpleRPG.green + "[Достижение] Подняться на 100 этаж" + SimpleRPG.reset);
            }
        }
        if(SimpleRPG.gold >= 100) {
            if(collect100gold != 1) {
                collect100gold = 1;
                System.out.println(SimpleRPG.green + "[Достижение] Накопить 100 золотых" + SimpleRPG.reset);
            }
        }
        int a = 0;
        for(int i = 0; i < 3; i++) {
            if(!SimpleRPG.hero_name[i].equals("null")) {
                a++;
            }
        }
        if (a >= 3) {
            if (collectFullTeam != 1) {
                collectFullTeam = 1;
                System.out.println(SimpleRPG.green + "[Достижение] Собрать полную команду!" + SimpleRPG.reset);
            }
        }

        String diffS ="" + floor50 + floor100 + kill25enemy + collect100gold + collectFullTeam;

        try {
            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(diffS.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void achLoad() throws IOException {
        String inputFileName = path;
        BufferedReader settingsReader = new BufferedReader(new FileReader(inputFileName));
        String line;
        String ach = "";
        String[] split;
        while ((line = settingsReader.readLine()) != null) {
            ach = line;
            split = line.split("");
            floor50 = Integer.parseInt(split[0]);
            floor100 = Integer.parseInt(split[1]);
            kill25enemy = Integer.parseInt(split[2]);
            collect100gold = Integer.parseInt(split[3]);
            collectFullTeam = Integer.parseInt(split[4]);
        }
    }

    public static void list() {
        if(floor50 == 1) {
            System.out.println(SimpleRPG.green + "[+] Подняться на 50 этаж" + SimpleRPG.reset);
        } else {
            System.out.println(SimpleRPG.red + "[?] Подняться на 50 этаж" + SimpleRPG.reset);
        }
        if(floor100 == 1) {
            System.out.println(SimpleRPG.green + "[+] Подняться на 100 этаж" + SimpleRPG.reset);
        } else {
            System.out.println(SimpleRPG.red + "[?] Подняться на 100 этаж" + SimpleRPG.reset);
        }
        if(kill25enemy == 1) {
            System.out.println(SimpleRPG.green + "[+] Убить 25 врагов" + SimpleRPG.reset);
        } else {
            System.out.println(SimpleRPG.red + "[?] Убить 25 врагов" + SimpleRPG.reset);
        }
        if(collect100gold == 1) {
            System.out.println(SimpleRPG.green + "[+] Накопить 100 золотых" + SimpleRPG.reset);
        } else {
            System.out.println(SimpleRPG.red + "[?] Накопить 100 золотых" + SimpleRPG.reset);
        }
        if(collectFullTeam == 1) {
            System.out.println(SimpleRPG.green + "[+] Собрать полную команду!" + SimpleRPG.reset);
        } else {
            System.out.println(SimpleRPG.red + "[?] Собрать полную команду!" + SimpleRPG.reset);
        }
    }
}
