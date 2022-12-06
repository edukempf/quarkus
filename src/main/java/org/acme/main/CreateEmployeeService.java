package org.acme.main;

import org.acme.infra.util.BCryptAdapter;
import org.acme.data.interfaces.EmployeeRepository;
import org.acme.data.interfaces.Encrypter;
import org.acme.infra.panache.repositories.PanacheEmployeeRepository;
import org.acme.domain.usecases.CreateEmployee;
import org.acme.domain.dto.CreateEmployeeDTO;
import org.acme.data.usecases.CreateEmployeeImpl;
import org.acme.domain.models.Employee;

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
