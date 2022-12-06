package org.acme.infra.panache.repositories;

import io.quarkus.panache.common.Parameters;
import org.acme.data.interfaces.EmployeeRepository;
import org.acme.domain.dto.CreateEmployeeDTO;
import org.acme.domain.models.Employee;
import org.acme.infra.panache.entities.PanacheEmployee;

import javax.transaction.Transactional;

public class PanacheEmployeeRepository implements EmployeeRepository {
    private final String HQL_SELECT_BY_EMAIL =
    "SELECT employee FROM PanacheEmployee as employee WHERE employee.email = :email";
    @Override
    @Transactional
    public Employee findByEmail(String email) {
        PanacheEmployee employee =
                PanacheEmployee.find(HQL_SELECT_BY_EMAIL, Parameters.with("email", email)).firstResult();
        return employee == null ? null : employee.toEmployee();
    }

    @Override
    @Transactional
    public Employee create(CreateEmployeeDTO employee) {
        PanacheEmployee panacheEmployee = new PanacheEmployee();
        panacheEmployee.email = employee.email;
        panacheEmployee.password = employee.password;
        panacheEmployee.name = employee.name;
        panacheEmployee.persist();
        return panacheEmployee.toEmployee();
    }
}
