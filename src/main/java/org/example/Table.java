package org.example;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private Map<Object, Map<Object, Object>> table;

    public Table() {
        this.table = new HashMap<Object, Map<Object, Object>>();
    }

    public void insertInTable(String key_x, String key_y, Object o) {
        Map<Object, Object> inner_table = new HashMap<Object, Object>();

        if (this.table.containsKey(key_x)) {
            inner_table = this.table.get(key_x);
            inner_table.put(key_y, o);
            return;
        }

        this.table.put(key_x, new HashMap<Object, Object>());

        inner_table = this.table.get(key_x);
        inner_table.put(key_y, o);

        return;
    }

    public Object getFromTable(String key_x, String key_y) {
        Map<Object, Object> inner_table = new HashMap<Object, Object>();

        if (this.table.containsKey(key_x)) {
            inner_table = this.table.get(key_x);

            return inner_table.get(key_y);
        }

        return null;
    }
}
