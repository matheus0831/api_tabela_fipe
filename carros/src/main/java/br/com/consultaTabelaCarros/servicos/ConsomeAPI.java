package br.com.consultaTabelaCarros.servicos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsomeAPI {
    public String retornoString(String urlDoSite){

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(urlDoSite)).build();
        HttpResponse<String> respostaAPI = null;

        try{
            respostaAPI = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = respostaAPI.body();
        return json;
    }



}
