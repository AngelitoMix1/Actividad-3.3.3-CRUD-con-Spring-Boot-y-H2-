package com.example.productos.controller;

import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }

    // GET TODOS
    @GetMapping
    public List<Producto> all() {
        return repo.findAll();
    }

    // GET POR ID
    @GetMapping("/{id}")
    public Producto get(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    // POST
    @PostMapping
    public Producto create(@RequestBody Producto p) {
        return repo.save(p);
    }

    // PUT
    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto p) {
        Producto existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existente.setNombre(p.getNombre());
        existente.setPrecio(p.getPrecio());

        return repo.save(existente);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}