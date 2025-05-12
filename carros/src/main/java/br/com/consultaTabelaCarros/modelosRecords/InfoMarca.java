package br.com.consultaTabelaCarros.modelosRecords;

import com.fasterxml.jackson.annotation.JsonAlias;


public record InfoMarca(@JsonAlias("codigo") String codigo, @JsonAlias("nome") String nome) {
}
