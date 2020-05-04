package doi.todo.api.controller;

import doi.todo.api.domain.TodoEntity;
import doi.todo.api.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<TodoResponse> findAll(){
        List<TodoEntity> todoEntities = todoService.findAll();
        TodoResponse todoResponse = TodoResponse.builder().todoEntities(todoEntities).build();
        return new ResponseEntity<>(todoResponse, HttpStatus.OK);
    }
}
