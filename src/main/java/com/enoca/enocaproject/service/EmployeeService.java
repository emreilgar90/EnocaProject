package com.enoca.enocaproject.service;

import com.enoca.enocaproject.dto.request.EmployeeRegisterRequestDto;
import com.enoca.enocaproject.dto.request.EmployeeUpdateRequestDto;
import com.enoca.enocaproject.mapper.IEmployeeMapper;
import com.enoca.enocaproject.repository.IEmployeeRepository;
import com.enoca.enocaproject.repository.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService  {
    private final IEmployeeRepository repository;
    public Employee register(EmployeeRegisterRequestDto dto) {
        Employee employee= IEmployeeMapper.INSTANCE.toEmployee(dto);
        return employee;
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public void update(EmployeeUpdateRequestDto dto) {
       Optional<Employee>employee= repository.findById(dto.getId());
       if(employee.isEmpty()){
           throw new RuntimeException("Id ile kayıtlı kimse yok.");
       }else {
           Employee existingEmployee= employee.get();
           existingEmployee.setName(dto.getName());
           existingEmployee.setSurName(dto.getSurName());
           existingEmployee.setEmail(dto.getEmail());
           existingEmployee.setJob(dto.getJob());
           existingEmployee.setCompany(dto.getCompany());
           repository.save(existingEmployee);
       }
    }
    public List<Employee> findAll() {
        Optional<List<Employee>> employeList= Optional.of(repository.findAll());
        return findAll();
    }
    }


