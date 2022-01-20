package com.edoatley.api

import com.edoatley.service.WorkoutService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class WorkoutResource(val workoutService: WorkoutService) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun workouts() = workoutService.findAllWorkouts()
}