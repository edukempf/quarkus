package org.acme.presentation;

import org.acme.domain.dto.CreateEmployeeDTO;
import org.acme.domain.models.Employee;
import org.acme.main.CreateEmployeeService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CreateEmployeeResource {
    @Inject
    CreateEmployeeService createEmployeeService;
    @POST
    public Employee handle(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        return createEmployeeService.handle(createEmployeeDTO);
    }
}
