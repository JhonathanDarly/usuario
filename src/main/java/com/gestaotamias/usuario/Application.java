package com.gestaotamias.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = "com.gestaotamias.usuario.infrastructure.entity")
//@EnableJpaRepositories(basePackages = "com.gestaotamias.usuario.infrastructure.repository")
public class Application {

    public static void main(String[] args) {
        try {

            SpringApplication.run(Application.class, args);
        } catch (Exception e) {
            System.err.println("Erro ao iniciar a aplicação:");
            e.printStackTrace(System.err);
            // Imprime o stack trace completo, incluindo causas aninhadas
            Throwable cause = e.getCause();
            while (cause != null) {
                System.err.println("\nCausado por:");
                cause.printStackTrace(System.err);
                cause = cause.getCause();
            }
        }
    }
}
