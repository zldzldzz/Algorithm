import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static class Tree {
		Node root;

		public static class Node {
			int data;
			Node left;
			Node right;

			public Node(int data) {
				this.data = data;
				left = null;
				right = null;
			}
		}

		public void postSearch(Node node) throws IOException {

			if (node == null) {
				return;
			}
			postSearch(node.left);
			postSearch(node.right);
			bw.write(String.valueOf(node.data) + "\n");
		}

		public void addNode(Node node, int data) {

			if (this.root == null) {
				root = new Node(data);
			}

			if (node == null) {
				return;
			}
			if (node.data > data) {
				//들어갈 값이 부모보다 작음
				if (node.left == null) {
					node.left = new Node(data);
				} else {
					addNode(node.left, data);
				}
			} else {
				if (node.data < data) {
					if (node.right == null) {
						node.right = new Node(data);
					} else {
						addNode(node.right, data);
					}
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Tree tree = new Tree();
		String input;
		// readLine()이 null을 반환할 때까지 (입력이 끝날 때까지) 반복
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int number = Integer.parseInt(input);
			tree.addNode(tree.root, number);
		}

		tree.postSearch(tree.root);

		br.close();
		bw.flush();
		bw.close();
	}
}