package com.binarysearchtree.solutions;

/**
 * VImp: Medium: 450. Delete Node in a BST
 */

/**
 * Algorithm :
 * If key > root.val then delete the node to delete is in the right subtree root.right = deleteNode(root.right, key).
 *
 * If key < root.val then delete the node to delete is in the left subtree root.left = deleteNode(root.left, key).
 *
 * If key == root.val then the node to delete is right here. Let's do it :
 *
 * If the node is a leaf, the delete process is straightforward: root = null.
 *
 * If the node is not a leaf and has the right child, then replace the node value with a successor value root.val = successor.val, and then recursively delete, the successor in the right subtree root.right = deleteNode(root.right, root.val).
 *
 * If the node is not a leaf and has only the left child, then replace the node value with a predecessor value root.val = predecessor.val, and then recursively delete the predecessor in the left subtree root.left = deleteNode(root.left, root.val).
 *
 * Return root.
 */
public class DeleteNodeBST {
    /*
 One step right and then always left
 */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val); //*** See the explination below.
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);//*** See the explination below.
            }
        }
        return root;
    }
    /*
     * Why the recursive call is needed?
     * The recursive calls in the lines:
     *
     * java
     * Copy code
     * root.right = deleteNode(root.right, root.val);
     * root.left = deleteNode(root.left, root.val);
     * serve to actually remove the duplicate node created when we replace the current node's value with its successor or predecessor.
     *
     * Detailed Explanation:
     * Case: Replace with Successor
     *
     * After determining the successor, we assign its value (root.val = successor(root)).
     * However, the successor is still present in the right subtree, creating a duplicate.
     * To remove the duplicate, we must recursively call deleteNode(root.right, root.val) on the right subtree, specifically targeting the successor node for removal.
     * Case: Replace with Predecessor
     *
     * Similarly, after assigning the predecessor value (root.val = predecessor(root)), the predecessor node remains in the left subtree.
     * We recursively call deleteNode(root.left, root.val) to find and remove the predecessor node.
     * Without this recursive call, the BST would contain duplicate values, violating the BST property.
     */
}
