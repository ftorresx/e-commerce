[![LinkedIn][linkedin-shield]][linkedin-url]
<p style="text-align:justify">
  <h3 align="center">E-COMMERCE TEST TUL </h3>
  <p>
    Entregable del test e-comerce, desarrollo de API REST en el lenguaje de programación Java; de acuerdo a los requerimientos técnicos. 
  </p>
  Las funcionalidades esperadas son las siguientes:

●     Lista de todos los productos

●     Agregar, eliminar y modificar productos

●     Lista de todos los productos de un carrito

●     Agregar, eliminar y modificar productos al carrito

●     Checkout, debe devolver el costo final de los productos del carrito y cambiar su estado a completado.
</p>

### Arquitectura

Aplicación construida siguiendo los principios de la [Arquitectura Limpia](https://www.freecodecamp.org/news/a-quick-introduction-to-clean-architecture-990c014448d2/), se han 
sugerido los siguientes modulos:  

 - **Config**: Modulo que permite agregar configuración y perfilamiento de la aplicación.
 - **Controller**: Modulo que guarda los posibles controladores de la aplicación.
 - **Enums**: Modulo que guarda los Enums de la aplicación.
 - **Exeption**: Modulo que guarda el manejo dela expection de respuesta al cliente de la aplicación.
 - **Model**: Modulo que representa la transformacion de data del dominio.
 - **Service**: Modulo que representa la interface de del dominio de la aplicación.
 


### Construido Con
Esta API fue contruida con el modulo Spring-Boot del Eco-Sistema o Framework Spring que permite ligera y rapidamente desplegar implicitament con TomCat los casos de usos dispuestos; Usando los principios S.O.L.I.D con el lenguaje de programación Java, como Build se uso Maven Version 3.8. 
* [MySql](https://www.mysql.com/)
* [Spring Boot](https://spring.io/)
* [Java](https://www.java.com/es/)
* [S.O.L.I.D](https://profile.es/blog/principios-solid-desarrollo-software-calidad/)


## Funcionamiento

A continuacion se realizan unas consideraciones para ejecutar y usar el API local y publicamente.

### Pre-Requisitos e Instalación Local

BD Mysql,  JDK 8 o Mayor, IDE IntelliJ u otro que permita importar y configurar los archivos:   

```pom.xml```
<p> - </p>
```aplication.properties```

<p>Clonar el repositorio y ejecuatr en el raiz del proyecto el comando </p>

```mvn install```
<p>Crear una Base de datos en MySql con el nombre de:</p>
```ecomerce```
<p>Importar el archivo</p>  
```BD_ecommerce_TUL.sql```
<p>Correr la aplicacion con Spring Boot App</p>
```La aplicacion correra por defecto en el puerto 8080```


## Uso
Considerar comprobar el funcionamiento con una herramienta como Postman o Similar para realizar la Peticiones POST y/o GET

<b>Para obtener los productos: </b> 

URL Local Metodo GET:
```http://localhost:8080/api/product/ ```

<b>Ejemplo de la respuesta</b> 
```
[
    {
        "id": "4b852323-ac8a-471b-9593-d3519cffabd2",
        "name": "Atari 2000",
        "price": 100.0,
        "description": "Atari 2000",
        "sku": "CSAT-25-A89",
        "categoryId": 1
    },
    {
        "id": "39390d56-064c-4894-bd52-5d5c0b4c5eb2",
        "name": "Sony PS4",
        "price": 1500.0,
        "description": "Sony PS4",
        "sku": "GFD-ASD-48",
        "categoryId": 1
    },
    {
        "id": "264142dd-7883-4c3d-b228-9243a026148a",
        "name": "Sony PS5",
        "price": 2500.0,
        "description": "Sony PS5",
        "sku": "TOM-25-A87",
        "categoryId": 2
    },
    {
        "id": "c7435903-35fe-4da2-8a9a-5ce60857c74e",
        "name": "XBOX Series",
        "price": 2500.0,
        "description": "XBOX Series",
        "sku": "JMT-25-N88",
        "categoryId": 2
    },
    {
        "id": "66311618-9932-477d-a585-2d84497c3396",
        "name": "Nintendo Switch",
        "price": 1300.0,
        "description": "Nintendo Switch",
        "sku": "NTY-25-N89",
        "categoryId": 2
    }
]
```

<b>Lista de todos los productos de un carrito </b> 

URL Local Metodo GET :
```http://localhost:8080/api/cart/?token=f4c3c2e9-f82a-4137-a174-de197428cd8b```


Ejemplo de la respuesta:

```
{
    "cartItems": [
        {
            "id": "3dd03c2a-633a-40da-8898-e5c6d9f49a76",
            "userId": 23,
            "quantity": 1,
            "product": {
                "id": "66311618-9932-477d-a585-2d84497c3396",
                "name": "Nintendo Switch",
                "price": 1300.0,
                "sku": "NTY-25-N89",
                "description": "Nintendo Switch"
            }
        }
    ],
    "totalCost": 1300.0
}
```

<b>Lista de todos los productos de un carrito </b> 

URL Local Metodo GET:
```http://localhost:8080/api/cart/?token=f4c3c2e9-f82a-4137-a174-de197428cd8b```


Ejemplo de la respuesta:

```
{
    "cartItems": [
        {
            "id": "3dd03c2a-633a-40da-8898-e5c6d9f49a76",
            "userId": 23,
            "quantity": 1,
            "product": {
                "id": "66311618-9932-477d-a585-2d84497c3396",
                "name": "Nintendo Switch",
                "price": 1300.0,
                "sku": "NTY-25-N89",
                "description": "Nintendo Switch"
            }
        }
    ],
    "totalCost": 1300.0
}
```

<b>Agregar productos al carrito carrito </b> 

URL Local Metodo POST:
```http://localhost:8080/api/cart/add?token=f4c3c2e9-f82a-4137-a174-de197428cd8b```


Ejemplo de la respuesta:

```
{
    "success": true,
    "message": "Added to cart",
    "timestamp": "2021-04-13T23:31:37.973211900"
}
```

<b>Checkout del carrito </b> 

URL Local Metodo POST:
```http://localhost:8080/api/order/checkout/?token=f4c3c2e9-f82a-4137-a174-de197428cd8b```

Ejemplo de la respuesta:

```
{
    "success": true,
    "message": "Checkout has been created",
    "total": 2500.0,
    "timestamp": "2021-04-13T23:12:08.750458700"
}
```

## Autor
 <b>Fernando Torres</b> Ingeniero de Software
 
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/ftorresx/
