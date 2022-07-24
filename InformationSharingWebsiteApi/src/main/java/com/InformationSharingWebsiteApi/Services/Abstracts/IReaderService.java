package com.InformationSharingWebsiteApi.Services.Abstracts;

import com.InformationSharingWebsiteApi.Entities.Reader;

public interface IReaderService {
	
	public Reader LogIn(String userName, String password);
}
