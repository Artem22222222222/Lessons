

import java.util.Base64;

public interface Icontroler {
    //src3.Model це аналіз програми у функціях -- лише взаємодія з функціями
    //функції виликаються з src3.UI та звертаються до src3.Model
    String toString();
    //зберігання данних
    void save();
}
