package atividade04;

public interface ListaEncadeada_IF {
	
	public boolean isEmpty();
	public int size();
	public void insert(Pessoa element);
	public void remove(Pessoa element) throws Exception;
	public Pessoa search(Pessoa element) throws Exception;
	public Pessoa[] toArray();
	
}
