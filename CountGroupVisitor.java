package app;

public class CountGroupVisitor implements Visitor {

	private int total;
	
	public int getTotal(){
		return total;
	}
	@Override
	public void visitor_user(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getID());
	}

	@Override
	public void visitor_Group(Group group) {
		// TODO Auto-generated method stub
		total++;
	}

}
