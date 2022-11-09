//import javax.swing.*;
//import java.awt.*;

import java.io.*;
import java.util.HashMap;
import java.util.Random;

//import com.github.dhiraj072.randomwordgenerator.RandomWordGenerator;
//import com.github.dhiraj072.randomwordgenerator.datamuse.WordsRequest;
//import com.github.dhiraj072.randomwordgenerator.datamuse.DataMuseRequest;
//import com.github.dhiraj072.randomwordgenerator.exceptions.DataMuseException;


class Scratch {

    public static String green = "\u001B[32m";
    public static String reset = "\u001B[0m";
    public static String red = "\u001B[31m";
    public static String n = "\n";

    public static void main(String[] args) throws IOException {
        menu();

//        JFrame a = new JFrame("example");
//        JButton b = new JButton("Play");
//        b.setBounds(100,90,85,20);
//        a.add(b);
//        a.setSize(300,300);
//        a.setLayout(null);
//        a.setVisible(true);
//
//
//
//        JFrame frame = new JFrame("Game");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 400);
//        JMenuBar ob = new JMenuBar();
//        JMenu ob1 = new JMenu("FILE");
//        JMenu ob2 = new JMenu("Help");
//        ob.add(ob1);
//        ob.add(ob2);
//        JMenuItem m11 = new JMenuItem("Open");
//        JMenuItem m22 = new JMenuItem("Save as");
//        ob1.add(m11);
//        ob1.add(m22);
//
//        JPanel panel = new JPanel(); // the panel is not visible in output
//        JLabel label = new JLabel("Enter Text");
//        JTextField tf = new JTextField(10); // accepts upto 10 characters
//        JButton send = new JButton("Send");
//        JButton reset = new JButton("Reset");
//        panel.add(label); // Components Added using Flow Layout
//        panel.add(label); // Components Added using Flow Layout
//        panel.add(tf);
//        panel.add(send);
//        panel.add(reset);
//        JTextArea ta = new JTextArea();
//        frame.getContentPane().add(BorderLayout.SOUTH, panel);
//        frame.getContentPane().add(BorderLayout.NORTH, tf);
//        frame.getContentPane().add(BorderLayout.CENTER, ta);
//        frame.setVisible(true);

    }

    public static void menu() throws IOException {

        String inputFileName = "C:\\Users\\tonni\\AppData\\Roaming\\JetBrains\\IdeaIC2022.2\\scratches\\settings.txt";
        BufferedReader settingsReader = new BufferedReader(new FileReader(inputFileName));
        String line;
        int difficult = 2;
        while ((line = settingsReader.readLine()) != null) {
            difficult = Integer.parseInt(line);
        }

        System.out.println(
                "    " + "Меню:" + n
                        + green + "1." + reset + "Начать" + n
                        + green + "2." + reset + "Настойки" + n
                        + green + "3." + reset + "Рекорды" + n
        );

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ввод: ");

        int select = Integer.parseInt(reader.readLine());

        clear();


        switch (select) {
            case (1) -> game(difficult);
            case (2) -> settings(difficult);
            case (3) -> records();
        }

    }

    public static void clear() {

        int clr = 0;

        do{
            System.out.println(" ");
            clr++;
        } while(clr <= 10);
    }


    public static void game(int difficult) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Get a random word skewed towards topics "Car" and "Road"
//        WordsRequest customRequest = new DataMuseRequest().topics("Car", "Road");
//        String randomWord = RandomWordGenerator.getRandomWord(customRequest);
//
//        System.out.println(randomWord);


        clear();

        int score = 0;

        int tryings;

        Random random = new Random();
        int randomTheme = random.nextInt(7) + 1;
        int rnd;
        int falseTryings = 0;
        String wordNS = "ВОЛШЕБНИК";

