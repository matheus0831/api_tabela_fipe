package br.com.consultaTabelaCarros.modelosRecords;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InfoModelos(@JsonAlias("modelos") ArrayList<InfoMarca> modelo) {
}
