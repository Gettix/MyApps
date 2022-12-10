import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookOfMagic {



    public static void pages() throws IOException, InterruptedException {
        System.out.println(SimpleRPG.green + "1. Облако яда [3 lvl]" + SimpleRPG.reset);
        System.out.println("Отравляет всех врагов на 3 хода. Урон зависит от уровня и мастерства заклинателя.");

        System.out.println(SimpleRPG.green + "2. Призыв зомби [3 lvl]" + SimpleRPG.reset);
        System.out.println("Призывает зомби. Зомби может атаковать, носить оружие Рыцаря, броню. Улучшается на 5 уровне: Вместо зомби призывает зомби с токсинами.");

        System.out.println(SimpleRPG.green + "3. Паралич [1 lvl]" + SimpleRPG.reset);
        System.out.println("Блокирует противнику возможность атаковать в этот ход.");

        System.out.println(SimpleRPG.green + "4. Призыв паука [2 lvl]" + SimpleRPG.reset);
        System.out.println("Призывает паука. Паук может атаковать, носить броню.");

        System.out.println(SimpleRPG.green + "5. Вызов бомбы [1 lvl]" + SimpleRPG.reset);
        System.out.println("Заклинатель кидает бомбу. Бомба взрывается через [6 - уровень заклинателя] ходов.");
        System.out.println("");

        System.out.println("Нажмите [Enter], чтобы вернуться...");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        // SimpleRPG.selectMenu();
    }
}
