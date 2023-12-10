package com.enoca.enocaproject.mapper;

import com.enoca.enocaproject.dto.request.CompanyUpdateRequestDto;
import com.enoca.enocaproject.dto.request.EmployeeRegisterRequestDto;
import com.enoca.enocaproject.dto.request.EmployeeUpdateRequestDto;
import com.enoca.enocaproject.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface IEmployeeMapper {
    IEmployeeMapper INSTANCE= Mappers.getMapper(IEmployeeMapper.class);

    Employee toEmployee(final EmployeeRegisterRequestDto dto);

    Employee toEmployee(final EmployeeUpdateRequestDto dto);

}
