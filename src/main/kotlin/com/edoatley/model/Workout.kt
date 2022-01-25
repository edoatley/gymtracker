package com.edoatley.model

import java.time.ZonedDateTime
import java.util.*

class Workout (
    val startTime: ZonedDateTime,
    val location: String,
    val exercises: MutableList<Exercise>,
    val id: String = UUID.randomUUID().toString()
) {

    override fun toString(): String {
        return "Workout(startTime=$startTime, location='$location', exercises=$exercises)"
    }

}