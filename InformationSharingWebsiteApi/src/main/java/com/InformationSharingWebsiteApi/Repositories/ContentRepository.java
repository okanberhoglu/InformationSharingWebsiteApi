package com.InformationSharingWebsiteApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InformationSharingWebsiteApi.Entities.Content;

public interface ContentRepository extends JpaRepository<Content, Integer>{

}
