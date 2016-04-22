package com.dominion.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "note_tags")
public class NotesTag {

	@Id
	@Column(name = "note_tag_id", nullable = false)
	@SequenceGenerator(name = "pk_notes_tag_sequence", sequenceName = "seq_note_tag_note_tag_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_notes_tag_sequence")
	private int id;

	@JoinColumn(name = "notes_id")
	@OneToOne
	private Notes notes;

	@JoinColumn(name = "tag_id")
	@OneToOne
	private Tag tag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Notes getNotes() {
		return notes;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}
