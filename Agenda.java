package atividade04;

import java.util.ArrayList;
import java.util.Collections;

public class Agenda {
    
    private TabelaHash agenda;

    public Agenda(int tamanho) {
        this.agenda = new TabelaHash(tamanho);
    }

    public void adicionarContato(Pessoa p) throws Exception {
        try {
            if(this.agenda.search(p) != null) {
                throw new Exception("Já existe alguém com este telefone na agenda!");
            }
        } catch(Exception e) {
            if(e.getMessage().contains("Elemento não encontrado na tabela!")) {
                this.agenda.insert(p);
            } else {
                throw new Exception("\nERRO AO ADICIONAR CONTATO: " + e.getMessage());
            }
        }
    }

    public void removerContato(Pessoa p) throws Exception {
        try {
            this.agenda.remove(p);
        } catch(Exception e) {
            throw new Exception("\nERRO AO REMOVER CONTATO: " + e.getMessage());
        }
    }

    public Pessoa buscarContato(Pessoa p) throws Exception {
        try {
            return this.agenda.search(p);
        } catch(Exception e) {
            throw new Exception("\nERRO AO BUSCAR CONTATO: " + e.getMessage());
        }
    }

    private ArrayList<Pessoa> getContatos() {
        ArrayList<Pessoa> contatos = new ArrayList<>();
        for(int i = 0; i < agenda.getTamanho(); i++) {
            Collections.addAll(contatos, agenda.getTabela()[i].toArray());
        }
        return contatos;
    }

    public String listarContatos() {
        ArrayList<Pessoa> contatos = getContatos();
        Collections.sort(contatos);

        StringBuilder sb = new StringBuilder();
        for(Pessoa p : contatos) {
            sb.append(p.getNome()).append("\n");
        }
        return sb.toString();
    }

}
