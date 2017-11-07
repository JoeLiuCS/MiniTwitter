package app;

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
	            if (User instanceof Group){
	                label.setFont(new Font("SANS_SERIF", Font.BOLD, 12));
	            }
	            else {
	                label.setFont(new Font("SANS_SERIF", Font.PLAIN, 12));
	            }

	        return label;
	}
}
