package com.balsani.agenda.domain.service;

import com.balsani.agenda.domain.exception.BusinessException;
import com.balsani.agenda.domain.model.Agenda;
import com.balsani.agenda.domain.model.Paciente;
import com.balsani.agenda.domain.repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;
    private final PacienteService pacienteService;

    public AgendaService (AgendaRepository agendaRepository, PacienteService pacienteService) {
        this.agendaRepository = agendaRepository;
        this.pacienteService = pacienteService;


    }

    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    public Optional<Agenda> findById(Long id) {
        return agendaRepository.findById(id);
    }

    public Agenda salvar(Agenda agenda) {
        Optional<Paciente> optPaciente = pacienteService.findById(agenda.getPaciente().getId());

        if (optPaciente.isEmpty()) {
            throw new BusinessException("Paciente não encontrado");
        }

        Optional<Agenda> optHorario = agendaRepository.findByDataHorario(agenda.getDataHorario());

        if (optHorario.isPresent()) {
            throw new BusinessException("Já existe agendamento para este horário");
        }

        agenda.setPaciente(optPaciente.get());
        agenda.setDataCriacao(LocalDateTime.now());

        return agendaRepository.save(agenda);
    }
}
