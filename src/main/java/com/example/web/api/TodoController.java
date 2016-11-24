package com.example.web.api;

import com.example.model.Todo;
import com.example.repository.TodoMapper;
import com.example.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    /**
     * The Logger for this Class.
     */
    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/api/live",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createBroadcastor() {
        return new ResponseEntity<String>("{created}", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/live",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBroadcastors() {

        return new ResponseEntity<String>(todoService.getCurrentDataTime(), HttpStatus.CREATED);
    }

    @Transactional
    @RequestMapping(value = "/api/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todo> getUsers() {
        Todo newTodo = new Todo();
        newTodo.setTitle("AAAA");
        newTodo.setDetails("BBBB 19:00");

        todoMapper.insert(newTodo);

        Todo loadedTodo = todoMapper.select(newTodo.getId());
        return new ResponseEntity<Todo>(loadedTodo, HttpStatus.OK);
    }
}
