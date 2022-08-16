package by.tms.SpringBootCalculator.dao;

import by.tms.SpringBootCalculator.entity.Operation;

import java.util.List;

public interface OperationDao<T> {
    void save(T operation);
    List<T> findAllOperationByUsername(String username);
}
