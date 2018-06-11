package br.uefs.ecomp.bfs.facade;

import br.uefs.ecomp.bfs.model.*;
import br.uefs.ecomp.bfs.util.*;
import br.uefs.ecomp.bfs.controller.Controller;

public class BFSFacade{

    private final Controller controller;
    
    public BFSFacade(){
        this.controller = new Controller();
    }

//chamadas do controller

    public Bloco cadastrarBloco(String nome, String local, int saida){
        return controller.cadastrarBloco(nome, local, saida);
    }

    public Bloco obterBloco(int id){
        return controller.obterBloco(id);
    }

    public Iterator listarBlocos(String local, int dataInicio, int dataFim){
        return this.controller.listarBlocos(local, dataInicio, dataFim);
    }				


    public Transporte cadastrarTransporte(String nome, String tipo, double valor, int capacidade, 
                                    int saida, String localSaida, int retorno, String localRetorno, 
                                    int chegada, String localChegada, Bloco bloco){
            
        return controller.cadastrarTransporte(nome, tipo, valor, capacidade, saida, localSaida, 
                                            retorno, localRetorno, chegada, localChegada, bloco);
    }

    public Transporte obterTransporte(int id){
        return controller.obterTransporte(id);
    }

    public Iterator listarTransportes(Bloco bloco){
        return this.controller.listarTransportes(bloco);
    }	


    public Foliao cadastrarFoliao(String cpf, String rg, String nome, int idade){
        return controller.cadastrarFoliao(cpf, rg, nome, idade);
    }

    public Foliao obterFoliao(String cpf){
        return controller.obterFoliao(cpf);
    }

    public boolean registrarFoliaoEmTransporte(Foliao foliao, Transporte transporte){
        return this.controller.registrarFoliaoEmTransporte(foliao, transporte);
    }
	
    public Iterator listarFolioes(Transporte transporte){
        return this.controller.listarFolioes(transporte);
    }
}
