package atividade04;

public class ListaEncadeada implements ListaEncadeada_IF {

	protected SingleLinkedListNode<Pessoa> head;
	
	public ListaEncadeada() {
		this.head = new SingleLinkedListNode<Pessoa>();
	}
	
	@Override
	public boolean isEmpty() {
		if(this.head.isNIL()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		int tam = 0;
		SingleLinkedListNode<Pessoa> aux = this.head;
		while(!aux.isNIL()) {
			tam++;
			aux = aux.next;
		}
		return tam;
	}

	@Override
	public void insert(Pessoa element) {
		SingleLinkedListNode<Pessoa> newNode = new SingleLinkedListNode<Pessoa>(element, this.head);
        this.head = newNode;
	}

	@Override
	public void remove(Pessoa element) throws Exception {
		if(this.head.isNIL()) {
	        throw new Exception("Lista vazia, não é possível remover o elemento!");
	    }
	    
	    if(this.head.data.equals(element)) {
	        this.head = this.head.next;
	        return;
	    }
	    
	    SingleLinkedListNode<Pessoa> aux = this.head;
	    SingleLinkedListNode<Pessoa> previous = null;
	    boolean encontrado = false;
	    
	    while(aux != null && !aux.isNIL()) {
	        if(aux.data.equals(element)) {
	            encontrado = true;
	            break;
	        }
	        previous = aux;
	        aux = aux.next;
	    }
	    
	    if(encontrado) {
	        previous.next = aux.next;
	    } else {
	        throw new Exception("Elemento não encontrado na lista!");
	    }
	}

	@Override
	public Pessoa search(Pessoa element) throws Exception {
		SingleLinkedListNode<Pessoa> aux = this.head;
        while(!aux.isNIL()) {
            if(aux.data.equals(element)) {
                return aux.data;
            }
            aux = aux.next;
        }
        throw new Exception("Elemento não encontrado na lista!");
	}

	@Override
	public Pessoa[] toArray() {
		Pessoa[] result = new Pessoa[this.size()];
	    SingleLinkedListNode<Pessoa> aux = this.head;
	    int count = 0;
	    while(!aux.isNIL()) {
	        result[count] = aux.data;
	        aux = aux.next;
	        count++;
	    }
	    return result;
	}

}
