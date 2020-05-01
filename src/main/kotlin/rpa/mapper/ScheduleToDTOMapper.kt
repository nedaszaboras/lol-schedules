//package rpa.mapper
//
//import rpa.model.*
//import java.util.stream.Collectors
//
//public class ScheduleToDTOMapper {
//
//    fun map(eventEntity : EventEntity) : EventResponseDTO {
//        return EventResponseDTO(
//                startTime = eventEntity.startTime,
//                type = eventEntity.type,
//                leagueName = eventEntity.leagueName,
//                match = mapMatch(eventEntity.match)
//
//                )
//    }
//
//    private fun mapMatch(matchEntity : MatchEntity) : MatchResponseDTO {
//        return MatchResponseDTO(
//                matchId = matchEntity.matchId,
//                gameCount = matchEntity.gameCount,
//                teams = mapTeams(matchEntity.teams)
//        )
//    }
//
//    private fun mapTeams(teamEntities : List<TeamEntity>) : List<TeamsResponseDTO> {
//        return teamEntities.stream().map {
//            t: TeamEntity -> TeamsResponseDTO(
//                code = t.code,
//                name = t.name,
//                image = t.image,
//                recordLosses = t.recordLosses,
//                recordWins = t.recordWins
//        )
//        }.collect(Collectors.toList())
//    }
//
//
//}