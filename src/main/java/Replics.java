import java.util.Random;

public class Replics {
    public static String[] funny = {" рассказывает шутку о ядовитом слизне отряду.",
            " рассказывает шутку о шипастом жуке.",
            " вспоминает забавную историю с Садистским Сатаной.",
            " предлагает устроить небольшой лагерь на поверхности.",
            " предлагает расположиться рядом с мраморной колонной ненадолго.",
            " вспоминает, что кушал вчера."};

    public static String[] calm = {" размышляет о следующей комнате. Что же нас ожидает там?",
            " думает о тактике сражения с орками.",
            " спрашивает кто взял его воду.",
            " рассматривает узоры, вырезанные на стене комнаты.",
            " волнуется перед следующим боем.",
            " вспоминает, что кушал вчера."};

    public static String[] wise = {" думает над новой цитатой с волками.",
            " строит новую теорию появления шипастого жука.",
            " опять отвлекся на древние развалины.",
            " говорит: волк не волк, если медведь не собака. Все восхищены его умом.",
            " считает, что в следующий раз нужно попробовать откупиться.",
            " питается энергией солнца."};

    public static String[] ambitious = {" подбадривает команду своими словами.",
            " хочет показать всем врагам нашу силу.",
            " строит грандиозные планы по победе над Царем Тьмы.",
            " говорит: нам нужно двигаться дальше, давайте, бодрее!",
            " настроен исключительно положительно.",
            " озабочен вопросом крутости команды."};

    public static void say() {
        Random random = new Random();

        int sayOrNo = random.nextInt(5);
        if(sayOrNo == 3) {
            int phrase;
            int whatHero;
            do {
                whatHero = random.nextInt(3);
            } while (SimpleRPG.hero_name[whatHero].equals("null"));
            if (SimpleRPG.hero_nature[whatHero].equals("Веселый")) {
                phrase = random.nextInt(funny.length);
                System.out.println(SimpleRPG.hero_name[whatHero] + funny[phrase]);
            } else if (SimpleRPG.hero_nature[whatHero].equals("Спокойный")) {
                phrase = random.nextInt(calm.length);
                System.out.println(SimpleRPG.hero_name[whatHero] + calm[phrase]);
            } else if (SimpleRPG.hero_nature[whatHero].equals("Мудрый")) {
                phrase = random.nextInt(wise.length);
                System.out.println(SimpleRPG.hero_name[whatHero] + wise[phrase]);
            } else if(SimpleRPG.hero_nature[whatHero].equals("Амбициозный")) {
                phrase = random.nextInt(ambitious.length);
                System.out.println(SimpleRPG.hero_name[whatHero] + ambitious[phrase]);
            } else if(SimpleRPG.hero_nature[whatHero].equals("Паучный")) {
                System.out.println(SimpleRPG.hero_name[whatHero] + " издает звуки *пщвоуп ползь ползь*");
            }
        }
    }
}
