package dao;

import entity.Address;
import entity.Cars;

import java.sql.SQLException;
import java.util.List;

public interface CarsDAO {

    void add(Cars cars) throws SQLException;

    List<Cars> getAll() throws SQLException;

    Cars getById(Long id) throws SQLException;

    void update(Cars cars) throws SQLException;

    void delete(Cars cars) throws SQLException;

}
