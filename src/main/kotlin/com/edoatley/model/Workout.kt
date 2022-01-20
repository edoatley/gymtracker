package com.edoatley.model

import java.time.ZonedDateTime
import java.util.*

class Workout (
    val id: String = UUID.randomUUID().toString(),
    val startTime: ZonedDateTime,
    val location: String,
    val exercises: MutableList<Exercise>
) {

    override fun toString(): String {
        return "Workout(startTime=$startTime, location='$location', exercises=$exercises)"
    }

}