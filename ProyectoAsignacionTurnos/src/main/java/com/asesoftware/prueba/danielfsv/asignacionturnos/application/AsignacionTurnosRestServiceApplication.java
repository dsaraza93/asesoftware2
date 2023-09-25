package com.asesoftware.prueba.danielfsv.asignacionturnos.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * En Spring Boot, scanBasePackages es una propiedad que se utiliza para
 * configurar el escaneo de paquetes base para componentes administrados
 * por  Spring, como controladores, servicios y componentes. Esta propiedad
 * permite a Spring Boot buscar automáticamente componentes dentro de los
 * paquetes especificados en lugar de requerir configuraciones manuales exhaustivas.
 *
 * Referencias
 *
 * https://springhow.com/springbootapplication-annotation/
 */

@SpringBootApplication(scanBasePackages={"com.asesoftware.prueba.danielfsv"})
public class AsignacionTurnosRestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsignacionTurnosRestServiceApplication.class, args);
    }
}
