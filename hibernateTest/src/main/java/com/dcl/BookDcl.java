package com.dcl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class BookDcl {

	String title;
	int pages;

	@Id
	// @GeneratedValue(strategy =
	// GenerationType.AUTO)//AUTO,IDENTITY,SEQUENCE,TABLE
	@SequenceGenerator(name = "seq1", sequenceName = "HIB_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq1") // AUTO,IDENTITY,SEQUENCE,TABLE
	int id;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
