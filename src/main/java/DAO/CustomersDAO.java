package DAO;

import entity.Customers;

import java.sql.SQLException;
import java.util.List;

public interface CustomersDAO {
    void add(Customers cust) throws SQLException;

    List<Customers> getAll() throws SQLException;
    Customers getByID(int id) throws SQLException;

    void update(Customers cust) throws SQLException;

    void delete(Customers cust) throws SQLException;
}
