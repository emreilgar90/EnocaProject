package com.enoca.enocaproject.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyRegisterRequestDto {

    private String companyName;
    private String companyAddress;
    @NotNull
    //@Size(min =3, max =20,message = "Şifre en az 3 maksimum 32 karakter olmalıdır.")
    private String password;
    @NotNull
    //@Size(min =3, max =20,message = "Şifre en az 3 maksimum 32 karakter olmalıdır.")
    private String rePassword;


}
