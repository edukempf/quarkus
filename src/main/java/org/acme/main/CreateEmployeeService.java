package org.acme.main;

import org.acme.data.BCryptAdapter;
import org.acme.data.EmployeeRepository;
import org.acme.data.Encrypter;
import org.acme.data.PanacheEmployeeRepository;
import org.acme.domain.employee.CreateEmployee;
import org.acme.domain.employee.CreateEmployeeDTO;
import org.acme.domain.employee.CreateEmployeeImpl;
import org.acme.domain.employee.Employee;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class CreateEmployeeService {

    CreateEmployee createEmployee;

    public CreateEmployeeService() {
        Encrypter encrypter = new BCryptAdapter();
        EmployeeRepository employeeRepository = new PanacheEmployeeRepository();
        this.createEmployee = new CreateEmployeeImpl(employeeRepository, encrypter);
    }

    @Transactional
    public Employee handle(CreateEmployeeDTO createEmployeeDTO) {
        return this.createEmployee.create(createEmployeeDTO);
    }
}
