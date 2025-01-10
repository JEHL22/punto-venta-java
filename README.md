# Sistema de Punto de Venta

Este es un proyecto de sistema de punto de venta desarrollado con **Java**, **Spring Boot**, **HTML**, **CSS**, **JavaScript** y **MySQL**. Está diseñado para facilitar la gestión de ventas y el manejo de inventarios en un entorno empresarial.

---

## **Características del Proyecto**
- Gestión de productos y ventas.
- Interfaz de usuario moderna utilizando HTML, CSS y JavaScript.
- Backend robusto con Spring Boot.
- Persistencia de datos mediante una base de datos MySQL.
- Arquitectura escalable y modular.

---

## **Requisitos Previos**
1. **Java Development Kit (JDK):** Versión 17 o superior.
2. **Maven:** Para la gestión de dependencias.
3. **MySQL:** Para la base de datos.
4. **IDE:** IntelliJ IDEA, Eclipse u otro editor de tu preferencia.
5. **Git:** Para el control de versiones.

---

## **Configuración del Entorno**

### **1. Clonar el Repositorio**
Tu amigo (o cualquier colaborador) debe clonar este repositorio para comenzar:
```bash
git clone https://github.com/JEHL22/punto-venta-java.git
cd punto-venta-java
```

### **2. Configurar las Ramas**
Este proyecto utiliza dos ramas principales:
- `main`: Rama principal, estable y lista para producción.
- `dev`: Rama de desarrollo donde se realizan los cambios.

#### **Flujo de Trabajo para las Ramas**
- Antes de trabajar:
  ```bash
  git checkout dev
  git pull origin dev
  ```
- Después de realizar cambios:
  ```bash
  git add .
  git commit -m "Descripción del cambio"
  git push origin dev
  ```
- Fusionar `dev` en `main` (solo para responsables):
  ```bash
  git checkout main
  git pull origin main
  git merge dev
  git push origin main
  ```

### **3. Configurar la Base de Datos**
1. Crear una base de datos en MySQL:
   ```sql
   CREATE DATABASE punto_venta;
   ```
2. Configurar las credenciales de la base de datos en el archivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/punto_venta
   spring.datasource.username=TU_USUARIO
   spring.datasource.password=TU_CONTRASEÑA
   ```

### **4. Ejecutar la Aplicación**
1. Compilar y ejecutar el proyecto con Maven:
   ```bash
   mvn spring-boot:run
   ```
2. Accede a la aplicación en tu navegador en `http://localhost:8080`.

---

## **Estructura del Proyecto**
- **Backend:**
  - Controladores: Gestión de las solicitudes HTTP.
  - Servicios: Lógica de negocio.
  - Repositorios: Interacción con la base de datos.
  - Entidades: Modelos de datos.

- **Frontend:**
  - HTML y CSS: Diseño de la interfaz.
  - JavaScript: Interactividad.

- **Base de Datos:**
  - Tablas para productos, ventas y usuarios.

---

## **Contribuir al Proyecto**
### **1. Crear una Nueva Rama para Cambios**
Si deseas trabajar en una nueva funcionalidad o corrección de errores:
```bash
git checkout -b tunombre-dev
```

### **2. Realizar un Pull Request**
1. Haz cambios en tu rama y súbelos:
   ```bash
   git push origin tunombre-dev
   ```
2. Crea un Pull Request en GitHub para que el equipo revise los cambios.

---

## **Colaboradores**
- [Julio Huaman](https://github.com/JEHL22) 
- **[Colaborador 1]** 
- **[Colaborador 2]** 

---

## **Notas Importantes**
1. Siempre actualiza tu rama local antes de empezar a trabajar:
   ```bash
   git pull origin dev
   ```
2. Comunícate con el equipo para evitar conflictos en los archivos.
3. Antes de fusionar cambios en `main`, verifica que todo funcione correctamente.

---

Si tienes preguntas o necesitas ayuda, no dudes en contactarme.

¡Gracias por contribuir al proyecto! 🎉
