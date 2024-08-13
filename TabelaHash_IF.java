package atividade04;

public interface TabelaHash_IF {
	
	public void insert(Pessoa element);
	public void remove(Pessoa element) throws Exception;
	public Pessoa search(Pessoa element) throws Exception;
	public String print();
	
}
