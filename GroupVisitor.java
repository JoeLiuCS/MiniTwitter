package app;

public class GroupVisitor implements Visitor{
	private Group g;
	private User u;
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
	
	public Group getGroupTesting(){
		return g;
	}
	public User getUserTesting(){
		return u;
	}
	public String getIDTesting(){
		return ID;
	}
}
