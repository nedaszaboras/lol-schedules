package rpa.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResponseDTO {
    private List<EventResponseDTO> events;
}

