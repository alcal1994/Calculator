
public class Memento<E> {
	private E total;
	
	public Memento() {
		
	}
		
	public Memento(E total) {

		setTotal(total);
	}

	public E getTotal() {
		return total;
	}

	public void setTotal(E total) {
		this.total = total;
	}
	
}//end of class
