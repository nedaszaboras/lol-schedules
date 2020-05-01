package rpa.model;

import lombok.Data;

import java.util.List;

@Data
public class ScheduleDTO {
    private PagesDTO pages;
    private List<EventDTO> events;
}
