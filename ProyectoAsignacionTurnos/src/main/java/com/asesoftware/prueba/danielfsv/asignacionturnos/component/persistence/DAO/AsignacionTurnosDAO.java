package com.asesoftware.prueba.danielfsv.asignacionturnos.component.persistence.DAO;

import com.asesoftware.prueba.danielfsv.asignacionturnos.model.dto.AsignacionTurnosResponse;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AsignacionTurnosDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<AsignacionTurnosResponse> ejecutarProcedimientoAlmacenado(String fechaInicio, String fechaFinal, String idServicio) {
        List<AsignacionTurnosResponse> l_resultado = new ArrayList<>();
        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement callableStatement = connection.prepareCall("{call USUARIO_PRUEBA.ObtenerDatosCombinados(?, ?, ?, ?)}")) {
                callableStatement.setDate(1, java.sql.Date.valueOf(fechaInicio));
                callableStatement.setDate(2, java.sql.Date.valueOf(fechaFinal));
                callableStatement.setString(3, idServicio);
                callableStatement.registerOutParameter(4, OracleTypes.CURSOR); // Tipo de dato para el cursor
                callableStatement.execute();
                // Obtener el cursor de resultados
                ResultSet resultSet = (ResultSet) callableStatement.getObject(4);
                while (resultSet.next()) {
                    AsignacionTurnosResponse response = new AsignacionTurnosResponse();
                    response.setID_TURNO(resultSet.getString("ID_TURNO"));
                    response.setID_SERVICIO(resultSet.getString("ID_SERVICIO"));
                    response.setFECHA_TURNO(resultSet.getString("FECHA_TURNO"));
                    response.setHORA_INICIO(resultSet.getString("HORA_INICIO"));
                    response.setHORA_FIN(resultSet.getString("HORA_FIN"));
                    l_resultado.add(response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
        return l_resultado;
    }
}
