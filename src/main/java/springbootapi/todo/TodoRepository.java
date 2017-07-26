package springbootapi.todo;

import org.springframework.data.mongodb.repository.MongoRepository;
import springbootapi.todo.POJOs.TodoItem;
import java.util.List;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
public interface TodoRepository extends MongoRepository<TodoItem, String> {

    List<TodoItem> findByTitle(@org.springframework.data.repository.query.Param("title") String title);

}