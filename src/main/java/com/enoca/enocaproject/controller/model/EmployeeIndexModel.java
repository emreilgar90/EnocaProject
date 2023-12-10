package com.enoca.enocaproject.controller.model;

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
public class EmployeeIndexModel {

    String title;
    List<String> employeeProcesses;
    List<Employee> employeList;
}
