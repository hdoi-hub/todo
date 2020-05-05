package doi.todo.api.controller;

import doi.todo.api.domain.TodoBean;
import doi.todo.api.domain.TodoEntity;
import doi.todo.api.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<TodoResponse> findAll(){
        List<TodoEntity> todoEntities = todoService.findAll();
        List<TodoBean> todoBeans = new ArrayList<>();
        for (TodoEntity todoEntity : todoEntities) {
            Date deadline = todoEntity.getDeadline();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String strDeadline = sdf.format(deadline);
            TodoBean todoBean = new TodoBean();

            todoBean.setId(todoEntity.getId());
            todoBean.setName(todoEntity.getName());
            todoBean.setDeadline(strDeadline);
            todoBeans.add(todoBean);
        }

        TodoResponse todoResponse = TodoResponse.builder().todoBeans(todoBeans).build();
        return new ResponseEntity<>(todoResponse, HttpStatus.OK);
    }
}
