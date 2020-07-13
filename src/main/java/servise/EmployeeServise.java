package servise;

import bl.SessionUtil;
import dao.EmployeeDAO;
import entity.Address;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServise extends SessionUtil implements EmployeeDAO {

    @Override
    public void add(Employee employee) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(employee);

        closeTransactionSession();
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROME EMPLOYEE";

        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employeeList = query.list();

        closeTransactionSession();

        return employeeList;
    }

    @Override
    public Employee getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROME EMPLOYEE WHERE ID= :id";

        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id",id);

        Employee employee = (Employee) query.getSingleResult();

        closeTransactionSession();

        return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(employee);

        closeTransactionSession();
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(employee);

        closeTransactionSession();
    }
}
