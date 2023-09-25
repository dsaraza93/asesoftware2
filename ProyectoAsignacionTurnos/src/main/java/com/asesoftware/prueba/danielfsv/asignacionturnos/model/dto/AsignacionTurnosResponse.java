package com.asesoftware.prueba.danielfsv.asignacionturnos.model.dto;

public class AsignacionTurnosResponse {

    private String ID_TURNO;
    private String ID_SERVICIO;
    private String FECHA_TURNO;
    private String HORA_INICIO;
    private String HORA_FIN;
    private String ESTADO;

    public String getID_TURNO() {
        return ID_TURNO;
    }

    public void setID_TURNO(String ID_TURNO) {
        this.ID_TURNO = ID_TURNO;
    }

    public String getID_SERVICIO() {
        return ID_SERVICIO;
    }

    public void setID_SERVICIO(String ID_SERVICIO) {
        this.ID_SERVICIO = ID_SERVICIO;
    }

    public String getFECHA_TURNO() {
        return FECHA_TURNO;
    }

    public void setFECHA_TURNO(String FECHA_TURNO) {
        this.FECHA_TURNO = FECHA_TURNO;
    }

    public String getHORA_INICIO() {
        return HORA_INICIO;
    }

    public void setHORA_INICIO(String HORA_INICIO) {
        this.HORA_INICIO = HORA_INICIO;
    }

    public String getHORA_FIN() {
        return HORA_FIN;
    }

    public void setHORA_FIN(String HORA_FIN) {
        this.HORA_FIN = HORA_FIN;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }
}
