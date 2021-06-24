package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.Seeker;

public interface SeekerDao extends JpaRepository<Seeker, Integer> {

}
