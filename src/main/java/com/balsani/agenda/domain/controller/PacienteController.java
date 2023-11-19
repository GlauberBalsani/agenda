package com.balsani.agenda.domain.controller;

import com.balsani.agenda.domain.model.Paciente;
import com.balsani.agenda.domain.model.dto.PacienteRequest;
import com.balsani.agenda.domain.model.dto.mapper.PacienteMapper;
import com.balsani.agenda.domain.model.dto.PacienteResponse;
import com.balsani.agenda.domain.service.PacienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    private final PacienteService pacienteService;
    private final PacienteMapper pacienteMapper;

    public PacienteController(PacienteService pacienteService, PacienteMapper pacienteMapper) {
        this.pacienteService = pacienteService;
        this.pacienteMapper = pacienteMapper;
    }

    @PostMapping
    public ResponseEntity<PacienteResponse> save(@RequestBody PacienteRequest pacienteRequest) {
        Paciente paciente = pacienteMapper.toEntity(pacienteRequest);
        Paciente bodyPaciente = pacienteService.save(paciente);
        PacienteResponse pacienteResponse = pacienteMapper.toPacienteResponse(bodyPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteResponse);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> getAll() {
        List<Paciente> all = pacienteService.findAll();
        List<PacienteResponse> pacienteResponses = pacienteMapper.toPacienteResponseList(all);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponses);

    }

    @GetMapping("{id}")
    public ResponseEntity<PacienteResponse> getById(@PathVariable Long id) {
        Optional<Paciente> byId = pacienteService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(pacienteMapper.toPacienteResponse(byId.get()));
    }

    @PutMapping("{id}")
    public ResponseEntity<PacienteResponse> update(@PathVariable Long id, @RequestBody PacienteRequest pacienteRequest) {
        Paciente paciente = pacienteMapper.toEntity(pacienteRequest);
        Paciente bodyPaciente = pacienteService.update(id, paciente);
        PacienteResponse pacienteResponse = pacienteMapper.toPacienteResponse(bodyPaciente);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pacienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
