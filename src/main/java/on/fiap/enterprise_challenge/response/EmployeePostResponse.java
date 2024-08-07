package on.fiap.enterprise_challenge.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeePostResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private String clockIn;
    private String clockOut;

}
