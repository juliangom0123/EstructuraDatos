package p2;

import java.io.*;
import java.util.*;

/**
 *
 * @author RENE
 */
class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Index {
    int index = 0;
}

class BinaryTree {

    Index index = new Index();

    Node constructTreeUtil(int pre[], Index preIndex,int low, int high, int size) {

        if (preIndex.index >= size || low > high) {
            return null;
        }

        Node root = new Node(pre[preIndex.index]);
        preIndex.index = preIndex.index + 1;

        if (low == high) {
            return root;
        }

        int i;
        for (i = low; i <= high; ++i) {
            if (pre[i] > root.data) {
                break;
            }
        }

        root.left = constructTreeUtil(pre, preIndex, preIndex.index, i - 1, size);
        root.right = constructTreeUtil(pre, preIndex, i, high, size);

        return root;
    }

    Node constructTree(int pre[], int size) {
        return constructTreeUtil(pre, index, 0, size - 1, size);
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[]) throws NumberFormatException, IOException {
        BinaryTree tree = new BinaryTree();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(reader.readLine());
        int number_nodes = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        String nodes_leaves = reader.readLine();
        int[] preorder = new int[number_nodes];
        for (int i = 0; i < number_nodes; i++) {
            preorder[i] = Integer.parseInt(st.nextToken());
        }
        int size = preorder.length;
        Node root = tree.constructTree(preorder, size);
        tree.printInorder(root);
    }
}
