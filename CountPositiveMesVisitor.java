package app;

import java.util.List;

public class CountPositiveMesVisitor implements Visitor{
	private int total;
	private final String good = "good";
	private final String great = "great";
	private final String excellent = "excellent";
	
	public int getTotal(){
		return total;
	}
	public CountPositiveMesVisitor(List<String> li){
		for(String s:li){
			if(s.equals(good)||s.equals(great)||s.equals(excellent)){
				total++;
			}
		}
	}
	
	@Override
	public void visitor_user(User user) {
		if(!user.getID().isEmpty()){
			System.out.println(user.getID());
		}
		
	}

	@Override
	public void visitor_Group(Group group) {
		if(!group.getID().isEmpty()){
			System.out.println(group.getID());
		}
	}

}
