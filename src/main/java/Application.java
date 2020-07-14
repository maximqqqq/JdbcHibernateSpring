import entity.Address;
import entity.Cars;
import entity.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.AddressRepository;
import repository.CarsRepository;
import repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        AddressRepository addressRepository = context.getBean(AddressRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        CarsRepository carsRepository = context.getBean(CarsRepository.class);


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

        addressRepository.save(address);
        employeeRepository.save(employee);
        carsRepository.save(cars);

        System.out.println("************************");
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }
}