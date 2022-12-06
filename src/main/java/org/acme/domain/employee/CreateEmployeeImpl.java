package org.acme.domain.employee;

import org.acme.data.EmployeeRepository;
import org.acme.data.Encrypter;

import javax.transaction.Transactional;

public class CreateEmployeeImpl implements CreateEmployee{
    private EmployeeRepository employeeRepository;
    private Encrypter encrypter;

    public CreateEmployeeImpl(EmployeeRepository employeeRepository, Encrypter encrypter) {
        this.employeeRepository = employeeRepository;
        this.encrypter = encrypter;
    }

    @Override
    @Transactional
    public Employee create(CreateEmployeeDTO employeeDTO) {
        Employee employee = this.employeeRepository.findByEmail(employeeDTO.email);
        if(employee != null) {
            throw new RuntimeException("User alredy exists");
        }

        employeeDTO.password = this.encrypter.hash(employeeDTO.password);

        return this.employeeRepository.create(employeeDTO);
    }
}
