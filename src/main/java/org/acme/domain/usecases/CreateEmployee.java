package org.acme.domain.usecases;

import org.acme.domain.dto.CreateEmployeeDTO;
import org.acme.domain.models.Employee;

public interface CreateEmployee {
    Employee create(CreateEmployeeDTO employee);
}
