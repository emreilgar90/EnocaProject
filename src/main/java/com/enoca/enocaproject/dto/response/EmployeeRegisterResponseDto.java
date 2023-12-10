package com.enoca.enocaproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRegisterResponseDto {
    private Long id;
    private String name;
    private String surName;
    private String email;
}
