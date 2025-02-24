package ge.bacho.students.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
    public String errorCode;
    public String errorMessage;
}
