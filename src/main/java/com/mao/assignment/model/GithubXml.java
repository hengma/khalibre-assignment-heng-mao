package com.mao.assignment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GithubXml extends Github{

	private String totalCount;
	
	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

}
