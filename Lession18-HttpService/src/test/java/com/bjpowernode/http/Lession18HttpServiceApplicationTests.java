package com.bjpowernode.http;

import com.bjpowernode.http.model.Albums;
import com.bjpowernode.http.model.Todo;
import com.bjpowernode.http.service.AlbumsService;
import com.bjpowernode.http.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class Lession18HttpServiceApplicationTests {

    @Autowired
    private TodoService todoService;

    @Test
    void testQuery() {
        Todo todoById = todoService.getTodoById(1);
        System.out.println("todoById = " + todoById);
    }

    @Test
    void testCreateTodo(){
        Todo todo = new Todo();
        todo.setId(1001);
        todo.setUserId(5005);
        todo.setTitle("事项1");
        todo.setCompleted(true);

        Todo resultTodo = todoService.createTodo(todo);
        System.out.println("resultTodo = " + resultTodo);
    }

    @Test
    void testModifyTodo(){
        Todo todo = new Todo();
        todo.setId(1002);
        todo.setUserId(5007);
        todo.setTitle("事项2");
        todo.setCompleted(true);

        ResponseEntity<Todo> entity = todoService.modifyTodo(2, todo);
        HttpStatusCode statusCode = entity.getStatusCode();
        Todo body = entity.getBody();
        HttpHeaders headers = entity.getHeaders();
        System.out.println("statusCode = " + statusCode);
        System.out.println("body = " + body);
        System.out.println("headers = " + headers);
    }

    @Test
    void testDelete() {
        todoService.removeTodo(10);
    }

    @Autowired
    private AlbumsService albumsService;

    @Test
    void testQuery2() {
        Albums byId = albumsService.getById(1);
        System.out.println("byId = " + byId);
    }
}
