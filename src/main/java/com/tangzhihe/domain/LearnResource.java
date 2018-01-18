package com.tangzhihe.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "learn_resource")
public class LearnResource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 描述
	 */
	private String title;
	/**
	 * 地址链接
	 */
	private String url;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}
	
}



























