package com.dominion.test.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dominion.test.model.Notes;
import com.dominion.test.model.NotesTag;
import com.dominion.test.model.Tag;

@Repository("notesRepository")
public class NotesRepositoryImpl implements NotesRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Boolean saveTag(Tag tag) {
		try {
			sessionFactory.getCurrentSession().save(tag);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean saveNotes(Notes notes) {
		try {
			sessionFactory.getCurrentSession().save(notes);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean saveNoteTags(List<NotesTag> noteTags) {
		try {

			for (NotesTag t : noteTags) {
				sessionFactory.getCurrentSession().save(t);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Notes> getNotes(String tagName) {
		List<Notes> notes = new ArrayList<Notes>();
		try {
			List<Integer> notesList = sessionFactory.getCurrentSession()
					.createCriteria(NotesTag.class).createAlias("tag", "tag").createAlias("notes", "notes")
					.add(Restrictions.eq("tag.name", tagName))
					.setProjection(Projections.property("notes.id")).list();

			notes = sessionFactory.getCurrentSession()
					.createCriteria(Notes.class)
					.add(Restrictions.in("id", notesList)).list();
			return notes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
