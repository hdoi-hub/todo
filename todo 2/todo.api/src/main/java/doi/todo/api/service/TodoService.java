package doi.todo.api.service;

import doi.todo.api.domain.TodoEntity;
import doi.todo.api.domain.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<TodoEntity> findAll(){
        return todoRepository.findAll();
    }
}
