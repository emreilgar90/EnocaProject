package com.enoca.enocaproject.controller.model;

import com.enoca.enocaproject.repository.entity.Company;
import com.enoca.enocaproject.repository.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyIndexModel {

    String title;  //Şirket İşlemleri
    List<String> companyProcesses; //Yapılan İşlemler

    List<Company> companyList;
    List<Employee> employeeList;

}
