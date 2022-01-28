package test.java.models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorFields {
    String field;
    String error;
}
