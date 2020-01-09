package com.udemy.compras.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    @Query("select c from Compra c where c.cliente.id = :clienteId")
    List<Compra> findAllByCliente(@Param("clienteId") Long clienteId);
}