package br.uefs.ecomp.bfs.view;

import br.uefs.ecomp.bfs.controller.Controller;
import br.uefs.ecomp.bfs.model.*;
import br.uefs.ecomp.bfs.util.*;
import java.io.IOException;


public class MainView {
    public static void main(String[] args) throws IOException {
        
        Controller controller = new Controller();
        
        int verificaBloco = 0;
        int verificaFoliao = 0;
        int verificaTransporte = 0;
        int verificaFoliaoEmTransporte = 0;
        
        String menuEscolha;
        String menuOpcao;
        System.out.println("Sistema BestFoliaSys");
        do{
            System.out.println("Escolha uma das opções:\n"
                            + "|1| - Cadastrar Foliao\n"
                            + "|2| - Cadastrar Bloco\n"
                            + "|3| - Cadastrar Transporte\n"
                            + "|4| - Cadastrar Foliao em Transporte\n"
                            + "|5| - Obter Foliao\n"
                            + "|6| - Obter Bloco\n"
                            + "|7| - Obter Transporte\n"
                            + "|8| - Listar Foliao\n"
                            + "|9| - Listar Bloco\n"
                            + "|10| - Listar Transporte\n"
                            + "|11| - Sair\n");
            System.out.println("O que deseja: "); 
            menuEscolha = menuOpcao = Console.readString();
                
            String cpf , rg, nome , idade ,opcao;
            String saidaB, localB;
            String saidaT, chegadaT, retornoT, capacidadeT, blocoT, valorT, tipo, localSaida, localRetorno, localChegada;
            String idT;
            boolean verificaLimite, verificaNull;
            
            switch (menuOpcao){
                case "1":
                    do{
                        System.out.println("Cadastrando Foliao\n");
                        do{
                            System.out.printf("Insira cpf do Foliao: ");
                            cpf = Console.readString();
                            cpf = replaceInteger(cpf);
                            System.out.println("Esse é o cpf "+cpf+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringIdeal(cpf,11);
                            verificaNull = stringNull(cpf);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        do{
                            System.out.printf("Insira rg do Foliao: ");
                            rg = Console.readString();
                            rg = replaceInteger(rg);
                            System.out.println("Esse é o rg "+rg+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringIdeal(rg,10);
                            verificaNull = stringNull(rg);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        do{    
                            System.out.printf("Insira nome do Foliao: ");
                            nome = Console.readString();
                            nome = replaceLetters(nome);
                            System.out.println("Esse é o nome do Foliao "+nome+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(nome,50);
                            verificaNull = stringNull(nome);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        do{
                            System.out.printf("Insira idade do Foliao: ");
                            idade = Console.readString();
                            idade = replaceInteger(idade);
                            System.out.println("Esse é o idade "+idade+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(idade,3);
                            verificaNull = stringNull(idade);
                        }while(opcao.equals("")||idadeLimit(idade) == false ||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        
                        int idades = Integer.parseInt(idade);
                        Foliao foliaoTest = controller.cadastrarFoliao(cpf, rg, nome, idades);
                        
                        if(foliaoTest == null){
                            System.out.println("Erro Cadastro.");
                        }else{
                            verificaFoliao++;
                            System.out.println("Cadastro Concluido.");
                        }
                        System.out.println("Insira 1 ou 2 :\n1 - Menu\n2 - Novo Foliao\nOpcao: ");
                        menuEscolha = Console.readString();
                    }while(!menuEscolha.equals("1"));
                    break;
                case "2":
                    do{
                            System.out.println("Cadastrando Bloco\n");
                        do{ 
                            System.out.printf("Insira o nome do Bloco: ");
                            nome = Console.readString();
                            nome = replaceLetters(nome);
                            System.out.println("Esse é o nome do Bloco "+nome+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(nome,15);
                            verificaNull = stringNull(nome);
                        }while(opcao.equals("") ||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        do{    
                            System.out.printf("Insira o local do Bloco: ");
                            localB = Console.readString();
                            localB = replaceLetters(localB);
                            System.out.println("Esse é o local "+localB+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(localB,25);
                            verificaNull = stringNull(localB);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        do{    
                            System.out.printf("Insira a saida do Bloco: ");
                            saidaB = Console.readString();
                            saidaB = replaceInteger(saidaB);
                            System.out.println("Esse é o saida "+saidaB+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(saidaB,1);
                            verificaNull = stringNull(saidaB);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2"));  
                        
                        int saidaBloco = Integer.parseInt(saidaB);
                        
                        Bloco blocoTest = controller.cadastrarBloco(nome, localB, saidaBloco);
                        if(blocoTest == null){
                            System.out.println("Erro Cadastro.");
                        }else{
                            verificaBloco++;
                            System.out.println("Cadastro Concluido.");
                        }
                        
                        System.out.println("Insira 1 ou 2 :\n1 - Menu\n2 - Novo Bloco\nOpcao: ");
                        menuEscolha = Console.readString();
                    }while(!menuEscolha.equals("1"));
                    break;
                case "3":
                    if(verificaBloco > 0){
                        do{
                            System.out.println("Cadastrando Transporte\n");
                            do{
                                System.out.printf("Insira o nome do Transporte: ");
                                nome = Console.readString();
                                nome = replaceLetters(nome);
                                System.out.println("Esse é o nome do Transporte "+nome+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(nome,15);
                                verificaNull = stringNull(nome);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2"));  
                            do{
                                System.out.printf("Insira o tipo do Transporte: ");
                                tipo = Console.readString();
                                tipo = replaceLetters(tipo);
                                System.out.println("Esse é o tipo "+tipo+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(tipo,10);
                                verificaNull = stringNull(tipo);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2"));  
                            do{    
                                System.out.printf("Insira o valor do Transporte: ");
                                valorT = Console.readString();  
                                valorT = valorT.replaceAll(",", ".");//CASE TENHO VIRGULA
                                valorT = replaceInteger(valorT);
                                System.out.println("Esse é o valor "+valorT+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(valorT,5);
                                verificaNull = stringNull(valorT);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2"));  
                                double valor = Double.parseDouble(valorT);
                            do{    
                                System.out.printf("Insira a capacidade do Transporte: ");
                                capacidadeT = Console.readString();
                                capacidadeT = replaceInteger(capacidadeT);
                                System.out.println("Essa é a capacidade "+capacidadeT+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(capacidadeT,2);
                                verificaNull = stringNull(capacidadeT);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                                int capacidade = Integer.parseInt(capacidadeT);
                            do{    
                                System.out.printf("Insira a saida do Transporte: ");
                                saidaT = Console.readString();
                                saidaT = replaceInteger(saidaT);
                                System.out.println("Esse é a saida "+saidaT+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(saidaT,1);
                                verificaNull = stringNull(saidaT);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                                int saida = Integer.parseInt(saidaT);
                            do{    
                                System.out.printf("Insira o local de Saida do Transporte: ");
                                localSaida = Console.readString();
                                localSaida = replaceLetters(localSaida);
                                System.out.println("Esse é o local da Saida "+localSaida+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(localSaida,25);
                                verificaNull = stringNull(localSaida);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2"));  
                            do{ 
                                System.out.printf("Insira o retorno do Transporte: ");
                                retornoT = Console.readString();
                                retornoT = replaceInteger(retornoT);
                                System.out.println("Esse é o retorno "+retornoT+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(retornoT,1);
                                verificaNull = stringNull(retornoT);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                                int retorno = Integer.parseInt(retornoT);
                            do{    
                                System.out.printf("Insira o local de retorno do Transporte: ");
                                localRetorno = Console.readString();
                                localRetorno = replaceLetters(localRetorno);
                                System.out.println("Esse é o local do Retorno "+localRetorno+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(localRetorno,25);
                                verificaNull = stringNull(localRetorno);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2"));  
                            do{ 
                                System.out.printf("Insira a chegada do Transporte: ");
                                chegadaT = Console.readString();
                                chegadaT = replaceInteger(chegadaT);
                                System.out.println("Essa é a chegada "+chegadaT+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(chegadaT,1);
                                verificaNull = stringNull(chegadaT);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                                int chegada = Integer.parseInt(chegadaT);
                            do{    
                                System.out.printf("Insira o local de chegada do Transporte: ");
                                localChegada = Console.readString();
                                localChegada = replaceLetters(localChegada);
                                System.out.println("Esse é o local da Chegada "+localChegada+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(localChegada,25);
                                verificaNull = stringNull(localChegada);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2"));  
                            do{ 
                                System.out.printf("Insira o id do Bloco do Transporte: ");
                                blocoT = Console.readString();
                                blocoT = replaceInteger(blocoT);
                                System.out.println("Esse é o id do Bloco "+blocoT+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(blocoT,2);
                                verificaNull = stringNull(blocoT);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                            int bloco = Integer.parseInt(blocoT);
                            
                            Bloco blocoTransporte = controller.obterBloco(bloco);
                            Transporte transporteTest = controller.cadastrarTransporte(nome, tipo, valor, capacidade, saida, localSaida, retorno, localRetorno, chegada, localChegada, blocoTransporte);
                            
                            if(saida > retorno || retorno > chegada){
                                System.out.println("Erro Horarios dessicronizados.");
                            }else if(transporteTest == null || blocoTransporte == null){
                                System.out.println("Erro Cadastro.");
                            }else{
                                verificaTransporte++;
                                System.out.println("Cadastro Concluido.");
                            }
                            System.out.println("Insira 1 ou 2 :\n1 - Menu\n2 - Novo Transporte\nOpcao: ");
                            menuEscolha = Console.readString();
                        }while(!menuEscolha.equals("1"));
                    }else{
                        menuEscolha = "1";
                        System.out.println("Não há Bloco para cadastrar Transporte.");
                    }
                    break;
                case "4":
                    if(verificaTransporte > 0 && verificaFoliao > 0){
                        do{
                            System.out.println("Cadastrando Foliao em Transporte\n");
                            do{
                                System.out.printf("Insira cpf do Foliao: ");
                                cpf = Console.readString();
                                cpf = replaceInteger(cpf);
                                System.out.println("Esse é o cpf "+cpf+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringIdeal(cpf,11);
                                verificaNull = stringNull(cpf);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                            Foliao foliaoEmTransporte = controller.obterFoliao(cpf);
                            do{ 
                                System.out.println("Insira o id do Transporte\n");
                                idT = Console.readString();
                                idT = replaceInteger(idT);
                                System.out.println("Esse é o id do Transporte "+idT+" ?\n"+"1 - Sim/2 - Nao: ");
                                opcao = Console.readString();
                                opcao = replaceOpcao(opcao);
                                verificaLimite = stringLimit(idT,2);
                                verificaNull = stringNull(idT);
                            }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2"));
                            int id = Integer.parseInt(idT);

                            Transporte TransporteDoFoliao = controller.obterTransporte(id);
                            Boolean b = controller.registrarFoliaoEmTransporte(foliaoEmTransporte, TransporteDoFoliao);

                            if(b == true){
                                verificaFoliaoEmTransporte++;
                                System.out.println("Cadastro Concluido.");
                            }else{
                                System.out.println("Erro Cadastro.");
                            }    
                            System.out.println("Insira 1 ou 2 :\n1 - Menu\n2 - Novo Cadastro\nOpcao: ");
                            menuEscolha = Console.readString();
                        }while(!menuEscolha.equals("1"));
                    }else{
                        menuEscolha = "1";
                        System.out.println("Não há Foliao ou Transporte para cadastrar.");
                    }    
                    break;   
                case "5":
                    if(verificaFoliao > 0){
                        System.out.println("Buscando Foliao");
                        do{
                            System.out.printf("Insira cpf do Foliao: ");
                            cpf = Console.readString();
                            cpf = replaceInteger(cpf);
                            System.out.println("Esse é o cpf "+cpf+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringIdeal(cpf,11);
                            verificaNull = stringNull(cpf);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        Foliao foliao = controller.obterFoliao(cpf);

                        if(controller.obterFoliao(cpf) == null){
                            System.out.println("Foliao inexistente!");
                        }else{
                            System.out.println("Foliao encontrado!");
                            System.out.println("Cpf: "+foliao.getCpf());
                            System.out.println("Rg: "+foliao.getRg());
                            System.out.println("Nome: "+foliao.getNome());
                            System.out.println("Idade: "+foliao.getIdade());
                        }
                    }else{
                        menuEscolha = "1";
                        System.out.println("Não há folião para listar.");
                    }
                    break;
                case "6":
                    if(verificaBloco > 0){
                        System.out.println("Buscando Bloco");
                        do{ 
                            System.out.printf("Insira o id do Bloco: ");
                            blocoT = Console.readString();
                            blocoT = replaceInteger(blocoT);
                            System.out.println("Esse é o id do Bloco "+blocoT+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(blocoT,2);
                            verificaNull = stringNull(blocoT);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        int idBloco = Integer.parseInt(blocoT);

                        Bloco bloco = controller.obterBloco(idBloco);
                        if(bloco == null){
                            System.out.println("Bloco inexistente!");
                        }else{
                            System.out.println("Bloco encontrado!");
                            System.out.println("|BLOCO "+bloco.getIdBloco()+"|");
                            System.out.println("Nome: "+bloco.getNome());
                            System.out.println("Local: "+bloco.getLocal());
                            System.out.println("Saida: "+bloco.getSaida());
                        }
                    }else{
                        menuEscolha = "1";
                        System.out.println("Não há Blocos para buscar.");
                    }    
                    break;
                case "7":
                    if(verificaBloco > 0 && verificaTransporte > 0){
                        System.out.println("Buscando Transporte");
                        do{ 
                            System.out.println("Insira o id do Transporte\n");
                            idT = Console.readString();
                            idT = replaceInteger(idT);
                            System.out.println("Esse é o id do Transporte "+idT+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(idT,2);
                            verificaNull = stringNull(idT);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2"));
                        int idTransporte = Integer.parseInt(idT);

                        Transporte transporte = controller.obterTransporte(idTransporte);
                        if(transporte == null){
                            System.out.println("Transporte inexistente!");
                        }else{
                            System.out.println("Transporte encontrado!");

                            System.out.println("Id:"+transporte.getIdTransporte());
                            System.out.println("Nome: "+transporte.getNome());
                            System.out.println("Local: "+transporte.getTipo());
                            System.out.println("Bloco: "+transporte.getBlocoTransporte().getNome());
                            System.out.println("Saida: "+transporte.getValor());
                            System.out.println("Capacidade: "+transporte.getCapacidade());
                            System.out.println("Vagas Ocupadas: "+transporte.getVagasOcupadas());
                            System.out.println("Saida: "+transporte.getSaida());
                            System.out.println("Local de Saida: "+transporte.getLocalSaida());
                            System.out.println("Retorno: "+transporte.getLocalRetorno());
                            System.out.println("Local de Retorno: "+transporte.getLocalRetorno());
                            System.out.println("Chegada: "+transporte.getLocalChegada());
                            System.out.println("Local de Chegada: "+transporte.getLocalChegada());
                        }
                    }else{
                        menuEscolha = "1";
                        System.out.println("Não há Transporte para buscar.");
                    }       
                    break;
                case "8":
                    if(verificaFoliaoEmTransporte > 0){
                        System.out.println("Listando Foliao");
                        do{ 
                            System.out.println("Qual o id do Transporte dos Folioes: ");
                            idT = Console.readString();
                            idT = replaceInteger(idT);
                            System.out.println("Esse é o id do Transporte "+idT+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(idT,2);
                            verificaNull = stringNull(idT);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2"));
                        int idTransporteFoliao = Integer.parseInt(idT);
                        
                        Transporte transporteDosFolioes = controller.obterTransporte(idTransporteFoliao);
                        Iterator iterTransporteFoliao = controller.listarFolioes(transporteDosFolioes);
                        
                        if(transporteDosFolioes == null){
                            System.out.println("Error Transporte inexistente!");
                        }else{
                            if(iterTransporteFoliao != null){
                                while(iterTransporteFoliao.hasNext()){
                                    Foliao foliaoNoTransporte = (Foliao) iterTransporteFoliao.next();
                                    int id = 0;
                                    System.out.println("|FOLIAO "+id+1+"|");
                                    System.out.println("Nome: "+ foliaoNoTransporte.getNome());
                                }
                            }else{
                                System.out.println("Erro Transporte sem Folioes.");
                            }    
                        }
                    }else{
                        menuEscolha = "1";
                        System.out.println("Ausencia de Foliao em Transporte.");
                    }    
                    break;
                case "9":
                    if(verificaBloco > 0){
                        System.out.println("Listar Bloco");
                        do{    
                            System.out.printf("Insira o local do Bloco: ");
                            localB = Console.readString();
                            localB = replaceLetters(localB);
                            System.out.println("Esse é o local "+localB+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(localB,25);
                            verificaNull = stringNull(localB);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        String local = localB;
                        do{ 
                            System.out.printf("Digite o inicio do Bloco: ");
                            saidaT = Console.readString();
                            saidaT = replaceInteger(saidaT);
                            System.out.println("Esse é a inicio "+saidaT+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(saidaT,1);
                            verificaNull = stringNull(saidaT);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        int inicio = Integer.parseInt(saidaT);    
                        do{ 
                            System.out.printf("Digite o fim do Bloco: ");
                            retornoT = Console.readString();
                            retornoT = replaceInteger(retornoT);
                            System.out.println("Esse é o fim "+retornoT+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(retornoT,1);
                            verificaNull = stringNull(retornoT);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        int fim = Integer.parseInt(retornoT);
                        
                        Iterator iterBloco = controller.listarBlocos(local,inicio,fim);
                        
                        if(iterBloco != null){
                            while(iterBloco.hasNext()){
                                Bloco blocoCurrent = (Bloco) iterBloco.next();
                                System.out.println("|BLOCO "+blocoCurrent.getIdBloco()+"|");
                                System.out.println("Nome: "+blocoCurrent.getNome());
                                System.out.println("Local: "+blocoCurrent.getLocal());
                                System.out.println("Saida: "+blocoCurrent.getSaida());
                            }
                        }else{
                            System.out.println("Erro ao Listar.");
                        }
                    }else{
                        System.out.println("Ausencia de Bloco.");
                    }
                    menuEscolha = "1";
                    break;
                            
                case "10":
                    if(verificaTransporte > 0 && verificaBloco > 0){
                        System.out.println("Listando Transporte");
                        do{ 
                            System.out.println("Qual o id do bloco dos transportes: ");
                            blocoT = Console.readString();
                            blocoT = replaceInteger(blocoT);
                            System.out.println("Esse é o id do Bloco "+blocoT+" ?\n"+"1 - Sim/2 - Nao: ");
                            opcao = Console.readString();
                            opcao = replaceOpcao(opcao);
                            verificaLimite = stringLimit(blocoT,2);
                            verificaNull = stringNull(blocoT);
                        }while(opcao.equals("")||verificaNull == false ||verificaLimite == false && (opcao.equals("1") ||  opcao.equals("2")) || verificaLimite == true && opcao.equals("2")); 
                        int idBlocoTransporte = Integer.parseInt(blocoT);
                        
                        Bloco BlocoDosTransportes = controller.obterBloco(idBlocoTransporte);
                        Iterator iterBlocoTransporte = controller.listarTransportes(BlocoDosTransportes);
                        
                        if(BlocoDosTransportes == null){
                            System.out.println("Error Bloco inexistente!");
                        
                        }else{
                            if(iterBlocoTransporte != null){
                                while(iterBlocoTransporte.hasNext()){
                                    Transporte transporteDoBloco = (Transporte) iterBlocoTransporte.next();
                                    System.out.println("|TRANSPORTE "+transporteDoBloco.getIdTransporte()+"|");
                                    System.out.println("Nome: "+transporteDoBloco.getNome());
                                    System.out.println("Local: "+transporteDoBloco.getTipo());
                                    System.out.println("Bloco: "+transporteDoBloco.getBlocoTransporte().getNome());
                                    System.out.println("Saida: "+transporteDoBloco.getValor());
                                    System.out.println("Capacidade: "+transporteDoBloco.getCapacidade());
                                    System.out.println("Vagas Ocupadas: "+transporteDoBloco.getVagasOcupadas());
                                    System.out.println("Saida: "+transporteDoBloco.getSaida());
                                    System.out.println("Local de Saida: "+transporteDoBloco.getLocalSaida());
                                    System.out.println("Retorno: "+transporteDoBloco.getLocalRetorno());
                                    System.out.println("Local de Retorno: "+transporteDoBloco.getLocalRetorno());
                                    System.out.println("Chegada: "+transporteDoBloco.getLocalChegada());
                                    System.out.println("Local de Chegada: "+transporteDoBloco.getLocalChegada());
                                }
                            }else{
                                System.out.println("Erro Bloco não tem Transporte.");
                            }
                        }
                    }else{
                        menuEscolha = "1";
                        System.out.println("Ausencia de Transporte.");
                    }
                    break;
            }        
        }while(menuEscolha.equals("1") || !menuOpcao.equals("11"));
    }
    
    public static boolean idadeLimit(String idade){
        int idades = Integer.parseInt(idade);
        if(idades < 18){
            System.out.println("Menor de idade. Inválido!");
            return false;
        }
        return true;
    }
    
    public static boolean stringLimit(String texto, int maximo){
        if(texto.length() > maximo){
            System.out.println("Voce ultrapassou o maximo de caracteres.");
            return false;
        }
        return true;
    }
    
    public static boolean stringIdeal(String texto, int maximo){
        if(!(texto.length() == maximo)){
            System.out.println("Falta ou Excesso de caracteres.");
            return false;
        }
        return true;
    }
    
    public static String replaceLetters(String text){
        return text.replaceAll("[^A-z]", "");
    }
    
    public static String replaceOpcao(String text){
        return text.replaceAll("[^1-2]", "");
    }

    public static String replaceInteger(String text){
        return text.replaceAll("[^0-9]", "");
    }
    
    public static boolean stringNull(String text){
        if(!text.equals("")&&!text.equals("'")&&!text.equals("\\")){
            if(text.equals("0")){
                System.out.println("Voce digitou "+text+". Invalido!");
                return false;
            }else if(text.equals("")){
                System.out.println("Voce não digitou nada.");
                return false;
            }
        }    
        return true;
    }
}