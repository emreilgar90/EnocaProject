package com.enoca.enocaproject.controller;

import com.enoca.enocaproject.controller.model.EmployeeIndexModel;
import com.enoca.enocaproject.dto.request.CompanyRegisterRequestDto;
import com.enoca.enocaproject.dto.request.CompanyUpdateRequestDto;
import com.enoca.enocaproject.dto.request.EmployeeRegisterRequestDto;
import com.enoca.enocaproject.dto.request.EmployeeUpdateRequestDto;
import com.enoca.enocaproject.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

import static com.enoca.enocaproject.constants.EndPoints.*;


@Controller
@RequestMapping(EMPLOYEE)
@RequiredArgsConstructor
public class EmployeeMvcController {
    private final EmployeeService employeeService;

//    @GetMapping(INDEX)
//    public ModelAndView index(){
//        ModelAndView modelAndView= new ModelAndView();
//        modelAndView.setViewName("employee");
//        EmployeeIndexModel model= new EmployeeIndexModel();
//        model.setTitle("ÇALIŞAN İŞLEMLERİ");
//        model.setEmployeeProcesses(Arrays.asList("Çalışan Kaydetme", "Çalışan Silme",
//                "Çalışan Bilgi Güncelleme","Çalışan Listeleme"));
//        model.setEmployeList(employeeService.findAll());
//
//        modelAndView.addObject("model",model);
//        return modelAndView;
//    }
    @GetMapping(REGISTER)
    public ModelAndView getEmployeeRegisterPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerEmployee");
        return modelAndView;

    }
    @PostMapping(REGISTER)
    public ModelAndView save(@RequestBody @Valid EmployeeRegisterRequestDto dto){
        employeeService.register(dto);
        return new ModelAndView("redirect:registerEmployee");//successPage'e yönlendirilebilir.

    }
    @PostMapping(DELETE)
    public ModelAndView delete(@PathVariable Long id){
        employeeService.deleteById(id);
        return new ModelAndView("redirect:index");
    }
    @PostMapping(FINDALL)
    public ModelAndView getEmployeeList() {
        employeeService.findAll();
        return new ModelAndView("redirect:index");
    }
    @PostMapping(UPDATE)
    public ModelAndView updateEmployee(@RequestBody @Valid EmployeeUpdateRequestDto dto) {
        employeeService.update(dto);
        return new ModelAndView("redirect:index");
    }


}
