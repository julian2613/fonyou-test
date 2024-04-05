# FONYOU - Prueba tecnica
## Requisitos
* Docker
* Docker compose
* Postman
## Posibles mejoras
* Abstraer los crud
* Implementar sistema de versionado de base de datos *"liquibase,flyway"*
## Aclaraciones
* Si se desea importar la coleccion de postman, se puede usar el archivo *Test.postman_collection.json* que se encuentra dentro del proyecto
* A continuacion se evidencia la estructura de mensaje de error
```json
{
  "code": "INVALID_REQUEST",
  "message": "Peticion invalida"
}
```
## Instalacion
    docker compose up
## Uso
### Crear un examen
Para crear un examen se debe tener en cuenta lo siguiente:
* El número de preguntas *"questions"* no tiene limite
* Cada pregunta obligatoriamente debe tener 4 respuestas *"answers"*
* Solamente una respuesta *"answer"* puede ser correcta
* La sumatoria del valor *"value"* dentro de cada pregunta *"question"* debe ser 100
* Todos los campos son obligatorios
#### Curl
```shell
curl --location 'http://localhost:8080/quiz' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Ciclo 1",
    "questions": [
        {
            "description": "¿Que fue primero, el huevo o la gallina",
            "value": 100,
            "answers": [
                {
                    "description": "El huevo",
                    "isCorrect": true
                },
                {
                    "description": "La gallina",
                    "isCorrect": false
                },
                {
                    "description": "Ambos",
                    "isCorrect": false
                },
                {
                    "description": "Ninguno",
                    "isCorrect": false
                }
            ]
        }
    ]
}'
```
#### Respuesta
```json
{
    "id": "66a93c38-79ad-4058-8ca1-c7c2ebc3d689",
    "name": "Ciclo 1",
    "questions": [
        {
            "id": "3a89c679-2049-4298-af2c-8a2d7408712d",
            "description": "¿Que fue primero, el huevo o la gallina",
            "answers": [
                {
                    "id": "9bed60ca-9bd2-4018-af60-244ea6f75afe",
                    "description": "El huevo",
                    "isCorrect": true
                },
                {
                    "id": "0c253022-dfb8-4c12-9e81-52e90fbffa85",
                    "description": "La gallina",
                    "isCorrect": false
                },
                {
                    "id": "799f6ed8-f072-48e5-80b7-65246c8893fb",
                    "description": "Ambos",
                    "isCorrect": false
                },
                {
                    "id": "00bfb493-67fa-409b-905b-a4d2c755c4c9",
                    "description": "Ninguno",
                    "isCorrect": false
                }
            ]
        }
    ]
}
```
### Crear un estudiante
Para crear un estudiante se debe tener en cuenta lo siguiente:
* El campo *"timezone"* debe ser válido, para más información ver: https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
* Todos los campos son obligatorios
#### Curl
```shell
curl --location 'http://localhost:8080/student' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Luisa fernanda",
    "birthdate": "1998-02-02",
    "city": "Brasilia",
    "timezone": "America/Boa_Vista"
}'
```
#### Respuesta
```json
{
    "id": "a33c5c9b-4259-417d-b68d-5cd290cac9c7",
    "name": "Luisa fernanda",
    "birthdate": "1998-02-02",
    "city": "Brasilia",
    "timezone": "America/Boa_Vista"
}
```

### Definir fecha del examen y asignar examen a estudiantes en su zona horaria
Para definir fecha y asistencia de un examen se debe tener en cuenta lo siguiente:
* El campo *"timezone"* debe ser válido, para más información ver: https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
* El campo *"quiz.id"* debe ser un quiz válido previamente creado mediante la opcion *"Crear examen"*
* El campo *"students.id"* debe ser un estudiante válido previamente creado mediante la opcion *"Crear estudiante"*
* Todos los campos son obligatorios
#### Curl
```shell
curl --location 'http://localhost:8080/exam' \
--header 'Content-Type: application/json' \
--data '{
    "presentationDate": "2014-04-04T12:00:00",
    "timezone": "America/Bogota",
    "quiz": {
        "id": "caf4e147-c3c4-4924-96ba-05ab9d709861"
    },
    "students": [
        {
            "id": "13ebb088-0541-454d-b5a3-c3e9ed7602d3"
        },
        {
            "id": "a33c5c9b-4259-417d-b68d-5cd290cac9c7"
        }
    ]
}'
```
#### Respuesta
```json
{
    "presentationDate": "2014-04-04T12:00:00",
    "timezone": "America/Bogota",
    "quiz": {
        "id": "caf4e147-c3c4-4924-96ba-05ab9d709861"
    },
    "students": [
        {
            "id": "13ebb088-0541-454d-b5a3-c3e9ed7602d3"
        },
        {
            "id": "a33c5c9b-4259-417d-b68d-5cd290cac9c7"
        }
    ]
}
```
### Consultar examenes por estudiante
Una vez definida la fecha y hora de presentacion de un examen el estudiante puede consultar él sus examentes pendientes
Para consultar examenes por estudiante se debe tener en cuenta lo siguiente:
* El path param *"STUDENT_ID"* debe ser un, id de un estudiante válido, previamente creado mediante el servicio de *"Crear estudiante"*
#### Curl
```shell
curl --location 'http://localhost:8080/exam/findByStudent/:STUDENT_ID'
```
#### Respuesta
```json
[
    {
        "presentationDate": "2014-04-04T13:00:00",
        "timezone": "America/Boa_Vista",
        "quiz": {
            "id": "caf4e147-c3c4-4924-96ba-05ab9d709861",
            "name": "Ciclo 1"
        }
    }
]
```
### Recopilar las respuestas de un estudiante y Calificar los exámenes
Se pueden enviar respuestas de los examenes para su calificacion teniendo en cuenta lo siguiente:
* El parametro *"quiz.id"* debe ser un, id válido previamente creado mediante el servicio de *"Crear examen"*
* El parametro *"student.id"* debe ser un, id válido previamente creado mediante el servicio de *"Crear estudiante"*
* El parametro *"answers.questionId" y "answers.answerId"* deben ser id válidos previamente creados mediante el servicio *"Crear examen"*
#### Curl
```shell
curl --location 'http://localhost:8080/exam-answer' \
--header 'Content-Type: application/json' \
--data '{
    "quiz": {
        "id": "66a93c38-79ad-4058-8ca1-c7c2ebc3d689"
    },
    "student": {
        "id": "a33c5c9b-4259-417d-b68d-5cd290cac9c7"
    },
    "answers": [
        {
            "questionId": "3a89c679-2049-4298-af2c-8a2d7408712d",
            "answerId": "9bed60ca-9bd2-4018-af60-244ea6f75afe"
        }
    ]
}'
```
#### Respuesta
```json
{
    "id": "9b3183d0-dcd4-4f42-b880-ddf54278d62e",
    "score": 100.0,
    "quiz": {
        "id": "66a93c38-79ad-4058-8ca1-c7c2ebc3d689"
    },
    "student": {
        "id": "a33c5c9b-4259-417d-b68d-5cd290cac9c7"
    },
    "answers": [
        {
            "questionId": "3a89c679-2049-4298-af2c-8a2d7408712d",
            "answerId": "9bed60ca-9bd2-4018-af60-244ea6f75afe"
        }
    ]
}
```