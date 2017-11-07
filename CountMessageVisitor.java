package app;

public class CountMessageVisitor implements Visitor{
	private int total;
	
	public int getTotal(){
		return total;
	}
	@Override
	public void visitor_user(User user) {
		// TODO Auto-generated method stub
		total = total +user.getsizeOfTwitter();
	}

	@Override
	public void visitor_Group(Group group) {
		// TODO Auto-generated method stub
		System.out.println(group.getID());
	}

}
