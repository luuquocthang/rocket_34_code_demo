package org.example.dao;

import java.util.ArrayList;

public interface IDAO<T> {
    String insert(T t);
    String update(T t);
    String delete(T t);
    String delete(int id);
    ArrayList<T> selectAll();
}
