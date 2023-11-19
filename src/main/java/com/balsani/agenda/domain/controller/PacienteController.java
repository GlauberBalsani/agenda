package com.balsani.agenda.domain.controller;

import com.balsani.agenda.domain.model.Paciente;
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
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente) {
        Paciente save = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAll() {
        List<Paciente> all = pacienteService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable Long id) {
        Optional<Paciente> byId = pacienteService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Paciente paciente = byId.get();
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }

}
