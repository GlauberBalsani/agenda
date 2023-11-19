package com.balsani.agenda.domain.service;

import com.balsani.agenda.domain.exception.BusinessException;
import com.balsani.agenda.domain.model.Paciente;
import com.balsani.agenda.domain.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente save(Paciente paciente) {
        boolean existeCpf = false;

        Optional<Paciente> byCpf = pacienteRepository.findByCpf(paciente.getCpf());

        if (byCpf.isPresent()) {
            if (!byCpf.get().getId().equals(paciente.getId())) {
                existeCpf = true;
            }
        }

        if (existeCpf) {
            throw new BusinessException("Cpf jáá existe");
        }

        return pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente update(Long id, Paciente paciente) {
        Optional<Paciente> pacienteBody = pacienteRepository.findById(id);

        if (pacienteBody.isEmpty()) {
            throw new BusinessException("Paciente não cadastrado");
        }
        paciente.setId(id);

        return save(paciente);
    }
}
