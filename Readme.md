# Administrador de franquicias, sucursales y productos

## Description

El administrador de franquicias tiene como objetivo disponer API REST que permitan hacer la manipulación y configuración de los datos relacionados a las mismas, tales como las sucursales y productos.

## Features

- Crear una franquicia
- Crear una sucursal a una franquicia
- Crear un producto asociado a una sucursal
- Reporte de Stock

## Tech

- Java 17
- Docker
- Docker compose
- IDE Development (Intellij, VSC, entre otros)

## Installation

Para ejecutar el proyecto en ambiente local se usan contenedores con Docker para la App y para la Base de datos Mysql

1. Clone el proyecto del siguiente enlace: [GitHUb](https://github.com/Jonathan-ordonez-projects/franquicia-ms)

2. Desde la consola de comandos de su preferencia ubicarse en la carpeta raiz del proyecto y ejecutar lo siguiente:

```sh
./gradlew build
```
- Se visualizará un resultado como el siguiente:  BUILD SUCCESSFUL.

Luego para ejcutar los contenedores ejecutar el siguiente comando:

En Windows
```sh
docker compose up -d
```
Para Linux y MAC
```sh
sudo docker compose up -d
```

Para terminar los contenedores creados usamos el siguiente comando:

```sh
sudo docker compose down
```

- Se visualizará un resultado como el siguiente:

✔ Network franquicia_default      Created
✔ Container franquicia-db-1       Started
✔ Container franquicia-adminer-1  Started
✔ Container franquicias-app       Started

Esperar unos minutos que se aprovisionen los contenedores y ya queda lista la aplicación para su uso.

## Consumos de APIS

En el proyecto se encuentra una Postman Collection con los request disponibles para consumo.

https://github.com/Jonathan-ordonez-projects/franquicia-ms/blob/master/Franchises.postman_collection.json

Tener en cuenta lo siguiente:

- En la edición de una Franquicia se indica el id por medio de un PathParam

```sh
api/v1/franchises/edit/{idFranquicia}
```

- En la creación de una Sucursal asociada a una Franquicia, esta franquicia se indica por medio de un PathParam

```sh
api/v1/franchises/{idFranquicia}/branch
```

- En la edición de una Sucursal, esta sucursal se indica por medio de un PathParam

```sh
api/v1/branch/edit/{idSucursal}
```

- En la creación de un Producto asociado a una Sucursal, esta sucursal se indica por medio de un PathParam

```sh
api/v1/branch/{idSucursal}/product
```

- En la edición de un Producto, este producto se indica por medio de un PathParam

```sh
api/v1/product/edit/{idProducto}
```
- En la consulta del producto con mas Stock por Sucursal para una franquicia determinada, esta franquicia se indica por medio de un PathParam

```sh
api/v1/franchises/{idFranquicia}/max-product-for-branch
```

## Conexion a la BD

Se puede usar la herramienta de su preferencia y los datos de conexión son los siguientes:

| Atributo | Descripción |
| ------ | ------ |
| Tipo BD | MySQL |
| DATABASE_NAME | franchises |
| DATABASE_USER | mysqluser |
| DATABASE_PASSWORD | secret |
| DATABASE_PORT | 3306 |
| DATABASE_HOST | localhost |





## License

**Free Software**
