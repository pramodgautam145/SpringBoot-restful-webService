package com.example.rest.springrestws.JpaDynamicexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpostRepository extends JpaRepository<JPost, Integer>{

}
