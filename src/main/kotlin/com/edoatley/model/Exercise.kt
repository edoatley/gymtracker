package com.edoatley.model


data class Exercise (
    val type: String,
    val effortLevel: EffortLevel,
    var timeTaken: TimeTaken? = null
)

enum class EffortLevel { VERY_HIGH, HIGH, MODERATE, LOW, NONE }