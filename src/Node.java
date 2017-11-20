import java.util.ArrayList;
import java.util.List;

public class Node extends BtreeOrder {

	private List<Integer> valueNode = new ArrayList<Integer>();
	private List<Node> nextNodes = new ArrayList<Node>();
	private String name;
	private Node father;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getFather() {
		return father;
	}

	public void setFather(Node father) {
		this.father = father;
	}

	public Node(String k) {
		name = k;
	}

	public List<Integer> getValueNode() {
		return valueNode;
	}

	public void setValueNode(List<Integer> valueNode) {
		this.valueNode = valueNode;
	}

	public List<Node> getNextNodes() {
		return nextNodes;
	}

	public void setNextNodes(List<Node> nextNodes) {
		this.nextNodes = nextNodes;
	}

	@Override
	public String toString() {

		return this.name;
	}

}
