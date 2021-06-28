package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.GithubAccount;

public interface GithubAccountDao extends JpaRepository<GithubAccount, Integer> {

}
