package ua.hrynko.projectcv.db.dao.interfaces;

import java.util.List;

public interface AbstractDAO<T> {
    void save(T obj);

    void update(T obj);

    void delete(T obj);

    T getById(int id);

    List<T> getAll();
}
