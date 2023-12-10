package com.enoca.enocaproject.repository;

import com.enoca.enocaproject.repository.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {


    Company findByCompanyName(String companyName);
    Boolean existsByCompanyName(String companyName);
    boolean existsById(Long id);

    void deleteById(Long id);
}
