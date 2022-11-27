import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Effects {

    // Эффекты
    private static int[] poisoned_enemy = new int[3];
    private static int[] poisoned_hero = new int[3];
    private static int[] poison_lvl_hero = new int[3];
    private static int[] poison_lvl_enemy = new int[3];


    public static void checkPoison() {
        Random random = new Random();
        for(int h = 0; h < 3; h++) {
            if(!SimpleRPG.hero_name[h].equals("null")) {
                if(poisoned_hero[h] > 0) {
                    SimpleRPG.hero_hp[h] -= 5 * poison_lvl_hero[h];
                    poisoned_hero[h] -= 1;
                    if(SimpleRPG.hero_hp[h] <= 0) {
                        SimpleRPG.hero_name[h] = "null";
                        System.out.println(SimpleRPG.hero_name[h] + " скончался от отравления");
                    } else {
                        System.out.println(SimpleRPG.hero_name[h] + " получил урон [" + (5 * poison_lvl_hero[h]) + "] от отравления");
                    }
                }
            }
        }
        for(int h = 0; h < 3; h++) {
            if(!SimpleRPG.enemy_name[h].equals("null")) {
                if(poisoned_enemy[h] > 0) {
                    SimpleRPG.enemy_hp[h] -= 5 * poison_lvl_enemy[h];
                    poisoned_enemy[h] -= 1;
                    int lvl_bust;

                    if(SimpleRPG.checkDifficult() <= 1) {
                        lvl_bust = 3;
                    } else if(SimpleRPG.checkDifficult() == 2) {
                        lvl_bust = 2;
                    } else {
                        lvl_bust = 1;
                    }
                    int xp = SimpleRPG.enemy_lvl[h] * (random.nextInt(4) + 1) * lvl_bust;
                    if(SimpleRPG.enemy_hp[h] <= 0) {
                        System.out.println(SimpleRPG.enemy_name[h] + " скончался от отравления");
                        poisoned_enemy[h] = 0;
                        SimpleRPG.enemy_name[h] = "null";
                        System.out.println("Все герои получили " + xp + " опыта");
                        int a = 0;
                        for(int i = 0; i < 3; i++) {
                            if (!SimpleRPG.hero_name[i].equals("null")) {
                                SimpleRPG.hero_xp[i] += xp;
                            }
                        }
                        for(int i = 0; i < 3; i++) {
                            if (SimpleRPG.enemy_name[i].equals("null")) {
                                a++;
                            }
                        }

                        if(a == 3) {
                            SimpleRPG.inFight = 0;
                            int luck = random.nextInt(3);
                            if(luck == 0) {
                                SimpleRPG.chests++;
                                System.out.println("У одного из павших врагов вы нашли ключ от сундука рядом с вами!");
                            } else if(luck == 1) {
                                System.out.println("У врагов в карманах пусто.");
                            } else {
                                int gold_luck = random.nextInt(5) + 1;
                                SimpleRPG.gold += gold_luck;
                                System.out.println("Вы нашли немного золота в карманах злодеев.");
                            }
                        }

                    } else {
                        System.out.println(SimpleRPG.enemy_name[h] + " получил урон [" + (5 * poison_lvl_enemy[h]) + "] от отравления");
                    }
                }
            }
        }
    }
    public static void poison(int target, int id, int turns, int poison_lvle) {
        if (target == 1) { // ВРАГ
            poisoned_enemy[id] = turns;
            poison_lvl_enemy[id] = poison_lvle;
            SimpleRPG.enemy_hp[id] -= 5 * poison_lvle;
            System.out.println(SimpleRPG.enemy_name[id] + " получил отравление на " + turns + " ходов");
        } else { // ГЕРОЙ
            poison_lvl_hero[id] = poison_lvle;
            poisoned_hero[id] = turns;
            SimpleRPG.enemy_hp[id] -= 5 * poison_lvle;
            System.out.println(SimpleRPG.hero_name[id] + " получил отравление на " + turns + " ходов");
        }
    }

    public static int[] getPoisoned_enemy() {
        return poisoned_enemy;
    }

    public static void setPoisoned_enemy(int[] poisoned_enemy) {
        Effects.poisoned_enemy = poisoned_enemy;
    }

    public static int[] getPoisoned_hero() {
        return poisoned_hero;
    }

    public static void setPoisoned_hero(int[] poisoned_hero) {
        Effects.poisoned_hero = poisoned_hero;
    }

    public static int[] getPoison_lvl_hero() {
        return poison_lvl_hero;
    }

    public static void setPoison_lvl_hero(int[] poison_lvl_hero) {
        Effects.poison_lvl_hero = poison_lvl_hero;
    }


    public static void effectWeapon(int thisHero, int id) {
        Random random = new Random();
        if(SimpleRPG.equipped[thisHero].equals("Ядовитый кинжал")) {
            int pson = random.nextInt(3);
            int pslvl = 0;
            for(int s =0; s < 6; s++) {
                if(SimpleRPG.weapon_ids[s] == SimpleRPG.weapon_id[thisHero]) {
                    pslvl = (random.nextInt(3) + 1) * SimpleRPG.weapon_lvl[s];
                }
            }
            if (pson == 2) {
                Effects.poison(1, id, 3, pslvl);
            }
        }
    }
}
