package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.LangTechno;

public interface LangTechnoDao extends JpaRepository<LangTechno, Integer> {

}
