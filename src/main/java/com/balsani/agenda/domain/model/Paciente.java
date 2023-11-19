package com.balsani.agenda.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_id_seq")
    @SequenceGenerator(name = "paciente_id_seq", sequenceName = "paciente_id_seq", allocationSize = 1)
    @Column(name = "paciente_id")
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "cpf")
    private String cpf;


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
