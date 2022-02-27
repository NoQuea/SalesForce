package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Opportunities {
    String opportunityName;
    String accountName;
    String closeDate;
    String stage;
    String nextStep;
}
