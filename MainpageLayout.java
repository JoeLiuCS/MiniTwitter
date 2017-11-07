package app;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class MainpageLayout implements ActionListener,TreeSelectionListener{
	
	private static MainpageLayout INSTANCE; 
	
	private JFrame frame = new JFrame();
	private JTree treeList;
	private DefaultMutableTreeNode top_root = new DefaultMutableTreeNode("Root");
	
	private JPanel backGround = new JPanel();
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel(); 
	
	private JButton addUser = new JButton("AddUser");
	private JButton addGroup = new JButton("AddGroup");
	private JButton userTotal_button = new JButton("userTotal");
	private JButton groupTotal_button = new JButton("groupTotal");
	private JButton messageTotal_button = new JButton("messagerTotal");
	private JButton Positive_percentage_button = new JButton("Positive percentage");
	private JButton openUserView = new JButton("openUserView");
	
	
	private JTextField userID = new JTextField(5);
	private JTextField groupID = new JTextField(5);
	private Object root_select;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("AddUser")){
			String input_userID = userID.getText();
			if(!input_userID.equals("")){
				System.out.println("Add user");
				addUser(input_userID);
			}
		}
		if(command.equals("AddGroup")){
			String input_groupID = groupID.getText();
			if(!input_groupID.equals("")){	
				addGroup(input_groupID);
			}
		}
		if(command.equals("userTotal")){
			showUserTotal();
		}
		if(command.equals("groupTotal")){
			showGroupTotal();
		}
		if(command.equals("messagerTotal")){
			showMessagerTotal();
		}
		if(command.equals("Positive percentage")){
			showPositivePercentage();
		}
		if(command.equals("openUserView")){
			showOpenUserView();
		}
	}
	
    private MainpageLayout(){
        System.out.println("Main Panel running");
    }
	
	public static MainpageLayout getInstance(){
        if (INSTANCE == null){
            synchronized(MainpageLayout.class){
                if (INSTANCE == null){
                    INSTANCE = new MainpageLayout();
                }
            }
        }
        return INSTANCE;
    }
	
	public void initialize(){
		frame.setTitle("MainPage");
	    frame.setPreferredSize(new Dimension(700, 300));
	    frame.setBackground(Color.GRAY);
	    backGround.setPreferredSize(new Dimension(700,300));
	    backGround.setBackground(Color.GRAY);
	    
	    leftPanel.setPreferredSize(new Dimension(280,280));
	    leftPanel.setBackground(Color.WHITE);
	    leftPanel.setLocation(10,10);
	    
	    rightPanel.setPreferredSize(new Dimension(380,280));
	    rightPanel.setBackground(Color.WHITE);
	    rightPanel.setLocation(310,10);
	    
		addUser.addActionListener(this);
		addGroup.addActionListener(this);
		userTotal_button.addActionListener(this);
		groupTotal_button.addActionListener(this);
		messageTotal_button.addActionListener(this);
		Positive_percentage_button.addActionListener(this);
		openUserView.addActionListener(this);
	    
	    //tree  leftPanel
		treeList =  new JTree(top_root);
		treeList.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		treeList.addTreeSelectionListener(this);
	    leftPanel.add(treeList);
	    
	    //rightPanel (Top)
	    GridLayout experimentLayout_top = new GridLayout(0,3);
	    
	    JPanel rightTopPanel = new JPanel();
	    rightTopPanel.setBackground(Color.LIGHT_GRAY);
	    rightTopPanel.setPreferredSize(new Dimension(370,120));
	    rightTopPanel.setLayout(experimentLayout_top);
	    
	    JLabel U_ID = new JLabel("UserID: ");
        U_ID.setForeground(Color.BLACK);
        rightTopPanel.add(U_ID);
	    
	    
	    userID.setSize(50, 50);
	    rightTopPanel.add(userID);
	    
	    rightTopPanel.add(addUser);
	    
	    JLabel G_ID = new JLabel("GroupID: ");
        G_ID.setForeground(Color.BLACK);
        rightTopPanel.add(G_ID);
	    
        
	    groupID.setSize(50, 50);
	    rightTopPanel.add(groupID);
	    
	    
	    rightTopPanel.add(addGroup);
	    JLabel empty = new JLabel("");
	    empty.setForeground(Color.BLACK);
        rightTopPanel.add(empty);
	    rightTopPanel.add(openUserView);
	    
	    
	    // rightPanel  (bottom)
	    GridLayout experimentLayout_bot = new GridLayout(0,2);
	    
	    JPanel rightButtomPanel = new JPanel();
	    rightButtomPanel.setBackground(Color.LIGHT_GRAY);
	    rightButtomPanel.setPreferredSize(new Dimension(370,140));
	    rightButtomPanel.setLayout(experimentLayout_bot);
	    
	    rightButtomPanel.add(userTotal_button);
	    rightButtomPanel.add(groupTotal_button);
	    rightButtomPanel.add(messageTotal_button);
	    rightButtomPanel.add(Positive_percentage_button);
	    
	    rightPanel.add(rightTopPanel);
	    rightPanel.add(rightButtomPanel);
	    
	    backGround.add(leftPanel);
	    backGround.add(rightPanel);
	    frame.add(backGround);
	    
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	private void showUserTotal(){
		User u  = new User(treeList.getModel().getRoot(),"root");
		CountUserVisitor c = new CountUserVisitor();
		u.accept(c);
		System.out.println(c.getNum());
		
	}
	private void showGroupTotal(){
		Group u  = new Group(treeList.getModel().getRoot(),"root");
		CountGroupVisitor c = new CountGroupVisitor();
		u.accept(c);
		System.out.println(c.getTotal());
	}
	private void showMessagerTotal(){
		User u  = new User(treeList.getModel().getRoot(),"root");
		CountMessageVisitor c = new CountMessageVisitor();
		u.accept(c);
		System.out.println(c.getTotal());
	}
	private void showPositivePercentage(){
		User u  = new User(treeList.getModel().getRoot(),"root");
		List<String> l  = (List<String>) treeList;
		CountPositiveMesVisitor c = new CountPositiveMesVisitor(l);
		u.accept(c);
		System.out.println(c.getTotal());
	}
	private void showOpenUserView(){
		ChatPageLayout c = new ChatPageLayout(root_select);
	}
	
	
	
	private void addGroup(String name){
		top_root.add(new DefaultMutableTreeNode(name));
		System.out.println("add me"+top_root.toString());
	}
	
	private void addUser(String name){
		DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode(name);
		top_root.add(vegetableNode);
		System.out.println("add me"+top_root.toString());
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		    DefaultMutableTreeNode node = (DefaultMutableTreeNode)
		                       treeList.getLastSelectedPathComponent();
		    if (node == null)     
		    	return;

		    Object nodeInfo = node.getUserObject();
		    if (node.isLeaf()) {
		        root_select = nodeInfo;
		        System.out.println(root_select.toString());
		    } else {
		    	System.out.println("ss2");
		    }
		
	}

	
	 
}
