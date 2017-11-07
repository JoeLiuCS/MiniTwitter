package app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;


public class User extends Subject implements Observer{
	private List<String> twitter = new ArrayList<>();
	private List<String> news = new ArrayList<>();
	private List<User> follower = new ArrayList<>();
	private String tweet;
	private String ID;
	private TreeNode node;
	
	public User(String input_ID,TreeNode input_Node,String newPost){
		node = input_Node;
		ID = input_ID;
		tweet = newPost;
		attach(this);
		follower.add(this);
	}
	
	public String showMefirstTweet(){
		return twitter.get(0);
	}
	public int CountMyFollowers(){
		return twitter.size();
	}
	public User[] getMyAllFollwers(){
		return (User[])follower.toArray();
	}
	public boolean postNewTweet(String tweet){
		return twitter.add(tweet);
	}
	public boolean postNews(String input_new){
		return news.add(input_new);
	}
	public int getSizeOfNews(){
		return news.size();
	}
	public int getsizeOfTwitter(){
		return twitter.size();
	}
	public int getSizeOfFollwer(){
		return follower.size();
	}
	public String getID(){
		return ID;
	}
	public TreeNode getMyCurrentNode(){
		return node;
	}
	
	public void accept(Visitor s) {
        s.visitor_user(this);
    }

	@Override
	public void update(Subject subject) {
		if (subject instanceof User) {
			news.add(tweet);
	        twitter.add(tweet);
        }
	}

}
