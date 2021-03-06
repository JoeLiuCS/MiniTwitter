package app;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.soap.Node;


public class Group {
		private String ID;
		private List<Node> child;
		private DefaultMutableTreeNode tree;
		SimpleDateFormat time;
		
		public Group(String input_ID,DefaultMutableTreeNode input_node,SimpleDateFormat GivenTime){
			time = GivenTime;
			ID = input_ID;
			child = new LinkedList<>();
			tree = input_node;
			
		}
		
		public String getID(){
			return ID;
		}
		
		public List getChild(){
			return child;
		}
		public Node getChildFirst(){
			return child.get(0);
		}
		public DefaultMutableTreeNode getTreeRoot(){
			return tree;
		}
		public Node getIndex(int index){
			return child.get(index);
		}
		public int sizeOfChild(){
			return child.size();
		}
		public Node[] getNodeArray(){
			return (Node[]) child.toArray();
		}
		public void accept(Visitor v) {
	        v.visitor_Group(this);
	        for (Node elem : child){
	            ((Group) elem).accept(v);
	        }
	    }
}
