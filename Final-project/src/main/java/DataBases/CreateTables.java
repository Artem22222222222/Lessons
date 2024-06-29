package DataBases;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    public CreateTables(){
        String sqlP = "CREATE TABLE IF NOT EXISTS players (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "level INTEGER NOT NULL, " +
                "email VARCHAR(255) NOT NULL, " +
                "character_id INTEGER NOT NULL, " +
                "account_id INTEGER NOT NULL" +
                ");";

        try (Connection conn = Connect.connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlP);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String sqlC = "CREATE TABLE IF NOT EXISTS characters (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "power INTEGER NOT NULL"+
                ");";

        try (Connection conn = Connect.connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlC);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String sqlA = "CREATE TABLE IF NOT EXISTS accounts (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "power INTEGER NOT NULL, "+
                "email VARCHAR(255) NOT NULL " +
                ");";

        try (Connection conn = Connect.connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlA);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
