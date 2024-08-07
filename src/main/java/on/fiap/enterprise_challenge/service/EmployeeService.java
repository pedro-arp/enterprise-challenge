package on.fiap.enterprise_challenge.service;

import lombok.RequiredArgsConstructor;
import on.fiap.enterprise_challenge.domain.Employee;
import on.fiap.enterprise_challenge.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private static final String NOW_FORMATTED = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm").format(LocalDateTime.now());

    private final EmployeeRepository repository;

    public List<Employee> getEmployeeAccessControl() {
        return repository.findAll();
    }

    public Employee findById(Long id) {

        return repository.findById(id).orElseThrow(RuntimeException::new);

    }

    public List<Employee> findByFirstName(String firstName) {

        return repository.findByFirstName(firstName).orElseThrow(RuntimeException::new);

    }

    public Employee save(Employee employee) {

        employee.setClockIn(NOW_FORMATTED);
        employee.setClockOut("Aguardando registro de saída...");
        return repository.save(employee);
    }

    public void delete(Long id) {

        var employee = findById(id);

        repository.delete(employee);
    }

    public void update(Employee employeeToUpdate) {

        employeeToUpdate.setClockOut(NOW_FORMATTED);

        repository.save(employeeToUpdate);

    }


}
