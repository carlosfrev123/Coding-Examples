/*
Name: Carlos Revilla
Computing ID: cfr5spw

*/


public class Queue {

	final int INITIAL_SIZE = 10;
	String[] elements;
	int currentSize, head, tail;
	
	public Queue(){
		this.elements = new String[this.INITIAL_SIZE];
		this.currentSize = this.head = this.tail = 0;
	}
	
	public void add(String s){
		// TODO: Complete this method to implement the add() method for a Queue
		growIfNecessary();
		elements[tail] = s;
		tail++;
        
        
	}
	
	public String remove(){
		// TODO: Complete this method to implement the remove() method for a Queue
		if(tail == 0){
			return null;
		}
		tail--;
		return elements[tail];
		
       	}
	
	private void growIfNecessary(){
		if(currentSize == elements.length){
			String[] newElements = new String[2*elements.length];
			for(int i = 0; i < elements.length; i++){
				newElements[i] = elements[(head+i)%elements.length];
			}
			elements = newElements;
			head = 0;
			tail = currentSize;
		}
	}
	
	public static void main(String[] args) {
        // TODO: Use main-method testing to test your code!
        // Optional suggestion: Write a print method to show the contents of the queue and maybe even your pointers
        
		Queue s = new Queue();
		s.add("Lorna");
		s.add("Sandy");
		s.add("Lucas");
		s.add("Zach");
		System.out.println(s.remove());
		System.out.println(s.remove());
		System.out.println(s.remove());
		System.out.println(s.remove());
		System.out.println(s.remove());
		s.add("Help");
		System.out.println(s.remove());
		System.out.println(s.remove());
		System.out.println(s.remove());
	}

	

}
