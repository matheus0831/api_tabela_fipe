package br.com.consultaTabelaCarros.servicos;

import br.com.consultaTabelaCarros.modelos.Carro;
import br.com.consultaTabelaCarros.modelosRecords.CarroModelo;
import br.com.consultaTabelaCarros.modelosRecords.InfoMarca;
import br.com.consultaTabelaCarros.modelosRecords.InfoModelos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.*;

import static java.lang.System.in;

public class Menu {
    ConsomeAPI api = new ConsomeAPI();
    ConverteJSON conversor = new ConverteJSON();
    Scanner inserir = new Scanner(in);


    List<CarroModelo> individuais = new ArrayList<>();
    List<Carro> veiculos = new ArrayList<>();

    String urlBase = "https://parallelum.com.br/fipe/api/v1/";

    boolean opcaoInvalida = true;
    String opcaoVeiculo = "";

    public void executaMenu() throws JsonProcessingException {

        while(opcaoInvalida){
            System.out.println("""
                Selecione uma opção válida:
                
                Carros
                
                Caminhoes
                
                Motos
                
                """);

            opcaoVeiculo = inserir.next();

            switch (opcaoVeiculo.toLowerCase()){

                case "carros":
                    opcaoInvalida = false;
                break;

                case "motos":
                    opcaoInvalida = false;
                break;


                case "caminhoes":
                    opcaoInvalida = false;
                break;


                default:
                    opcaoInvalida = true;
                break;
            }
        }

        urlBase += opcaoVeiculo.toLowerCase() + "/marcas";

        String codigoTipoVec = listaItensLista(urlBase);

        urlBase += "/" + codigoTipoVec + "/modelos";

        String codigoDoModelo = listaModelos(urlBase);

        urlBase += "/" + codigoDoModelo + "/anos";

        listaTodosOsAnos(urlBase);

    }


    private String listaItensLista(String url){
        String dados = api.retornoString(url);
        List<InfoMarca> lista = conversor.retornaDadosEmLista(dados, new TypeReference<List<InfoMarca>>(){});
        lista.stream().forEach(modelo -> System.out.println("Código:" + modelo.codigo() + " - " + "nome:" + modelo.nome()));

        Optional<InfoMarca> contem = Optional.empty();

        while(contem.isEmpty()){
            System.out.println("Selecione o código de uma das marcas acima: ");
            String codigoTipoVec = inserir.next();

            contem = lista.stream().filter(marca -> marca.codigo().equalsIgnoreCase(codigoTipoVec)).findFirst();
        }
        return contem.get().codigo();
    }

    private String listaModelos(String url){
        String dados = api.retornoString(url);
        InfoModelos m = conversor.obterDados(dados, InfoModelos.class);
        m.modelo().stream().forEach(modelo -> System.out.println("Código:" + modelo.codigo() + " - " + "nome:" + modelo.nome()));
        Optional<InfoMarca> presente  = Optional.empty();;

        while(presente.isEmpty()){
            System.out.println("Selecione o código de um dos modelos acima: ");
            String codigoModeloVec = inserir.next();
            presente = m.modelo().stream().filter(model -> model.codigo().equalsIgnoreCase(codigoModeloVec)).findFirst();
        }

        return presente.get().codigo();

    }

    void listaTodosOsAnos(String url){
        String dados = api.retornoString(url);
        List<InfoMarca> lista = conversor.retornaDadosEmLista(dados, new TypeReference<List<InfoMarca>>(){});

        for(int index = 0; index < lista.size(); index++){
            String urlParaCadaModelo = url + "/" + lista.get(index).codigo();
            String dadosIndividuais = api.retornoString(urlParaCadaModelo);
            individuais.add(conversor.obterDados(dadosIndividuais, CarroModelo.class));
        }

        individuais.stream().forEach(unico -> veiculos.add(new Carro(unico)));
        veiculos.stream().forEach(System.out::println);

    }

}
