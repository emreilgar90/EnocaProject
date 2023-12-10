package com.enoca.enocaproject.controller;

import com.enoca.enocaproject.dto.request.CompanyRegisterRequestDto;
import com.enoca.enocaproject.dto.request.CompanyUpdateRequestDto;
import com.enoca.enocaproject.repository.entity.Company;
import com.enoca.enocaproject.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.util.List;
import static com.enoca.enocaproject.constants.EndPoints.*;
@RequestMapping(COMPANY)
@RequiredArgsConstructor
@Controller
public class CompanyMvcController  {
    private final CompanyService companyService;

//    @GetMapping(INDEX)
//    public ModelAndView index(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("company");
//        CompanyIndexModel model = new CompanyIndexModel();
//        model.setTitle(" Şirket İşlemleri");
//        model.setCompanyProcesses(Arrays.asList("Şirket Ekleme","Şirket Silme","Şirket Güncelleme","Şirket Listeleme"));
//       // model.setCompanyList(companyService.findAll());
//        modelAndView.addObject("model",model);
//        return modelAndView;
//    }
    @GetMapping(REGISTER)
    public ModelAndView getCompanyRegisterPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerCompany");
        return modelAndView;
    }
    @Operation(summary = "Recording data directly through an endpoint. - Localden Veri Alıp Kaydetme")
    @PostMapping(REGISTER)
    public String registerCompany(@RequestParam("companyName") String companyName,
                                  @RequestParam("companyAddress") String companyAddress,
                                  @RequestParam("password") String password,
                                  @RequestParam("repassword") String rePassword) throws IOException {

        CompanyRegisterRequestDto dto = new CompanyRegisterRequestDto();
        dto.setCompanyName(companyName);
        dto.setCompanyAddress(companyAddress);
        dto.setPassword(password);
        dto.setRePassword(rePassword);
        companyService.register(dto);
        return "successView";
    }
    @GetMapping(FINDALL)   //"/allCompany"
    public ModelAndView getCompanyListPage() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Company> companyList = companyService.getCompanyList();
            modelAndView.setViewName("allCompany");
            modelAndView.addObject("company");
        } catch (Exception e) {
            String error = "Şirket bilgileri alınamadı.";
            modelAndView.setViewName("errorPage");
            modelAndView.addObject("errorMessage", error);
        }
        return modelAndView;
    }
    @Operation(summary = "List All Companies-Tüm Şirketleri Listele")
    @PostMapping(FINDALL)
    public ModelAndView getCompanyList() {
       companyService.findAll();
       return new ModelAndView("redirect:index");
    }
    @GetMapping(UPDATE)
    public ModelAndView getUpdateCompanyPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Company company = companyService.getCompany(id);
            modelAndView.setViewName("updateCompany");
            modelAndView.addObject("company", company);
        } catch (Exception e) {
            String error = "Şirket bilgileri alınamadı.";
            modelAndView.setViewName("errorPage");
            modelAndView.addObject("errorMessage", error);
        }
        return modelAndView;
    }
    @Operation(summary = "Update-Güncelleme")
    @PutMapping(UPDATE)
    public ModelAndView updateCompany(@PathVariable Long id,@RequestBody CompanyUpdateRequestDto dto) {
       companyService.updateCompany(id,dto);
        return new ModelAndView("redirect:index");
    }
        @GetMapping(DELETEBYID) //+
    public ModelAndView getCompanyRemovePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("companyRemove");
        return modelAndView;
    }

    @Operation(summary = "Delete-Id'ye Göre Silme")
    @DeleteMapping(DELETEBYID) //+
    public ModelAndView delete(@PathVariable Long id) {
            System.out.println("Silme işlemi çalıştı silinen id ...: "+ id);
            try{
                if(id !=null && id>0)
                    companyService.deleteById(id);
            }catch (Exception exception){
                System.out.println("hata oluştu...: "+ exception.toString());
            }
            return new ModelAndView("redirect:index");
        }

}
