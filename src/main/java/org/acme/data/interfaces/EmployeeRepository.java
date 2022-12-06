package org.acme.data.interfaces;

import org.acme.domain.dto.CreateEmployeeDTO;
import org.acme.domain.models.Employee;

public interface EmployeeRepository {
    Employee findByEmail(String email);
    Employee create(CreateEmployeeDTO employeeDTO);
}
