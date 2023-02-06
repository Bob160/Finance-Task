package com.example.clientcontractor.dto;

import com.example.clientcontractor.Enum.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    private String firstName;

    private String LastName;

    private String email;

    private String password;

    private UserType userType;
}
