package app;

public class UserVisitor implements Visitor{
	public User u;
	public Group g;
	private String ID;
	
	public UserVisitor(String my_id){
		ID = my_id;
	}
	@Override
	public void visitor_user(User user) {
		// TODO Auto-generated method stub
		if(!user.getID().isEmpty()&&user.getID().equals(ID)){
			u = user;
		}
	}

	@Override
	public void visitor_Group(Group group) {
		if(!group.getID().isEmpty()){
			g = group;
		}
		
	}

}
