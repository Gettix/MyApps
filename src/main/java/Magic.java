import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Magic {
    // Переменные
    public static int bomb = 0;
    public static int bombSummoner = 0;

    // Уровень, требуемый у персонажа для использования заклинания
    public static int summonSpider_lvl = 2;
    public static int summonZombie_lvl = 4;
    public static int toxicCloud_lvl = 3;
    public static int paralysis_lvl = 1;
    public static int explosionBomb_lvl = 1;

    public static void magics(int thisHero) throws IOException, InterruptedException {
        SimpleRPG.updateScreen();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Показать заклинания, подходящие по уровню

        if(summonSpider_lvl <= SimpleRPG.hero_lvl[thisHero]) {
            System.out.println("[f] Призвать паука - " + SimpleRPG.cost(thisHero, 20) + " маны");

        }
        if(explosionBomb_lvl <= SimpleRPG.hero_lvl[thisHero]) {
            System.out.println("[g] Бросить магическую бомбу - " + SimpleRPG.cost(thisHero, 15) + " маны");

        }
        if(summonZombie_lvl <= SimpleRPG.hero_lvl[thisHero]) {
            System.out.println("[r] Призвать зомби - " + SimpleRPG.cost(thisHero, 25) + " маны");

        }
        if(toxicCloud_lvl <= SimpleRPG.hero_lvl[thisHero]) {
            System.out.println("[t] Вызвать ядовитое облако - " + SimpleRPG.cost(thisHero, 20) + " маны");

        }
        if(paralysis_lvl <= SimpleRPG.hero_lvl[thisHero]) {
            System.out.println("[y] Вызвать паралич - " + SimpleRPG.cost(thisHero, 15) + " маны");

        }

        System.out.println("[*] Открыть книгу заклинаний");
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
        } else if(answer.equals("r")) {
            summonZombie(thisHero);
        } else if(answer.equals("*")) {
            BookOfMagic.pages();
        } else if(answer.equals("t")) {
            toxicCloud(thisHero);
        } else if(answer.equals("y")) {
            paralysis(thisHero);
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
                            System.out.println(SimpleRPG.hero_name[summonerId] + " призвал Паучка. [-" + cost + " маны]");
                            SimpleRPG.turns[summonerId] = 1;
                        }
                    }
                }
            }
        }
    }

    public static void summonZombie(int summonerId) {
        int cost = SimpleRPG.cost(summonerId, 25);
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
                            SimpleRPG.hero_name[i] = "Зомби";
                            SimpleRPG.hero_hp[i] = 30 * SimpleRPG.hero_lvl[summonerId];
                            SimpleRPG.hero_class[i] = "Рыцарь";
                            SimpleRPG.hero_dmg[i] = 15 * (SimpleRPG.hero_lvl[summonerId] + SimpleRPG.hero_class_xp[summonerId]);
                            SimpleRPG.hero[i] = i + 1;
                            SimpleRPG.hero_lvl[i] = SimpleRPG.hero_lvl[summonerId];
                            SimpleRPG.hero_mana[i] = 0;
                            SimpleRPG.hero_charisma[i] = 0;
                            SimpleRPG.hero_nature[i] = "Зомбячный";
                            SimpleRPG.hero_maxMana[i] = 0;
                            SimpleRPG.hero_class_xp[i] = 0;
                            SimpleRPG.hero_class_xp_xp[i] = 0;
                            SimpleRPG.hero_maxHp[i] = SimpleRPG.hero_hp[i];
                            b++;
                            SimpleRPG.hero_mana[summonerId] -= cost;
                            System.out.println(SimpleRPG.hero_name[summonerId] + " призвал Зомби. [-" + cost + " маны]");
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
            bomb += 6 - SimpleRPG.hero_lvl[summonerId];
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

    public static void toxicCloud(int summonerId) {
        int cost = SimpleRPG.cost(summonerId, 20);
        if(SimpleRPG.hero_mana[summonerId] >= cost) {

            for(int i = 0; i < 0; i++) {
                if(!SimpleRPG.enemy_name[i].equals("null")) {
                    Effects.poison(i, summonerId, 3, 2);
                }
            }
            System.out.println(SimpleRPG.hero_name[summonerId] + " призвал ядовитое облако и отравил врагов на 3 хода.");
            SimpleRPG.hero_mana[summonerId] -= cost;
            SimpleRPG.turns[summonerId] = 1;
        }
    }

    public static void paralysis(int summonerId) throws IOException {
        int cost = SimpleRPG.cost(summonerId, 15);
        if(SimpleRPG.hero_mana[summonerId] >= cost) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Выберите врага:");
            for(int b = 0; b <= 0; b++) {
                SimpleRPG.thatEnemy(b, true);
            }
            int a = Integer.parseInt(reader.readLine());

            if(!SimpleRPG.enemy_name[a].equals("null")) {
                SimpleRPG.enemy_nextAttack[a] = 0;
                System.out.println(SimpleRPG.hero_name[summonerId] + " парализовал " + SimpleRPG.enemy_name[a]);
                SimpleRPG.hero_mana[summonerId] -= cost;
                SimpleRPG.turns[summonerId] = 1;
            } else {
                System.out.println("Выберите реального врага!");
            }

        }
    }
}
