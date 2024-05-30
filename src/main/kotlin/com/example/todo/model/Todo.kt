package com.example.todo.model

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import jakarta.validation.constraints.NotBlank
import org.bson.types.ObjectId

@MappedEntity
data class Todo(
    @field:Id
    @field:GeneratedValue
    var id: Long? = null,
    @field:NotBlank val text: String,
    val completed: Boolean = false
)