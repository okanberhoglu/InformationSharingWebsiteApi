package com.InformationSharingWebsiteApi.Services.Abstracts;

import java.util.List;

import com.InformationSharingWebsiteApi.Entities.Author;
import com.InformationSharingWebsiteApi.Entities.Content;

public interface IAuthorService {

	public Author LogIn(String userName, String password);
	public List<Content> ContentsList(int authorId);
}
