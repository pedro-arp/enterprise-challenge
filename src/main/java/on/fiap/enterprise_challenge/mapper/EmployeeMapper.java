package on.fiap.enterprise_challenge.mapper;

import on.fiap.enterprise_challenge.domain.Employee;
import on.fiap.enterprise_challenge.request.EmployeePostRequest;
import on.fiap.enterprise_challenge.request.EmployeePutRequest;
import on.fiap.enterprise_challenge.response.EmployeeGetResponse;
import on.fiap.enterprise_challenge.response.EmployeePostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    List<EmployeeGetResponse> toGetResponseList(List<Employee> employee);

    EmployeeGetResponse toGetResponse(Employee employee);

    Employee postToEmployee(EmployeePostRequest request);
    EmployeePostResponse toPostResponse(Employee employee);

    Employee putToEmployee(EmployeePutRequest request);



}
