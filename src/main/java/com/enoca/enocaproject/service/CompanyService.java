package com.enoca.enocaproject.service;

import com.enoca.enocaproject.dto.request.CompanyRegisterRequestDto;
import com.enoca.enocaproject.dto.request.CompanyUpdateRequestDto;

import com.enoca.enocaproject.mapper.ICompanyMapper;
import com.enoca.enocaproject.repository.ICompanyRepository;
import com.enoca.enocaproject.repository.entity.Company;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService  {
   private final ICompanyRepository repository;

    public void register(CompanyRegisterRequestDto dto) {
        if(repository.existsByCompanyName(dto.getCompanyName())) {
            throw new RuntimeException("Şirket Kaydı Mevcut !");
        } else {
            if(!dto.getPassword().equals(dto.getRePassword())) {
                throw new RuntimeException("Şifreler uyuşmuyor !");
            }
            Company company = ICompanyMapper.INSTANCE.toCompany(dto);
            repository.save(company);
        }
    }
    public void delete(@PathVariable Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else {
            throw new RuntimeException("Şirket Zaten Mevcut Değil !");
        }
    }
    public void updateCompany(Long id, CompanyUpdateRequestDto dto) {
        Optional<Company> optionalCompany = repository.findById(id);

        if (optionalCompany.isPresent()) {
            Company existingCompany = optionalCompany.get();

            existingCompany.setCompanyName(dto.getCompanyName());
            existingCompany.setCompanyAddress(dto.getCompanyAddress());
            // Şifrelerin düz metin olarak atanması yerine güvenli bir şekilde hash'lenmesi önerilir
            existingCompany.setPassword(hashFunction(dto.getPassword())); // Örnek bir hash fonksiyonu kullanıldı
            existingCompany.setRePassword(hashFunction(dto.getRePassword())); // Örnek bir hash fonksiyonu kullanıldı

            repository.save(existingCompany);
        } else {
            throw new RuntimeException("Şirket bulunamadı, güncellenemedi.");
        }
    }

    private Long hashFunction(Long password) {
        return password;
    }

    public List<Company> getCompanyList(){
        Optional<List<Company>> companyList= Optional.of(repository.findAll());
        return getCompanyList();
    }
       public Company getCompanyByName(String companyName) {
    Optional<Company> company= Optional.ofNullable(repository.findByCompanyName(companyName));
        if(company.isPresent()){
            return company.get();
        }else {
            return null;
        }
    }
        public void findAll() {
        List<Company> companyList=repository.findAll();
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public Company getCompany(Long id){
        Optional<Company> company= repository.findById(id);
        return company.get();
    }
 }

