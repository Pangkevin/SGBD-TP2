import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BTree extends BtreeOrder {

	private Node root;
	private int height;
	private Node[] nodes = new Node[5];
	private Node currentNode;

	public Node getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(Node currentNode) {
		this.currentNode = currentNode;
	}

	public BTree() {

		root = new Node("n0");
		this.currentNode = root;
	}

	public String toString() {
		String tabValue = "Valeur du Noeud : [";

		String tabNext = "[";

		for (Integer s : root.getValueNode()) {

			tabValue += s + ", ";
		}

		tabValue += "]";

		for (Node s : root.getNextNodes()) {

			tabNext += s.toString() + ", ";
		}

		tabNext += "]";

		return tabValue + "     " + tabNext;
	}

	/*
	 * public Node search(int value) {
	 * 
	 * Node res = null; for (Node node : this.nodes)
	 * 
	 * for (int nodeValue : node.getValueNode()) {
	 * 
	 * if (value == nodeValue) { return res = node; }
	 * 
	 * }
	 * 
	 * return res;
	 * 
	 * }
	 */

	public Node search(Integer value) {

		Node nodeCurrent = this.getCurrentNode();

		if (nodeCurrent.getValueNode().contains(value)) {
			return nodeCurrent;
		} else {

			for (int i = 0; i < nodeCurrent.getValueNode().size(); i++) {

				if (nodeCurrent.getValueNode().get(i) > value) {

					for (int j = 1; j < this.getNodes().length; ++j) { // pour trouver le fils avec ce père

						if (this.nodes[j].getFather().equals(nodeCurrent)) {
							System.out.println(this.getNodes()[j + i].getName());
							nodeCurrent = this.getNodes()[j + i];
							j = this.getNodes().length;
							i = nodeCurrent.getValueNode().size();
						}

					}

					
				} else if (nodeCurrent.getValueNode().get(i) < value){
					
					for (int j = 1; j < this.getNodes().length; ++j) { // pour trouver le fils avec ce père

						if (this.nodes[j].getFather().equals(nodeCurrent)) {
							System.out.println(this.getNodes()[j + i].getName());
							nodeCurrent = this.getNodes()[j + i +1];
							j = this.getNodes().length;
							i = nodeCurrent.getValueNode().size();
						}

					}
				}
			}
			
		}
		this.currentNode = nodeCurrent;
		search(value); 

		return nodeCurrent;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node[] getNodes() {
		return nodes;
	}

	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	}

	public void insertion(int valueInsert) {

		if (this.search(valueInsert) != null) {

			System.out.println("ALREADY EXIST");
		} else {

			for (Node node : this.nodes)
				innerloop: for (int nodeValue : node.getValueNode()) {

					if (valueInsert < nodeValue
							|| (valueInsert > nodeValue && node.getValueNode().size() == this.getM() - 1)) {
						break innerloop;

					} else if (valueInsert > nodeValue && node.getValueNode().size() < this.getM() - 1) {

						node.getValueNode().add(valueInsert);
						break;
					}

				}
		}

	}

	public static void main(String[] args) {

		BTree btree = new BTree();
		List<Integer> rootValues = new ArrayList<Integer>();

		rootValues.add(7);
		rootValues.add(10);
		// rootValues.add(8);
		btree.root.setValueNode(rootValues);
		// btree.currentNode.setValueNode(rootValues);

		Node n1 = new Node("N1");
		n1.setFather(btree.root);
		Node n2 = new Node("N2");
		n2.setFather(btree.root);
		Node n3 = new Node("N3");
		n3.setFather(btree.root);
		Node n4 = new Node("N4");

		// Init value N1
		List<Integer> n1Values = new ArrayList<Integer>();
		n1Values.add(2);

		n1.setValueNode(n1Values);

		// Init value N2
		List<Integer> n2Values = new ArrayList<Integer>();
		n2Values.add(8);

		n2.setValueNode(n2Values);

		// Init value N3
		List<Integer> n3Values = new ArrayList<Integer>();
		n3Values.add(15);

		n3.setValueNode(n3Values);

		// Init value N4
		List<Integer> n4Values = new ArrayList<Integer>();

		n4.setValueNode(n4Values);

		// on rajoute les node

		List<Node> nextNodes = new ArrayList<Node>();
		nextNodes.add(n1);
		nextNodes.add(n2);
		nextNodes.add(n3);
		nextNodes.add(n4);

		btree.root.setNextNodes(nextNodes);

		Node[] node = { btree.root, n1, n2, n3, n4 };
		btree.setNodes(node);

		System.out.println(btree.toString());
	//	System.out.println("The Value is located in node : " + btree.search(7));
	//	System.out.println("The Value is located in node : " + btree.search(2));
		//System.out.println("The Value is located in node : " + btree.search(8));
		System.out.println("The Value is located in node : " + btree.search(15));
		/*
		 * System.out.println(btree.getNodes()[0].toString()); btree.insertion(11);
		 * System.out.println("The Value is located in node : " + btree.search(11));
		 * System.out.println(btree.toString());
		 */

	}

}