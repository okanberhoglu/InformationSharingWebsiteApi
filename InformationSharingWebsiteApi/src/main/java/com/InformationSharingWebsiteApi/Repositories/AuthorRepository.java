package com.InformationSharingWebsiteApi.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.InformationSharingWebsiteApi.Entities.Author;
import com.InformationSharingWebsiteApi.Entities.Content;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	@Query(value = "Select * from authors Where email = :email LIMIT 1", nativeQuery = true)
	public Author AuthorControl( @Param("email") String email);
	
	@Query(value = "Select * from authors Where user_name = :userName and password = :password LIMI 1", nativeQuery = true)
	public Author LogIn(@Param("userName") String userName, @Param("password") String password);
	
	@Query(value = "Select * from contents Where author_id = :authorId", nativeQuery = true)
	public List<Content> authorsContents(@Param("authorId") int authorId);
}
