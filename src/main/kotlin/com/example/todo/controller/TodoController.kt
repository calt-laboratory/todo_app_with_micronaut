package com.example.todo.controller

import com.example.todo.model.Todo
import com.example.todo.service.TodoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import org.bson.types.ObjectId

@Controller("/todos")
class TodoController(private val todoService: TodoService) {

    @Get("/")
    fun listAllTodos() : HttpResponse<List<Todo>> {
        val todos = todoService.listAllTodos()
        return HttpResponse.ok(todos)
    }

    @Get("/{id}")
    fun getTodoById(@PathVariable id: Long) : HttpResponse<Todo> {
        val todo = todoService.getTodoById(id = id)
        return if (todo != null) {
            HttpResponse.ok(todo)
        } else HttpResponse.notFound()
    }

    @Post("/")
    fun createTodo(@Body todo: Todo) : HttpResponse<Todo> {
        val newTodo = todoService.createTodo(todo = todo)
        return HttpResponse.ok(newTodo)
    }

    @Put("/{id}")
    fun updateTodo(@PathVariable id: Long, todo: Todo) : HttpResponse<Todo> {
        val currentTodo = todoService.updateTodoById(id = id, todo = todo)
        return if (currentTodo != null) {
            HttpResponse.ok(currentTodo)
        } else HttpResponse.notFound()
    }

    @Delete("/{id}")
    fun deleteTodoById(@PathVariable id: Long): HttpResponse<Void> {
        todoService.deleteTodoById(id)
        return HttpResponse.noContent()
    }

    @Delete("/deleteAll")
    fun deleteAllTodos() {
        todoService.deleteAllTodos()
    }
}
