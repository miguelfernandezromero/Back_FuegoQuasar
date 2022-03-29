# Operaciòn Fuego de Quasar

## Software Architecture

The application was developed under the Model-View-Controller (MVC) architecture pattern, which separates data and business logic.

The Back product is developed with Java 1.8 technology and with the Spring Boot framework

## EndPoint

Post -> /topsecret/

This method returns the coordinates 'x' and 'y' and the message as generated by the sender of the message

![Captura de Pantalla 2022-03-27 a la(s) 11 06 18 p  m](https://user-images.githubusercontent.com/36859045/160324896-b170c2a0-ae5e-4c82-a959-e9ccfc269017.png)

Post -> /topsecret_split/{satellite_name}

This method we can add or update a satellite in the database

![Captura de Pantalla 2022-03-27 a la(s) 11 08 55 p  m](https://user-images.githubusercontent.com/36859045/160325120-b98d102d-1605-4dc7-81e6-f23855ecae57.png)

Get -> /topsecret_split/

This method returns a list with the added satellites

![Captura de Pantalla 2022-03-27 a la(s) 11 10 21 p  m](https://user-images.githubusercontent.com/36859045/160325235-173b6fa8-d6af-4566-900e-879f6f8a9562.png)

## Host
 The application is hosted on: https://fuegoquasarback.herokuapp.com/