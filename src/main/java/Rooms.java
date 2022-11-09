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


        SimpleRPG.updateScreen();


        System.out.println("Вы спускаетесь ниже в подземелье...");

        TimeUnit.SECONDS.sleep(2);

        //todo Изменить значение room_id (nextInt) на 2 или 3
        int money = 0;
        if (room_id == 0) {
            event = random.nextInt(4);
            int dif = SimpleRPG.checkDifficult();

            SimpleRPG.updateScreen();

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

                    Object[] b = (Object[]) SimpleRPG.createEnemy();
                    SimpleRPG.enemy_name[1] = (String) b[0];
                    SimpleRPG.enemy_hp[1] = (int) b[1];
                    SimpleRPG.enemy_maxHp[1] = SimpleRPG.enemy_hp[1];
                    SimpleRPG.enemy_class[1] = (String) b[2];
                    SimpleRPG.enemy_dmg[1] = (int) b[3];
                    SimpleRPG.enemy[1] = 1;
                    SimpleRPG.enemy_lvl[1] = (int) b[4];

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

                    Object[] b = (Object[]) SimpleRPG.createEnemy();
                    SimpleRPG.enemy_name[1] = (String) b[0];
                    SimpleRPG.enemy_hp[1] = (int) b[1];
                    SimpleRPG.enemy_maxHp[1] = SimpleRPG.enemy_hp[1];
                    SimpleRPG.enemy_class[1] = (String) b[2];
                    SimpleRPG.enemy_dmg[1] = (int) b[3];
                    SimpleRPG.enemy[1] = 2;
                    SimpleRPG.enemy_lvl[1] = (int) b[4];

                    Object[] c = (Object[]) SimpleRPG.createEnemy();
                    SimpleRPG.enemy_name[2] = (String) c[0];
                    SimpleRPG.enemy_hp[2] = (int) c[1];
                    SimpleRPG.enemy_maxHp[2] = SimpleRPG.enemy_hp[2];
                    SimpleRPG.enemy_class[2] = (String) c[2];
                    SimpleRPG.enemy_dmg[2] = (int) c[3];
                    SimpleRPG.enemy[2] = 3;
                    SimpleRPG.enemy_lvl[2] = (int) c[4];

                    SimpleRPG.inFight = 1;

                    System.out.println("Вы шли по тусклому тоннели и набрели на " + SimpleRPG.enemy_name[0] + " вместе с " + SimpleRPG.enemy_name[1] + " и " + SimpleRPG.enemy_name[2]);

                }
            } else if (event == 1) {
                SimpleRPG.updateScreen();
                int earn = random.nextInt(10) + 1;
                SimpleRPG.gold += earn;

                System.out.println("Вы вошли в большой зал, кругом сплошные обломки и уцелевшая мебель. Покопавшись в обломках вы находите " + earn + " золотых.");
            } else  if(event == 2){
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
            } else {
                SimpleRPG.updateScreen();
                System.out.println("Вы брели по тоннелю, пока не забрели в небольшой подземный магазин. Хотите что-то купить? (y/n)");
                String answer = reader.readLine();
                if (answer.equals("y")) {
                    SimpleRPG.updateScreen();

                    System.out.println("       [Магазин]");
                    int loot = random.nextInt(SimpleRPG.weapon_names.length);
                    int temp_lvl = SimpleRPG.checkDifficult() * (random.nextInt(2) + 1);
                    int temp_dmg = random.nextInt(SimpleRPG.weapon_stats[loot]) + 1 + temp_lvl;
                    int cost = (random.nextInt(30) + 5) * temp_lvl;
                    System.out.println(SimpleRPG.green + ( + 1) + ". " + SimpleRPG.weapon_names[loot] + SimpleRPG.reset + " Класс:" + SimpleRPG.weapon_classes[loot] + " Урон:" + temp_dmg + " Уровень:" + temp_lvl + "    Цена:" + cost + " золотых.");
                    int loot2 = random.nextInt(SimpleRPG.weapon_names.length);
                    int temp_lvl2 = SimpleRPG.checkDifficult() * (random.nextInt(2) + 1);
                    int temp_dmg2 = random.nextInt(SimpleRPG.weapon_stats[loot]) + 1 + temp_lvl;
                    int cost2 = (random.nextInt(30) + 5) * temp_lvl;
                    System.out.println(SimpleRPG.green + ( + 2) + ". " + SimpleRPG.weapon_names[loot] + SimpleRPG.reset + " Класс:" + SimpleRPG.weapon_classes[loot] + " Урон:" + temp_dmg2 + " Уровень:" + temp_lvl2 + "    Цена:" + cost2 + " золотых.");
                    int loot3 = random.nextInt(SimpleRPG.weapon_names.length);
                    int temp_lvl3 = SimpleRPG.checkDifficult() * (random.nextInt(2) + 1);
                    int temp_dmg3 = random.nextInt(SimpleRPG.weapon_stats[loot]) + 1 + temp_lvl;
                    int cost3 = (random.nextInt(30) + 5) * temp_lvl;
                    System.out.println(SimpleRPG.green + ( + 3) + ". " + SimpleRPG.weapon_names[loot] + SimpleRPG.reset + " Класс:" + SimpleRPG.weapon_classes[loot] + " Урон:" + temp_dmg3 + " Уровень:" + temp_lvl3 + "    Цена:" + cost3 + " золотых.");
                    int closed = 0;
                    int h = 0;
                    System.out.println("Введи номер оружия, чтобы купить его, или N для выхода.");
                    String chooose = reader.readLine();
                    if (chooose.equals("1")) {
                        if(SimpleRPG.gold >= cost) {
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
                    } else if(chooose.equals("2")) {
                        if(SimpleRPG.gold >= cost2) {
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
                    } else if(chooose.equals("3")) {
                        SimpleRPG.gold -= cost3;
                        if(SimpleRPG.gold >= cost3) {
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
            }

        }
        SimpleRPG.selectMenu();
    }
}

