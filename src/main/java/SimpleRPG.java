import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class SimpleRPG {

    public static int inFight = 1;

    public static int room_count = 1;
    public static int chests = 10;

    public static int turns_unto_reset = -1;
    public static int pay_to_esc = 5;

    public static int gold = 10;

    // ХОДЫ

    public static int[] turns = {0, 0, 0};

    // ЗАЩИТА
    //todo ДОДЕЛАТЬ ЗАЩИТУ
    public static String[] shield_names = {"Деревянный щит"};
    public static int[] shield_hps = {3};
    public static int[] shield_stats = {50};

    // ОРУЖИЯ

    public static String[] weapon_names = {"Обыкновенный меч", "Железный кинжал", "Простой лук", "Книга целителя", "Атлас призыва стрел", "Боевой топор", "Арбалет", "Шар воплощения"};
    public static String[] types = {"Ближний", "Ближний", "Дальний", "Лечение", "Дальний", "Ближний", "Дальний", "Ближний"};
    public static String[] weapon_classes = {"Рыцарь", "Берсерк", "Лучник", "Паладин", "Маг", "Берсерк", "Лучник", "Чародей"};
    public static String[] items = {"Пирог", "Вишня"};
    public static int[] weapon_stats = {15, 25, 30, 20, 35, 30, 40, 50};
    public static int[] item_stats = {2, 1};

    // ИНВЕНТАРЬ

    //public static String[] weapon_name = {"null", "null", "null", "null", "null", "null"};
    public static String[] weapon_name = {"null", "null", "null", "null", "null", "null"};
    public static String[] weapon_class = {"Внеклассовое", "Внеклассовое", "Внеклассовое", "Внеклассовое", "Внеклассовое", "Внеклассовое"};
    public static int[] weapon_ids = new int[6];
    public static String[] type = new String[6];
    public static String[] equipped = {"null", "null", "null"};
    public static String[] weapon_class_e = {"Внеклассовое", "Внеклассовое", "Внеклассовое"};
    public static String[] type_eq = {"Ближний", "Ближний", "Ближний"};
    public static int[] weapon_id = {0, 0, 0};
    public static String[] item = new String[10];
    public static int[] weapon_dmg = new int[6];
    public static int[] item_stat = new int[10];
    public static int[] weapon_lvl = new int[6];
    public static String[] shield_name = {"null", "null", "null", "null"};
    public static int[] shield_ids = new int[4];
    public static int[] shield_hp = {0, 0, 0, 0};
    public static int[] shield_stat = {0, 0, 0, 0};
    public static int[] shield_hp_e = {0, 0, 0};
    public static String[] equipped_shields = {"null", "null", "null"};
    public static int[] shield_def = new int[3];

    public static int[] shield_id = {0, 0, 0};

    // ГЕРОИ

    public static String[] classes = {"Чародей", "Рыцарь", "Паладин", "Берсерк", "Маг", "Лучник"};
    public static String[] names = {"Гошан", "Нилу", "Серега", "Милана", "Старый", "Меченый", "Юра Всратый", "Саша", "Гитлер", "Руна", "Миллер", "Шурик", "Нимрус", "Вольфрам", "Штайнус", "Спурс", "Крякнес", "Симфи", "Рё-Мин", "Кеннеди", "Джаспер", "Крюгер", "Гендальф", "Внезапный дед", "Гнхоби", "Мирвельт", "Лимсения", "Виргл", "Узкоглазый Динн"};
    public static int[] hero_lvl = new int[3];

    public static int[] hero_xp = new int[3];
    public static String[] hero_class = new String[3];
    public static int[] hero_dmg = new int[3];

    public static int[] hero_maxHp = new int[3];
    public static int[] hero_hp = new int[3];
    public static int[] hero_mana = new int[3];
    public static int[] hero_shield = {1, 1, 1};
    public static int[] isReady = {0, 0, 0};
    public static String[] hero_name = {"null", "null", "null"};
    public static int[] hero = new int[3];

    //КЛАССЫ

    public static int[] berserk = {0, 0, 0};

    // ВРАГИ

    public static String[] enemy_names = {"Орк", "Скелет", "Дракончик", "Странный паук", "Снеговик", "Сумасшедшая книга"};
    public static int[] enemys = new int[6];

    public static int[] enemy_lvl = new int[3];
    public static String[] enemy_class = new String[3];
    public static int[] enemy_dmg = new int[3];
    public static int[] enemy_hp = new int[3];
    public static int[] enemy_maxHp = new int[3];
    public static String[] enemy_name = {"null", "null", "null"};
    public static int[] enemy = new int[3];

    public static String green = "\u001B[32m";
    public static String yellow = "\u001B[33m";
    public static String reset = "\u001B[0m";
    public static String red = "\u001B[31m";
    public static String n = "\n";

    // Меню

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(
                "    " + "Меню:" + n
                        + green + "1." + reset + "Начать" + n
                        + green + "2." + reset + "Настойки" + n
                        + green + "3." + reset + "Бестиарий" + n
        );

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ввод: ");

        int select = Integer.parseInt(reader.readLine());

        switch (select) {
            case (1) -> game();
            case (2) -> settings();
            case (3) -> bestiary();
        }


    }

    // Игра
    public static void game() throws InterruptedException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        updateScreen();

        System.out.println("Выбери героя:");
        Random random = new Random();
        int temp_hp = 100;
        int temp_class = random.nextInt(5);
        int randomName = random.nextInt(28);
        int temp_hp1 = 100;
        int temp_class1 = random.nextInt(5);
        int randomName1 = random.nextInt(28);
        int temp_hp2 = 100;
        int temp_class2 = random.nextInt(5);
        int randomName2 = random.nextInt(28);

        System.out.println(green + "1." + names[randomName] + reset + "\n Жизни: " + temp_hp + "\n Класс: " + classes[temp_class]);
        System.out.println(green + "2." + names[randomName1] + reset + "\n Жизни: " + temp_hp1 + "\n Класс: " + classes[temp_class1]);
        System.out.println(green + "3." + names[randomName2] + reset + "\n Жизни: " + temp_hp2 + "\n Класс: " + classes[temp_class2]);

        System.out.print("Ввод: ");
        int choose = Integer.parseInt(reader.readLine());

        if(choose == 1) {
            hero[0] = 0;
            hero_hp[0] = temp_hp;
            hero_name[0] = names[randomName];
            hero_class[0] = classes[temp_class];
            hero_dmg[0] = 40;
            hero_lvl[0] = 1;
            hero_maxHp[0] = temp_hp;
        } else if (choose == 2) {
            hero[0] = 0;
            hero_hp[0] = temp_hp1;
            hero_name[0] = names[randomName1];
            hero_class[0] = classes[temp_class1];
            hero_dmg[0] = 1;
            hero_lvl[0] = 1;
            hero_mana[0] = 5;
            hero_maxHp[0] = temp_hp1;
        } else {
            hero[0] = 0;
            hero_hp[0] = temp_hp2;
            hero_name[0] = names[randomName2];
            hero_class[0] = classes[temp_class2];
            hero_dmg[0] = 1;
            hero_lvl[0] = 1;
            hero_mana[0] = 5;
            hero_maxHp[0] = temp_hp2;
        }

        System.out.println("Хотите сменить имя герою? (y/n)");

        System.out.print("Ввод: ");
        String choose2 = reader.readLine();

        if(choose2.equals("y")) {

            System.out.print("Введите новое имя: ");
            String choose3 = reader.readLine();
            hero_name[0] = choose3;
        }

        enemy[0] = 1;
        enemy_name[0] = "Орк";
        enemy_maxHp[0] = 15;
        enemy_dmg[0] = 5;
        enemy_hp[0] = 11;

        /*
        enemy[1] = 1;
        enemy_name[1] = "Орк";
        enemy_dmg[1] = 5;
        enemy_hp[1] = 1;

        enemy[2] = 1;
        enemy_name[2] = "Орк";
        enemy_dmg[2] = 3;
        enemy_hp[2] = 1;
        */

        updateScreen();
        selectMenu();


    }

    // Настройки
    public static void settings() {

    }

    // Бестиарий
    public static void bestiary() {

    }

    /* public static int[] turnOut(int hero_dmg, int hero_hp) {

        return new int[0];
        }
    */

    public static int[] turnHero(int hero_dmg, int enemy_hp, String hero_name1, String enemy_name1, int hero, int enemy) throws InterruptedException {

        Random random = new Random();
        int hero_turn = 0;
        int hero_hit;
        int lvl_bust;

        if(checkDifficult() <= 1) {
            lvl_bust = 3;
        } else if(checkDifficult() == 2) {
            lvl_bust = 2;
        } else {
            lvl_bust = 1;
        }

        updateScreen();

        if(hero_dmg > 0) {
            if(hero_class[hero].equals("Берсерк")) {
                hero_hit = (random.nextInt(hero_dmg) + 1) * hero_lvl[hero];
            } else {
                hero_hit = random.nextInt(hero_dmg) + 1 + hero_lvl[hero];
            }
            hero_turn = enemy_hp - hero_hit; // Прибавляется к хп врага
            if((hero_turn) <= 0) {
                enemy_name[enemy] = "null";
                int xp = enemy_lvl[enemy] * (random.nextInt(4) + 1) * lvl_bust;
                hero_xp[hero] += xp;
                if(hero_xp[hero] >= 30 * hero_lvl[hero]) {
                    hero_lvl[hero] ++;
                    hero_xp[hero] = 0;
                    System.out.println("Персонаж " + hero_name1 + " перешел на уровень [" + hero_lvl[hero] + "].");
                } else {
                    System.out.println("Персонаж " + hero_name1 + " получил [" + xp + "] опыта.");
                }
                System.out.println("Персонаж " + hero_name1 + " добивает " + enemy_name1 + " нанеся [" + hero_hit + "] урона.");
            } else {
                System.out.println("Персонаж " + hero_name1 + " наносит [" + hero_hit + "] урона " + enemy_name1);
            }
        }

        int a = 0;

        for(int i = 0; i < 3; i++) {
            if (enemy_name[i].equals("null")) {
                a++;
            }
        }

        if(a == 3) {
            inFight = 0;
            int luck = random.nextInt(3);
            if(luck == 0) {
                chests++;
                System.out.println("У одного из павших врагов вы нашли ключ от сундука рядом с вами!");
            } else if(luck == 1) {
                System.out.println("У врагов в карманах пусто.");
            } else {
                int gold_luck = random.nextInt(5) + 1;
                gold += gold_luck;
                System.out.println("Вы нашли немного золота в карманах злодеев.");
            }
        }

        return new int[]{hero_turn};
    }

    public static int turnEnemy(int enemy_dmg, int hero_hp, String hero_name2, int hero1, String enemy_name1) throws InterruptedException {

        Random random = new Random();
        int enemy_turn = hero_hp;
        int enemy_hit = random.nextInt(enemy_dmg) + 1;

        TimeUnit.SECONDS.sleep(1);

        if(enemy_dmg > 0) {
            if (isReady[hero1] == 0) {
                enemy_turn = hero_hp - enemy_hit; // Прибавляется к хп героя
                if (enemy_turn <= 0) {
                    hero_name[hero1] = "null";
                    System.out.println("Враг " + enemy_name1 + " добивает " + hero_name2 + " нанеся [" + enemy_hit + "] урона.");
                    turns[hero1] = 0;
                    hero_xp[hero1] = 0;
                    hero_mana[hero1] = 0;

                } else {
                    System.out.println("Враг " + enemy_name1 + " наносит [" + enemy_hit + "] урона " + hero_name2);
                }
            } else {
                enemy_hit = random.nextInt(enemy_dmg) + 1 - (hero_shield[hero1] + shield_def[hero1]);
                if (enemy_hit > 0) {
                    enemy_turn = hero_hp - enemy_hit; // Прибавляется к хп героя
                    if (enemy_turn <= 0) {
                        hero_name[hero1] = "null";
                        System.out.println("Враг " + enemy_name1 + " добивает " + hero_name2 + " пробив щит и нанеся [" + enemy_hit + "] урона.");
                        turns[hero1] = 0;
                        hero_xp[hero1] = 0;
                        hero_mana[hero1] = 0;
                        shield_hp_e[hero1] = shield_hp_e[hero1] - 1;

                    } else {
                        System.out.println("Враг " + enemy_name1 + " пробивает щит и наносит [" + enemy_hit + "] урона " + hero_name2);
                        shield_hp_e[hero1] = shield_hp_e[hero1] - 1;
                    }
                } else {
                    System.out.println(enemy_name1 + " не пробивает щит " + hero_name2);
                    enemy_turn = hero_hp;
                    shield_hp_e[hero1] = shield_hp_e[hero1] - 1;
                }
                isReady[hero1] = 0;
                if(!equipped_shields[hero1].equals("null")) {
                    if (shield_hp_e[hero1] <= 0) {
                        System.out.println("Щит " + shield_name[hero1] + " вышел из строя.");
                        for (int r = 0; r < 4; r++) {
                            if (shield_ids[r] == shield_id[hero1]) {
                                shield_name[r] = "null";
                                shield_def[r] = 0;
                            }
                        }
                    }
                }
            }
        }

        if(turns_unto_reset != -1) {
            if(turns_unto_reset < 3) {
                turns_unto_reset += 1;
            } else {
                turns_unto_reset = -1;
                pay_to_esc = random.nextInt((20 * checkDifficult())) + 5;
            }
        }

        return enemy_turn;
    }


    // Функция обновления экрана
    public static void updateScreen() {
        for(int i = 0; i < 25; i++) {
            System.out.println(" ");
        }
    }

    public static void thatHero(int id) {
        String color;
        if(!hero_name[id].equals("null")) {
            if(turns[id] == 0) {
                color = green;
            } else {
                color = red;
            }
            String am = "" + (hero_hp[id] / 5);
            String load = "";
            String s = "";
            int ami = Integer.parseInt(am);
            String s1 = "" + "#".repeat(Math.max(0, ami)) +
                    "-".repeat(Math.max(0, (20 - ami)));
            if(hero_hp[id] <= 60 && hero_hp[id] > 30) {
                load = s1;
                s = yellow + "[" + load + "]" + reset + "   [" + hero_hp[id] + " hp]";
            } else if(hero_hp[id] < 31) {
                load = s1;
                s = red + "[" + load + "]" + reset + "   [" + hero_hp[id] + " hp]";
            } else {
                load = s1;
                s = green + "[" + load + "]" + reset + "   [" + hero_hp[id] + " hp]";
            }
            if (equipped[id].equals("null")) {
                System.out.println(color + (id + 1) + ". " + hero_name[id] + reset  + " Оружие:Руки" + " Класс:" + hero_class[id] + " Урон:" + hero_dmg[id] + " Уровень:" + hero_lvl[id] + " (" + hero_xp[id] + "/" + (30 * hero_lvl[id]) + ")   " + s);
            } else {
                System.out.println(color + (id + 1) + ". " + hero_name[id] + reset + " Оружие:" + equipped[id] + " Класс:" + hero_class[id] + " Урон:" + hero_dmg[id] + " Уровень:" + hero_lvl[id] +  " (" + hero_xp[id] + "/" + (30 * hero_lvl[id]) + ")   " + s);
            }
        }
    }
    public static void thatEnemy(int id) { //C:\Program Files\Eclipse Adoptium\jdk-8.0.312.7-hotspot\
        if(!enemy_name[id].equals("null")) {
            int yy = enemy_maxHp[id] / 5;
            String am = "" + (enemy_hp[id] / 5);
            String load = "";
            String s = "";
            int ami = Integer.parseInt(am);
            String s1 = "" + "#".repeat(Math.max(0, ami)) +
                    "-".repeat(Math.max(0, (yy - ami)));
            if(enemy_hp[id] <= (enemy_maxHp[id] / 2 + enemy_maxHp[id] / 4) && enemy_hp[id] > (enemy_maxHp[id] / 3)) {
                load = s1;
                s = yellow + "[" + load + "]" + reset + "   [" + enemy_hp[id] + " hp]";
            } else if(enemy_hp[id] < (enemy_maxHp[id] / 3)) {
                load = s1;
                s = red + "[" + load + "]" + reset + "   [" + enemy_hp[id] + " hp]";
            } else {
                load = s1;
                s = green + "[" + load + "]" + reset + "   [" + enemy_hp[id] + " hp]";
            }
            System.out.println(green + (id + 1) + ". " + enemy_name[id] + reset + " Урон:" + enemy_dmg[id] + " Уровень:" + enemy_lvl[id] + "   " + s);
        }
    }

    public static void showWeapons() {
        for(int id = 0; id < 6; id++) {
            int a = 0;
            if (!weapon_name[id].equals("null")) {
                for(int i = 0; i < 3; i++) {
                    if(weapon_ids[id] == weapon_id[i]) {
                        System.out.println(green + (id + 1) + ". " + weapon_name[id] + reset + " Класс:" + weapon_class_e[i] + " Урон:" + weapon_dmg[id] + " Уровень:" + weapon_lvl[id] + " {надето на " + hero_name[i] + "}");
                    } else {
                        a++;
                    }
                }
                if(a == 3) {
                    System.out.println(green + (id + 1) + ". " + weapon_name[id] + reset + " Класс:" + weapon_class[id] + " Урон:" + weapon_dmg[id] + " Уровень:" + weapon_lvl[id]);
                }
                a = 0;
            }
        }
    }

    public static void showShields() {
        for(int id = 0; id < 4; id++) {
            int a = 0;
            if (!shield_name[id].equals("null")) {
                for(int i = 0; i < 3; i++) {

                    if(shield_ids[id] == shield_id[i]) {
                        System.out.println(green + (id + 1) + ". " + shield_name[id] + reset + " Прочность:" + shield_hp_e[i] + " Защита:" + shield_def[i] + " {надето на " + hero_name[i] + "}");
                    } else {
                        a++;
                    }
                }
                if(a == 3) {
                    System.out.println(green + (id + 1) + ". " + shield_name[id] + reset + " Прочность:" + shield_hp[id] + " Защита:" + shield_stat[id]);
                }
                a = 0;
            }
        }
    }

    public static void enter() {
        System.out.print("Ввод: ");
    }

    public static int checkDifficult() {
        Random random = new Random();
        int difficult_k;
        int difficult = 0;
        int[] hero_lvls = new int[3];
        for(int i = 0; i < 3; i++) {
            if(!SimpleRPG.hero_name[i].equals("null")) {
                hero_lvls[i] = SimpleRPG.hero_lvl[i];
            } else {
                hero_lvls[i] = 1;
            }
        }
        int hero_lvl_k = hero_lvls[0] * hero_lvls[1] * hero_lvls[2];

        difficult_k = hero_lvl_k * (random.nextInt(3) + 1);

        if(difficult_k <= 5) {
            difficult = 1;
        } else if (difficult_k > 5 && difficult_k < 20) {
            difficult = random.nextInt(3) + 1;
        } else if (difficult_k > 20) {
            difficult = random.nextInt(3) + 1;
            if(difficult < 2) {
                difficult = 2;
            }
        }

        return difficult;
    }

    public static Object createEnemy() {
        Random random = new Random();
        int temp_lvl = 0;
        if(checkDifficult() == 1) {
            temp_lvl = 1;
        } else if (checkDifficult() == 2) {
            temp_lvl = random.nextInt(3) + 1;
        } else if (checkDifficult() == 3) {
            temp_lvl = random.nextInt(4) + 1;
        }
        int temp_hp = ((random.nextInt(10) + 1) * 10) + 50 + (checkDifficult() * 10);
        int temp_class = random.nextInt(3);
        int temp_dmg = random.nextInt(25) + (checkDifficult() * 5) + (temp_lvl * 5);
        int randomName = random.nextInt(enemy_names.length);

        return new Object[]{enemy_names[randomName], temp_hp, classes[temp_class], temp_dmg, temp_lvl};
    }

    public static Object createHero(int select_hero_number) {
        Random random = new Random();
        int temp_class = random.nextInt(5);
        int temp_hp = 100;
        int temp_mana = 30;


        //КЛАССОВЫЕ ОСОБЕННОСТИ
        if(temp_class == 2) { //ПАЛАДИН ИМЕЕТ НА 50 ЕДИНИЦ БОЛЬШЕ ЗДОРОВЬЯ
            temp_hp += 50;
            temp_mana = 40;
        } else if(temp_class == 3) {
            temp_hp -= 40;

        } else if (temp_class == 4){
            temp_hp -= 20;
            temp_mana = 60;
        }


        int randomName = random.nextInt(28);

        // System.out.println(green + select_hero_number + ". " + names[randomName] + reset + "\n Жизни: " + temp_hp + "\n Класс: " + classes[temp_class]);
        return new Object[]{names[randomName], temp_hp, classes[temp_class], 1, 1, temp_mana};
    }
    /*
    Пример как использовать createHero

    Object[] newHero = (Object[]) createHero(1);
    hero_name[1] = (String) newHero[0];
    hero_hp[1] = (int) newHero[1];
    hero_class[1] = (String) newHero[2];
    hero_dmg[1] = (int) newHero[3];
    hero[1] = 2;
    hero_lvl[1] = (int) newHero[4];
    hero_mana[1] = (int) newHero[5];
    selectMenu();
    */

    public static void openChest() throws IOException, InterruptedException {
        updateScreen();
        chests--;
        Random random = new Random();
        int loot_num = random.nextInt(3) + 1;
        for (int i = 0; i < loot_num; i++) {
            int luck = random.nextInt(3) + 1;
            if (luck == 1) {
                int loot = random.nextInt(weapon_names.length);
                int closed = 0;
                int h = 0;
                for (int c = 0; c < 6; c++) {
                    if (weapon_name[c].equals("null")) {
                        if (h == 0) {
                            weapon_name[c] = weapon_names[loot];
                            weapon_lvl[c] = checkDifficult() * (random.nextInt(2) + 1);
                            weapon_dmg[c] = random.nextInt(weapon_stats[loot]) + 1 + weapon_lvl[c];
                            weapon_class[c] = weapon_classes[loot];
                            type[c] = types[loot];
                            weapon_ids[c] = random.nextInt(200) + 1;
                            for (int t = 0; t < 6; t++) {
                                if (weapon_ids[c] == weapon_ids[t]) {
                                    weapon_ids[c] = random.nextInt(200) + 1;
                                }
                            }
                            System.out.println("Вы получили " + weapon_name[c]);
                            h++;
                        }
                    } else {
                        closed++;
                    }
                    if (closed == 6) {
                        System.out.println("У вас не хватает места в инвентаре. Введите номер предмета, который вы хотите заменить на " + weapon_names[loot] + ", либо напишите [n] для отказа.");
                        showWeapons();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        enter();
                        String input = reader.readLine();
                        if (input.equals("n")) {
                            System.out.println("Вы отказались от предмета.");
                        } else {
                            int g = Integer.parseInt(input) - 1;
                            weapon_name[g] = weapon_names[loot];
                            weapon_lvl[g] = checkDifficult() * (random.nextInt(2) + 1);
                            weapon_dmg[g] = random.nextInt(weapon_stats[loot]) + 1 + weapon_lvl[g];
                            type[g] = types[loot];
                            weapon_class[g] = weapon_classes[loot];
                            weapon_ids[g] = random.nextInt(200) + 1;
                            for (int t = 0; t < 6; t++) {
                                if (weapon_ids[g] == weapon_ids[t]) {
                                    weapon_ids[g] = random.nextInt(200) + 1;
                                }
                                weapon_lvl[g] = 1;
                            }
                            System.out.println("Вы получили " + weapon_name[g]);
                        }
                    }

                }
            } else if(luck == 2) {
                int gr = random.nextInt(5) + 1;
                gold += gr;
                System.out.println("Найдена мелочь!");
            } else {
                int loot = random.nextInt(shield_names.length);
                int closed = 0;
                int h = 0;
                for (int c = 0; c < 4; c++) {
                    if (shield_name[c].equals("null")) {
                        if (h == 0) {
                            shield_name[c] = shield_names[loot];
                            shield_hp[c] = random.nextInt(shield_hps[loot]) + 1;
                            shield_stat[c] = random.nextInt(shield_stats[loot]) + 1;
                            shield_ids[c] = random.nextInt(200) + 1;
                            for (int t = 0; t < 4; t++) {
                                if (shield_ids[c] == shield_ids[t]) {
                                    shield_ids[c] = random.nextInt(200) + 1;
                                }
                            }
                            System.out.println("Вы получили " + shield_name[c]);
                            h++;
                        }
                    } else {
                        closed++;
                    }
                    if (closed == 4) {
                        System.out.println("У вас не хватает места в инвентаре. Введите номер предмета, который вы хотите заменить на " + shield_names[loot] + ", либо напишите [n] для отказа.");
                        showShields();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        enter();
                        String input = reader.readLine();
                        if (input.equals("n")) {
                            System.out.println("Вы отказались от предмета.");
                        } else {
                            int g = Integer.parseInt(input) - 1;
                            shield_name[g] = shield_names[loot];
                            shield_stat[c] = random.nextInt(shield_stats[loot]) + 1;
                            shield_hp[g] = random.nextInt(shield_hps[loot]) + 1;
                            shield_ids[g] = random.nextInt(200) + 1;
                            for (int t = 0; t < 4; t++) {
                                if (shield_ids[g] == shield_ids[t]) {
                                    shield_ids[g] = random.nextInt(200) + 1;
                                }
                            }
                            System.out.println("Вы получили " + shield_name[g]);
                        }
                    }

                }
            }

            selectMenu();
        }
    }


    public static void selectMenu() throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();

        int a = 0;

        for(int i = 0; i < 3; i++) {
            if (enemy_name[i].equals("null")) {
                a++;
            }
        }

        if(a == 3) {
            inFight = 0;
        }

        if(inFight == 1) {
            int acc = 0;
            for(int s = 0; s < 3; s++) {
                if(!hero_name[s].equals("null")) {
                    acc++;
                }
                //System.out.println(turns[s]);
            }
            if((turns[0] + turns[1] + turns[2]) == acc) {
                int whatHero;

                for(int attack = 0; attack < 3; attack++) {
                    if(!enemy_name[attack].equals("null")) {
                        do {
                            whatHero = random.nextInt(3);
                        } while (hero_name[whatHero].equals("null"));

                        int res = turnEnemy(enemy_dmg[attack], hero_hp[whatHero], hero_name[whatHero], whatHero, enemy_name[attack]);
                        hero_hp[whatHero] = res;
                    }
                }

                for(int t = 0; t < 3; t++) {
                    turns[t] = 0;
                }
                System.out.println(" ");
                System.out.println("Герои восстановили свои силы!");
            }

            System.out.println("     [ Вы находитесь в комнате #" + room_count + " ]  ");
            System.out.println("Меню действий:" + "        Мешок с золотом: " + gold + " золотых");
            System.out.println(green + "1." + reset + "Следующая комната");
            System.out.println(green + "2." + reset + "Выбрать героя");
            //System.out.println(turns_unto_reset);
            if(turns_unto_reset == -1) {
                System.out.println(green + "3." + reset + "Попробовать откупиться " + "(" + pay_to_esc + " золотых)");
            } else {
                System.out.println(green + "3." + reset + "Попробовать откупиться " + "(" + pay_to_esc + " золотых) | До обновления: " + (3 - turns_unto_reset) + " хода");
            }
            if(chests >= 1) {
                System.out.println(green + "4." + reset + "Открыть сундук");
            }

            System.out.print("Ввод: ");
            int answer = Integer.parseInt(reader.readLine());

            if(answer == 1) {
                System.out.println("Ты не можешь перейти к следующей комнате, пока не разберешься с врагами.");
                selectMenu();
            } else if (answer == 2) {
                updateScreen();
                System.out.println("Укажите героя: ");
                for (int i = 0; i < 3; i++) {
                    thatHero(i);
                }
                System.out.print("Ввод: ");
                int thisHero = Integer.parseInt(reader.readLine()) - 1;
                if(hero_name[thisHero].equals("null")){
                    updateScreen();
                    System.out.println("Выберите действующего героя.");
                    selectMenu();
                } else {
                    if (turns[thisHero] == 1) {
                        updateScreen();
                        System.out.println("Этот герой должен восстановить силы.");
                        selectMenu();
                    } else {
                        heroSelectMenu(thisHero);
                    }
                }
            } else if(answer == 3){
                if (gold >= pay_to_esc) {
                    if (turns_unto_reset == -1) {
                        System.out.println("Вы действительно хотите попробовать откупиться? Это будет стоить вам " + pay_to_esc + " золотых. (y/n)");
                        String tyu = reader.readLine();
                        if (tyu.equals("y")) {
                            int luck = random.nextInt(2);
                            int cause = random.nextInt(4);
                            if (luck == 0) {
                                gold -= pay_to_esc;
                                for (int o = 0; o < 3; o++) {
                                    enemy_name[o] = "null";
                                }
                                updateScreen();
                                switch (cause) {
                                    case 0:
                                        System.out.println("Вы предложили врагам деньги, от которых они просто не смогли отказаться. Оказывается им все это время просто нужны были деньги на пропитание.");
                                        turns_unto_reset = 0;
                                        break;

                                    case 1:
                                        System.out.println("Враги нашли ваше предложение недостаточно интересным. Сначала они хотели отказаться, но затем решили помиловать вас и отпустить по своим делам. (Деньги они все равно взяли)");
                                        turns_unto_reset = 0;
                                        break;

                                    case 2:
                                        System.out.println("Без лишних слов враги забрали деньги и ушли.");
                                        turns_unto_reset = 0;
                                        break;

                                    case 3:
                                        System.out.println("После того, как вы успешно откупились, у вас завязался длинный диалог с врагами. Вы успели познакомиться, а потом они ушли.");
                                        turns_unto_reset = 0;
                                        break;
                                }

                                selectMenu();

                            } else {
                                switch (cause) {
                                    case 0:
                                        updateScreen();
                                        System.out.println("Враги сочли ваше предложение проявлением трусости. Они стали более уверенны в своей победе. (их сила повышена)");
                                        for (int hj = 0; hj < 3; hj++) {
                                            enemy_dmg[hj] += 1;
                                        }
                                        turns_unto_reset = 0;
                                        selectMenu();
                                        break;

                                    case 1:
                                        updateScreen();
                                        System.out.println("Врагам такая сумма показалась недостаточной. Они требуют всех ваших сбережений. (" + gold + ") Согласиться на их условие? (y/n)");
                                        String gegr = reader.readLine();
                                        enter();
                                        if (gegr.equals("y")) {
                                            gold -= gold;
                                            updateScreen();
                                            System.out.println("Вы остались ни с чем, зато вас оставили в покое.");
                                            for (int o = 0; o < 3; o++) {
                                                enemy_name[o] = "null";
                                            }
                                            selectMenu();
                                        } else {
                                            updateScreen();
                                            System.out.println("Вы решили продолжить драку.");
                                            selectMenu();
                                        }
                                        turns_unto_reset = 0;
                                        break;

                                    default:
                                        updateScreen();
                                        System.out.println("Вражеская сторона ответила коротко и ясно: нет.");
                                        turns_unto_reset = 0;
                                        selectMenu();
                                }
                            }
                        } else {
                            updateScreen();
                            selectMenu();
                        }
                    } else {
                        updateScreen();
                        System.out.println("Дождитесь обновления!");
                        selectMenu();
                    }

                } else {
                    if (gold >= 5) {
                        System.out.println("У вас не хватает денег. Вы можете попробовать обновить цену за 5 золотых. (обновление займет 3 хода). Обновить? (y/n)");
                        String hjtk = reader.readLine();
                        if (hjtk.equals("y")) {
                            gold -= 5;
                            turns_unto_reset = 0;
                        } else {
                            updateScreen();
                            selectMenu();
                        }
                    } else {
                        System.out.println("У вас не хватает денег. (Даже на обновление)");
                    }
                }

            } else {
                openChest();
            }

        } else {
            for(int t = 0; t < 3; t++) {
                turns[t] = 0;
            }

            System.out.println("     [ Вы находитесь в комнате #" + room_count + " ]  ");
            System.out.println("Меню действий:" +  "           Мешок с золотом: " + gold + " золотых");
            System.out.println(green + "1." + reset + "Следующая комната");
            System.out.println(green + "2." + reset + "Выбрать героя");
            if(chests >= 1) {
                System.out.println(green + "3." + reset + "Открыть сундук");
            }

            System.out.print("Ввод: ");
            int answer = Integer.parseInt(reader.readLine());

            if(answer == 1) {
                Rooms.room();
            } else if (answer == 2) {
                updateScreen();
                System.out.println("Укажите героя: ");
                for (int i = 0; i < 3; i++) {
                    thatHero(i);
                }
                System.out.print("Ввод: ");
                int thisHero = Integer.parseInt(reader.readLine()) - 1;
                if(turns[thisHero] == 1) {
                    System.out.println("Этот герой должен восстановить силы.");
                    selectMenu();
                } else {
                    heroSelectMenu(thisHero);
                }
            } else {
                openChest();
            }
        }

    }

    public static void heroSelectMenu(int thisHero) throws IOException, InterruptedException {
        updateScreen();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        if(inFight == 1) {
            System.out.println("Меню персонажа:" +  "           Мешок с золотом: " + gold + " золотых         Выбран: " + hero_name[thisHero]);
            System.out.println(green + "1." + reset + "Атаковать");
            System.out.println(green + "2." + reset + "Подготовиться к атаке");
            System.out.println(green + "3." + reset + "Сменить снаряжение");
            System.out.println(green + "4." + reset + "Вернуться в меню действий");

            System.out.print("Ввод: ");
            int answer = Integer.parseInt(reader.readLine());
            int whatEnemy;


            if(answer == 1) {
                if(type_eq[thisHero].equals("Ближний")) {

                    System.out.println("Выберите врага для атаки:");
                    for (int i = 0; i < 3; i++) {
                        thatEnemy(i);
                    }
                    enter();
                    int choose = Integer.parseInt(reader.readLine()) - 1;

                    int whatHero;

                    do {
                        whatHero = random.nextInt(3);
                    } while (hero_name[whatHero].equals("null"));

                    // int hero_dmg, int enemy_hp, String hero_name1, String enemy_name1, int hero, int enemy
                    int[] turn_result = turnHero(hero_dmg[thisHero], enemy_hp[choose], hero_name[thisHero], enemy_name[choose], thisHero, choose);
                    turns[thisHero] = 1;
                    enemy_hp[choose] = turn_result[0];
                } else if(type_eq[thisHero].equals("Лечение")){
                    System.out.println("Выберите персонажа для лечения:");
                    for (int i = 0; i < 3; i++) {
                        thatHero(i);
                    }
                    enter();

                    int choose = Integer.parseInt(reader.readLine()) - 1;
                    int hp = random.nextInt(hero_dmg[thisHero]) + 1;

                    hero_hp[choose] += hp;
                    if(hero_hp[choose] > hero_maxHp[choose]) {
                        hero_hp[choose] = hero_maxHp[choose];
                    }
                    turns[thisHero] = 1;
                    System.out.println("Персонаж " + hero_name[thisHero] + " исцелил раны " + hero_name[choose] + " на [" + hp + "] оз.");
                } else if(type_eq[thisHero].equals("Дальний")){
                    System.out.println("Выберите врага для атаки:");
                    for (int i = 0; i < 3; i++) {
                        thatEnemy(i);
                    }
                    enter();
                    int choose = Integer.parseInt(reader.readLine()) - 1;

                    /*
                    int whatHero;

                    do {
                        whatHero = random.nextInt(3);
                    } while (hero_name[whatHero].equals("null"));
                    */

                    int[] turn_result = turnHero(hero_dmg[thisHero], enemy_hp[choose], hero_name[thisHero], enemy_name[choose], thisHero, choose);;
                    turns[thisHero] = 1;
                    enemy_hp[choose] = turn_result[0];
                }
                selectMenu();

            } else if (answer == 2) {
                /*
                do {
                    whatEnemy = random.nextInt(3);
                } while (enemy_name[whatEnemy].equals("null"));
                int whatHero;

                do {
                    whatHero = random.nextInt(3);
                } while (hero_name[whatHero].equals("null"));
                */
                turns[thisHero] = 1;
                isReady[thisHero] = 1;
                updateScreen();
                System.out.println("Герой " + hero_name[thisHero] + " подготовился к отражению урона.");
                selectMenu();
            } else if(answer == 3){
                System.out.println("Выберите новую экипировку.");
                System.out.println("          ОРУЖИЯ");
                showWeapons();
                System.out.println("           ЩИТЫ");
                showShields();
                enter();
                int gh = 0;
                int hg = 0;
                int gg = 0;
                int ggg = 0;
                String selects = reader.readLine();
                String[] selects1 = selects.split(" ");
                int select = Integer.parseInt(selects1[0]) - 1;
                int select2;
                try {
                    select2 = Integer.parseInt(selects1[1]);
                } catch (Exception e) {
                    select2 = 0;
                }
                System.out.println(select + " " + select2);
                updateScreen();
                if(!weapon_name[select].equals("null") || select >= 1 && select <= 6) {
                    if(weapon_class[select].equals(hero_class[thisHero])) {
                        for (int r = 0; r < 3; r++) {
                            if (Objects.equals(weapon_name[select], equipped[r])) {
                                if (weapon_ids[select] == weapon_id[r]) {
                                    equipped[r] = "null";
                                    type_eq[r] = "Ближний";
                                    hero_dmg[r] = 1;
                                    weapon_id[r] = 0;
                                    weapon_class_e[r] = "Внеклассовое";
                                    equipped[thisHero] = weapon_name[select];
                                    weapon_class_e[thisHero] = weapon_class[select];
                                    hero_dmg[thisHero] = weapon_dmg[select];
                                    weapon_id[thisHero] = weapon_ids[select];
                                    type_eq[thisHero] = type[select];
                                    turns[thisHero] = 1;
                                    System.out.println("Для героя " + hero_name[thisHero] + " установлено оружие " + equipped[thisHero] + " | урон [" + hero_dmg[thisHero] + "]");
                                    hg = 1;
                                }
                            } else {
                                gh = 1;
                            }
                        }
                        if (gh == 1) {
                            if (hg != 1) {
                                equipped[thisHero] = weapon_name[select];
                                hero_dmg[thisHero] = weapon_dmg[select];
                                weapon_id[thisHero] = weapon_ids[select];
                                weapon_class_e[thisHero] = weapon_class[select];
                                type_eq[thisHero] = type[select];
                                turns[thisHero] = 1;
                                System.out.println("Для героя " + hero_name[thisHero] + " установлено оружие " + equipped[thisHero] + " | урон [" + hero_dmg[thisHero] + "]");
                            }
                        }
                    } else {
                        System.out.println("Этот герой не может использовать оружие другого класса.");
                    }
                } else {
                System.out.println("Укажите имеющееся оружие!");
                }

                if(select2 != 0) {
                    select2--;
                    for (int t = 0; t < 3; t++) {
                        if (Objects.equals(shield_name[select2], equipped_shields[t])) {
                            if (shield_ids[select2] == shield_id[t]) {
                                equipped_shields[t] = "null";
                                shield_hp[select2] = shield_hp_e[t];
                                hero_shield[t] = 1 + hero_lvl[t];
                                shield_id[t] = 0;
                                shield_hp_e[thisHero] = shield_hp[select2];
                                equipped_shields[thisHero] = shield_name[select2];
                                shield_def[thisHero] = shield_stat[select2];
                                shield_id[thisHero] = shield_ids[select2];
                                turns[thisHero] = 1;
                                System.out.println("Для героя " + hero_name[thisHero] + " установлен щит " + equipped_shields[thisHero] + " | Защита [" + shield_def[thisHero] + "]");
                                ggg = 1;
                            }
                        } else {
                            gg = 1;
                        }
                    }
                }

                if(gg == 1) {
                    if(ggg != 1) {
                        if(equipped_shields[thisHero] != "null") {
                            for(int y = 0; y < 4; y++) {
                                if(shield_ids[y] ==  shield_id[thisHero]) {
                                    shield_hp[y] = shield_hp_e[thisHero];
                                }
                            }
                        }
                        equipped_shields[thisHero] = shield_name[select2];
                        shield_hp_e[thisHero] = shield_hp[select2];
                        shield_def[thisHero] = shield_stat[select2];
                        shield_id[thisHero] = shield_ids[select2];
                        turns[thisHero] = 1;
                        System.out.println("Для героя " + hero_name[thisHero] + " установлен щит " + equipped_shields[thisHero] + " | Защита [" + shield_def[thisHero] + "]");
                    }
                }
                selectMenu();

            } else {
                selectMenu();
            }

        } else {
            System.out.println(green + "1." + reset + "Сменить снаряжение");
            System.out.println(green + "2." + reset + "Вернуться в меню действий");

            System.out.print("Ввод: ");
            int answer = Integer.parseInt(reader.readLine());

            if(answer == 1){

                System.out.println("Выберите новую экипировку.");
                showWeapons();
                enter();
                int gh = 0;
                int hg = 0;
                int select = Integer.parseInt(reader.readLine()) - 1;
                updateScreen();
                for(int r = 0; r < 3; r++) {
                    if (weapon_name[select] == equipped[r]) {
                        if(weapon_ids[select] == weapon_id[r]) {
                            equipped[r] = "null";
                            hero_dmg[r] = 1;
                            weapon_id[r] = 0;
                            equipped[thisHero] = weapon_name[select];
                            hero_dmg[thisHero] = weapon_dmg[select];
                            weapon_id[thisHero] = weapon_ids[select];
                            type_eq[thisHero] = type[select];
                            type_eq[r] = "Ближний";
                            turns[thisHero] = 1;
                            System.out.println("Для героя " + hero_name[thisHero] + " установлено оружие " + equipped[thisHero] + " | урон [" + hero_dmg[thisHero] + "]");
                        }
                        hg = 1;
                    } else {
                        gh = 1;
                    }
                }
                if(gh == 1) {
                    if(hg != 1) {
                        equipped[thisHero] = weapon_name[select];
                        hero_dmg[thisHero] = weapon_dmg[select];
                        weapon_id[thisHero] = weapon_ids[select];
                        type_eq[thisHero] = type[select];
                        turns[thisHero] = 1;
                        System.out.println("Для героя " + hero_name[thisHero] + " установлено оружие " + equipped[thisHero] + " | урон [" + hero_dmg[thisHero] + "]");
                    }
                }
                selectMenu();
            } else {
                selectMenu();
            }
        }


    }
}
