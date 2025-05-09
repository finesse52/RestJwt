package finesse52.restjwtproject.dto;

import static finesse52.restjwtproject.utils.Constants.PASSWORD_NOT_BLANK;
import static finesse52.restjwtproject.utils.Constants.PASSWORD_PATTERN;
import static finesse52.restjwtproject.utils.Constants.USERNAME_NOT_BLANK;
import static finesse52.restjwtproject.utils.Constants.USERNAME_PATTERN;

import finesse52.restjwtproject.validator.PasswordMatching;
import finesse52.restjwtproject.validator.UserExist;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Getter
@Setter
@PasswordMatching
@Valid
@Schema(description = "Entity of User")
public class UserRegistrationDto {

    @NotBlank(message = USERNAME_NOT_BLANK)
    @Pattern(regexp = USERNAME_PATTERN, message = "Incorrect username")
    @UserExist
    @Schema(description = "Username", example = "Samael")
    private String username;
    @NotBlank(message = PASSWORD_NOT_BLANK)
    @Pattern(regexp = PASSWORD_PATTERN, message = "Incorrect password")
    @Schema(description = "Password", example = "rebel")
    private String password;
    @NotBlank(message = "Enter verify password")
    @Pattern(regexp = PASSWORD_PATTERN, message = "Incorrect  verify password")
    @Schema(description = "Password", example = "rebel")
    private String verifyPassword;
}