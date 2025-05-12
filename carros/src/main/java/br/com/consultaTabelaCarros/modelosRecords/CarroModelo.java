package br.com.consultaTabelaCarros.modelosRecords;


import com.fasterxml.jackson.annotation.JsonAlias;

public record CarroModelo(@JsonAlias("TipoVeiculo") int tipo,
                          @JsonAlias("Valor") String dinheiro,
                          @JsonAlias("Marca") String marcaCarro,
                          @JsonAlias("Modelo") String modelo,
                          @JsonAlias("AnoModelo") int ano,
                          @JsonAlias("Combustivel") String combustivel,
                          @JsonAlias("CodigoFipe") String codigoFipe,
                          @JsonAlias("MesReferencia") String mes,
                          @JsonAlias("SiglaCombustivel") String sigla) {




}
