//package rpa.api
//
//import org.springframework.beans.BeanUtils
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.http.HttpEntity
//import org.springframework.http.HttpHeaders
//import org.springframework.http.HttpMethod
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RestController
//import org.springframework.web.client.RestTemplate
//import rpa.model.LeagueDTO
//import rpa.model.LeagueDTOs
//import rpa.model.LeagueEntity
//import rpa.repository.LeagueRepository
//import java.util.ArrayList
//
//@RestController
//class ScheduleController(
//        val leagueRepository : LeagueRepository
//)
//{
//
//    @GetMapping("/")
//    fun home() : ResponseEntity<String> {
//        return ResponseEntity.ok("home")
//    }
//
//    @GetMapping("/getSchedules")
//    fun getSchedules() : ResponseEntity<String> {
//        println("Helo there")
//        return ResponseEntity.ok("hehexd boris gay hehexd")
//    }
//
//    @GetMapping("/test")
//    fun test() : ResponseEntity<String> {
////        var result : String
//
//        val headers = HttpHeaders()
//        headers.set("x-api-key", "0TvQnueqKa5mxJntVWt0w4LpLfEkrV1Ta8rQBb9Z")
//
//        val httpEntity = HttpEntity<String>(headers)
//
////        val restTemplate : RestTemplate
////        restTemplate.
//
//
//        val data = RestTemplate().exchange("https://esports-api.lolesports.com/persisted/gw/getLeagues?hl=en-GB", HttpMethod.GET, httpEntity, LeagueDTO::class.java)
////                restTemplate.getForObject("https://esports-api.lolesports.com/persisted/gw/getLeagues?hl=en-GB", LeagueDTO::class.java)
//
////        val result = data.body
//
//
//
////        data.body()
////
////        repository.saveAll(result.)
//        println(data)
//        val dtos : ArrayList<LeagueDTOs> = data.body?.data?.leagues!!
//        val entities = arrayListOf<LeagueEntity>()
////        val entityList : ArrayList<LeagueEntity> = BeanUtils.copyProperties(dtos, entities)
//
//        BeanUtils.copyProperties(dtos, entities)
//
////        entities = BeanUtils.copyProperties(dtos, entities).javaClass.declaringClass
//
//        leagueRepository.saveAll(entities)
//
//
//        return ResponseEntity.ok("zzz");
//    }
//
////    fun LeagueDTO.mapper() =
//}