//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
      // Index to keep track of the current root position in the postorder array
    int postIndex;
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
          // Initialize the postIndex to the last index of the postorder array
        postIndex = n - 1;
        // Call the recursive function to build the tree
        return buildTreeHelper(in, post, 0, n - 1);
    }

    // Recursive helper function to construct the tree
    Node buildTreeHelper(int in[], int post[], int inStart, int inEnd) {
        // Base case: If the start index is greater than the end index, return null
        if (inStart > inEnd)
            return null;

        // Create a new node with the current root value from postorder array
        Node root = new Node(post[postIndex]);
        // Decrement postIndex to move to the next root value in postorder array
        postIndex--;

        // If the start and end indices are equal, return the root
        if (inStart == inEnd)
            return root;

        // Find the index of the root value in the inorder array
        int inIndex = search(in, inStart, inEnd, root.data);

        // Recursively construct the right subtree
        root.right = buildTreeHelper(in, post, inIndex + 1, inEnd);
        // Recursively construct the left subtree
        root.left = buildTreeHelper(in, post, inStart, inIndex - 1);

        return root;
    }

    // Function to search for a value in the inorder array
    int search(int arr[], int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }
}
