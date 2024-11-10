package gr.aueb.cf.springauthsession5.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterTeacherDTO {
    //Bean Validation

    //User model
    @NotNull
    @Size(min = 3, max = 32)
    private String username;

    @Pattern(regexp = "^.{4,}$")
    private String password;

    //Teacher model
    @NotNull
    @Size(min = 3, max = 32)
    private String firstname;

    @NotNull
    @Size(min = 3, max = 32)
    private String lastname;
}
