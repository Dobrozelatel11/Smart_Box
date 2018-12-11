package DAO;

import entity.Shops;

import java.sql.SQLException;
import java.util.List;

public interface ShopsDAO {
    void add(Shops shop) throws SQLException;

    List<Shops> getAll() throws SQLException;
    Shops getByID(int id) throws SQLException;

    void update(Shops shop) throws SQLException;

    void delete(Shops shop) throws SQLException;


}
