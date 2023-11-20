package com.balsani.agenda.domain.controller;

import com.balsani.agenda.domain.model.Agenda;
import com.balsani.agenda.domain.model.dto.AgendaRequest;
import com.balsani.agenda.domain.model.dto.AgendaResponse;
import com.balsani.agenda.domain.model.dto.mapper.AgendaMapper;
import com.balsani.agenda.domain.service.AgendaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agenda")
public class AgendaController {
    private final AgendaService agendaService;
    private final AgendaMapper mapper;

    public AgendaController(AgendaService agendaService,AgendaMapper mapper ) {
        this.agendaService = agendaService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<AgendaResponse>> getAll() {
        List<Agenda> agendas = agendaService.findAll();
        List<AgendaResponse> agendaResponses = mapper.toAgendaResponseList(agendas);

        return ResponseEntity.status(HttpStatus.OK).body(agendaResponses);
    }

    @PostMapping
    public ResponseEntity<AgendaResponse> salvar(@RequestBody AgendaRequest request) {
        Agenda agenda = mapper.toAgenda(request);
        Agenda agendaSalva = agendaService.salvar(agenda);
        AgendaResponse agendaResponse = mapper.toAgendaResponse(agendaSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaResponse);
    }
}
