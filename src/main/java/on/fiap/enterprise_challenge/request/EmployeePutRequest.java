package on.fiap.enterprise_challenge.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeePutRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private String clockIn;

}
