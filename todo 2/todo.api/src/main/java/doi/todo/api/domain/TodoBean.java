package doi.todo.api.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoBean {
    private String id;
    private String name;
    private String deadline;
}
