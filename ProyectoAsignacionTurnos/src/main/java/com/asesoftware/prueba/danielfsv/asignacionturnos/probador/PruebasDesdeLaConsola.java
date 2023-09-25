package com.asesoftware.prueba.danielfsv.asignacionturnos.probador;

import com.asesoftware.prueba.danielfsv.asignacionturnos.component.persistence.DAO.AsignacionTurnosDAO;
import com.asesoftware.prueba.danielfsv.asignacionturnos.model.dto.AsignacionTurnosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Imports o librerias relacionadas con el tema de base de datos JDBC
// para consultar o llamar el procedimiento almacenado de Oracle
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import oracle.jdbc.OracleTypes;


@SpringBootApplication(scanBasePackages={"com.asesoftware.prueba.danielfsv"})
public class PruebasDesdeLaConsola  implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PruebasDesdeLaConsola.class);

    public static void main(String args[]) {
        SpringApplication.run(PruebasDesdeLaConsola.class, args);
    }

    @Autowired
    AsignacionTurnosDAO asignacionTurnosDAO;

    @Override
    public void run(String... args) throws Exception {
        log.info("Prueba con info");
        log.debug("Prueba con debug");
        log.error("Prueba con error");
        //ejecutarProcedimientoAlmacenado();
        PruebaLlamadoProcedimientoAlmacenado();
    }


    @Autowired
    JdbcTemplate jdbcTemplate;

    public void ejecutarProcedimientoAlmacenado() {
        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement callableStatement = connection.prepareCall("{call USUARIO_PRUEBA.ObtenerDatosCombinados(?, ?, ?, ?)}")) {
                callableStatement.setDate(1, java.sql.Date.valueOf("2023-09-01"));
                callableStatement.setDate(2, java.sql.Date.valueOf("2023-09-30"));
                callableStatement.setString(3, "1");
                callableStatement.registerOutParameter(4, OracleTypes.CURSOR); // Tipo de dato para el cursor
                callableStatement.execute();
                // Obtener el cursor de resultados
                ResultSet resultSet = (ResultSet) callableStatement.getObject(4);
                while (resultSet.next()) {
                    // Procesar los resultados del cursor
                    String idTurno = resultSet.getString("ID_TURNO");
                    String idServicio = resultSet.getString("ID_SERVICIO");
                    log.info("ID_TURNO "+idTurno+" ID_SERVICIO -> "+idServicio);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }


    public void PruebaLlamadoProcedimientoAlmacenado(){
        List<AsignacionTurnosResponse> l_resultado = asignacionTurnosDAO.ejecutarProcedimientoAlmacenado("2023-09-01","2023-09-30","1");
        for(AsignacionTurnosResponse response:l_resultado){
            System.out.println(response.getID_TURNO());
        }
    }
}
