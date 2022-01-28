package test.java.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Counts {
    int cases;
    int suites;
    int milestones;
}
