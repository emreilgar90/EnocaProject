package com.enoca.enocaproject.controller;

import com.enoca.enocaproject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final CompanyService companyService;
}
