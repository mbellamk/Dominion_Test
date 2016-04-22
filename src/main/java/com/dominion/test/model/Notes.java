package com.dominion.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Notes {

	@Id
	@Column(name = "notes_id", nullable = false)
	@SequenceGenerator(name = "pk_notes_sequence", sequenceName = "seq_notes_notes_id", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_notes_sequence")
	private int id;

	@Column(name = "note")
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
