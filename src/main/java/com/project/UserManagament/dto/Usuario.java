package com.project.UserManagament.dto;

import com.project.UserManagament.enums.Dependencia;
import com.project.UserManagament.enums.Perfil;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Usuario {
    private int id;
    private Date fecha_nacimiento;
    private Boolean activo;
    private Dependencia dependencia;
    private List<Perfil> perfil;
    private List<Fila> filas;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Date getFecha_nacimiento() {
//        return fecha_nacimiento;
//    }
//
//    public void setFecha_nacimiento(Date fecha_nacimiento) {
//        this.fecha_nacimiento = fecha_nacimiento;
//    }
//
//    public Boolean getActivo() {
//        return activo;
//    }
//
//    public void setActivo(Boolean activo) {
//        this.activo = activo;
//    }
//
//    public Dependencia getDependencia() {
//        return dependencia;
//    }
//
//    public void setDependencia(Dependencia dependencia) {
//        this.dependencia = dependencia;
//    }
//
//    public List<Perfil> getPerfil() {
//        return perfil;
//    }
//
//    public void setPerfil(List<Perfil> perfil) {
//        this.perfil = perfil;
//    }
//
//    public List<Fila> getFilas() {
//        return filas;
//    }
//
//    public void setFilas(List<Fila> filas) {
//        this.filas = filas;
//    }
}
