package com.dominion.test.repository;

import java.util.List;

import com.dominion.test.form.NotesForm;
import com.dominion.test.model.Notes;
import com.dominion.test.model.NotesTag;
import com.dominion.test.model.Tag;

public interface NotesRepository {

	public Boolean saveTag(Tag tag);

	public Boolean saveNotes(Notes notes);

	public Boolean saveNoteTags(List<NotesTag> noteTags);

	public List<Notes> getNotes(String tagName);

}
