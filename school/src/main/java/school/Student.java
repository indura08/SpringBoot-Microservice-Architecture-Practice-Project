package school;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private String firstName;
    private String lastName;
    private String email;
}
