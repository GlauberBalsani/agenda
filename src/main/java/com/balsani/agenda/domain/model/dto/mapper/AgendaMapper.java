package com.balsani.agenda.domain.model.dto.mapper;

import com.balsani.agenda.domain.model.Agenda;
import com.balsani.agenda.domain.model.dto.AgendaRequest;
import com.balsani.agenda.domain.model.dto.AgendaResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgendaMapper {

    private final ModelMapper mapper;

    public AgendaMapper(ModelMapper mapper) {
        this.mapper = mapper;

    }

    public Agenda toAgenda(AgendaRequest agendaRequest) {
        return mapper.map(agendaRequest, Agenda.class);
    }

    public AgendaResponse toAgendaResponse(Agenda agenda) {
        return mapper.map(agenda, AgendaResponse.class);
    }

    public List<AgendaResponse> toAgendaResponseList(List<Agenda> agendas) {
        return agendas.stream()
                .map(this::toAgendaResponse)
                .collect(Collectors.toList());
    }
}
