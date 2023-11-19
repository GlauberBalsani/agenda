package com.balsani.agenda.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "descricao_id_seq")
    @SequenceGenerator(name = "descricao_id_seq", sequenceName = "descricao_id_seq", allocationSize = 1)
    @Column(name = "agenda_id")
    private Long id;
    @Column(name = "descricao", unique = true, nullable = false)
    private String descricao;
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHorario;
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return Objects.equals(id, agenda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataHorario=" + dataHorario +
                ", dataCriacao=" + dataCriacao +
                ", paciente=" + paciente +
                '}';
    }
}
