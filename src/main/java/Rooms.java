import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Rooms {
    public static void room() throws IOException, InterruptedException {
        Random random = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int room_id = random.nextInt(1);
        int event;
        SimpleRPG.room_count++;
        int grats = 0;
        String cnt = "" + SimpleRPG.room_count;
        String[] spt = cnt.split("");
        if(spt.length == 2) {
            if (spt[1].equals("0")) {
                SimpleRPG.scores++;
                grats = 1;
            }
        }


        SimpleRPG.updateScreen();


        System.out.println("Вы спускаетесь ниже в подземелье...");

        TimeUnit.SECONDS.sleep(1);

        //todo Изменить значение room_id (nextInt) на 2 или 3
        int money = 0;
        if (room_id == 0) {
            event = random.nextInt(6);
            int dif = SimpleRPG.checkDifficult();

            SimpleRPG.updateScreen();

            if(SimpleRPG.room_count == 49) {
                SimpleRPG.enemy_name[0] = "Гейрред - Князь Великанов";
                SimpleRPG.enemy_hp[0] = 400;
                SimpleRPG.enemy_maxHp[0] = 400;
                SimpleRPG.enemy_class[0] = "Разрушитель";
                SimpleRPG.enemy_dmg[0] = 60;
                SimpleRPG.enemy[0] = 1;
                SimpleRPG.enemy_lvl[0] = 5;
                SimpleRPG.enemy_effect[0] = "null";

                System.out.println("Вы входите в 49 комнату. Высокие, просторные потолки сбивают вас с толку. Мощные, гранитные стены возвышаются над вами и вдалеке видно гигантскую дверь.");
                reader.readLine();
                System.out.println("*грохот*");
                reader.readLine();
                System.out.println("Дверь отлетает с ужасающей силой и в комнату входит Князь Великанов Гейрред. Он не пустит вас дальше без боя.");
                reader.readLine();

            } else {

                if (event == 0) {
                    if (dif == 1) {
                        Object[] a = (Object[]) SimpleRPG.createEnemy();
                        SimpleRPG.enemy_name[0] = (String) a[0];
                        SimpleRPG.enemy_hp[0] = (int) a[1];
                        SimpleRPG.enemy_maxHp[0] = SimpleRPG.enemy_hp[0];
                        SimpleRPG.enemy_class[0] = (String) a[2];
                        SimpleRPG.enemy_dmg[0] = (int) a[3];
                        SimpleRPG.enemy[0] = 1;
                        SimpleRPG.enemy_lvl[0] = (int) a[4];
                        SimpleRPG.enemy_effect[0] = (String) a[5];

                        System.out.println("Вы шли по тусклому тоннелю и набрели на " + SimpleRPG.enemy_name[0]);
                        SimpleRPG.inFight = 1;

                    } else if (dif == 2) {
                        Object[] a = (Object[]) SimpleRPG.createEnemy();
                        SimpleRPG.enemy_name[0] = (String) a[0];
                        SimpleRPG.enemy_hp[0] = (int) a[1];
                        SimpleRPG.enemy_maxHp[0] = SimpleRPG.enemy_hp[0];
                        SimpleRPG.enemy_class[0] = (String) a[2];
                        SimpleRPG.enemy_dmg[0] = (int) a[3];
                        SimpleRPG.enemy[0] = 1;
                        SimpleRPG.enemy_lvl[0] = (int) a[4];
                        SimpleRPG.enemy_effect[0] = (String) a[5];

                        Object[] b = (Object[]) SimpleRPG.createEnemy();
                        SimpleRPG.enemy_name[1] = (String) b[0];
                        SimpleRPG.enemy_hp[1] = (int) b[1];
                        SimpleRPG.enemy_maxHp[1] = SimpleRPG.enemy_hp[1];
                        SimpleRPG.enemy_class[1] = (String) b[2];
                        SimpleRPG.enemy_dmg[1] = (int) b[3];
                        SimpleRPG.enemy[1] = 1;
                        SimpleRPG.enemy_lvl[1] = (int) b[4];
                        SimpleRPG.enemy_effect[1] = (String) a[5];

                        System.out.println("Вы шли по тусклому тоннелю и набрели на " + SimpleRPG.enemy_name[0] + " вместе с " + SimpleRPG.enemy_name[1]);
                        SimpleRPG.inFight = 1;

                    } else {
                        Object[] a = (Object[]) SimpleRPG.createEnemy();
                        SimpleRPG.enemy_name[0] = (String) a[0];
                        SimpleRPG.enemy_hp[0] = (int) a[1];
                        SimpleRPG.enemy_maxHp[0] = SimpleRPG.enemy_hp[0];
                        SimpleRPG.enemy_class[0] = (String) a[2];
                        SimpleRPG.enemy_dmg[0] = (int) a[3];
                        SimpleRPG.enemy[0] = 1;
                        SimpleRPG.enemy_lvl[0] = (int) a[4];
                        SimpleRPG.enemy_effect[0] = (String) a[5];

                        Object[] b = (Object[]) SimpleRPG.createEnemy();
                        SimpleRPG.enemy_name[1] = (String) b[0];
                        SimpleRPG.enemy_hp[1] = (int) b[1];
                        SimpleRPG.enemy_maxHp[1] = SimpleRPG.enemy_hp[1];
                        SimpleRPG.enemy_class[1] = (String) b[2];
                        SimpleRPG.enemy_dmg[1] = (int) b[3];
                        SimpleRPG.enemy[1] = 2;
                        SimpleRPG.enemy_lvl[1] = (int) b[4];
                        SimpleRPG.enemy_effect[1] = (String) a[5];

                        Object[] c = (Object[]) SimpleRPG.createEnemy();
                        SimpleRPG.enemy_name[2] = (String) c[0];
                        SimpleRPG.enemy_hp[2] = (int) c[1];
                        SimpleRPG.enemy_maxHp[2] = SimpleRPG.enemy_hp[2];
                        SimpleRPG.enemy_class[2] = (String) c[2];
                        SimpleRPG.enemy_dmg[2] = (int) c[3];
                        SimpleRPG.enemy[2] = 3;
                        SimpleRPG.enemy_lvl[2] = (int) c[4];
                        SimpleRPG.enemy_effect[2] = (String) a[5];

                        SimpleRPG.inFight = 1;

                        System.out.println("Вы шли по тусклому тоннели и набрели на " + SimpleRPG.enemy_name[0] + " вместе с " + SimpleRPG.enemy_name[1] + " и " + SimpleRPG.enemy_name[2]);

                    }
                } else if (event == 1) {
                    SimpleRPG.updateScreen();
                    int earn = random.nextInt(10) + 1;
                    SimpleRPG.gold += earn;

                    System.out.println("Вы вошли в большой зал, кругом сплошные обломки и уцелевшая мебель. Покопавшись в обломках вы находите " + earn + " золотых.");
                } else if (event == 2) {
                    SimpleRPG.updateScreen();
                    money = random.nextInt(10) + 3;
                    int h = 0;
                    for (int i = 0; i < 3; i++) {
                        if (!SimpleRPG.hero_name[i].equals("null")) {
                            h++;
                        }
                    }
                    Object[] mercenary = (Object[]) SimpleRPG.createHero(1);
                    if (SimpleRPG.gold >= money) {
                        if (h == 3) {
                            System.out.println("Вы входите" + " в таверну #" + SimpleRPG.room_count + ". Внезапно к вам подходит одетый в черный плащ " + mercenary[0] + " и предлагает" +
                                    " вам свою помощь, еще и согласен отдать вам свои последние " + money + " золотых. Вы согласитесь? (y/n)");
                            SimpleRPG.enter();
                            String answer = reader.readLine();

                            int f = 0;

                            if (answer.equals("y")) {
                                System.out.println("Выберите персонажа на замену:");
                                for (int i = 0; i < 3; i++) {
                                    SimpleRPG.thatHero(i);
                                }
                                SimpleRPG.enter();
                                int i = Integer.parseInt(reader.readLine()) - 1;
                                SimpleRPG.hero_name[i] = (String) mercenary[0];
                                SimpleRPG.hero_hp[i] = (int) mercenary[1];
                                SimpleRPG.hero_class[i] = (String) mercenary[2];
                                SimpleRPG.hero_dmg[i] = (int) mercenary[3];
                                SimpleRPG.hero[i] = i + 1;
                                SimpleRPG.hero_lvl[i] = (int) mercenary[4];
                                SimpleRPG.hero_mana[i] = (int) mercenary[5];
                                SimpleRPG.hero_charisma[i] = (int) mercenary[6];
                                SimpleRPG.hero_nature[i] = (String) mercenary[7];
                                SimpleRPG.hero_maxMana[i] = (int) mercenary[8];
                                SimpleRPG.hero_class_xp[i] = 0;
                                SimpleRPG.hero_class_xp_xp[i] = 0;
                                SimpleRPG.hero_maxHp[i] = SimpleRPG.hero_hp[i];
                                System.out.println("К вам присоединился новый персонаж! Встречайте: " + mercenary[0] + "!");
                                SimpleRPG.thatHero(i);
                                SimpleRPG.gold += money;
                                f = 1;
                            }
                        } else {
                            System.out.println("Входя в комнату #" + SimpleRPG.room_count + " вы оказываетесь в таверне. Жар огня, веселье народа. Внезапно к вам подходит одетый в черный плащ " + mercenary[0] + " и предлагает" +
                                    " вам свою помощь за " + money + " золотых. Вы согласитесь? (y/n)");
                            SimpleRPG.enter();
                            String answer = reader.readLine();

                            int f = 0;

                            if (answer.equals("y")) {
                                SimpleRPG.gold -= money;
                                for (int i = 0; i < 3; i++) {
                                    if (f == 0) {
                                        if (SimpleRPG.hero_name[i].equals("null")) {
                                            SimpleRPG.hero_name[i] = (String) mercenary[0];
                                            SimpleRPG.hero_hp[i] = (int) mercenary[1];
                                            SimpleRPG.hero_class[i] = (String) mercenary[2];
                                            SimpleRPG.hero_dmg[i] = (int) mercenary[3];
                                            SimpleRPG.hero[i] = i + 1;
                                            SimpleRPG.hero_lvl[i] = (int) mercenary[4];
                                            SimpleRPG.hero_mana[i] = (int) mercenary[5];
                                            SimpleRPG.hero_charisma[i] = (int) mercenary[6];
                                            SimpleRPG.hero_nature[i] = (String) mercenary[7];
                                            SimpleRPG.hero_maxMana[i] = (int) mercenary[8];
                                            SimpleRPG.hero_class_xp[i] = 0;
                                            SimpleRPG.hero_class_xp_xp[i] = 0;
                                            SimpleRPG.hero_maxHp[i] = SimpleRPG.hero_hp[i];
                                            System.out.println("К вам присоединился новый персонаж! Встречайте: " + mercenary[0] + "!");
                                            SimpleRPG.thatHero(i);
                                            System.out.println(" ");
                                            f = 1;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Входя в комнату #" + SimpleRPG.room_count + " вы оказываетесь в таверне. Внезапно к вам подходит одетый в черный плащ " + mercenary[0] + " и предлагает" +
                                " вам свою помощь за деньги, которых у вас нет. Он уходит.");
                    }
                } else if (event == 3) {
                    SimpleRPG.updateScreen();
                    System.out.println("Вы брели по тоннелю, пока не забрели в небольшой подземный магазин. Хотите что-то купить? (y/n)");
                    String answer = reader.readLine();
                    if (answer.equals("y")) {
                        SimpleRPG.updateScreen();

                        System.out.println("                                    [Магазин]               Мешок с золотом: " + SimpleRPG.gold);
                        int loot = random.nextInt(SimpleRPG.weapon_names.length);
                        int temp_lvl = SimpleRPG.checkDifficult() * (random.nextInt(2) + 1);
                        int temp_dmg = random.nextInt(SimpleRPG.weapon_stats[loot]) + 1 + temp_lvl;
                        int cost = (random.nextInt(30) + 5) * temp_lvl;
                        System.out.println(SimpleRPG.green + (+1) + ". " + SimpleRPG.weapon_names[loot] + SimpleRPG.reset + " Класс:" + SimpleRPG.weapon_classes[loot] + " Урон:" + temp_dmg + " Уровень:" + temp_lvl + "    Цена:" + cost + " золотых.");
                        int loot2 = random.nextInt(SimpleRPG.weapon_names.length);
                        int temp_lvl2 = SimpleRPG.checkDifficult() * (random.nextInt(2) + 1);
                        int temp_dmg2 = random.nextInt(SimpleRPG.weapon_stats[loot2]) + 1 + temp_lvl;
                        int cost2 = (random.nextInt(30) + 5) * temp_lvl;
                        System.out.println(SimpleRPG.green + (+2) + ". " + SimpleRPG.weapon_names[loot2] + SimpleRPG.reset + " Класс:" + SimpleRPG.weapon_classes[loot2] + " Урон:" + temp_dmg2 + " Уровень:" + temp_lvl2 + "    Цена:" + cost2 + " золотых.");
                        int loot3 = random.nextInt(SimpleRPG.weapon_names.length);
                        int temp_lvl3 = SimpleRPG.checkDifficult() * (random.nextInt(2) + 1);
                        int temp_dmg3 = random.nextInt(SimpleRPG.weapon_stats[loot3]) + 1 + temp_lvl;
                        int cost3 = (random.nextInt(30) + 5) * temp_lvl;
                        System.out.println(SimpleRPG.green + (+3) + ". " + SimpleRPG.weapon_names[loot3] + SimpleRPG.reset + " Класс:" + SimpleRPG.weapon_classes[loot3] + " Урон:" + temp_dmg3 + " Уровень:" + temp_lvl3 + "    Цена:" + cost3 + " золотых.");
                        int closed = 0;
                        int h = 0;
                        System.out.println("Введи номер оружия, чтобы купить его, или N для выхода.");
                        String chooose = reader.readLine();
                        if (chooose.equals("1")) {
                            if (SimpleRPG.gold >= cost) {
                                for (int c = 0; c < 6; c++) {
                                    if (SimpleRPG.weapon_name[c].equals("null")) {
                                        if (h == 0) {
                                            SimpleRPG.weapon_name[c] = SimpleRPG.weapon_names[loot];
                                            SimpleRPG.weapon_lvl[c] = temp_lvl;
                                            SimpleRPG.weapon_dmg[c] = temp_dmg;
                                            SimpleRPG.weapon_class[c] = SimpleRPG.weapon_classes[loot];
                                            SimpleRPG.type[c] = SimpleRPG.types[loot];
                                            SimpleRPG.weapon_ids[c] = random.nextInt(200) + 1;
                                            for (int t = 0; t < 6; t++) {
                                                if (SimpleRPG.weapon_ids[c] == SimpleRPG.weapon_ids[t]) {
                                                    SimpleRPG.weapon_ids[c] = random.nextInt(200) + 1;
                                                }
                                            }
                                            System.out.println("Вы получили " + SimpleRPG.weapon_name[c]);
                                            h++;
                                        }
                                    } else {
                                        closed++;
                                    }
                                    if (closed == 6) {
                                        System.out.println("У вас не хватает места в инвентаре. Введите номер предмета, который вы хотите заменить на " + SimpleRPG.weapon_names[loot] + ", либо напишите [n] для отказа.");
                                        SimpleRPG.showWeapons();
                                        SimpleRPG.enter();
                                        String input = reader.readLine();
                                        if (input.equals("n")) {
                                            System.out.println("Вы отказались от предмета.");
                                        } else {
                                            int g = Integer.parseInt(input) - 1;
                                            SimpleRPG.weapon_name[g] = SimpleRPG.weapon_names[loot];
                                            SimpleRPG.weapon_lvl[g] = temp_lvl;
                                            SimpleRPG.weapon_dmg[g] = temp_dmg;
                                            SimpleRPG.type[g] = SimpleRPG.types[loot];
                                            SimpleRPG.weapon_class[g] = SimpleRPG.weapon_classes[loot];
                                            SimpleRPG.weapon_ids[g] = random.nextInt(200) + 1;
                                            for (int t = 0; t < 6; t++) {
                                                if (SimpleRPG.weapon_ids[g] == SimpleRPG.weapon_ids[t]) {
                                                    SimpleRPG.weapon_ids[g] = random.nextInt(200) + 1;
                                                }
                                                SimpleRPG.weapon_lvl[g] = 1;
                                            }
                                            System.out.println("Вы получили " + SimpleRPG.weapon_name[g]);
                                        }
                                    }

                                }
                                SimpleRPG.gold -= cost;
                            }
                        } else if (chooose.equals("2")) {
                            if (SimpleRPG.gold >= cost2) {
                                SimpleRPG.gold -= cost2;
                                for (int c = 0; c < 6; c++) {
                                    if (SimpleRPG.weapon_name[c].equals("null")) {
                                        if (h == 0) {
                                            SimpleRPG.weapon_name[c] = SimpleRPG.weapon_names[loot2];
                                            SimpleRPG.weapon_lvl[c] = temp_lvl;
                                            SimpleRPG.weapon_dmg[c] = temp_dmg2;
                                            SimpleRPG.weapon_class[c] = SimpleRPG.weapon_classes[loot2];
                                            SimpleRPG.type[c] = SimpleRPG.types[loot2];
                                            SimpleRPG.weapon_ids[c] = random.nextInt(200) + 1;
                                            for (int t = 0; t < 6; t++) {
                                                if (SimpleRPG.weapon_ids[c] == SimpleRPG.weapon_ids[t]) {
                                                    SimpleRPG.weapon_ids[c] = random.nextInt(200) + 1;
                                                }
                                            }
                                            System.out.println("Вы получили " + SimpleRPG.weapon_name[c]);
                                            h++;
                                        }
                                    } else {
                                        closed++;
                                    }
                                    if (closed == 6) {
                                        System.out.println("У вас не хватает места в инвентаре. Введите номер предмета, который вы хотите заменить на " + SimpleRPG.weapon_names[loot2] + ", либо напишите [n] для отказа.");
                                        SimpleRPG.showWeapons();
                                        SimpleRPG.enter();
                                        String input = reader.readLine();
                                        if (input.equals("n")) {
                                            System.out.println("Вы отказались от предмета.");
                                        } else {
                                            int g = Integer.parseInt(input) - 1;
                                            SimpleRPG.weapon_name[g] = SimpleRPG.weapon_names[loot2];
                                            SimpleRPG.weapon_lvl[g] = temp_lvl2;
                                            SimpleRPG.weapon_dmg[g] = temp_dmg2;
                                            SimpleRPG.type[g] = SimpleRPG.types[loot2];
                                            SimpleRPG.weapon_class[g] = SimpleRPG.weapon_classes[loot2];
                                            SimpleRPG.weapon_ids[g] = random.nextInt(200) + 1;
                                            for (int t = 0; t < 6; t++) {
                                                if (SimpleRPG.weapon_ids[g] == SimpleRPG.weapon_ids[t]) {
                                                    SimpleRPG.weapon_ids[g] = random.nextInt(200) + 1;
                                                }
                                                SimpleRPG.weapon_lvl[g] = 1;
                                            }
                                            System.out.println("Вы получили " + SimpleRPG.weapon_name[g]);
                                        }
                                    }

                                }
                            }
                        } else if (chooose.equals("3")) {
                            if (SimpleRPG.gold >= cost3) {
                                SimpleRPG.gold -= cost3;
                                for (int c = 0; c < 6; c++) {
                                    if (SimpleRPG.weapon_name[c].equals("null")) {
                                        if (h == 0) {
                                            SimpleRPG.weapon_name[c] = SimpleRPG.weapon_names[loot3];
                                            SimpleRPG.weapon_lvl[c] = temp_lvl3;
                                            SimpleRPG.weapon_dmg[c] = temp_dmg3;
                                            SimpleRPG.weapon_class[c] = SimpleRPG.weapon_classes[loot3];
                                            SimpleRPG.type[c] = SimpleRPG.types[loot3];
                                            SimpleRPG.weapon_ids[c] = random.nextInt(200) + 1;
                                            for (int t = 0; t < 6; t++) {
                                                if (SimpleRPG.weapon_ids[c] == SimpleRPG.weapon_ids[t]) {
                                                    SimpleRPG.weapon_ids[c] = random.nextInt(200) + 1;
                                                }
                                            }
                                            System.out.println("Вы получили " + SimpleRPG.weapon_name[c]);
                                            h++;
                                        }
                                    } else {
                                        closed++;
                                    }
                                    if (closed == 6) {
                                        System.out.println("У вас не хватает места в инвентаре. Введите номер предмета, который вы хотите заменить на " + SimpleRPG.weapon_names[loot3] + ", либо напишите [n] для отказа.");
                                        SimpleRPG.showWeapons();
                                        SimpleRPG.enter();
                                        String input = reader.readLine();
                                        if (input.equals("n")) {
                                            System.out.println("Вы отказались от предмета.");
                                        } else {
                                            int g = Integer.parseInt(input) - 1;
                                            SimpleRPG.weapon_name[g] = SimpleRPG.weapon_names[loot3];
                                            SimpleRPG.weapon_lvl[g] = temp_lvl3;
                                            SimpleRPG.weapon_dmg[g] = temp_dmg3;
                                            SimpleRPG.type[g] = SimpleRPG.types[loot3];
                                            SimpleRPG.weapon_class[g] = SimpleRPG.weapon_classes[loot3];
                                            SimpleRPG.weapon_ids[g] = random.nextInt(200) + 1;
                                            for (int t = 0; t < 6; t++) {
                                                if (SimpleRPG.weapon_ids[g] == SimpleRPG.weapon_ids[t]) {
                                                    SimpleRPG.weapon_ids[g] = random.nextInt(200) + 1;
                                                }
                                                SimpleRPG.weapon_lvl[g] = 1;
                                            }
                                            System.out.println("Вы получили " + SimpleRPG.weapon_name[g]);
                                        }
                                    }

                                }
                            }
                        }
                    }
                } else if (event == 4) {
                    if (dif == 1) {
                        Object[] a = (Object[]) SimpleRPG.createMiniBoss();
                        SimpleRPG.enemy_name[0] = (String) a[0];
                        SimpleRPG.enemy_hp[0] = (int) a[1];
                        SimpleRPG.enemy_maxHp[0] = SimpleRPG.enemy_hp[0];
                        SimpleRPG.enemy_class[0] = (String) a[2];
                        SimpleRPG.enemy_dmg[0] = (int) a[3];
                        SimpleRPG.enemy[0] = 1;
                        SimpleRPG.enemy_lvl[0] = (int) a[4];
                        SimpleRPG.enemy_effect[0] = (String) a[5];

                        if (SimpleRPG.enemy_name[0].equals("Каменный голем")) {
                            System.out.println("Внезапно земля под ногами начинает потрясываться. Вы слышите стук камней.");
                            reader.readLine();
                            System.out.println("*грохот*");
                            reader.readLine();
                            if (SimpleRPG.enemy_effect[0] == "none") {
                                System.out.println("Из-за поворота на вас выглядывает здоровенный каменный голем. Такую машину не остановить чем-то легким. Готовьте что-то мощное.");
                            } else if (SimpleRPG.enemy_effect[0] == "Яд") {
                                System.out.println("Из-за поворота на вас выглядывает здоровенный каменный голем, обвешанный лозами. Осторожно, кажется его лозы ядовиты.");
                            } else if (SimpleRPG.enemy_effect[0] == "Колючий") {
                                System.out.println("Из-за поворота на вас выглядывает здоровенный каменный голем, покрытый огромными шипами. Кажется, шипы достаточно острые, чтобы моментально наносить урон.");
                            }
                            reader.readLine();
                        } else if (SimpleRPG.enemy_name[0].equals("Демилич")) {
                            System.out.println("Вас внезапно начинает что-то тревожить.");
                            reader.readLine();
                            System.out.println("*свист*");
                            reader.readLine();
                            if (SimpleRPG.enemy_effect[0] == "none") {
                                System.out.println("На вас с бешенной скоростью несется парящий череп в синем огне. кажется, это Демилич. Вам стоить быть осторожнее.");
                            } else if (SimpleRPG.enemy_effect[0] == "Яд") {
                                System.out.println("Вы и не замечаете как к вам начинает приближаться летающая голова, горящая зелёным огнем. Скорее всего, это ядовитый Демилич.");
                            } else if (SimpleRPG.enemy_effect[0] == "Колючий") {
                                System.out.println("Черепок, покрытый шипами скатывается вниз с лестницы. -Бойся меняяяя! Я Демилич - кричит голова. Он может мгновенно нанести ответный урон.");
                            }
                            reader.readLine();
                        } else if (SimpleRPG.enemy_name[0].equals("Кентавр")) {
                            System.out.println("Лошадиный топот слышно отовсюду.");
                            reader.readLine();
                            System.out.println("*лошадиный смех*");
                            reader.readLine();
                            if (SimpleRPG.enemy_effect[0] == "none") {
                                System.out.println("Сзади к вам подскочил Кентавр в булатных доспехах и мечом в руке. Его горящие глаза пугают вас.");
                            } else if (SimpleRPG.enemy_effect[0] == "Яд") {
                                System.out.println("Мимо вас пролетает стрела с непонятной жижей на ней. Вслед за стрелой из тени выходит Кентавр. Он хочет убить вас.");
                            } else if (SimpleRPG.enemy_effect[0] == "Колючий") {
                                System.out.println("Вы догадываетесь, что это кентавр, однако как только вы окончательно его замечаете, то приходите в замешательство. Он весь напичкан шипами и вовсе не ранен. Он использует шипы как броню.");
                            }
                            reader.readLine();
                        } else if (SimpleRPG.enemy_name[0].equals("Циклоп")) {
                            System.out.println("Входя в комнату вы видите Циклопа, пасущего овец..");
                            reader.readLine();
                            System.out.println("*...*");
                            reader.readLine();
                            if (SimpleRPG.enemy_effect[0] == "none") {
                                System.out.println("Пока вы стояли в ожидании чего-то, до Циклопа дошло, что вы можете быть вкусными. Он хочет убить вас.");
                            } else if (SimpleRPG.enemy_effect[0] == "Яд") {
                                System.out.println("Вы замечаете странное, сгорбленное существо с кучей клыков и лишь одним глазом. Своими шипастыми культяпками он отрывает от коровы мясо и ложит в свою пасть. Заметив вас, у него изо рта бежит зеленая слюна. Он бросается на вас.");
                            } else if (SimpleRPG.enemy_effect[0] == "Колючий") {
                                System.out.println("Вы встречаете необычного циклопа, полностью покрытого шипами. Он замечает вас. Ну что-ж, в бой.");
                            }
                            reader.readLine();
                        }

                        SimpleRPG.inFight = 1;

                    }
                } else if (event == 5) {
                    System.out.println("Вы натыкаетесь на место для проведения ритуалов. По середине стоит плоский камень, а вокруг него расположены 9 обелисков.");
                    reader.readLine();
                    System.out.println("Вы заметили надпись на камне: Положи оружие и добавь очков прокачки, тогда его уровень и характеристики повысятся.");
                    reader.readLine();
                    System.out.println("Попробовать? (y/n)");
                    String answer = reader.readLine();
                    if (answer.equals("y")) {
                        //todo Доделать систему прокачки оружия
                        SimpleRPG.updateScreen();
                        System.out.println("Очки: " + SimpleRPG.scores);
                        SimpleRPG.swScore = 1;
                        SimpleRPG.showWeapons();
                        System.out.println("Введите номер предмета, который хотите прокачать, либо откажитесь с помощью [n]: ");
                        SimpleRPG.swScore = 0;
                        answer = reader.readLine();
                        if (answer.equals("n") || answer.equals("N")) {

                            System.out.println("Вы отказались.");

                        } else {
                            int num = Integer.parseInt(answer) - 1;
                            if (SimpleRPG.scores >= (SimpleRPG.weapon_lvl[num] * 3)) {
                                SimpleRPG.scores -= (SimpleRPG.weapon_lvl[num] * 3);
                                SimpleRPG.weapon_lvl[num] += 1;
                                SimpleRPG.weapon_dmg[num] += (SimpleRPG.weapon_dmg[num] / (5 * SimpleRPG.weapon_lvl[num]));
                                System.out.println("Ваше оружие прокачано!");
                                //todo баг с оружием, урон меняется только у пассивного оружия, а выбранное меняется, но его нужно заново экипировать
                            } else {
                                System.out.println("У вас недостаточно очков! Пожалуйста, вернитесь позже!");
                            }
                        }

                    } else {
                        System.out.println("Вы прошли мимо...");
                    }
                }
            }

        }
        if(grats == 1) {
            grats = 0;
            System.out.println("[Очки] Вам начислены очки прокачки за достижение " + SimpleRPG.room_count + " комнаты!");
        }
        SimpleRPG.selectMenu();
    }
}

