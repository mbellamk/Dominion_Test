package com.dominion.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominion.test.form.NotesForm;
import com.dominion.test.form.TagForm;
import com.dominion.test.model.Notes;
import com.dominion.test.model.NotesTag;
import com.dominion.test.model.Tag;
import com.dominion.test.repository.NotesRepository;

@Service("notesService")
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepository notesRepository;

	@Transactional
	public Boolean saveTag(TagForm tagForm) {
		Tag tag = new Tag();
		tag.setName(tagForm.getName());
		tag.setDescription(tagForm.getDescription());

		return notesRepository.saveTag(tag);
	}

	@Transactional
	public Boolean saveNotes(NotesForm notesForm) {
		Notes notes = new Notes();
		notes.setNote(notesForm.getNote());
		notesRepository.saveNotes(notes);
		List<NotesTag> noteTags = new ArrayList<NotesTag>();
		for (Integer tag : notesForm.getTagIds()) {
			NotesTag noteTag = new NotesTag();
			noteTag.setNotes(notes);
			Tag tagObj = new Tag();
			tagObj.setId(tag);
			noteTag.setTag(tagObj);
			noteTags.add(noteTag);
		}
		notesRepository.saveNoteTags(noteTags);
		return true;
	}

	@Transactional
	public List<NotesForm> getNotes(String tagName) {
		List<Notes> notes = notesRepository.getNotes(tagName);
		List<NotesForm> notesForm = new ArrayList<NotesForm>();
		for (Notes note : notes) {
			NotesForm notesFormObj = new NotesForm();
			notesFormObj.setNote(note.getNote());
			notesForm.add(notesFormObj);
		}
		return notesForm;
	}

}
