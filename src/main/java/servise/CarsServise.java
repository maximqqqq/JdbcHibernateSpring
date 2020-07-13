package servise;

import bl.SessionUtil;
import dao.CarsDAO;
import entity.Cars;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CarsServise extends SessionUtil implements CarsDAO {
    @Override
    public void add(Cars cars) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(cars);

        closeTransactionSession();
    }

    @Override
    public List<Cars> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROME PETS";

        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Cars.class);
        List<Cars> carsList = query.list();

        closeTransactionSession();

        return carsList;
    }

    @Override
    public Cars getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROME PETS WHERE ID= :id";

        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Cars.class);
        query.setParameter("id", id);

        Cars cars = (Cars) query.getSingleResult();

        closeTransactionSession();

        return cars;
    }

    @Override
    public void update(Cars cars) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(cars);

        closeTransactionSession();
    }

    @Override
    public void delete(Cars cars) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(cars);

        closeTransactionSession();
    }
}
