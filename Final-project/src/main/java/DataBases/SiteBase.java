package DataBases;

import Exceptions.SQLEConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SiteBase {
    ResultSet rs;

    public String findAccountsByEmail(String email) throws SQLEConnectionException {
        String answer = "";
        String SQL = "SELECT name, power " +
                "FROM base.public.accounts a " +
                "WHERE a.email = ?;";

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                answer += "Name: " + rs.getString("name") + "\n";
                answer += "Power: " + rs.getInt("power");
            } else {
                answer = "Account not found";
            }

        } catch (SQLException e) {
            answer = "A server error has occurred";
            throw new SQLEConnectionException(answer);
        }

        return answer;
    }
}