package com.balsani.agenda.domain.repository;

import com.balsani.agenda.domain.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByNome(String nome);
    Optional<Paciente> findByCpf(String cpf);
}
