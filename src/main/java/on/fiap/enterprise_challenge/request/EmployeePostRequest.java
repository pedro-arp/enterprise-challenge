package on.fiap.enterprise_challenge.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeePostRequest {
    private String firstName;
    private String lastName;
    private String position;

}
