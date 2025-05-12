package br.com.consultaTabelaCarros.servicos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConverteJSON {
    ObjectMapper mapeador = new ObjectMapper();

    public <T> T obterDados(String json, Class <T> conversao){
        try{
            return mapeador.readValue(json, conversao);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    public <T> List<T> retornaDadosEmLista(String json, TypeReference<List<T>> classe){
        try{
            return mapeador.readValue(json, classe);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
