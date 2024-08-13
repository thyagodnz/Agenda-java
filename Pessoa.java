package atividade04;

public class Pessoa implements Comparable<Pessoa> {
    
    private String nome;
    private String email;
    private long telefone;

    public Pessoa() {}
    
    public Pessoa(String nome, String email, long telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public long getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome + "\n" +
               "E-mail: " + this.email + "\n" +
               "Telefone: " + this.telefone;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return telefone == other.telefone;
	}

    @Override
    public int compareTo(Pessoa outraPessoa) {
        return this.nome.compareTo(outraPessoa.getNome());
    }
    
}
