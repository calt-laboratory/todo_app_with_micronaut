package com.example.todo.service

import com.example.todo.model.Todo
import com.example.todo.repository.TodoRepository
import jakarta.inject.Singleton
import org.bson.types.ObjectId

@Singleton
class TodoService(private val todoRepository: TodoRepository) {
    fun listAllTodos(): List<Todo> = todoRepository.findAll().toList()

    fun getTodoById(id: Long?): Todo? = todoRepository.findById(id).orElse(null)

    fun createTodo(todo: Todo) : Todo = todoRepository.save(todo)

    fun updateTodoById(id: Long?, todo: Todo) : Todo? {
        val currentTodo = todoRepository.findById(id)
        return if (currentTodo.isPresent) {
            val updatedTodo = currentTodo.get().copy(text = todo.text, completed = todo.completed)
            todoRepository.update(updatedTodo)
            updatedTodo
        }
        else null
    }

    fun deleteTodoById(id: Long) {
        todoRepository.deleteById(id)
    }

    fun deleteAllTodos() {
        val todos = todoRepository.findAll().toList()
        todoRepository.deleteAll(todos)
    }
}
