package com.edoatley.repository

import com.edoatley.model.Exercise
import com.edoatley.model.Workout
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni

interface IWorkoutRepository {
    fun findAll(): Multi<Workout>
    fun get(id: String): Uni<Workout>
    fun addExercise(id: String, exercise: Exercise)
    fun save(workout: Workout): Uni<Workout>
}