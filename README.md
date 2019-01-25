# PruebaSocketsClienteServidor

En este proyecto realizamos en JAVA la conexión entre un cliente y un servidor. Utilizando Sockets y haciendo que el servidor se conecte a una API externa que nos devuelve el tiempo que hay en una ciudad que solicitemos mediante teclado.

# La API --> OpenWeatherMap

Lo único que no está añadido dentro del repositorio es un clase java que nos devuelve la key de nuesto usuario.

    package com.mycompany.servidor;

    /**
     *
     * @author ismaelds
    */
    public class ApiKey {
        public static String getApiKey(){
            return "la_key_que_vayan_a_utilizar";
        }
    }

Para ello solo se debe hacer un usuario gratuito dentro de la web: 

[OpenWeatherMap](https://openweathermap.org/)

#Proyecto

Este proyecto es la continuación de un proyecto de clase del IES El Rincón y gracias al usuario [tcrurav](https://github.com/tcrurav) en github.
Aquí el link al proyecto original [socketsmultiusuario](https://github.com/tcrurav/EjemplosPara2DAMT/tree/master/SocketsMultiusuario/EjemploBasico).