package test.java.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {
    String title;
    String code;
    Counts counts;
}
