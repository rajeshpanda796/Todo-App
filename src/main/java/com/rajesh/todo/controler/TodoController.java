package com.rajesh.todo.controler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rajesh.todo.model.Todo;
import com.rajesh.todo.service.TodoRepository;


@Controller
@SessionAttributes("name")
public class TodoController {

	
	@Autowired
	TodoRepository repository;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/y");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	private String getLoggedInUsername(ModelMap model) {
		return (String) model.get("name");
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUsername(model);
		model.put("todos", repository.findByUser(name));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUsername(model), "", new Date(), false));
		return "todo";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		//service.deleteTodo(id);
		repository.deleteById(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		Optional<Todo> todo = repository.findById(id);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo";
		todo.setUser(getLoggedInUsername(model));
		repository.save(todo);
		return "redirect:/list-todos";
	}


	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodos(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo";
		todo.setUser(getLoggedInUsername(model));
		repository.save(todo);
		return "redirect:/list-todos";
	}

}
