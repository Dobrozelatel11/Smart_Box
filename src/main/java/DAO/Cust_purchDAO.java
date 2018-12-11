package DAO;

import entity.Cust_purch;

import java.sql.SQLException;
import java.util.List;

public interface Cust_purchDAO {
    void add(Cust_purch cp) throws SQLException;

    List<Cust_purch> getAll() throws SQLException;
    Cust_purch getByID(int cust_id, int purch_id) throws SQLException;

    void update(Cust_purch cp) throws SQLException;

    void delete(Cust_purch cp) throws SQLException;
}
