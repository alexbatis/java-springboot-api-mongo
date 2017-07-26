package springbootapi.todo.POJOs;

import lombok.*;

@ToString(includeFieldNames=true)
@Data()
public class Widget {
    private String name;
    private int age;
}