 /*CLASE PRINCIPAL
 Arranca el spring boot
👉 “Despierta.”
👉 “Levanta servidor.”
👉 “Empieza a trabajar.” */
package com.puntodeventa;//Ordena archivos

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication //Totem sagrado: CConfiguraion, busca componentes, activa la configuración automática de Spring Boot. Esencial para el arranque de la aplicación.   
public class PuntoDeVentaApplication {

    /*metodo principal que ejecuta la aplicación Spring Boot*/
    public static void main(String[] args) {
        SpringApplication.run(PuntoDeVentaApplication.class, args);
        //SpringApplication.run() es un metodo estatico
        //1 Parametro le dice desde donde arrancar la aplicación (clase actual)
        //2 Parametro son los argumentos de la línea de comandos (si los hay)
    }

}
