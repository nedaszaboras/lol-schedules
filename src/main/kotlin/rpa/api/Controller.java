package rpa.api;

import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rpa.model.DataDTO;
import rpa.model.EventResponseDTO;
import rpa.model.LeagueDTOs;
import rpa.model.LeagueEntity;
import rpa.repository.LeagueRepository;
import rpa.service.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Endpoints for fetching events")
public class Controller {

    private final LeagueRepository leagueRepository;

    private ApiService apiService;

    @Autowired
    public Controller(LeagueRepository leagueRepository, ApiService apiService) {
        this.leagueRepository = leagueRepository;
        this.apiService = apiService;
    }

    @GetMapping("/getEventList")
    public ResponseEntity<List<EventResponseDTO>> getEventList() {

        ResponseEntity<DataDTO> data = apiService.getSchedule();
        apiService.saveSchedule(Objects.requireNonNull(Objects.requireNonNull(data.getBody()).getData()).getSchedule());
        List<EventResponseDTO> events = apiService.getAllEvents();

        return ResponseEntity.ok(events);

    }

    @GetMapping("/getTodaysEvents")
    public ResponseEntity<List<EventResponseDTO>> getTodaysEvents() {
        return ResponseEntity.ok(apiService.getTodaysEvents());

    }

    @PatchMapping("/initiateDataUpdate")
    public void update() {
        ResponseEntity<DataDTO> data = apiService.getSchedule();
        apiService.saveSchedule(Objects.requireNonNull(Objects.requireNonNull(data.getBody()).getData()).getSchedule());
    }
}
