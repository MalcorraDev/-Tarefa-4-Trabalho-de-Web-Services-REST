package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
class Cars {

  private @Id
  @GeneratedValue Long id;
  private String marca;
  private String modelo;
  private int ano;
  private int preco;

  Cars() {}

  Cars(String marca, String modelo, int ano, int preco) {

    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.preco = preco;
  }

  public Long getId() {
    return this.id;
  }

  public String getMarca() {
    return this.marca;
  }

  public String getModelo() {
    return this.modelo;
  }

  public int getAno() {
    return this.ano;
  }

  public int getPreco() {
    return this.preco;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public void setPreco(int preco){
    this.preco = preco;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Cars))
      return false;
    Cars cars = (Cars) o;
    return  Objects.equals(this.id, cars.id) && 
            Objects.equals(this.marca, cars.marca) && 
            Objects.equals(this.modelo, cars.modelo) && 
            Objects.equals(this.ano, cars.ano) && 
            Objects.equals(this.preco, cars.preco);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.marca, this.modelo, this.ano, this.preco);
  }

  @Override
  public String toString() {
    return "Cars{" + "id=" + this.id + ", marca='" + this.marca +
                                   '\'' + ", modelo='" + this.modelo + '\'' + 
                                   '\'' + ", ano='" + this.ano + '\'' + 
                                   '\'' + ", preco='" + this.preco + '\'' + '}';
  }
}