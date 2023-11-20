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
    private final AgendaRepository repository;
    private final PacienteService pacienteService;

    public AgendaService (AgendaRepository agendaRepository, PacienteService pacienteService) {
        this.repository = agendaRepository;
        this.pacienteService = pacienteService;


    }

    public List<Agenda> findAll() {
        return repository.findAll();
    }

    public Optional<Agenda> buscarPorId(Long id) {
        return repository.findById(id);
    }


    public Agenda salvar(Agenda agenda) {
        Paciente paciente = agenda.getPaciente();

        if (paciente == null || paciente.getId() == null) {
            throw new BusinessException("Paciente não informado ou ID do paciente não encontrado na agenda");
        }

        Optional<Paciente> optPaciente = pacienteService.findById(paciente.getId());

        if (optPaciente.isEmpty()) {
            throw new BusinessException("Paciente não encontrado");
        }

        Optional<Agenda> optHorario = repository.findByDataHorario(agenda.getDataHorario());

        if (optHorario.isPresent()) {
            throw new BusinessException("Já existe agendamento para este horário");
        }

        agenda.setPaciente(optPaciente.get());
        agenda.setDataCriacao(LocalDateTime.now());

        return repository.save(agenda);
    }
}
