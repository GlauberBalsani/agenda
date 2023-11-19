package com.balsani.agenda.domain.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacienteRequest(
        @NotBlank
        String nome,
        @NotNull
        String sobrenome,
        @NotNull
        String email,
        @NotNull
        String cpf
) {

}
