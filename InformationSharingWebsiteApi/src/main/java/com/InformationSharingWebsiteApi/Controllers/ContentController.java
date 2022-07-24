package com.InformationSharingWebsiteApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InformationSharingWebsiteApi.Entities.Content;
import com.InformationSharingWebsiteApi.Services.ContentService;

@RestController
@RequestMapping("api/contents")
public class ContentController {

	@Autowired
	private ContentService service;
	
	@GetMapping("/getAll")
	public List<Content> GetAll(){
		return service.GetAll();
	}
	
	@GetMapping("/getById/{id}")
	public Content GetById(@RequestBody int id) {
		return service.GetById(id);
	}
	
	@PostMapping("/add")
	public String Add(@RequestBody Content content) {
		return service.Add(content);
	}
	
	@PutMapping("/update")
	public String Update(@RequestBody Content content) {
		return service.Update(content);
	}
	
	@DeleteMapping("/delete/{id}")
	public String Delete(@RequestBody int id) {
		return service.Delete(id);
	}
}
