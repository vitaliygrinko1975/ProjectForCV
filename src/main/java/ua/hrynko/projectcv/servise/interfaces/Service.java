package ua.hrynko.projectcv.servise.interfaces;

import java.util.List;

public interface Service<T> {
    void save(T obj);

    void update(T obj);

    void delete(T obj);

    T getById(int id);

    List<T> getAll();
}
