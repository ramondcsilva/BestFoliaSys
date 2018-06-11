package br.uefs.ecomp.bfs.controller;

//Importações das classes necessárias;
import br.uefs.ecomp.bfs.model.*;
import br.uefs.ecomp.bfs.util.*;

public class Controller{
    
    //LinkedList necessarias para guardar dados;
    public LinkedList blocoList;
    public LinkedList transporteList;
    public LinkedList foliaoList;
    public LinkedList listar;//Usada apenas para listar os dados;
    
    //Inicia os atributos LinkedList;
    public Controller(){
        this.blocoList = new LinkedList();
        this.foliaoList  = new LinkedList();
        this.transporteList = new LinkedList();
        this.listar = new LinkedList();
    }
    
    //Metodo cadastrarBloco recebe nome, local, e saida, de determidado 
    //Bloco retornando o proprio(Caso ja exista o Bloco ele retorna nulo);  
    public Bloco cadastrarBloco(String nome, String local, int saida){
        Bloco blocos = new Bloco(nome,local,saida);
        if(!blocoList.contains(blocos)){
            this.blocoList.addLast(blocos);
            blocos.setIdBloco(blocoList.size()-1);
            return blocos;
        }
        return null;
    }
    
    //Metodo obterBloco, recebe uma identificação do Bloco e procurar caso 
    //a lista de Blocos não esteja vazia e a identificação seja menor que o tamanho 
    //tamanho da lista(Caso contrario retorna nulo), retornando o bloco buscado;
    public Bloco obterBloco(int id){
        if(!blocoList.isEmpty() && id <= blocoList.size()){
            return (Bloco) blocoList.get(id);
        }
        return null;
    }    
    
    //Metodo ListarBloco recebe local, dataInicio , dataFim, do usuario, onde caso seja a lista de Blocos
    //não esteja vazia(Sendo vazia, retorna nulo), percorre pegando apenas aqueles que tenham mesmo local
    //e saida maior ou igual que dataInicio e menor ou igual que dataFim, colocando em uma nova lista e 
    //retornando o iterator dela;
    public Iterator listarBlocos(String local, int dataInicio, int dataFim){
        Iterator iteratorB = blocoList.iterator();        
        emptyList(listar);
        if(!blocoList.isEmpty()){
            while(iteratorB.hasNext()){
                Bloco blocoL = (Bloco) iteratorB.next();
                if(blocoL.getLocal().equals(local) && blocoL.getSaida() >= dataInicio && blocoL.getSaida() <= dataFim){
                    if(!listar.contains(blocoL)){
                        listar.addLast(blocoL);
                    }
                }
            }
            if(!listar.isEmpty()){
                return listar.iterator();
            }
        }    
        return null;
    }
    
    //Metodo cadastrarTransporte recebe todos os atributos do construtor do modelo Transporte, verificando 
    //se a lista de Bloco é nula(Caso seja não pode haver Transporte), assim cadastrando os dados 
    //(caso tenha igual retorna nulo), e adicionando no final da lista de Transportes; 
    public Transporte cadastrarTransporte(String nome, String tipo, double valor, int capacidade, int saida, String localSaida, int retorno, String localRetorno, int chegada, String localChegada, Bloco blocoTransporte){
        if(!blocoList.isEmpty()){
            if(saida <= retorno && retorno <= chegada){
                Transporte transportes = new Transporte(nome,tipo,valor,capacidade,saida,localSaida,retorno,localRetorno,chegada,localChegada,blocoTransporte);

                if(!transporteList.contains(transportes)){
                    this.transporteList.addLast(transportes);
                    transportes.setIdTransporte(transporteList.size()-1);
                    return transportes;
                }
            }
        }
        return null;
    }
    
    //Metodo obterTransporte recebe a identificação do Transporte e caso seja não esteja vazia,
    //e identificação menor que o tamanho, retorna o transporte achado pelo metodo get();
    //retorna null caso não passe das verificações;
    public Transporte obterTransporte(int id){
        if(!transporteList.isEmpty() && id < transporteList.size()){
            return (Transporte) transporteList.get(id);
        }    
        return null;
    }
    
