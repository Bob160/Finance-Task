package com.example.clientcontractor.model;

import com.example.clientcontractor.Enum.UserType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "profiles")
public class Profile extends SuperUser{

    @NotBlank(message = "Please enter your Firstname")
    private String firstName;

    @NotBlank(message = "Please enter your Lastname")
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private BigDecimal balance;

    @NotBlank(message = "Please select a role")
    private UserType userType;
}
