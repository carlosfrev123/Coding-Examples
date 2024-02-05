
public class Stack {

	private String[] theStack;
	private final int STACK_SIZE = 3;
	private int top;
	
	public Stack(){
		this.theStack = new String[STACK_SIZE];
		this.top = 0;
	}
	
	public void push(String s){
		growIfNecessary();
		theStack[top] = s;
		top++;
	}
	
	public String pop(){
		if(top == 0){
			return null;
		}
		top--;
		return theStack[top];
	}
	
	private void growIfNecessary(){
		if(top == theStack.length){
			String[] newStack = new String[2*theStack.length];
			for(int i = 0; i < theStack.length; i++){
				newStack[i] = theStack[i];
			}
			theStack = newStack;
		}
	}
	
	public static void main(String[] args) {
		
		Stack s = new Stack();
		s.push("Lorna");
		s.push("Sandy");
		s.push("Lucas");
		s.push("Zach");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push("Help");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
