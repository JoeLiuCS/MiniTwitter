package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatPageLayout implements ActionListener{

	private JFrame frame = new JFrame();
	private JPanel topPanel = new JPanel();
	private JPanel botPanel = new JPanel();
	
	private JTextField userID = new JTextField(8);
	private JTextField message = new JTextField(8);
	private JTextArea follower_list = new JTextArea(6, 10);
	private JTextArea message_list = new JTextArea(6, 10);
	
	private JButton follower_Button = new JButton("follow user");
	private JButton post_Button = new JButton("post");
	private User user;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("follow user")){
			showFollowUser();
		}
		if(command.equals("post")){
			postMessage(message.getText());
		}
		
	}
	
	private void postMessage(String text){
		if(!text.isEmpty()){
			user.postNewTweet(text);
			user.setTime();
			user.changeLastPerson(user.getID());
		}
	}
	
	private void showFollowUser(){
		if(!user.getID().isEmpty()){
			follower_list.setText(user.getMyAllFollwers().toString());
		}
	}
    
    public ChatPageLayout(Object select){
    	frame.setTitle("ChatPage");
	    frame.setPreferredSize(new Dimension(400, 600));
	    frame.setBackground(Color.BLACK);
	    JPanel backGround = new JPanel();
	    backGround.setPreferredSize(new Dimension(400,600));
	    backGround.setBackground(Color.black);
	    
	    //top
	    topPanel.setBackground(Color.LIGHT_GRAY);
	    topPanel.setPreferredSize(new Dimension(370,280));
	    
	    JLabel U_ID = new JLabel("UserID: ");
        U_ID.setForeground(Color.BLACK);
        
	    userID.setSize(50, 50);
	    follower_list.setPreferredSize(new Dimension(300,200));
	    
	    topPanel.add(U_ID);
	    topPanel.add(userID);
	    topPanel.add(follower_Button);
	    topPanel.add(follower_list);
	    
	    
	    //bottom
	    botPanel.setBackground(Color.LIGHT_GRAY);
	    botPanel.setPreferredSize(new Dimension(370,280));
	    
	    message.setSize(50, 50);
	    message_list.setPreferredSize(new Dimension(300,200));
	    JLabel mes_typeIn = new JLabel("Message typeIn: ");
	    mes_typeIn.setForeground(Color.BLACK);
	    
	    botPanel.add(mes_typeIn);
	    botPanel.add(message);
	    botPanel.add(post_Button);
	    botPanel.add(message_list);
	    
	    
	    
	    backGround.add(topPanel);
	    backGround.add(botPanel);
	    frame.add(backGround);
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
    }


	

}
