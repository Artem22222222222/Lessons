package DataBases;

import Exceptions.SQLEConnectionException;
import org.junit.jupiter.api.Test;

class SiteBaseTest {

    @Test
    void findAccountsByEmail() throws SQLEConnectionException {
        String s = new SiteBase().findAccountsByEmail("h");
        assert s.equals("Name: hvm" + "\n"+ "Power: 0");
    }
}