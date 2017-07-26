package springbootapi.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapi.todo.POJOs.TodoItem;
import springbootapi.todo.POJOs.TodoItemRequestWrapper;

import java.util.HashMap;

//TODO: implement PUT with updating completion (may be null)

@SpringBootApplication
public class SpringbootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiApplication.class, args);
	}

	@RequestMapping("/api")
	@RestController
	public class TodoListController {

		HashMap<String, TodoItem> todoList = new HashMap<String, TodoItem>();


		@RequestMapping(value = "/todos",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
		public HashMap<String, TodoItem> getAllItems(){
			return todoList;
		}

		@RequestMapping(value = "/todo/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
		public Object getItemByID(@PathVariable("id") String id){
			TodoItem todo = todoList.get(id);
			return (todo != null) ? todo : 	new ResponseEntity<>("No TodoList Item found for the requested ID : " + id, HttpStatus.BAD_REQUEST); //TODO: fix this to send an actual error message
		}

		@RequestMapping(value = "/todo/{id}",method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
		public Object deleteItemByID(@PathVariable("id") String id){
			TodoItem todo = todoList.get(id);
			if(todo!= null)
				todoList.remove(id);
			return (todo != null) ? todoList : 	new ResponseEntity<>("No TodoList Item found for the requested ID : " + id, HttpStatus.BAD_REQUEST); //TODO: fix this to send an actual error message
		}

		@RequestMapping(value = "/todo/{id}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
		public Object updateTodoItem(@RequestBody TodoItemRequestWrapper updatedTodo,@PathVariable("id") String id){
			if(updatedTodo == null)
				return "Error. Must include response body in PUT request";

			TodoItem todo = todoList.get(id);
			if(todo!= null){
				todo.setTitle(updatedTodo.getTitle());
				todo.setDescription(updatedTodo.getDescription());
				todoList.put(id,todo);
			}
				return todo;
		}




		@RequestMapping(value = "/todo/", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
		public Object postTodoItem(@RequestBody TodoItemRequestWrapper todo){
			if(todo == null)
				return "Error. Must include response body in POST request";

			TodoItem itemToAdd = new TodoItem(todo.getTitle(),todo.getDescription());
			todoList.put(itemToAdd.getId(),itemToAdd);

			return itemToAdd;
		}
	}
}
