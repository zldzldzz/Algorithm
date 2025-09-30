import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.sun.source.tree.Tree;

public class Main {

	public static class Tree {
		Node root;

		private StringBuilder sb = new StringBuilder();

		class Node {
			String data;
			Node leftNode, rightNode;

			Node(String data) {
				this.data = data;
				leftNode = null;
				rightNode = null;
			}
		}

		public String getPreOrderResult() {
			sb.setLength(0);
			preOrder(root);
			return sb.toString();
		}

		private void preOrder(Node node) {
			if (node == null)
				return;
			//방문 처리
			sb.append(node.data);
			preOrder(node.leftNode);
			preOrder(node.rightNode);
		}

		public String getInOrderResult() {
			sb.setLength(0);
			inOrder(root);
			return sb.toString();
		}

		private void inOrder(Node node) {
			if (node == null)
				return;
			inOrder(node.leftNode);
			sb.append(node.data);
			inOrder(node.rightNode);
		}

		public String getPostOrderResult() {
			sb.setLength(0);
			postOrder(root);
			return sb.toString();
		}

		private void postOrder(Node node) {
			if (node == null)
				return;
			postOrder(node.leftNode);
			postOrder(node.rightNode);
			sb.append(node.data);
		}

		public void addNode(String data, String left, String right) {

			//root에 아무것도 없는 경우
			if (this.root == null) {
				root = new Node(data);
				if (!left.equals(".")) {
					root.leftNode = new Node(left);
				}
				if (!right.equals(".")) {
					root.rightNode = new Node(right);
				}
			} else {
				search(root, data, left, right);
			}
		}

		public void search(Node node, String data, String left, String right) {

			//최하위 노드로 이동했지만 없는 경우
			if (node == null) {
				return;
			}
			//내가 찾는 노드를 찾은 경우 삽입
			if (node.data.equals(data)) {
				if (!left.equals(".")) {
					node.leftNode = new Node(left);
				}
				if (!right.equals(".")) {
					node.rightNode = new Node(right);
				}
				return;
			}
			// 현재 삽입하는 노드를 못 찾는 경우 자식 노드를 기준으로 다시 탐색
			else {
				search(node.leftNode, data, left, right);
				search(node.rightNode, data, left, right);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Tree tree = new Tree();
		Integer lenght = Integer.parseInt(br.readLine());
		for (int i = 0; i < lenght; i++) {
			String[] line = br.readLine().split(" ");
			tree.addNode(line[0], line[1], line[2]);
		}

		bw.write(tree.getPreOrderResult() + "\n");
		bw.write(tree.getInOrderResult() + "\n");
		bw.write(tree.getPostOrderResult() + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}