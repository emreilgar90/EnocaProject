package com.enoca.enocaproject.controller;

import com.enoca.enocaproject.dto.request.CompanyRegisterRequestDto;
import com.enoca.enocaproject.dto.request.CompanyUpdateRequestDto;
import com.enoca.enocaproject.repository.entity.Company;
import com.enoca.enocaproject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    @GetMapping("/companyRegister")
    public ModelAndView getCompanyRegisterPage(){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("companyRegister");
    return modelAndView;

    }
    @PostMapping("/companyRegister")
    public ModelAndView companyRegister(CompanyRegisterRequestDto dto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            companyService.companyRegister(dto);
            modelAndView.setViewName("successPage"); // Başarılı olunduğunda yönlendirilecek sayfa
            modelAndView.addObject("successMessage", "Kayıt başarıyla tamamlandı!"); // Başarı mesajı

        } catch (Exception e) {
            String error = e.getMessage();
            modelAndView.setViewName("companyRegister");
            modelAndView.addObject("errorMessage", error); // Hata mesajı
        }

        return modelAndView;
    }

    /******************************************************************************************************************/

    @GetMapping("/companyRemove")
    public ModelAndView getCompanyRemovePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("companyRemove");
        return modelAndView;

    }
    @DeleteMapping("/deleteCompany/{companyId}")
    public ModelAndView deleteCompany(@PathVariable Long companyId) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            companyService.deleteCompany(companyId);
            modelAndView.setViewName("Hoşçakalın :( sayfası"); // Başarılı olunduğunda yönlendirilecek sayfa
            modelAndView.addObject("successMessage", "Şirket başarıyla silindi!"); // Başarı mesajı
        } catch (Exception e) {
            String error = "Şirket silinirken bir hata oluştu.";
            modelAndView.setViewName("errorPage");
            modelAndView.addObject("errorMessage", error); // Hata mesajı
        }

        return modelAndView;
    }

    /******************************************************************************************************************/

    @GetMapping("/updateCompany/{companyName}")
    public ModelAndView getUpdateCompanyPage(@PathVariable String companyName) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Company company = companyService.getCompanyByName(companyName);
            modelAndView.setViewName("updateCompany");
            modelAndView.addObject("company", company);
        } catch (Exception e) {
            String error = "Şirket bilgileri alınamadı.";
            modelAndView.setViewName("errorPage");
            modelAndView.addObject("errorMessage", error);
        }
        return modelAndView;
    }

    @PostMapping("/updateCompany")
    public ModelAndView updateCompany(CompanyUpdateRequestDto dto) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            companyService.updateCompany(dto);
            modelAndView.setViewName("successPage"); // Başarılı olunduğunda yönlendirilecek sayfa
            modelAndView.addObject("successMessage", "Şirket bilgileri başarıyla güncellendi!"); // Başarı mesajı
        } catch (Exception e) {
            String error = e.getMessage();
            modelAndView.setViewName("updateCompany");
            modelAndView.addObject("errorMessage", error); // Hata mesajı
        }

        return modelAndView;
    }
    /******************************************************************************************************************/

    @GetMapping("/allCompany")
    public ModelAndView getCompanyListPage() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Company>companyList = companyService.getCompanyList();
            modelAndView.setViewName("allCompany");
            modelAndView.addObject("company");
        } catch (Exception e) {
            String error = "Şirket bilgileri alınamadı.";
            modelAndView.setViewName("errorPage");
            modelAndView.addObject("errorMessage", error);
        }
        return modelAndView;
    }

    @PostMapping("/allCompany")
    public ModelAndView getCompanyList() {
        ModelAndView modelAndView = new ModelAndView();

        try {
            companyService.getCompanyList();
            modelAndView.setViewName("successPage"); // Başarılı olunduğunda yönlendirilecek sayfa
            modelAndView.addObject("successMessage", "Şirket bilgileri başarıyla güncellendi!"); // Başarı mesajı
        } catch (Exception e) {
            String error = e.getMessage();
            modelAndView.setViewName("allCompany");
            modelAndView.addObject("errorMessage", error); // Hata mesajı
        }

        return modelAndView;
    }

}
