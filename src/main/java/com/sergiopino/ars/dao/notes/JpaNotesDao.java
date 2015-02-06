package com.sergiopino.ars.dao.notes;

import org.springframework.stereotype.Repository;

import com.sergiopino.ars.dao.JpaDao;
import com.sergiopino.ars.entity.Note;

@Repository("notesDao")
public class JpaNotesDao extends JpaDao<Note, Long> implements NotesDao
{

	public JpaNotesDao()
	{
		super(Note.class);
	}


}
