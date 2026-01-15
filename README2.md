# 🧾 PUNTO DE VENTA JAVA (Hexagonal Architecture)

## Sistema de Punto de Venta Profesional

Aplicación robusta para la gestión de productos y ventas, diseñada bajo los principios de **Arquitectura Hexagonal (Ports & Adapters)** para garantizar escalabilidad, mantenibilidad y desacoplamiento tecnológico.

Un cambio a la vez

---

## ✨ Características del Proyecto

* **Arquitectura Hexagonal:** Separación clara entre la lógica de negocio, puertos e infraestructura.
* **Gestión de Productos:** CRUD completo con validaciones de negocio.
* **Precisión Financiera:** Uso de `BigDecimal` para el manejo de precios y dinero.
* **Persistencia Robusta:** Integración con PostgreSQL mediante Spring Data JPA.
* **Documentación de API:** Preparado para integración con dashboards modernos (Next.js).

---

## 🛠️ Tech Stack

* **Lenguaje:** Java 21 (LTS)
* **Framework:** Spring Boot 3.4.1
* **Base de Datos:** PostgreSQL
* **Gestión de Dependencias:** Maven
* **Arquitectura:** Hexagonal (Dominio, Aplicación, Infraestructura)

---

## 🧩 Requisitos Previos

1. **Java Development Kit (JDK):** Versión 21 (Obligatorio).
2. **Maven:** 3.9 o superior.
3. **PostgreSQL:** Instancia local o remota corriendo.
4. **IDE:** VS Code con el  *Java Extension Pack* .

---

## 🗂️ Estructura del Proyecto (Arquitectura Hexagonal)

El proyecto sigue una estructura de "Puertos y Adaptadores":

**Plaintext**

```
com.puntodeventa
├── domain          # Núcleo: Entidades puras y lógica de negocio.
├── application     # Casos de Uso y Puertos (Interfaces de entrada/salida).
└── infrastructure  # Adaptadores: Controladores REST y Persistencia (JPA).
```

---

## ⚙️ Configuración del Entorno

### 1️⃣ Clonar el repositorio

**Bash**

```
git clone https://github.com/JEHL22/punto-venta-java.git
cd punto-venta-java
```

### 2️⃣ Configurar la Base de Datos

Crea una base de datos en PostgreSQL llamada `punto_venta` y actualiza el archivo `src/main/resources/application.properties`:

**Properties**

```
spring.datasource.url=jdbc:postgresql://localhost:5432/punto_venta
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Ejecutar la aplicación

Desde la terminal del proyecto:

**Bash**

```
.\mvnw.cmd spring-boot:run
```

La API estará disponible en: `http://localhost:8080/api/products`

---

## 🚀 API Endpoints (Ejemplos)

### Crear un Producto

**POST** `/api/products`

**JSON**

```
{
  "name": "Laptop Gamer",
  "price": 1250.00,
  "stock": 15
}
```

---

## 🤝 Flujo de Trabajo (Git)

* `main`: Rama de producción (solo código testeado).
* `dev`: Rama principal de desarrollo.

**Para contribuir:**

1. Crea una rama: `git checkout -b feature/nueva-funcionalidad`
2. Sube tus cambios: `git push origin feature/nueva-funcionalidad`
3. Abre un Pull Request hacia `dev`.

---

## 👥 Equipo

* **Julio Huaman** - *Desarrollador Principal* - [JEHL22](https://github.com/JEHL22)

---

### ⚠️ Nota de Versión

Este proyecto ha sido migrado a **Java 21** para aprovechar las últimas mejoras de rendimiento y estabilidad en el ecosistema Spring.

---

### ¿Te gustaría que ahora preparemos el **Figma** del Dashboard o prefieres añadir la lógica para las **Ventas** en el Backend?
