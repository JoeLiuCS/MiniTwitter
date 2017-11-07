package app;

public class CountUserVisitor implements Visitor{
	private int num;
	
	public int getNum(){
		return num;
	}
	@Override
	public void visitor_user(User user) {
		// TODO Auto-generated method stub
		num++;
	}

	@Override
	public void visitor_Group(Group group) {
		// TODO Auto-generated method stub
		System.out.println(group.getID());
	}

}
