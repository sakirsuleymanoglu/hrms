package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.LinkedinAccount;

public interface LinkedinAccountDao extends JpaRepository<LinkedinAccount, Integer> {

}
