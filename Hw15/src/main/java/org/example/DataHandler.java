package org.example;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

    Map<Integer, String> map = new DataRepository().getData();

    // Метод формує виведення нумерованого переліку імен
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        map.forEach((id, name) ->
                sb.append("(" + count.incrementAndGet() + ") " +
                        id + ", " +
                        name + "\n")
        );
        return "ALL NAMES:\n" + sb;
    }

    // Метод формує виведення імені за певним id
    public String getById(int id) {
        if (map.containsKey(id)) {
            return "NAME: id " + id + ", " +
                    map.get(id);
        } else return "No data!";
    }
}
