package com.InformationSharingWebsiteApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.InformationSharingWebsiteApi.Entities.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer>{

	@Query(value = "Select * from readers Where email = :email LIMIT 1", nativeQuery = true)
	public Reader ReaderControl( @Param("email") String email);
	
	@Query(value = "Select * from readers Where user_name = :userName and password = :password LIMI 1", nativeQuery = true)
	public Reader LogIn(@Param("userName") String userName, @Param("password") String password);
}
