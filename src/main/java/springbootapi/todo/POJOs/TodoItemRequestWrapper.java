package springbootapi.todo.POJOs;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class TodoItemRequestWrapper {
    private @Getter @Setter String title;
    private @Getter @Setter String description;


}
