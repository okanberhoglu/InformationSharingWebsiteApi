package com.InformationSharingWebsiteApi.Services.Abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.InformationSharingWebsiteApi.Entities.Image;

public interface IImageService {
	
	public String Add(MultipartFile file, int contentId, String imageName);
	public List<Image> GetAll();
	public Image GetById(int id);
	public String Delete(int id);
	public String Update(MultipartFile file,int imageId, int contentId, String imageName);
	
}
