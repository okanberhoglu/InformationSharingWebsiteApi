package com.InformationSharingWebsiteApi.Services.Abstracts;

import java.util.List;

public interface IService<T> {
	
	public String Add(T data);
	public List<T> GetAll();
	public T GetById(int id);
	public String Delete(int id);
	public String Update(T data);
	
}
