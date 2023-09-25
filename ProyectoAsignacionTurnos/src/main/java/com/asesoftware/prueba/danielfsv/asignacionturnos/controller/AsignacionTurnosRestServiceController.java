package com.asesoftware.prueba.danielfsv.asignacionturnos.controller;

import com.asesoftware.prueba.danielfsv.asignacionturnos.component.persistence.DAO.AsignacionTurnosDAO;
import com.asesoftware.prueba.danielfsv.asignacionturnos.model.dto.AsignacionTurnosRequest;
import com.asesoftware.prueba.danielfsv.asignacionturnos.model.dto.AsignacionTurnosResponse;
import com.asesoftware.prueba.danielfsv.asignacionturnos.probador.PruebasDesdeLaConsola;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AsignacionTurnosRestServiceController {
    private static final Logger log = LoggerFactory.getLogger(PruebasDesdeLaConsola.class);
    @Autowired
    AsignacionTurnosDAO asignacionTurnosDAO;
    @GetMapping(value="/consultarTurnos", consumes = "application/json", produces = "application/json")
    public List<AsignacionTurnosResponse> activateCardEnroll(@RequestBody AsignacionTurnosRequest request) throws Exception{
        try{
            AsignacionTurnosResponse successfulResponse = new AsignacionTurnosResponse();
            String fechaInicio = request.getFechaInicio();
            String fechaFin = request.getFechaFin();
            String idServicio = request.getIdServicio();
            return asignacionTurnosDAO.ejecutarProcedimientoAlmacenado(fechaInicio,fechaFin,idServicio);
        }catch(Exception e){
            log.error(e.toString());
        }
        return null;
    }
}
