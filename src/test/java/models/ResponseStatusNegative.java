package test.java.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatusNegative {
    boolean status;
    String errorMessage;
//    ErrorFields errorFields;
}
