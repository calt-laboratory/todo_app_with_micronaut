package com.example.todo.repository

import com.example.todo.model.Todo
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository
import org.bson.types.ObjectId

@MongoRepository
interface TodoRepository : CrudRepository<Todo, Long>
