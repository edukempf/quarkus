package org.acme.data;

import org.acme.domain.employee.CreateEmployeeDTO;
import org.acme.domain.employee.Employee;

public interface EmployeeRepository {
    Employee findByEmail(String email);
    Employee create(CreateEmployeeDTO employeeDTO);
}
