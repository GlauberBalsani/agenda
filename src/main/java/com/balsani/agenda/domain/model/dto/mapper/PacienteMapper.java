package com.balsani.agenda.domain.model.dto.mapper;

import com.balsani.agenda.domain.model.Paciente;
import com.balsani.agenda.domain.model.dto.PacienteRequest;
import com.balsani.agenda.domain.model.dto.PacienteResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PacienteMapper {

    private final ModelMapper mapper;

    public PacienteMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Paciente toModel(PacienteRequest pacienteRequest) {
        return mapper.map(pacienteRequest, Paciente.class);
    }

    public PacienteResponse toPacienteResponse(Paciente paciente){
        return mapper.map(paciente, PacienteResponse.class);

    }

    public List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(this::toPacienteResponse)
                .collect(Collectors.toList());
    }
//    public static Paciente toEntity(PacienteRequest pacienteDTO) {
//        Paciente paciente = new Paciente();
//        paciente.setNome(pacienteDTO.nome());
//        paciente.setSobrenome(pacienteDTO.sobrenome());
//        paciente.setEmail(pacienteDTO.email());
//        paciente.setCpf(pacienteDTO.cpf());
//
//        return paciente;
//    }

//    public static PacienteResponse toPacienteResponse(Paciente paciente) {
//        return new PacienteResponse(
//                paciente.getNome(),
//                paciente.getSobrenome(),
//                paciente.getEmail()
//                //paciente.getCpf()
//        );
//    }

//    public static List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
//        List<PacienteResponse> pacienteResponses = new ArrayList<>();
//        for(Paciente paciente : pacientes) {
//            pacienteResponses.add(toPacienteResponse(paciente));
//        }
//        return pacienteResponses;
//    }
}
