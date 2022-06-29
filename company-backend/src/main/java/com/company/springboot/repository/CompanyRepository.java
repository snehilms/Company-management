/**
 * 
 */
package com.company.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.company.springboot.model.Company;

/**
 * @author snehil
 *
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

	@Query(value="select * from company c where c.company_name=:name",nativeQuery= true)
	Company findByName(String name);

}
