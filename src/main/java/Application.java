import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Cars;
import servise.AddresServise;
import servise.EmployeeServise;
import servise.CarsServise;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) throws SQLException {
        AddresServise addresServise = new AddresServise();
        EmployeeServise employeeServise = new EmployeeServise();
        CarsServise carsServise = new CarsServise();


        Address address = new Address();
        address.setCity("Gomel");
        address.setCountry("Belorus");

        Employee employee = new Employee();
        employee.setName("Vasa");
        employee.setSurname("Pupkin");
        employee.setYears(35);
        employee.setAddress(address);

        Cars cars = new Cars();
        cars.setModel("BMW");
        cars.setYears(9);
        cars.setEmploye(employee);

        Set<Cars> cars1 = new HashSet<>();
        cars1.add(cars);
        employee.setCars(cars1);

        try {
            addresServise.add(address);
            employeeServise.add(employee);
            carsServise.add(cars);
        }catch (SQLException e){
            System.err.println("ERRORE "+e);
            e.printStackTrace();
        }

//        //get
//        Address a = addresServise.getById(1L);
//        System.out.println(a);

        HibernateUtil.shutdowm();
    }
}