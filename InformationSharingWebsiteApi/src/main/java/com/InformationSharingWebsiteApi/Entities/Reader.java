package com.InformationSharingWebsiteApi.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "readers")
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int readerId;
	
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
	
	public int age;
}
