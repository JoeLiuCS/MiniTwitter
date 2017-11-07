package app;

public class GroupVisitor implements Visitor{
	public Group g;
	public User u;
	private String ID;

	public GroupVisitor(String input_id){
		ID = input_id;
	}
	@Override
	public void visitor_user(User user) {
		if(!user.getID().isEmpty()){
			u = user;
		}
	}

	@Override
	public void visitor_Group(Group group) {
		if(!group.getID().isEmpty()&&group.getID().equals(ID)){
			g = group;
		}
	}

}
