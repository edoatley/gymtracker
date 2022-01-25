package com.edoatley.model

import org.junit.jupiter.api.Test
import java.time.ZonedDateTime

class WorkoutTest {

    @Test
    fun testSimpleWorkoutToString() {
        val exercise1 = Exercise("Running", EffortLevel.MODERATE, TimeTaken(0, 33, 28))
        val workout = Workout( ZonedDateTime.now(), "Reading", mutableListOf(exercise1))
        val workoutString = workout.toString()

        assert(workoutString.contains("Reading")) { "Location Reading was missing from toString(): $workoutString" }
        assert(workoutString.contains("Running")) { "Exercise type Running was missing from toString(): $workoutString" }
        assert(workoutString.contains("TimeTaken(hours=0, minutes=33, seconds=28)")) { "Exercise type Running was missing from toString(): $workoutString" }
    }

}