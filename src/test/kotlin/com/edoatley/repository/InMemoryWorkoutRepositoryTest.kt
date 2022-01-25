package com.edoatley.repository

import com.edoatley.model.EffortLevel
import com.edoatley.model.Exercise
import com.edoatley.model.TimeTaken
import com.edoatley.model.Workout
import io.smallrye.mutiny.coroutines.awaitSuspending
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance
import java.time.Duration
import java.time.ZonedDateTime
import java.util.*
import kotlin.collections.HashMap

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InMemoryWorkoutRepositoryTest {

    private val workoutRepository: IWorkoutRepository
    private val id1 = UUID.randomUUID().toString()
    private val id2 = UUID.randomUUID().toString()
    private val exercise1 = Exercise("Running", EffortLevel.MODERATE, TimeTaken(0, 33, 28))
    private val workout1 = Workout( ZonedDateTime.now(), "Reading", mutableListOf(exercise1), id1)
    private val exercise2a = Exercise("Rowing", EffortLevel.VERY_HIGH, TimeTaken(0, 7, 51))
    private val exercise2b = Exercise("Cycling", EffortLevel.LOW, TimeTaken(0, 25, 2))
    private val exercise2c = Exercise("Stretching", EffortLevel.NONE, TimeTaken(0, 11, 54))
    private val workout2 = Workout( ZonedDateTime.now(), "Reading", mutableListOf(exercise2a, exercise2b, exercise2c), id2)

    init {
        val workouts: MutableMap<String, Workout> = HashMap()
        workouts[workout1.id] = workout1
        workouts[workout2.id] = workout2
        workoutRepository = InMemoryWorkoutRepository(workouts)
    }

    @Test
    fun `test a retrieved workout matches as expected`() {
        // https://smallrye.io/smallrye-mutiny/guides/testing
        workoutRepository.get(id1)
            .invoke {w -> assertEquals(w, workout1)}
            .subscribe().withSubscriber(UniAssertSubscriber.create())
            .assertCompleted()
    }

    @Test
    fun `test a retrieved workout does not match another`() {
        workoutRepository.get(id1)
            .invoke {w -> assertNotEquals(w, workout2)}
            .subscribe().withSubscriber(UniAssertSubscriber.create())
            .assertCompleted()
    }

    @Test
    fun findAll() {
    }

    @Test
    fun save() {
    }

    @Test
    fun get() {
    }

    @Test
    fun addExercise() {
    }
}