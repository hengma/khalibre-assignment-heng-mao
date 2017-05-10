package com.mao.assignment.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="github")
@XmlAccessorType(XmlAccessType.FIELD)
public class GithubJSON {
	
	@XmlElement (name="total_count")
	private Long total_count;

	@XmlElement( name="item" )
	private List<Item> items;

	/**
	 * @return the total_count
	 */
	public Long getTotal_count() {
		return total_count;
	}

	/**
	 * @param total_count the total_count to set
	 */
	public void setTotal_count(Long total_count) {
		this.total_count = total_count;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
