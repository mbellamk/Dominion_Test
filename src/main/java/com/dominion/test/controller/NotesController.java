package com.dominion.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dominion.test.form.NotesForm;
import com.dominion.test.form.TagForm;
import com.dominion.test.service.NotesService;

@RestController
@Controller
public class NotesController {

	@Autowired
	private NotesService notesService;

	@RequestMapping(value = "/getNotes")
	public List<NotesForm> getNotes(@RequestParam String tagName) {
		return notesService.getNotes(tagName);
	}

	@ResponseBody
	@RequestMapping(value = "/saveTag", method = RequestMethod.POST, consumes = "application/json")
	public Boolean saveTag(@RequestBody TagForm tagForm) {
		notesService.saveTag(tagForm);
		System.out.println(tagForm);
		return true;
	}

	@ResponseBody
	@RequestMapping(value = "/saveNotes", method = RequestMethod.POST, consumes = "application/json")
	public Boolean saveNotes(@RequestBody NotesForm notesForm) {
		notesService.saveNotes(notesForm);
		return true;
	}
}
