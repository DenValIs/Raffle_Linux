package raffle;

public class Main {
    public static void main(String[] args) {
        Toy bear = new Toy(1, "Мишка");
        Toy car = new Toy(2, "Машинка");
        Toy cubes = new Toy(3, "Кубики");
        Toy lego = new Toy(4, "Лего");
        Toy balloons = new Toy(5, "Шарики");
        Toy ball = new Toy(6, "Мячики");
        Toy sword = new Toy(7, "Мечи");

        Toy_Lottery toy_lottery = new Toy_Lottery();
        toy_lottery.add_toy_in_listToy(bear);
        toy_lottery.add_toy_in_listToy(car);
        toy_lottery.add_toy_in_listToy(cubes);
        toy_lottery.add_toy_in_listToy(lego);
        toy_lottery.add_toy_in_listToy(balloons);
        toy_lottery.add_toy_in_listToy(ball);
        toy_lottery.add_toy_in_listToy(sword);

        toy_lottery.lottteryToy();
        toy_lottery.readFile();
        toy_lottery.lottteryToy();
        toy_lottery.readFile();
        toy_lottery.getToys();
        toy_lottery.getToy_count();
    }
}