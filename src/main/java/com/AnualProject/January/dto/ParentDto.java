package com.AnualProject.January.dto;


import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;


@Data
public class ParentDto {
    @NotNull
    private String fname;
   @NotNull
    private String lname;
    @Email
   @NotNull
    private String email;
 @NotNull
    private String phone;
@NotNull
    private String password;
}
