package finesse52.restjwtproject.controller;

import static finesse52.restjwtproject.utils.Constants.USER;
import static finesse52.restjwtproject.utils.ResponseUtils.CREATION_MESSAGE;
import static finesse52.restjwtproject.utils.ResponseUtils.getSuccessResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import finesse52.restjwtproject.dto.BaseResponse;
import finesse52.restjwtproject.dto.ErrorValidatorResponse;
import finesse52.restjwtproject.dto.ExceptionResponse;
import finesse52.restjwtproject.dto.JwtRequest;
import finesse52.restjwtproject.dto.JwtResponse;
import finesse52.restjwtproject.dto.SuccessResponse;
import finesse52.restjwtproject.dto.UserRegistrationDto;
import finesse52.restjwtproject.service.AuthService;
import finesse52.restjwtproject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth", description = "User`s management API")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @Operation(
            summary = "Create user token",
            description = "Get a jwt-token by credentials. The response is jwt-token",
            tags = "post"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = JwtRequest.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = ErrorValidatorResponse.class)), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)})})
    @PostMapping
    public ResponseEntity<JwtResponse> createAuthToken(@RequestBody @Valid JwtRequest request) throws BadCredentialsException {
        String token = authService.getToken(request);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @Operation(
            summary = "Create new user",
            description = "Create new user. The response is a message about the successful creation of a user",
            tags = "post"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = SuccessResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = ErrorValidatorResponse.class)), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)})})
    @PostMapping("/registration")
    public ResponseEntity<BaseResponse> createNewUser(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return ResponseEntity.ok(getSuccessResponse(CREATION_MESSAGE, USER));
    }
}