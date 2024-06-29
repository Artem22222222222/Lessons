package Exceptions;

import java.sql.SQLException;

public class SQLEConnectionException extends SQLException{

    public SQLEConnectionException(String reason) {
        super(reason);
    }
}
