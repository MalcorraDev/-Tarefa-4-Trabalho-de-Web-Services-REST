package com.example.demo;

class CarsNotFoundException extends RuntimeException {

  CarsNotFoundException(Long id) {
    super("Could not find cars " + id);
  }
}