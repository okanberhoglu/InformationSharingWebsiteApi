package com.InformationSharingWebsiteApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InformationSharingWebsiteApi.Entities.Content;
import com.InformationSharingWebsiteApi.Repositories.ContentRepository;
import com.InformationSharingWebsiteApi.Services.Abstracts.IService;

@Service
public class ContentService implements IService<Content>{

	@Autowired
	private ContentRepository repo;
	
	@Override
	public String Add(Content data) {
		try {
			repo.save(data);
			return "Content added.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public List<Content> GetAll() {
		return repo.findAll();
	}

	@Override
	public Content GetById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public String Delete(int id) {
		try {
			repo.deleteById(id);
			return "Content deleted.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public String Update(Content data) {
		try {
			Content content = repo.findById(data.contentId).orElse(null);
			if(content != null) {
				repo.save(data);
				return "Content updated.";
			}else {
				throw new Exception("Content not found.");
			}
		}catch (Exception e) {
			return e.getMessage();
		}
	}

}
