package entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CARS")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "YEARS")
    private int years;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Cars() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Employee getEmploye() {
        return employee;
    }

    public void setEmploye(Employee employe) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return years == cars.years &&
                Objects.equals(id, cars.id) &&
                Objects.equals(model, cars.model) &&
                Objects.equals(employee, cars.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, years, employee);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", years=" + years +
                ", employee=" + employee +
                '}';
    }
}
