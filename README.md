# CatroEnRaia-Java

# ♟️ Catro en Raia (Connect Four) en Java

Este proyecto implementa el clásico juego de mesa **Catro en Raia** (Conecta 4) utilizando el lenguaje de programación Java y un diseño modular y orientado a objetos.

## ⚙️ Estructura del Proyecto

El diseño sigue una arquitectura modular separada en dos paquetes principales:

### 1. Paquete `tgames` (Lógica Genérica de Tablero)

Contiene las clases abstractas y genéricas que podrían ser reutilizadas para otros juegos de tablero.

| Clase | Función Principal |
| :--- | :--- |
| **`Tableiro.java`** | Gestiona la matriz 6x7, la colocación y lectura de fichas. |
| **`Motor.java`** | Lógica abstracta de turnos y estado del juego. |
| **`Xogo.java`** | Contiene el bucle principal (`play()`). |
| `Xogador.java` | Clase base para un jugador. |

### 2. Paquete `catroenraia` (Lógica Específica)

Contiene la implementación concreta de las reglas del 4 en Raia.

| Clase | Función Principal |
| :--- | :--- |
| **`Motor4enRaia.java`** | **CLAVE:** Implementa la **caída de la ficha** y la **comprobación de victoria** (horizontal, vertical y diagonal). |
| **`Xogo4enRaia.java`** | Clase principal con el método `main()` para la ejecución. |

## ▶️ Execución e Compilación

Para compilar y ejecutar el proyecto, se debe usar la clase principal `catroenraia.Xogo4enRaia`.
