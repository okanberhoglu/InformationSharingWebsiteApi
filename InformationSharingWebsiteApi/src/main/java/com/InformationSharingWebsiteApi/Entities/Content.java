package com.InformationSharingWebsiteApi.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contents")
public class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int contentId;

	@Column(name = "content", length = 100000, nullable = false)
	public String content;
	
	@Column(name = "title", length = 20, nullable = false)
	public String title;
	
	@Column(name = "subject", length = 100, nullable = false)
	public String subject;
	
	public int authorId;
	
	@OneToMany
	@JoinColumn(name = "contentId", insertable = false, updatable = false, nullable = true)
	public List<Image> images;
}
