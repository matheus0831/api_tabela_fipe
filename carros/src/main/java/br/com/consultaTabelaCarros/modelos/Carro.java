package br.com.consultaTabelaCarros.modelos;

import br.com.consultaTabelaCarros.modelosRecords.CarroModelo;
import com.fasterxml.jackson.annotation.JsonAlias;

public class Carro {

    private int tipoCarro;
    private String dinheiroCarro;
    private String marcaCarro;
    private String modeloCarro;
    private int anoCarro;
    private String combustivelCarro;
    private String codigoFipeCarro;
    private String mesCarro;
    private String siglaCarro;

    public Carro(CarroModelo c){

        this.tipoCarro = c.tipo();
        this.dinheiroCarro = c.dinheiro();
        this.marcaCarro = c.marcaCarro();
        this.modeloCarro = c.modelo();
        this.anoCarro = c.ano();
        this.combustivelCarro = c.combustivel();
        this.codigoFipeCarro = c.codigoFipe();
        this.mesCarro = c.mes();
        this.siglaCarro = c.sigla();

    }

    @Override
    public String toString() {
        return  "Preço:" + dinheiroCarro + '\'' +
                ", Marca:" + marcaCarro + '\'' +
                ", Modelo:" + modeloCarro + '\'' +
                ", Ano:" + anoCarro +
                ", Combustivel:" + combustivelCarro + '\'' +
                ", Código tabela FIPE:" + codigoFipeCarro + ".";
    }
}
