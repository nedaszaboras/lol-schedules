package rpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rpa.mapper.ScheduleDTOToEntityMapper;
import rpa.mapper.ScheduleToDTOMapper;
import rpa.model.*;
import rpa.repository.EventRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ApiService {

    private final EventRepository eventRepository;

    private final ScheduleDTOToEntityMapper scheduleDTOToEntityMapper;

    private final ScheduleToDTOMapper scheduleToDTOMapper;

    private String endpoint = "https://esports-api.lolesports.com/persisted/gw/";

    @Autowired
    public ApiService(EventRepository eventRepository, ScheduleDTOToEntityMapper scheduleDTOToEntityMapper, ScheduleToDTOMapper scheduleToDTOMapper) {
        this.eventRepository = eventRepository;
        this.scheduleDTOToEntityMapper = scheduleDTOToEntityMapper;
        this.scheduleToDTOMapper = scheduleToDTOMapper;
    }

    public ResponseEntity<DataDTO> getSchedule() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange("https://esports-api.lolesports.com/persisted/gw/getSchedule?hl=en-GB", HttpMethod.GET, createHttpEntity(), DataDTO.class);
    }

    public List<EventResponseDTO> getAllEvents() {
        List<EventEntity> allEvents = eventRepository.findAll();
        return allEvents.stream().map(scheduleToDTOMapper::map).collect(Collectors.toList());
    }

    public void saveSchedule(ScheduleDTO scheduleDTO) {
        Objects.requireNonNull(scheduleDTO.getEvents()).forEach(e -> {
            eventRepository.save(scheduleDTOToEntityMapper.map(e));
        });
    }

    public List<EventResponseDTO> getTodaysEvents() {
        LocalDateTime startDate = LocalDate.now().atStartOfDay();
        LocalDateTime endDate = startDate.plusDays(1);

//        dateTime = dateTime.plusDays(1);
//        return eventRepository.findAllByStartTimeAfter(new DateTime().withTimeAtStartOfDay()).stream().map(scheduleToDTOMapper::map).collect(Collectors.toList());
        return eventRepository.findAllByStartTimeBetween(startDate, endDate).stream().map(scheduleToDTOMapper::map).collect(Collectors.toList());

    }

    public void getFullScheduleWithPagination() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DataDTO> data = restTemplate.exchange("https://esports-api.lolesports.com/persisted/gw/getSchedule?hl=en-GB", HttpMethod.GET, createHttpEntity(), DataDTO.class);
//        ResponseEntity<Data> data = restTemplate.exchange(endpoint + "getSchedule?hl=en-GB", HttpMethod.GET, createHttpEntity(), Data.class);
        String oldPageToken = Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(data.getBody()).getData()).getSchedule().getPages()).getOlder();
        List<DataDTO> fullDataDTO = new ArrayList<>();
        fullDataDTO.add(data.getBody());
        while (oldPageToken != null) {
            data = restTemplate.exchange("https://esports-api.lolesports.com/persisted/gw/getSchedule?hl=en-GB" + "&pageToken=" +oldPageToken, HttpMethod.GET, createHttpEntity(), DataDTO.class);
            if (Objects.equals(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(data.getBody()).getData()).getSchedule().getPages()).getOlder(), oldPageToken)) {
                oldPageToken = null;
            }
            else {
                fullDataDTO.add(data.getBody());
                oldPageToken = Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(data.getBody()).getData()).getSchedule().getPages()).getOlder();
            }
        }
        System.out.println(data);
    }

    //get event details, that include stream information
    // MATCH ID REQUIRED
    private void getEventDetails() {}

//    private List<String> getLeagueIds() {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<LeagueDTO> data = restTemplate.exchange("https://esports-api.lolesports.com/persisted/gw/getLeagues?hl=en-GB", HttpMethod.GET, createHttpEntity(), LeagueDTO.class);
//
//        List<LeagueEntity> entities = new ArrayList<>();
//        List<LeagueDTOs> dtos = Objects.requireNonNull(data.getBody()).getData().getLeagues();
//
//        return dtos.stream().map(LeagueDTOs::getId
//        ).collect(Collectors.toList());
//    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "0TvQnueqKa5mxJntVWt0w4LpLfEkrV1Ta8rQBb9Z");
        return headers;
    }

    private HttpEntity<?> createHttpEntity() {
        return new HttpEntity<String>(createHeaders());
    }
}
