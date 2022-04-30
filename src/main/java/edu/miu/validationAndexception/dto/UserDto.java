package edu.miu.validationAndexception.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserDto {
    @NotNull(message = "name should not be null")
    private String name;

    @Email(message = "Invalid Email Address")
    private String email;

    @Pattern(regexp = "\\d{10}$", message = "Invalid Phone Number")
    private String phoneNumber;
    @Min(10)
    @Max(100)
    private int age;
}
