package com.mao.assignment.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "github")
public class GithubJSON extends Github {

	@XmlElement(name = "total_count")
	private String total_count;

	/**
	 * @return the total_count
	 */
	public String getTotal_count() {
		return total_count;
	}

	/**
	 * @param total_count the total_count to set
	 */
	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}

	

}
