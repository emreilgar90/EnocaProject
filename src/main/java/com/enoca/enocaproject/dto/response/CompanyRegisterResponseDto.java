package com.enoca.enocaproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyRegisterResponseDto {
    private Long id;
    private String companyName;
    private String companyAddress;
}
