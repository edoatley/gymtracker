package com.edoatley.repository

import com.edoatley.exception.WorkoutNotFoundException
import com.edoatley.model.Exercise
import com.edoatley.model.Workout
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class InMemoryWorkoutRepository(val workouts: MutableMap<String, Workout> = HashMap()) : IWorkoutRepository {

    override fun findAll(): Multi<Workout> {
        return Multi.createFrom().iterable((workouts.values))
    }

    override fun save(workout: Workout): Uni<Workout> {
        workouts[workout.id] = workout
        return Uni.createFrom().item(workouts[workout.id])
    }

    override fun get(id: String): Uni<Workout> {
        return Uni.createFrom().item(workouts[id])
    }

    override fun addExercise(id: String, exercise: Exercise) {
        workouts[id]?.exercises?.add(exercise) ?: throw WorkoutNotFoundException("No Workout Found for id $id")
    }

}