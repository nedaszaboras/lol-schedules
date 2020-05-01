package rpa.model

import lombok.Builder
import org.joda.time.DateTime
import java.time.LocalDateTime
import java.util.*

data class ResponseDTO(val events : List<EventResponseDTO>)

data class EventResponseDTO (
        var startTime : LocalDateTime,
        var type : String,
        var leagueName : String,
        var match : MatchResponseDTO
)

data class MatchResponseDTO(
        var matchId : String,
        var gameCount : Int,
        var teams : List<TeamsResponseDTO>
)

data class TeamsResponseDTO(
        var code : String,
        var name : String,
        var image : String,
        var recordWins : Int,
        var recordLosses : Int
)