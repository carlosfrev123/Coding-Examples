/**
 * <p>This is the class you will complete - fill in all the missing method implementations</p>
 * 
 *  * <p>All the classes have been created for you, you must implement the ActorTree class methods.
 * If your BST works correctly, searches made against it should return in almost no time at all.</p>
 * 
 * @author Your friendly CS professors
 *
 */
public class ActorTree {
	/**
	 * ActorTree has only one property, the root node
	 */
	Node root;
	

	/**
	 * Initialize the root node in the default constructor
	 */
	public ActorTree() {
		this.root = null;
		
	}

	/**
	 * 
	 * @param name
	 *            - the name to find
	 * @return the matching Actor object
	 */
	public Actor find(String name) {
		if(root == null)
			return null;
		return root.find(name);
	}

	/**
	 * 
	 * @return an int representing 1 for each node in the tree
	 * 
	 */
	public int size() {
		if (root != null)
			return root.size();
		return 0;
		
		
	}

	/**
	 * 
	 * @return an int representing the maximum height of any branch
	 */
	public int height() {
		if (root != null)
			return root.height();
		return 0;
	}
    

	/**
	 * an empty tree is one with no data
	 * 
	 * @return boolean - True if the tree is empty
	 */
	public boolean isEmpty() {
		if(root == null)
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param a
	 *            - an Actor object
	 * @return boolean - True if the element was inserted
	 */
	public boolean insert(Actor a) {
		// use find method to find where to insert node a ie less than or greather than node by comparison
		
		if(root == null) {
			root = new Node(a);
			return true;
		}
		else 
			return root.insert(a);
		
		
	
	}
	
	/**
	 * In order Traversal
	 *
	 * @return a String representing the in-order traversal of this tree
	 */
	public String inOrder() {
		if(root == null) {
			return "";
		}
		else
			return root.inOrder();
		
		}
	}

	/**
	 * The Node class is an inner class of the ActorTree This is a Binary Search
	 * Tree, so each Node will have left and right children
	 * 
	 * @author Your friendly CS Professors
	 *
	 */
	class Node {
		Actor actor;
		Node left;
		Node right;

		/**
		 * default constructor
		 */
		public Node() {
			this.actor = new Actor();
			this.left = null;
			this.right = null;
			
		}

		/**
		 * Constructor that takes an Actor object
		 * 
		 * @param a
		 *            - an Actor left and right children are initialized to null
		 */
		public Node(Actor a) {
			this.actor = a;
			this.left = null;
			this.right = null;
			
		}

		
		/**
		 * The size method is recursive
		 * 
		 * @return an int to represent a count of all nodes
		 */
		public int size() {
			if (actor == null)
				return 0;
			else if( left == null && right == null) {
				return 1;
			}
			else if( left != null && right == null) {
				return left.size() + 1;
			}
			else if( left == null && right != null) {
				return right.size() + 1;
			}
				return left.size() + 1 + right.size(); 
		}

		

		/**
		 * The height method is recursive
		 * 
		 * @return an int to represent the maximum height of right or left child nodes,
		 *         plus 1 for the current node
		 */
		public int height() {
			int leftH = 0;
			int rightH = 0;
			if (actor == null)
				return 0;
			if(left != null) 
				leftH = left.height();
			else
				leftH = 0;
			if(right != null)
				rightH = right.height();
			else
				rightH = 0;
			
			if(rightH >= leftH)
				return rightH + 1;
			
			return leftH + 1;
			
			
				
		}
		
		/**
		 * The insert method finds the best place to insert the Actor argument
		 * 
		 * @param a
		 *            - an Actor to insert
		 * @return boolean - True if the Actor argument was added, false otherwise
		 */
		public boolean insert(Actor a) {
			if (actor == null ) {
				return false;
			}
			else if(actor.getPrimaryName().compareTo(a.getPrimaryName()) > 0) {
				if (left == null) {
					left = new Node(a);
					return true;
				}else
				
					return left.insert(a);
			} else if(actor.getPrimaryName().compareTo(a.getPrimaryName()) < 0) {
				if (right == null) {
					right = new Node(a);
					return true;
				}else
					return right.insert(a);
			}
			return false;
		}	
			

		/**
		 * The find method returns an Actor object with a matching name
		 * 
		 * @param name
		 *            - the name to search for
		 * @return the searched for Actor, or null
		 */
		public Actor find(String name) {
			if (actor != null) {
				if(actor.getPrimaryName().equals(name)) 
					return actor;
				if (left != null) {
				if(actor.getPrimaryName().compareTo(name) > 0) 
					return left.find(name);
				}
				if (right != null) {
				if(actor.getPrimaryName().compareTo(name) < 0) 
					return right.find(name);
				}
			}
			return null;
		}
		
			
	    /**
	     * In order Traversal
	     *
	     * @return a String representing the in-order traversal of the subtree rooted at this node
	     */
		public String inOrder() {
			
			if(actor == null) {
				return "";
			}
			else if(left == null && right == null) {
				return "" + actor.toString()  + "" ;
			}
			else if(left != null && right == null) {
				return left.inOrder()+ "\n" + actor.toString() +  "" ;
			}
			else if(left == null && right != null) {
				return "" +  actor.toString() + "\n"+ right.inOrder();
			}
			else {
		
		    return left.inOrder() + "\n"+ actor.toString() + "\n"+ right.inOrder();
			}
			
			
		}
}
	

