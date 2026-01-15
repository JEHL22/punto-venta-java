# 🧾 PUNTO DE VENTA JAVA

## Sistema de Punto de Venta

Aplicación web para la gestión de productos y ventas, desarrollada con Spring Boot y PostgreSQL.

---

## ✨ Características del Proyecto

- Gestión de productos y ventas.
- Interfaz de usuario moderna utilizando HTML, CSS y JavaScript.
- Backend robusto con Spring Boot.
- Persistencia de datos mediante PostgreSQL.
- Arquitectura escalable y modular.

---

## 🧩 Requisitos Previos

1. **Java Development Kit (JDK):** Versión 17 o superior.
2. **Maven:** Para la gestión de dependencias.
3. **PostgreSQL:** Para la base de datos.
4. **IDE:** IntelliJ IDEA, Eclipse, VS Code u otro editor.
5. **Git:** Para el control de versiones.

---

## ⚙️ Configuración del Entorno

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/JEHL22/punto-venta-java.git
cd punto-venta-java
```

### 2️⃣ Configurar las ramas

* `main`: Rama estable.
* `dev`: Rama de desarrollo.

#### Flujo de trabajo

Antes de trabajar:

<pre class="overflow-visible! px-0!" data-start="1299" data-end="1347"><div class="contain-inline-size rounded-2xl corner-superellipse/1.1 relative bg-token-sidebar-surface-primary"><div class="sticky top-[calc(--spacing(9)+var(--header-height))] @w-xl/main:top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-bash"><span><span>git checkout dev
git pull origin dev
</span></span></code></div></div></pre>

Después de los cambios:

<pre class="overflow-visible! px-0!" data-start="1374" data-end="1454"><div class="contain-inline-size rounded-2xl corner-superellipse/1.1 relative bg-token-sidebar-surface-primary"><div class="sticky top-[calc(--spacing(9)+var(--header-height))] @w-xl/main:top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-bash"><span><span>git add .
git commit -m </span><span>"Descripción del cambio"</span><span>
git push origin dev
</span></span></code></div></div></pre>

Fusionar `dev` en `main` (solo responsables):

<pre class="overflow-visible! px-0!" data-start="1503" data-end="1588"><div class="contain-inline-size rounded-2xl corner-superellipse/1.1 relative bg-token-sidebar-surface-primary"><div class="sticky top-[calc(--spacing(9)+var(--header-height))] @w-xl/main:top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-bash"><span><span>git checkout main
git pull origin main
git merge dev
git push origin main
</span></span></code></div></div></pre>

---

### 3️⃣ Configurar la Base de Datos

Crear la base de datos:

<pre class="overflow-visible! px-0!" data-start="1657" data-end="1696"><div class="contain-inline-size rounded-2xl corner-superellipse/1.1 relative bg-token-sidebar-surface-primary"><div class="sticky top-[calc(--spacing(9)+var(--header-height))] @w-xl/main:top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-sql"><span><span>CREATE</span><span> DATABASE punto_venta;
</span></span></code></div></div></pre>

Configurar `application.properties`:

<pre class="overflow-visible! px-0!" data-start="1736" data-end="2031"><div class="contain-inline-size rounded-2xl corner-superellipse/1.1 relative bg-token-sidebar-surface-primary"><div class="sticky top-[calc(--spacing(9)+var(--header-height))] @w-xl/main:top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-properties"><span>spring.datasource.url=jdbc:postgresql://localhost:5432/punto_venta
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
</span></code></div></div></pre>

---

### 4️⃣ Ejecutar la aplicación

<pre class="overflow-visible! px-0!" data-start="2070" data-end="2101"><div class="contain-inline-size rounded-2xl corner-superellipse/1.1 relative bg-token-sidebar-surface-primary"><div class="sticky top-[calc(--spacing(9)+var(--header-height))] @w-xl/main:top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-bash"><span><span>mvn spring-boot:run
</span></span></code></div></div></pre>

Abrir en el navegador:

👉 [http://localhost:8080](http://localhost:8080)

---

## 🗂️ Estructura del Proyecto

### Backend

* Controladores: Gestión de solicitudes HTTP.
* Servicios: Lógica de negocio.
* Repositorios: Acceso a datos (JPA).
* Entidades: Modelos de datos.

### Frontend

* HTML y CSS: Interfaz.
* JavaScript: Interactividad.

### Base de Datos

* Tablas para productos, ventas y usuarios.

---

## 🤝 Contribuir al Proyecto

### 1️⃣ Crear una nueva rama

<pre class="overflow-visible! px-0!" data-start="2549" data-end="2589"><div class="contain-inline-size rounded-2xl corner-superellipse/1.1 relative bg-token-sidebar-surface-primary"><div class="sticky top-[calc(--spacing(9)+var(--header-height))] @w-xl/main:top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-bash"><span><span>git checkout -b tunombre-dev
</span></span></code></div></div></pre>

### 2️⃣ Subir cambios

<pre class="overflow-visible! px-0!" data-start="2614" data-end="2654"><div class="contain-inline-size rounded-2xl corner-superellipse/1.1 relative bg-token-sidebar-surface-primary"><div class="sticky top-[calc(--spacing(9)+var(--header-height))] @w-xl/main:top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-bash"><span><span>git push origin tunombre-dev
</span></span></code></div></div></pre>

Luego crear un Pull Request en GitHub.

---

## 👥 Colaboradores

* [Julio Huaman](https://github.com/JEHL22)
* Colaborador 1
* Colaborador 2

---

## ⚠️ Notas Importantes

* Actualiza siempre tu rama antes de trabajar:

<pre class="overflow-visible! px-0!" data-start="2877" data-end="2908"><div class="contain-inline-size rounded-2xl corner-superellipse/1.1 relative bg-token-sidebar-surface-primary"><div class="sticky top-[calc(--spacing(9)+var(--header-height))] @w-xl/main:top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-bash"><span><span>git pull origin dev
</span></span></code></div></div></pre>

* Verifica que la app compile y corra antes de hacer merge a `main`.

---

Si tienes preguntas o sugerencias, ¡bienvenido al equipo! 🚀
