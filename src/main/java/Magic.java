import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Magic {
    // Переменные
    public static int bomb = 0;
    public static int bombSummoner = 0;

    // Уровень, требуемый у персонажа для использования заклинания
    public static int summonSpider_lvl = 2;
    public static int explosionBomb_lvl = 1;

    public static void magics(int thisHero) throws IOException, InterruptedException {
        SimpleRPG.updateScreen();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Показать заклинания, подходящие по уровню

        if(summonSpider_lvl == SimpleRPG.hero_lvl[thisHero]) {
            System.out.println("[f] Призвать паука - " + SimpleRPG.cost(thisHero, 20) + " маны");

        }
        if(explosionBomb_lvl == SimpleRPG.hero_lvl[thisHero]) {
            System.out.println("[g] Бросить магическую бомбу - " + SimpleRPG.cost(thisHero, 15) + " маны");

        }

        System.out.println("[b] Вернуться");

        SimpleRPG.enter();

        // Проверка и ввод выбора
        String answer = reader.readLine();

        if(answer.equals("f")) {
            summonSpider(thisHero);
        } else if (answer.equals("b")) {
            SimpleRPG.heroSelectMenu(thisHero);
        } else if(answer.equals("g")) {
            explosionBomb(thisHero);
        }
    }

    public static void summonSpider(int summonerId) {
        int cost = SimpleRPG.cost(summonerId, 15);
        int a = 0;
        for(int i = 0; i < 3; i++) {
            if(!SimpleRPG.hero_name[i].equals("null")) {
                a++;
            }
        }
        if(a < 3) {
            if(SimpleRPG.hero_mana[summonerId] >= cost) {
                int b = 0;
                for (int i = 0; i < 3; i++) {
                    if(b == 0) {
                        if (SimpleRPG.hero_name[i].equals("null")) {
                            SimpleRPG.hero_name[i] = "Паучок";
                            SimpleRPG.hero_hp[i] = 10 * SimpleRPG.hero_lvl[summonerId];
                            SimpleRPG.hero_class[i] = "Ползунчик";
                            SimpleRPG.hero_dmg[i] = 5 * (SimpleRPG.hero_lvl[summonerId] + SimpleRPG.hero_class_xp[summonerId]);
                            SimpleRPG.hero[i] = i + 1;
                            SimpleRPG.hero_lvl[i] = SimpleRPG.hero_lvl[summonerId];
                            SimpleRPG.hero_mana[i] = 0;
                            SimpleRPG.hero_charisma[i] = 0;
                            SimpleRPG.hero_nature[i] = "Паучный";
                            SimpleRPG.hero_maxMana[i] = 0;
                            SimpleRPG.hero_class_xp[i] = 0;
                            SimpleRPG.hero_class_xp_xp[i] = 0;
                            SimpleRPG.hero_maxHp[i] = SimpleRPG.hero_hp[i];
                            b++;
                            SimpleRPG.hero_mana[summonerId] -= cost;
                            System.out.println(SimpleRPG.hero_name[summonerId] + " призвал Паучка. [-15 маны]");
                            SimpleRPG.turns[summonerId] = 1;
                        }
                    }
                }
            }
        }
    }

    public static void explosionBomb(int summonerId) {
        int cost = SimpleRPG.cost(summonerId, 10);
        if(SimpleRPG.hero_mana[summonerId] >= cost) {
            bomb += 10 - SimpleRPG.hero_lvl[summonerId];
            if(bomb <= 2) {
                bomb = 3;
            }
            SimpleRPG.updateScreen();
            System.out.println(SimpleRPG.hero_name[summonerId] + " бросил бомбу. [Таймер: " + bomb + " хода]");
            SimpleRPG.hero_mana[summonerId] -= cost;
            bombSummoner = summonerId;
            SimpleRPG.turns[summonerId] = 1;
        }
    }
}
