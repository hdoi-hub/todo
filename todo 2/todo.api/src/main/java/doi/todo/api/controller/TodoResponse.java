package doi.todo.api.controller;

import doi.todo.api.domain.TodoEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TodoResponse {

    private List<TodoEntity> todoEntities;
}
