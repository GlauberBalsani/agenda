package com.balsani.agenda.domain.controller;

import com.balsani.agenda.domain.model.Paciente;
import com.balsani.agenda.domain.model.dto.PacienteRequestDTO;
import com.balsani.agenda.domain.model.dto.mapper.PacienteMapper;
import com.balsani.agenda.domain.model.dto.PacienteResponseDTO;
import com.balsani.agenda.domain.service.PacienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> save(@RequestBody PacienteRequestDTO pacienteRequestDTO) {
        Paciente paciente = PacienteMapper.toEntity(pacienteRequestDTO);
        Paciente bodyPaciente = pacienteService.save(paciente);
        PacienteResponseDTO dto = PacienteMapper.toPacienteResponse(bodyPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAll() {
        List<Paciente> all = pacienteService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);

    }

    @GetMapping("{id}")
    public ResponseEntity<Paciente> getById(@PathVariable Long id) {
        Optional<Paciente> byId = pacienteService.findById(id);
        if (!byId.isPresent()) {

            return ResponseEntity.notFound().build();
        }

        Paciente paciente = byId.get();
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }

    @PutMapping
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente) {
        Paciente save = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delet(@PathVariable Long id) {
        pacienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
