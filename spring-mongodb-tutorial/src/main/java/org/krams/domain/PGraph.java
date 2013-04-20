package org.krams.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PGraph {
	
	@Id
	private String id;
	
	private String task;
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	private String prodF;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getProdF() {
		return prodF;
	}
	public void setProdF(String prodF) {
		this.prodF = prodF;
	}
	
}
