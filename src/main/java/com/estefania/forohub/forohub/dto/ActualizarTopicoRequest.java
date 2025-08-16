package com.estefania.forohub.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public class ActualizarTopicoRequest {
    @NotBlank private String titulo;
    @NotBlank private String mensaje;
    @NotBlank private String estado;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}