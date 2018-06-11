package br.uefs.ecomp.bfs.model;

import java.util.Objects;

/**
 * @author ramon
 */

public class Bloco{
    
    private String nome;
    private String local;
    private int saida;
    private int idBloco;

    public Bloco(String nome, String local, int saida){
        this.nome = nome;
        this.local = local;
        this.saida = saida;    
    }
 
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getLocal(){
        return local;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public int getSaida(){
        return saida;
    }

    public void setSaida(int saida){
        this.saida = saida;
    }

    public int getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(int idBloco) {
        this.idBloco = idBloco;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bloco other = (Bloco) obj;
        if (this.saida != other.saida) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        return true;
    }
}
