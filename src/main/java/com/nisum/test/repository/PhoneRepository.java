package com.nisum.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nisum.test.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, String> {

}