        if(difficult == 1) {

            if(randomTheme == 1) { // Eда
                String[] wordNSm = {"ПЕЧЕНЬЕ", "МОЛОКО", "ТОРТ", "МОРОЖЕНОЕ"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else if(randomTheme == 2) { // Водные обитатели
                String[] wordNSm = {"ИГЛОБРЮХ", "САРДИНА", "ЩУКА", "КАРАСЬ"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else if(randomTheme == 3) { // Животные
                String[] wordNSm = {"КРОТ", "СОВА", "ЯСТРЕБ", "ОЛЕНЬ"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else if(randomTheme == 4) { // Транспорт
                String[] wordNSm = {"КАТЕР", "ЯХТА", "АВТОБУС", "САМОЛЕТ"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else if (randomTheme == 5) { // Черты характера
                String[] wordNSm = {"ЗЛОСТЬ", "ГРУБОСТЬ", "ДОБРОТА", "СМЕЛОСТЬ"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else if (randomTheme == 6) { // Природные явления
                String[] wordNSm = {"ШТОРМ", "СНЕГОПАД", "ДОЖДЬ", "ГРОЗА"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else { // Профессии
                String[] wordNSm = {"БУХГАЛТЕР", "ЮРИСТ", "ВОЕННЫЙ", "ПРОГРАММИСТ"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            }

        } else if (difficult == 2) {
            if(randomTheme == 1) { // Eда
                String[] wordNSm = {"СМОРОДИНА", "БИФШТЕКС", "АНТРЕКОТ", "БАСТУРМА"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else if(randomTheme == 2) { // Водные обитатели
                String[] wordNSm = {"ИХТИОЗАВР", "ПОЛОСАТИК", "БЕЛОБОЧКА", "СПЕРМАЦЕТ"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else if(randomTheme == 3) { // Животные
                String[] wordNSm = {"ГИППОПОТАМ", "ГИСТОЛОГИЯ", "СКОТОБОЙНЯ", "ТРАВОЯДНЫЕ"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else if(randomTheme == 4) { // Транспорт
                String[] wordNSm = {"ВУЛКАНИЗАТ", "ТРАМВАЙЩИК", "ВЕЛОКАМЕРА", "КОНТРОЛЛЕР"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else if (randomTheme == 5) { // Черты характера
                String[] wordNSm = {"АВАНТЮРИЗМ", "АЗАРТНОСТЬ", "БЕССТРАШИЕ", "ДУШЕВНОСТЬ"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else if (randomTheme == 6) { // Явления
                String[] wordNSm = {"АБСТРАКЦИЯ", "АНТИСЕЛЕНА", "АНТИЦИКЛОН", "АЭРОМАНТИЯ"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            } else { // Профессии
                String[] wordNSm = {"ТРАКТОРИСТ", "АРХИТЕКТОР", "УКРОТИТЕЛЬ", "ДЕМЬЯНЕНКО"};
                rnd = random.nextInt(wordNSm.length);
                wordNS = wordNSm[rnd];
            }
        }

        String[] word = wordNS.split("");
        String[] symbols = new String[word.length];
        if(difficult == 1) {
            tryings = symbols.length + 10;
        } else if (difficult == 2) {
            tryings = symbols.length + 5;
        } else {
            tryings = symbols.length + 3;
        }
        for(int i = 0; i < word.length; i++) {
            symbols[i] = "_";
        }
        int nice = 0;
        StringBuilder visible = new StringBuilder();
        String[] c = {reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset, reset};
        String vis = visible.toString();
        String[] visMass = vis.split("");

        HashMap<String, Integer> letters = new HashMap<>();
        letters.put("А", 0); letters.put("Б", 1); letters.put("В", 2); letters.put("Г", 3); letters.put("Д", 4); letters.put("Е", 5); letters.put("Ё", 6); letters.put("Ж", 7); letters.put("З", 8); letters.put("И", 9); letters.put("Й", 10); letters.put("К", 11); letters.put("Л", 12); letters.put("М", 13); letters.put("Н", 14); letters.put("О", 15); letters.put("П", 16); letters.put("Р", 17); letters.put("С", 18); letters.put("Т", 19); letters.put("У", 20); letters.put("Ф", 21); letters.put("Х", 22); letters.put("Ц", 23); letters.put("Ч", 24); letters.put("Ш", 25); letters.put("Щ", 26); letters.put("Ъ", 27); letters.put("Ы", 28); letters.put("Ь", 29); letters.put("Э", 30); letters.put("Ю", 31); letters.put("Я", 32);

        for(int g = 0; g <= tryings; g++) {

            if(randomTheme == 1) {
                System.out.println("Тема: Еда");
            } else if(randomTheme == 2) {
                System.out.println("Тема: Водные обитатели");
            } else if(randomTheme == 3) {
                System.out.println("Тема: Животные");
            } else if(randomTheme == 4) {
                System.out.println("Тема: Транспорт");
            } else if(randomTheme == 5) {
                System.out.println("Тема: Черты характера");
            } else if (randomTheme == 6) {
                System.out.println("Тема: Явления");
            } else if (randomTheme == 7) {
                System.out.println("Тема: Профессии");
            }

            for(int i = 0; i < word.length; i++) {
                for(int b = 0; b < visMass.length; b++) {
                    if (visMass[b].equals(symbols[b])) {
                        symbols[b] = word[b];
                    }
                }
            }
            StringBuilder wordPanel = new StringBuilder();
            for (String symbol : symbols) {
                wordPanel.append(symbol);
            }

            System.out.println(
                    "    " + "Виселица:           " + "Баллы: " + score + n
                            + "Осталось: " + (word.length - nice) + " " + "из " + word.length + n
                            + "Попыток: " + (tryings - g) + " " + "из " + tryings + n
                            + green + "   " + wordPanel + n
                            + c[0] + "А " + c[1] + "Б " + c[2] + "В " + c[3] + "Г " + c[4] + "Д " + c[5] + "Е " + c[6] + "Ё " + c[7] + "Ж " + c[8] + "З " + n
                            + c[9] + "И " + c[10] + "Й " + c[11] + "К " + c[12] + "Л " + c[13] + "М " + c[14] + "Н " + c[15] + "О " + c[16] + "П " + c[17] + "Р " + n
                            + c[18] + "С " + c[19] + "Т " + c[20] + "У " + c[21] + "Ф " + c[22] + "Х " + c[23] + "Ц " + c[24] + "Ч " + c[25] + "Ш " + c[26] + "Щ " + n
                            + c[27] + "   Ъ" + c[28] + " Ы " + c[29] + "Ь " + c[30] + "Э " + c[31] + "Ю " + c[32] + "Я" + n + reset
                            + n + "Подсказка: !" + n
                            + "(Подсказки стоят 3 попытки.)"
            );

            System.out.print("Ввод: ");
            String input = reader.readLine();
            String[] select = input.split("");
            int rightS = 0;
            int num = 0;
            for(int i = 0; i < symbols.length; i++) {
                if(select[0].equals(word[i])) {
                    symbols[i] = word[i];
                    rightS = 1;
                    num++;
                    score++;
                }
            }
            if(select.length >= 2) {
                System.out.println("Ввод по одной букве.");
            } else if(rightS == 1) {
                nice += num;

                if(nice >= word.length) {
                    clear();
                    g = tryings;
                    visible.append(input);
                    System.out.println("Поздравляю! Ты отгадал слово " + wordNS + "!");
                    double scoreIn = (100 / word.length) * (score - (falseTryings / 2));
                    float scores = (float)scoreIn;
                    System.out.println("Ваш процент:" + "   " + score + " " + scores);
//                    try {
//                        File file = new File("C:\\Users\\tonni\\AppData\\Roaming\\JetBrains\\IdeaIC2022.2\\scratches\\settings.txt");
//                        FileOutputStream fileOutputStream = new FileOutputStream(file);
//                        String diff = "" + difficult + "\n";
//                        fileOutputStream.write(diff.getBytes());
//                        fileOutputStream.write(name.getBytes());
//                        fileOutputStream.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                } else {
                    clear();
                    System.out.println(green + "Ты угадал букву :)" + reset);
                    int letter = letters.get(input);
                    c[letter] = green;
                    int a = 0;

                    visible.append(input);
                }

            } else if(select[0].equals("!")) {

                clear();
                g += 2;
                symbols[nice] = word[nice];
                visible.append(word[nice]);
                nice++;
                for(int r = 0; r < 29; r++) {

                    c[r] = reset;

                }
                if(score >= 1) {
                    score--;
                }



                System.out.println("У вас осталось: " + (tryings - g - 1) + " попыток");
                if(tryings - g - 1 == 0) {
                    clear();
                    System.out.println("Вы проиграли!");
                    float scoreIn = (word.length / 100 * 1) * score;
                    System.out.println("Ваш процент:" + scoreIn);
                    menu();
                }

            } else {
                clear();
                int letter = letters.get(input);
                c[letter] = red;
                System.out.println(red + "�Ты не угадал! У тебя осталось: " + (tryings - g - 1) + " попыток" + reset);
                if (score == 0) {
                    falseTryings++;
                }
                if(score >= 1) {
                    score--;
                }
                if(tryings - g - 1 == 0) {
                    clear();
                    System.out.println("Ты проиграл!");
                    double scoreIn = (word.length / 100 * 1) * score;
                    float scores = (float)scoreIn;
                    System.out.println("Ваш процент:" + scores);
                    menu();
                }
            }
        }
        menu();

    }

    public static void settings(int difficult) throws IOException {

        String difficultName = "Не поставлено";

        for(int i = 0; i < 30; i++) {
            clear();

            switch (difficult) {
                case (1) -> difficultName = "Легко";
                case (2) -> difficultName = "Нормально";
                case (3) -> difficultName = "Сложно";
            }
            System.out.println(
                    "    " + "Настройки:" + n
                            + green + "1." + reset + "[Сложность]" + "   | " + difficultName + n
                            + green + "2." + reset + "[Четотам]" + n
                            + green + "3." + reset + "[Вернуться]" + n
            );

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Ввод: ");

            int select = Integer.parseInt(reader.readLine());

            if (select == 1) {
                clear();
                System.out.println(
                        "    " + "Выберите сложность:" + n
                                + green + "1." + reset + "Легко" + n
                                + green + "2." + reset + "Нормально" + n
                                + green + "3." + reset + "Сложно" + n
                );
                System.out.print("Ввод: ");

                String diffS = reader.readLine();

                int diff = Integer.parseInt(diffS);

                try {
                    File file = new File("C:\\Users\\tonni\\AppData\\Roaming\\JetBrains\\IdeaIC2022.2\\scratches\\settings.txt");
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(diffS.getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                switch (diff) {
                    case (1) -> difficult = 1;
                    case (2) -> difficult = 2;
                    case (3) -> difficult = 3;
                }
            } else if(select == 3) {

                clear();
                menu();

            }

        }

    }

    public static void records() {

        System.out.println("Скоро...");


    }
}


// String[] name = new String[x];