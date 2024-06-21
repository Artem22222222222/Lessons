

public class PostgresConnection {

    public static void main(String[] args) {

        DataBase base = new DataBase();
        base.addPlayer(new Player("fkhky", 16, 1, 1));
        base.addCharacter(new Character("rhoils", 53571));
        base.getPlayerPurchases(2);
    }
}
