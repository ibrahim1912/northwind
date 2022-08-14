package com.etiya.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
