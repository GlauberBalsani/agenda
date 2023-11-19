package com.balsani.agenda.domain.model.dto.mapper;

import com.balsani.agenda.domain.model.Paciente;
import com.balsani.agenda.domain.model.dto.PacienteDTO;
import com.balsani.agenda.domain.model.dto.PacienteRequestDTO;
import com.balsani.agenda.domain.model.dto.PacienteResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {
    public static Paciente toEntity(PacienteRequestDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.nome());
        paciente.setSobrenome(pacienteDTO.sobrenome());
        paciente.setEmail(pacienteDTO.email());
        paciente.setCpf(pacienteDTO.cpf());

        return paciente;
    }

    public static PacienteResponseDTO toPacienteResponse(Paciente paciente) {
        return new PacienteResponseDTO(
                paciente.getNome(),
                paciente.getSobrenome(),
                paciente.getEmail(),
                paciente.getCpf()
        );
    }
}
