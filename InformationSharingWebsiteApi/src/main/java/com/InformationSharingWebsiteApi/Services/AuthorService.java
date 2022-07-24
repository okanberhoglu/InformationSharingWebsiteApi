package com.InformationSharingWebsiteApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InformationSharingWebsiteApi.Entities.Author;
import com.InformationSharingWebsiteApi.Entities.Content;
import com.InformationSharingWebsiteApi.Entities.Reader;
import com.InformationSharingWebsiteApi.Repositories.AuthorRepository;
import com.InformationSharingWebsiteApi.Repositories.ReaderRepository;
import com.InformationSharingWebsiteApi.Services.Abstracts.IAuthorService;
import com.InformationSharingWebsiteApi.Services.Abstracts.IService;

@Service
public class AuthorService implements IService<Author>, IAuthorService{

	@Autowired
	private AuthorRepository repo;
	
	@Autowired
	private ReaderRepository readerRepo;
	
	@Override
	public String Add(Author data) {
		try {
			if(repo.AuthorControl(data.email) == null) {
				repo.save(data);
				if(readerRepo.ReaderControl(data.email) == null) {
					Reader reader = new Reader();
					reader.email = data.email;
					reader.firstName = data.firstName;
					reader.lastName = data.lastName;
					reader.password = data.password;
					reader.phone = data.phone;
					reader.userName = data.userName;
					reader.age = data.age;
					readerRepo.save(reader);
				}
				return "Author added.";
			}else {
				throw new Exception("There is an author with the same email.");
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public List<Author> GetAll() {
		return repo.findAll();
	}

	@Override
	public Author GetById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public String Delete(int id) {
		try {
			repo.deleteById(id);
			return "Author deleted.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public String Update(Author data) {
		try {
			Author author = repo.findById(data.authorId).orElse(null);
			if (author != null) {
				repo.save(data);
				return "Author updated.";
			}else {
				throw new Exception("Author not found.");
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public Author LogIn(String userName, String password) {
		return repo.LogIn(userName, password);
	}

	@Override
	public List<Content> ContentsList(int authorId) {
		return repo.authorsContents(authorId);
	}

}
