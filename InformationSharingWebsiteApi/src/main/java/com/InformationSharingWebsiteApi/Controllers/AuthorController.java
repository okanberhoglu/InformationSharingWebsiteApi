package com.InformationSharingWebsiteApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.InformationSharingWebsiteApi.Entities.Author;
import com.InformationSharingWebsiteApi.Entities.Content;
import com.InformationSharingWebsiteApi.Services.AuthorService;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

	@Autowired
	private AuthorService service;
	
	@GetMapping("/getAll")
	public List<Author> GetAll(){
		return service.GetAll();
	}
	
	@GetMapping("/getById/{id}")
	public Author GetById(@PathVariable int id) {
		return service.GetById(id);
	}
	
	@PostMapping("/add")
	public String Add(@RequestBody Author author) {
		return service.Add(author);
	}
	
	@PutMapping("/update")
	public String Update(@RequestBody Author author) {
		return service.Update(author);
	}
	
	@DeleteMapping("/delete/{id}")
	public String Delete(@PathVariable int id) {
		return service.Delete(id);
	}
	
	@GetMapping("/getContentsByAuthorId/{id}")
	public List<Content> GetContentsByAuthor(@PathVariable int id) {
		return service.ContentsList(id);
	}
	
	@GetMapping("/logIn")
	public Author LogIn(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		return service.LogIn(userName, password);
	}
}
