package com.balsani.agenda.domain.model.dto;

import jakarta.validation.constraints.NotBlank;

public class PacienteRequest {
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    private String email;
    @NotBlank
    private String cpf;


}
