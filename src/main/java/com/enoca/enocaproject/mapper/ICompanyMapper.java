package com.enoca.enocaproject.mapper;

import com.enoca.enocaproject.dto.request.CompanyRegisterRequestDto;
import com.enoca.enocaproject.dto.request.CompanyUpdateRequestDto;
import com.enoca.enocaproject.dto.response.CompanyRegisterResponseDto;
import com.enoca.enocaproject.repository.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompanyMapper {
    ICompanyMapper INSTANCE= Mappers.getMapper(ICompanyMapper.class);
    Company toCompany(final CompanyRegisterRequestDto dto);



    CompanyRegisterResponseDto toCompanyRegisterResponseDto(final Company company);

    Company toCompany(final CompanyUpdateRequestDto dto);
}
