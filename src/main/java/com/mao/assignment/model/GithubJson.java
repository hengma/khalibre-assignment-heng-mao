package com.mao.assignment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GithubJson extends Github{
	
	private String total_count;

	public String getTotal_count() {
		return total_count;
	}

	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}
}
