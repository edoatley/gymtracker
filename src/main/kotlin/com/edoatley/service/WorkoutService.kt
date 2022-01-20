package com.edoatley.service

import com.edoatley.model.Exercise
import com.edoatley.model.Workout
import com.edoatley.repository.IWorkoutRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WorkoutService (val workoutRepository: IWorkoutRepository) {

    fun findAllWorkouts(): Multi<Workout> {
        return workoutRepository.findAll()
    }

    fun getWorkoutById(id: String): Uni<Workout> {
        return workoutRepository.get(id)
    }

    fun saveWorkout(workout: Workout): Uni<Workout> {
        return workoutRepository.save(workout)
    }

    fun addExecrise(id: String, exercise: Exercise) {
        workoutRepository.addExercise(id, exercise)
    }
}