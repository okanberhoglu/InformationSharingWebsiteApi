package com.InformationSharingWebsiteApi.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int authorId;
	
	@Column(name = "user_name", length = 20, nullable = false)
	public String userName;
	
	@Column(name = "password", length = 20, nullable = false)
	public String password;
	
	@Column(name = "first_name", length = 50, nullable = false)
	public String firstName;
	
	@Column(name = "last_name", length = 50, nullable = false)
	public String lastName;
	
	@Column(name = "email", length = 100, nullable = false)
	public String email;
	
	@Column(name = "phone", length = 13) //only for Turkey
	public String phone;
	
	@Column(name = "title", length = 50, nullable = false)
	public String title;
	
	public int age;
	
	@OneToMany
	@JoinColumn(name = "authorId", insertable = true, nullable = true)
	public List<Content> contents; 
}
