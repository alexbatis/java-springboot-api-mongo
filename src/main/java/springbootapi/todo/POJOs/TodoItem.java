package springbootapi.todo.POJOs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import java.util.Date;

@ToString(includeFieldNames=true)
public class TodoItem {
    @Id private @Getter String id;
    private @Getter @Setter String title;
    private @Getter @Setter String description;
    private @Getter @Setter boolean completed;
    private @Getter Date created;


    public TodoItem() {
        this.title = "";
        this.description = "";
        this.completed = false;
        this.created = new Date();
    }

    public TodoItem(String title, String description){
        this.title = title;
        this.description = description;
        this.completed = false;
        this.created = new Date();
    }
}