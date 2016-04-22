package com.dominion.test.form;

import java.util.List;

public class NotesForm {

	private String note;

	private List<Integer> tagIds;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Integer> getTagIds() {
		return tagIds;
	}

	public void setTagIds(List<Integer> tagIds) {
		this.tagIds = tagIds;
	}

}
