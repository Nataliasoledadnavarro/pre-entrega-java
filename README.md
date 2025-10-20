# 🎲 CRUD de Juegos de Mesa - Java POO

Proyecto realizado como **preentrega del curso de Java**.  
El objetivo es practicar los fundamentos de **Programación Orientada a Objetos (POO)** y aplicar un **CRUD funcional por consola**.

---

## 📘 Descripción

El sistema permite gestionar un catálogo de **juegos de mesa** y **categorías**.  
Cada módulo cuenta con un menú que permite **crear, listar, modificar y eliminar** registros.  
Toda la información se maneja en memoria mediante **ArrayList**, y los datos se ingresan desde consola.

---

## Funcionalidades principales

### 🕹️ CRUD de Juegos
- Crear juegos físicos o digitales.  
- Listar todos los juegos.  
- Modificar nombre o precio.  
- Eliminar un juego por ID.  

### 🗂️ CRUD de Categorías
- Crear, listar, modificar y eliminar categorías.  

---

## 🧩 Estructura de clases

- **Game** → clase abstracta base.  
- **BoardGame** y **DigitalGame** → subclases.  
- **Category** → clase asociada a los juegos.  
- **Sellable** → interfaz que define el comportamiento de los objetos vendibles.  
- **CrudConsole** → clase base con métodos comunes de lectura y validación.  
- **CrudGames / CrudCategories** → implementaciones específicas de los CRUD.  
- **Main** → orquestador general de los menús.  

---

## 🧠 Conceptos aplicados

- Clases y objetos  
- Herencia y abstracción  
- Encapsulamiento (atributos privados + getters y setters)  
- Polimorfismo (`@Override`)  
- Implementación de interfaz  
- Uso de `ArrayList`  
- Validaciones básicas de entrada  

---

## 👩‍💻 Autora

### Natalia Soledad Navarro
Proyecto educativo - Curso de Java (Preentrega POO) - Talento Tech - 2025
