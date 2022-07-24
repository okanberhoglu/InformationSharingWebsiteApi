package com.InformationSharingWebsiteApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.InformationSharingWebsiteApi.Entities.Image;
import com.InformationSharingWebsiteApi.Services.ImageService;

@RestController
@RequestMapping("api/images")
public class ImageController {
	
	@Autowired
	private ImageService service;
	
	@PostMapping("/add")
	public String Add(@RequestParam("image") MultipartFile image,@RequestParam("contentId") int contentId,@RequestParam("name") String imageName) {
		return service.Add(image, contentId, imageName);
	}
	
	@GetMapping("/getAll")
	public List<Image> GetAll() {
		return service.GetAll();
	}
	
	@GetMapping("/getById/{id}")
	public Image GetById(@PathVariable int id) {
		return service.GetById(id);
	}
	
	@PutMapping("/update")
	public String Update(@RequestParam("image") MultipartFile image,@RequestParam("contentId") int contentId,@RequestParam("name") String imageName,@RequestParam("id") int id ) {
		return service.Update(image, id, contentId, imageName);
	}
	
	@DeleteMapping("/delete/{id}")
	public String Delete(@PathVariable int id) {
		return service.Delete(id);
	}
}
