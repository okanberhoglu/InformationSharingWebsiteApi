package com.InformationSharingWebsiteApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.InformationSharingWebsiteApi.Entities.Reader;
import com.InformationSharingWebsiteApi.Services.ReaderService;

@RestController
@RequestMapping("api/readers")
public class ReaderController {

	@Autowired
	private ReaderService service;
	
	@GetMapping("/getAll")
	public List<Reader> GetAll(){
		return service.GetAll();
	}
	
	@GetMapping("/getById/{id}")
	public Reader GetById(@RequestBody int id) {
		return service.GetById(id);
	}
	
	@PostMapping("/add")
	public String Add(@RequestBody Reader reader) {
		return service.Add(reader);
	}
	
	@PutMapping("/update")
	public String Update(@RequestBody Reader reader) {
		return service.Update(reader);
	}
	
	@DeleteMapping("/delete/{id}")
	public String Delete(@RequestBody int id) {
		return service.Delete(id);
	}
	@GetMapping("/logIn")
	public Reader LogIn(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		return service.LogIn(userName, password);
	}
}
