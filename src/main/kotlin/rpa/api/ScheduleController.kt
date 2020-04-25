package rpa.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ScheduleController {

    @GetMapping("/getSchedules")
    fun getSchedules() : ResponseEntity<String> {
        println("Helo there")
        return ResponseEntity.ok("hehexd boris gay hehexd")
    }
}