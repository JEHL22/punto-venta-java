const API_URL = '/api/products'

// Cargar productos al iniciar
document.addEventListener('DOMContentLoaded', () => {
  loadProducts()
  document.getElementById('productForm').addEventListener('submit', handleCreateProduct)
})

async function loadProducts() {
  try {
    const response = await fetch(API_URL)
    if (!response.ok) throw new Error(`Error ${response.status}`)
    
    const products = await response.json()
    displayProducts(products)
  } catch (error) {
    console.error('Error cargando productos:', error)
    document.getElementById('productsList').innerHTML = `
      <div class="error">Error cargando productos. AsegÃºrate de que el servidor estÃ¡ corriendo en http://localhost:8080</div>
    `
  }
}

function displayProducts(products) {
  const container = document.getElementById('productsList')
  
  if (!products || products.length === 0) {
    container.innerHTML = '<div class="empty-state">No hay productos aÃºn. Â¡Crea uno!</div>'
    return
  }

  container.innerHTML = products.map(product => `
    <div class="product-card">
      <h3>${product.name}</h3>
      <div class="product-info">ID: ${product.id}</div>
      <div class="product-info">Stock: ${product.stock} unidades</div>
      <div class="product-price">$${product.price}</div>
    </div>
  `).join('')
}

async function handleCreateProduct(e) {
  e.preventDefault()
  
  const formData = {
    name: document.getElementById('name').value,
    price: parseFloat(document.getElementById('price').value),
    stock: parseInt(document.getElementById('stock').value)
  }

  const messageDiv = document.getElementById('formMessage')
  
  try {
    const response = await fetch(API_URL, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formData)
    })

    if (!response.ok) {
      throw new Error(`Error ${response.status}: ${response.statusText}`)
    }

    messageDiv.innerHTML = '<div class="success">âœ“ Producto creado exitosamente</div>'
    document.getElementById('productForm').reset()
    
    // Recargar productos
    setTimeout(() => {
      loadProducts()
      messageDiv.innerHTML = ''
    }, 1000)
  } catch (error) {
    console.error('Error creando producto:', error)
    messageDiv.innerHTML = `<div class="error">âœ— Error: ${error.message}</div>`
  }
}
