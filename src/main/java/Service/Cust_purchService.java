package Service;

import DAO.Cust_purchDAO;
import Logic.Util;
import entity.Cust_purch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cust_purchService extends Util implements Cust_purchDAO {


    private Connection con = getConnection();
    @Override
    public void add(Cust_purch cp) throws SQLException {
        PreparedStatement ps = null;

        String rq = "INSERT INTO cust_purch (id_purchase, id_customer) VALUES(?, ?)";

        try {
            ps = con.prepareStatement(rq);

            ps.setLong(1, cp.getId_purchase());
            ps.setLong(2, cp.getId_customer());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }

    @Override
    public List<Cust_purch> getAll() throws SQLException {
        List<Cust_purch> cplist = new ArrayList<>();

        String sql = "SELECT id_purchase, id_customer FROM cust_purch";

        Statement st = null;
        try {
            st = con.createStatement();

            ResultSet resultSet = st.executeQuery(sql);

            while (resultSet.next()) {
                Cust_purch cp = new Cust_purch();
                cp.setId_purchase(resultSet.getInt("id_purchase"));
                cp.setId_customer(resultSet.getInt("id_customer"));

                cplist.add(cp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return cplist;
    }

    @Override
    public Cust_purch getByID(int cust_id, int purch_id) throws SQLException {
        PreparedStatement ps = null;

        String sql = "SELECT id_purchase, id_customer FROM cust_purch WHERE id_purchase=? AND id_customer=?";
        Cust_purch cp = new Cust_purch();
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, purch_id);
            ps.setLong(2, cust_id);

            ResultSet resultSet = ps.executeQuery();

            cp.setId_purchase(resultSet.getInt("id_purchase"));
            cp.setId_customer(resultSet.getInt("id_customer"));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return cp;
    }

    @Override
    public void update(Cust_purch cp) throws SQLException {
        PreparedStatement ps = null;

        String rq = "UPDATE cust_purch SET id_customer=?, id_purchase=?";

        try {
            ps = con.prepareStatement(rq);

            ps.setInt(1, cp.getId_customer());
            ps.setInt(2, cp.getId_purchase());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }

    @Override
    public void delete(Cust_purch cp) throws SQLException {
        PreparedStatement ps = null;

        String sql = "DELETE FROM cust_purch WHERE id_customer=? AND id_purchase=?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, cp.getId_customer());
            ps.setLong(2, cp.getId_purchase());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }
}
