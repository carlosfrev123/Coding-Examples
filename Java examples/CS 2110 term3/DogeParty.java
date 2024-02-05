
public class DogeParty {

	public static void main(String[] args) {
		/* Bella is a friendly black labrador dog who is about to turn 1
		year old and wants to have a party! 
		Unfortunately, nobody will attend the party right now.
		A Doge will only attend the party if it gets an invitation with
		the correct name.
		Help save Bella's party! Debug the code below so that everyone attends.
		Hint: you may want to first read through the code to understand what is intended,
		then look for possible errors.
		 */
		
		BirthdayGirl bella = new BirthdayGirl("Bella");
		
		// Bell thinks of the Doge's she wants to invite
		
		String[] inviteList = { "Fang","Fido","Ruff","Chauncy","Princess","Hampton" };
		bella.setInviteList(inviteList);
			
		bella.sendInvitations();
		
		System.out.println(bella);
		
		if ( bella.getAttendees() == null) {
			System.out.println("Tragic. Nobody is coming to Bella's party.");
		} else {
			// When fully debugged, this should print all six Doge
			for (int i =0; i< bella.getAttendees().length; i++) {
				System.out.println(bella.getAttendees()[i]);
			}
		}
	}
}

class Doge {
	private String name;
	public Doge() {
		name ="";
	}
	public Doge(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return "Doge named " + this.name;
	}
	
}

class BirthdayGirl extends Doge {
	private String[] inviteList;
	private Doge[] attendees;
	private Doge[] dogeNeighbors;
	
	// Overloaded constructor
	public BirthdayGirl(String name) {
		super(name);
		setUpNeighborhood();
	}
	
	/*
	 * add Attendee resizes the attendee array and adds the new attendee
	 * (since arrays are a fixed size)
	 * hint: this method is used because we have not introduced more advanced data structures
	 * it works correctly and does not contain bugs
	 */
	public void addAttendee(Doge dogeToAdd) {
		if (attendees == null ) {
			attendees = new Doge[1]; 
			attendees[0]=dogeToAdd;
		} else {
			Doge[] newAttendees = new Doge[ attendees.length+1 ];
			for (int y = 0; y < attendees.length;y++ ) {
				newAttendees[y]=attendees[y];
			}
			newAttendees[ newAttendees.length-1 ] = dogeToAdd;
			attendees=newAttendees;
		}
	}
	/*
	 * find neighbor accepts a string and attempts to find a Doge by that name
	 * in the dogeNeighbors array. It returns a -1 if that name is not found.
	 * 
	 */
	public int findNeighbor(String dogeName) {
		int returnValue = -1;  // sentinel value to indicate nothing found
		for ( int q =0; q<dogeNeighbors.length; q++) {
			if ( dogeNeighbors[q].getName().equals(dogeName) ) {
				returnValue = q; // set the return value to the current index 
				break;  // exit this loop to save time
			}
		}
		return returnValue;
	}
	
	public void sendInvitations() {
		/* for every doge in the invite list, see if they exist
		 * in the dogeNeighbors array - if a match is found,
		 * add them to the list of attendees
		 */
		for (int p = 0; p < inviteList.length; p++) {
			String dogeName = inviteList[p];
			int x = findNeighbor(dogeName);  // try to find this doge
			if ( x != -1 ) {  // if a doge is found, add it to the list
				addAttendee(dogeNeighbors[x]);
			}
		}
	}
	/*
	 * called by the constructor to set up all the neighborhood dogs
	 */
	public void setUpNeighborhood() {
		Doge[] dogsInTheNeighborhood = {
				new Doge("Smith"),
				new Doge("Jones"),
				new Doge("Hampton"),
				new Doge("Fang"),
				new Doge("Fido"),
				new Doge("Ruff"),
				new Doge("Chauncy"),
				new Doge("Princess")
				};
		
		this.setDogeNeighbors(dogsInTheNeighborhood);
	}
	
	@Override
	public String toString() {
		return "A SPECIAL Doge named " + this.getName()+ " who is a birthday girl!";
	}
	// getters and setters below
	public String[] getInviteList() {
		return inviteList;
	}
	public void setInviteList(String[] inviteList) {
		this.inviteList=inviteList;
	}
	public Doge[] getDogeNeighbors() {
		return dogeNeighbors;
	}
	public void setDogeNeighbors(Doge[] dogeNeighbors) {
		this.dogeNeighbors=dogeNeighbors;
	}
	public Doge[] getAttendees() {
		return attendees;
	}
	public void setAttendees(Doge[] attendees) {
		this.attendees=attendees;
	}
	
}