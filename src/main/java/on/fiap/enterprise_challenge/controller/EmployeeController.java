package on.fiap.enterprise_challenge.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import on.fiap.enterprise_challenge.mapper.EmployeeMapper;
import on.fiap.enterprise_challenge.request.EmployeePostRequest;
import on.fiap.enterprise_challenge.request.EmployeePutRequest;
import on.fiap.enterprise_challenge.response.EmployeeGetResponse;
import on.fiap.enterprise_challenge.response.EmployeePostResponse;
import on.fiap.enterprise_challenge.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = {"v1/employee/access-control"})
@RequiredArgsConstructor
@Log4j2
public class EmployeeController {

    private final EmployeeService service;
    private final EmployeeMapper mapper;

    @GetMapping()
    public ResponseEntity<List<EmployeeGetResponse>> getEmployeeAccessControl() {

        var employeeAccessControl = service.getEmployeeAccessControl();

        var responseList = mapper.toGetResponseList(employeeAccessControl);

        return ResponseEntity.ok(responseList);

    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeGetResponse> findById(@PathVariable Long id) {

        var employee = service.findById(id);

        var response = mapper.toGetResponse(employee);

        return ResponseEntity.ok(response);

    }

    @GetMapping("filter")
    public ResponseEntity<List<EmployeeGetResponse>> findByFirstName(@RequestParam(required = false) String firstName) {

        var employee = service.findByFirstName(firstName);

        var response = mapper.toGetResponseList(employee);

        return ResponseEntity.ok(response);

    }

    @PostMapping()
    public ResponseEntity<EmployeePostResponse> save(@RequestBody EmployeePostRequest request) {

        var employee = mapper.postToEmployee(request);

        var employeeToSave = service.save(employee);

        var response = mapper.toPostResponse(employeeToSave);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody EmployeePutRequest request) {

        var employeeToUpdate = mapper.putToEmployee(request);

        service.update(employeeToUpdate);

        return ResponseEntity.noContent().build();
    }


}
