package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;


public class CustomizeTreeCellRenderer implements TreeCellRenderer{
	private JLabel label;
	
	public CustomizeTreeCellRenderer() {
        label = new JLabel();
    }

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
	            if (selected) {
	                label.setOpaque(true);
	            }
	            else {
	                label.setOpaque(false);
	            }
	            if (row ==tree.getRowCount()-1){
	            	int get = Integer.parseInt(value.toString());
	            	if(get > 0){
	            		label.setBackground(Color.black);
	            		label.setFont(new Font("Lo", Font.BOLD, 10));
	            	}
	            }
	            else {
	            	int get = Integer.parseInt(value.toString());
	            	if(get>0){
	            		label.setBackground(Color.RED);
	            		label.setFont(new Font("Ro", Font.PLAIN, 10));
	            	}
	            	
	            }

	        return label;
	}
}
