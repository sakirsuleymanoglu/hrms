  
package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {

}