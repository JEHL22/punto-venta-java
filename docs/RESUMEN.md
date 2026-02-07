# Resumen del proyecto — Punto de Venta

Este documento resume cómo funciona cada archivo relevante de la aplicación (backend y frontend), los endpoints, payloads y cómo ejecutar el proyecto.

## Resumen general
- Backend: aplicación Spring Boot que expone API REST en `http://localhost:8080` y persiste productos en PostgreSQL.
- Frontend: UI estática servida por Vite (desarrollo con proxy a backend). Interactúa con `/api/products`.

---

## Backend (carpeta `src/main/java`)

- `PuntoDeVentaApplication.java`
  - Clase principal con `main()` que arranca Spring Boot.

- `domain/model/Product.java`
  - Modelo de dominio `Product` con campos: `id` (Long), `name` (String), `price` (BigDecimal), `stock` (Integer).
  - Incluye constructor vacío, constructor con todos los campos, getters y setters.

- `application/ports/input/CreateProductUseCase.java`
  - Interfaz (puerto de entrada) que expone `Product create(Product product)` para el caso de uso de creación.

- `application/ports/output/ProductRepositoryPort.java`
  - Interfaz (puerto de salida) para persistencia que declara `Product save(Product product)`.

- `application/usecase/ProductService.java`
  - Implementa `CreateProductUseCase`.
  - Valida que el `price` no sea negativo y delega en `ProductRepositoryPort.save()`.

- `infrastructure/adapter/output/db/ProductPersistenceAdapter.java`
  - Adaptador que implementa `ProductRepositoryPort`.
  - Convierte `Product` (dominio) → `ProductEntity` (JPA), usa `JpaProductRepository.save(entity)` y actualiza el `id` en el dominio antes de devolver.

- `infrastructure/adapter/output/db/ProductEntity.java`
  - Entidad JPA mapeada a la tabla `products`.
  - Campos: `id` (PK, auto), `name`, `price` (BigDecimal con precision/scale), `stock`.

- `infrastructure/adapter/output/db/JpaProductRepository.java`
  - Interfaz Spring Data JPA que extiende `JpaRepository<ProductEntity, Long>` para CRUD.

- `infrastructure/adapter/input/rest/ProductController.java`
  - Controlador REST mapeado en `/api/products`.
  - `POST /api/products`: recibe `ProductRequest` JSON, convierte a `Product`, llama al caso de uso y devuelve `ProductResponse` con `id`.
  - `GET /api/products`: actualmente devuelve lista vacía (placeholder).

- `infrastructure/adapter/input/rest/HomeController.java`
  - Controlador MVC que mapea `GET /` a la plantilla `home` (vista Thymeleaf en `resources/templates/home.html`).

- `infrastructure/adapter/input/rest/dto/ProductRequest.java`
  - DTO usado para recibir datos del cliente: `name`, `price`, `stock`.

- `infrastructure/adapter/input/rest/dto/ProductResponse.java`
  - DTO para enviar al cliente: `id`, `name`, `price`, `stock`.

- `src/main/resources/application.properties`
  - Configuración principal: `server.port=8080`, datasource PostgreSQL (`jdbc:postgresql://localhost:5432/punto_venta`), credenciales y JPA (`ddl-auto=update`, `show-sql=true`).

---

## Frontend (carpeta `frontend`)

- `index.html`
  - Página principal con formulario para crear productos y seccion para listar productos.
  - Carga `./src/main.js` como módulo.

- `src/main.js`
  - Variables: `API_URL = '/api/products'`.
  - `loadProducts()`: hace `GET /api/products`, parsea JSON y llama `displayProducts()`; en error muestra mensaje.
  - `displayProducts(products)`: renderiza tarjetas de producto o estado vacío.
  - `handleCreateProduct(e)`: evita submit por defecto, construye `formData`, hace `POST /api/products` con JSON, muestra mensaje de éxito/error y recarga productos.

- `package.json`
  - Scripts: `dev` (vite), `build`, `preview`. Dependencias incluyen `vite`, React (aunque la UI actual es vanilla JS).

- `vite.config.js`
  - Config de Vite con plugin React y `server.proxy` que redirige `/api` → `http://localhost:8080` (útil en dev para evitar CORS).

- `README.md` (frontend)
  - Instrucciones básicas: `npm install`, `npm run dev`, recuerda iniciar backend en `http://localhost:8080`.

---

## Endpoints y payloads (ejemplos)

- POST /api/products
  - Request JSON (ejemplo):

```json
{
  "name": "Cafe",
  "price": 12.50,
  "stock": 10
}
```

  - Response JSON (ejemplo):

```json
{
  "id": 1,
  "name": "Cafe",
  "price": 12.50,
  "stock": 10
}
```

- GET /api/products
  - Actualmente devuelve `[]` (vacío). Debe implementarse en el `ProductService` y repositorio si se desea listar productos.

---

## Cómo ejecutar (rápido)

- Backend (desde la raíz del repo):

```bash
./mvnw spring-boot:run
```

(En Windows usar `mvnw.cmd spring-boot:run` si `./mvnw` falla.)

- Frontend:

```bash
cd frontend
npm install
npm run dev
```

Vite correrá en `http://localhost:5173` y proxyeará `/api` al backend.

---

## Observaciones y mejoras sugeridas

- Implementar `GET /api/products` real en `ProductService` y adaptar `ProductRepositoryPort` con método `List<Product> findAll()` y su implementación JPA.
- Manejo de errores más explícito: definir excepciones personalizadas y controladores `@ControllerAdvice` para mapear a respuestas HTTP con códigos apropiados.
- Validación de entrada: usar `@Valid` y anotaciones de validación en `ProductRequest` para campos requeridos, rangos y formato (por ejemplo `@NotBlank`, `@DecimalMin("0.0")`).
- Tests: agregar pruebas unitarias para `ProductService` y pruebas de integración para controladores.
- Seguridad/CORS: si se va a desplegar separado, configurar CORS o asegurar con OAuth/JWT según necesidades.
- Frontend: si vas a usar React (está en dependencias), migrar `index.html` a componente React para aprovechar el stack actual o eliminar la dependencia de React si no se usará.

---

## Siguientes pasos posibles (si quieres que los haga)
- Implementar `GET /api/products` y actualizar frontend para mostrar datos reales.
- Añadir validaciones (`@Valid`) y manejo global de errores.
- Crear tests unitarios para `ProductService`.
- Migrar frontend a React con componentes y fetch hooks.


---

Archivo generado automáticamente. Si quieres que extienda con diagramas, ejemplos de pruebas o implemente alguna mejora (p.ej. listar productos), dime cuál y lo hago.