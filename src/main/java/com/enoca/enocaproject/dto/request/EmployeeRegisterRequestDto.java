package com.enoca.enocaproject.dto.request;

import com.enoca.enocaproject.repository.entity.Company;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRegisterRequestDto {

    private String name;
    private String surName;
    @Email
    @NotBlank
    private String email;
    private String job;
    private Company company;
}
