package DAO;

import entity.Purchases;


import java.sql.SQLException;
import java.util.List;

public interface PurchasesDAO {
    void add(Purchases purch) throws SQLException;

    List<Purchases> getAll() throws SQLException;
    Purchases getByID(int id) throws SQLException;

    void update(Purchases purch) throws SQLException;

    void delete(Purchases purch) throws SQLException;
}
