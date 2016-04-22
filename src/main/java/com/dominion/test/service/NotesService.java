package com.dominion.test.service;

import java.util.List;

import com.dominion.test.form.NotesForm;
import com.dominion.test.form.TagForm;

public interface NotesService {

	public Boolean saveTag(TagForm tagForm);

	public Boolean saveNotes(NotesForm notesForm);

	public List<NotesForm> getNotes(String tagName);

}