    //Metodo listarTransportes recebe um Bloco como parâmetro, verificando se a lista 
    //de Transportes não está vazia(Caso seja retorna null), assim percorre a lista 
    //pegando todos transportes que tenham o mesmo Bloco passado no parâmetro adicionando
    //em uma nova lista, e retornando seu iterator;
    public Iterator listarTransportes(Bloco bloco){
        Iterator iteratorT = this.transporteList.iterator();
        emptyList(listar);
        
        if(!transporteList.isEmpty() && bloco != null){
            while(iteratorT.hasNext()){
                Transporte transporteL = (Transporte) iteratorT.next();
                if(transporteL.getBlocoTransporte().equals(bloco)){
                    listar.addLast(transporteL);
                }
            }
            if(!listar.isEmpty()){
                return listar.iterator();
            }
        }
        return null;
    }
    
    //Metodo cadastrarFoliao recebe atributos de Foliao inicializados no seu modelo,
    //cadastrando e colocando na lista de Foliao caso não contenha um mesmo objeto;
    //Caso exista retorna null;
    public Foliao cadastrarFoliao(String cpf, String rg, String nome, int idade){
        Foliao folioes = new Foliao(cpf,rg,nome,idade);
        
        if(!foliaoList.contains(folioes)){
            this.foliaoList.addLast(folioes);
            return folioes;
        }
        return null;
    }

    //Metodo obterFoliao recebe um atributo String cpf, e caso a lista de Foliao
    //nao esteja vazia(Caso esteja retorna nulo), percorre a lista de Foliao com o 
    //Iterator e retorna o Foliao esperado(Caso não tenha retorna nulo);
    public Foliao obterFoliao(String cpf){
        if(!foliaoList.isEmpty()){
            Iterator iter_Foliao = this.foliaoList.iterator();

            while(iter_Foliao.hasNext()){
                Foliao foliao_Esperado = (Foliao) iter_Foliao.next();
                if(foliao_Esperado.getCpf().equals(cpf)){
                    return foliao_Esperado;
                }
            }
        }    
        return null;
    }

    //Metodo registrarFoliaoEmTransporte recebe um atributo Foliao e um atributo Transporte
    //e caso atributo Transporte em Foliao seja nula e o atributo de vaga ocupadada seja
    //menor que a capacidade do Transporte, registra e retorna true, caso contrario, retorna false;
    public boolean registrarFoliaoEmTransporte(Foliao foliao, Transporte transporte){
        if(!foliaoList.isEmpty() && !transporteList.isEmpty()){
            if(foliaoList.contains(foliao) && transporteList.contains(transporte)){    
                if(foliao.getTransporteFoliao() == null && transporte.getVagasOcupadas() != transporte.getCapacidade()){
                    transporte.setVagasOcupadas(transporte.getVagasOcupadas()+1);
                    foliao.setTransporteFoliao(transporte);
                    return true;
                }
            }
        }
        return false;
    }
    
    //Metodo listarFolioes recebe um atributo Transporte como parâmetro e caso a lista
    //de Folioes não esteja vazia(Caso esteja retorna nulo), utiliza-se um Iterator da 
    //lista de foliao, percorrendo e adicionando em uma nova lista aqueles que tenham
    //tal transporte, retornando seu Iterator;
    public Iterator listarFolioes(Transporte transporte){
        Iterator iteratorF = this.foliaoList.iterator();
        emptyList(listar);
        
        if(!foliaoList.isEmpty() && transporte != null){
            while(iteratorF.hasNext()){
                Foliao foliaoNoTransporte = (Foliao) iteratorF.next();
                if(transporte.equals(foliaoNoTransporte.getTransporteFoliao())){
                    listar.addLast(foliaoNoTransporte);
                }
            }
            if(!listar.isEmpty()){
                return listar.iterator();
            }
        }
        return null;
    }
    
    //Metodo para limpar uma lista, usada para reutilizar o atributo LinkedList listar;
    public LinkedList emptyList(LinkedList list){
        if(!list.isEmpty()){
            while(list.iterator().hasNext()){
                list.toRemoveLast();
            }
        }
        return list;
    }
}