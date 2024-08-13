package atividade04;

public class TabelaHash implements TabelaHash_IF {
    
	private ListaEncadeada[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new ListaEncadeada[tamanho];
        for(int i = 0; i < tamanho; i++) {
            this.tabela[i] = new ListaEncadeada();
        }
    }

    public ListaEncadeada[] getTabela() {
        return this.tabela;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    private int hashFunction(long telefone) {
        return (int) (telefone % tamanho);
    }

    @Override
    public void insert(Pessoa element) {
        int index = hashFunction(element.getTelefone());
        tabela[index].insert(element);
    }

    @Override
    public void remove(Pessoa element) throws Exception {
        int index = hashFunction(element.getTelefone());
        try {
            tabela[index].remove(element);
        } catch(Exception e) {
            throw new Exception("Elemento não encontrado na tabela!");
        }
    }

    @Override
    public Pessoa search(Pessoa element) throws Exception {
        int index = hashFunction(element.getTelefone());
        try {
            return tabela[index].search(element);
        } catch(Exception e) {
            throw new Exception("Elemento não encontrado na tabela!");
        }
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tamanho; i++) {
            sb.append(i).append(": ");
            Pessoa[] pessoas = tabela[i].toArray();
            for(Pessoa p : pessoas) {
                sb.append(p.getTelefone()).append(", ");
            }
            if(pessoas.length > 0) {
                sb.setLength(sb.length() - 2);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
