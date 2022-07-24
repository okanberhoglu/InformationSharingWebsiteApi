package com.InformationSharingWebsiteApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InformationSharingWebsiteApi.Entities.Reader;
import com.InformationSharingWebsiteApi.Repositories.ReaderRepository;
import com.InformationSharingWebsiteApi.Services.Abstracts.IReaderService;
import com.InformationSharingWebsiteApi.Services.Abstracts.IService;

@Service
public class ReaderService implements IService<Reader>, IReaderService{

	@Autowired
	private ReaderRepository repo;

	@Override
	public String Add(Reader data) {
		try {
			if(repo.ReaderControl(data.email) == null){
				repo.save(data);
				return "Reader added.";
			}else {
				throw new Exception("There is a reader with the same email.");
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public List<Reader> GetAll() {
		return repo.findAll();
	}

	@Override
	public Reader GetById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public String Delete(int id) {
		try {
			repo.deleteById(id);
			return "Reader deleted.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public String Update(Reader data) {
		try {
			if(repo.findById(data.readerId).orElse(null) != null) {
				repo.save(data);
				return "Reader updated.";
			}else {
				throw new Exception("Reader not found.");
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	@Override
	public Reader LogIn(String userName, String password) {
		return repo.LogIn(userName, password);
	}
}
