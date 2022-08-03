package com.InformationSharingWebsiteApi.Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.InformationSharingWebsiteApi.Entities.Image;
import com.InformationSharingWebsiteApi.Repositories.ImageRepository;
import com.InformationSharingWebsiteApi.Services.Abstracts.IImageService;

@Service
public class ImageService implements IImageService{

	@Autowired
	private ImageRepository repo;
	
	private String dir = "./images";
	
	@Override
	public String Add(MultipartFile file, int contentId, String imageName) {
		try {
			Image i = new Image();
			
			String name = StringUtils.cleanPath(file.getOriginalFilename());
			
			String extension = name.substring(name.length()-3);
			if(!extension.equals("jpg") && !extension.equals("png")){
				throw new Exception("File must be jpg or png.");
			}
		    
			i.image = GenerateFileName() + "." + extension;
			
			i.contentId = contentId;
			i.imageName = imageName;
			
			Image savedImage = repo.save(i);
			i.image = GenerateFileName() + savedImage.imageId + "." + extension ;
			repo.save(i);
			
			Path uploadPath = Paths.get(dir);
			
			// if there is not a images file, the following if block will create
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			
			InputStream inputStream = file.getInputStream();
			Path filePath = uploadPath.resolve(i.image);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			
			return "Image added.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public List<Image> GetAll() {
		return repo.findAll();
	}

	@Override
	public Image GetById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public String Delete(int id) {
		try {
			Image image = repo.findById(id).orElse(null);
			DeleteImage(image);
			repo.deleteById(id);
			return "Image deleted.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public String Update(MultipartFile file, int imageId, int contentId, String imageName) {
		try {
			Image oldImage = repo.findById(imageId).orElse(null);
			if( oldImage != null) {
				DeleteImage(oldImage);
				Image i = new Image();
				i.imageId = imageId;
				
				String name = StringUtils.cleanPath(file.getOriginalFilename());
				String extension = name.substring(name.length()-3);
				if(!extension.equals("jpg") && !extension.equals("png")){
					throw new Exception("File must be jpg or png.");
				}
				
				i.image = GenerateFileName() + i.imageId + "." + extension;
				i.contentId = contentId;
				i.imageName = imageName;
				
				repo.save(i);
				Path uploadPath = Paths.get(dir);
				if(!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}
				InputStream inputStream = file.getInputStream();
				Path filePath = uploadPath.resolve(i.image);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
				return "Image updated";
			}else {
				throw new Exception("Image not found.");
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	private String GenerateFileName() {
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		int length = 7;
		for(int j = 0; j < length; j++) {
		    int index = random.nextInt(alphabet.length());
		    char randomChar = alphabet.charAt(index);
		    sb.append(randomChar);
		 }
		String randomString = sb.toString();
		return randomString;
	}
	
	private void DeleteImage(Image image) throws IOException {
		Path path = Paths.get(dir);
		Path filePath = path.resolve(image.image);
		File f = filePath.toFile();
		boolean a =  f.delete();
		if(a == false) {
			throw new FileNotFoundException("Failed to delete file: " + f);
		}
	}
}
