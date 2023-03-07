package raffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Toy_Lottery {
    private List<Toy> listToys = new ArrayList<>();
    private int toy_count;

    public List<Toy> getToys() {
        return listToys;
    }

    public int getToy_count() {
        System.out.println("Всего игрушек: ");
        return toy_count;
    }

    public List<Toy> add_toy_in_listToy(Toy name) {
        listToys.add(name);
        toy_count++;
        return listToys;
    }

    private List<Toy> delete_toy_in_listToy(Toy name) {
        listToys.remove(name);
        toy_count--;
        return listToys;
    }

    private void saveInFile() {
        try (FileWriter writer = new FileWriter("winner.txt", true)) {
            String text = listToys.get(0).getToy_name();
            writer.write(text + "\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println("Ошибка записи файла");
        }
    }

    public void readFile() {
        try {
            FileReader fr = new FileReader("winner.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
                reader.close();
            }

        } catch (Exception ex) {
            System.out.println("При чтении файла возникла ошибка");
        }
    }

    public void lottteryToy() {
        Scanner scan = new Scanner(System.in);
        int chance = 50;
        System.out.println("Шанс 50%");
        System.out.println("Для изменения дефолтного шанса - кнопка 1");
        System.out.println("Для сохранения дефолтного шанса - кнопка 2");
        String changeСhance = scan.next();
        if (changeСhance.equals("1")) {
            System.out.println("число от 1 до 100 - значение в процентах на победу");
            chance = scan.nextInt();
            scan.close();
        }
        if (chance >= 0 && chance <= 100) {
            Random rnd = new Random();
            int num = rnd.nextInt(100);
            if (num > chance) {
                System.out.println("Вы проиграли");
            } else if (num < chance) {
                System.out.println("Вы выйграли");
                saveInFile();
                delete_toy_in_listToy(listToys.get(0));
            }
        } else {
            System.out.println("Ошибка ввода");
        }
    }
}