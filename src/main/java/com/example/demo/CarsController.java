package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
class CarsController {

  private final CarsRepository repository;

  CarsController(CarsRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/cars")
  List<Cars> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/cars")
  Cars newCars(@RequestBody Cars newCars) {
    return repository.save(newCars);
  }

  // Single item
  
  @GetMapping("/cars/{id}")
  Cars one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new CarsNotFoundException(id));
  }

  @PutMapping("/cars/{id}")
  Cars replaceCars(@RequestBody Cars newCars, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(cars -> {
        cars.setMarca(newCars.getMarca());
        cars.setModelo(newCars.getModelo());
        cars.setAno(newCars.getAno());
        cars.setPreco(newCars.getPreco());
        return repository.save(cars);
      })
      .orElseGet(() -> {
        return repository.save(newCars);
      });
  }

  @DeleteMapping("/cars/{id}")
  void deleteCars(@PathVariable Long id) {
    repository.deleteById(id);
  }
}