package com.edoatley.model

import java.time.ZonedDateTime

class Workout (
    val startTime: ZonedDateTime,
    val location: String,
    val exercises: List<Exercise>
)