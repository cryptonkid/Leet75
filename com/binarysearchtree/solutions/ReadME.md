<H1> Approches Solve BST </H1>
<table>
    <tr>
        <td>
            resurcise
        </td>
        <td>
            HeapSpace is Consumed lot
        </td>
        <td>
            Code is Clean
        </td>
    </tr>
    <tr>
        <td>
            iterative
        </td>
        <td>
            Code is Complex edge case need to be handled
            To handle stack operation, needs additional data structure.
        </td>
        <td>
            Heapspace Usage is low
        </td>
    </tr>
<tr>
<td>
    Inorder traversal of BST is an array sorted in ascending order.
</td>
<td>
   <code> public LinkedList<Integer> inorder(TreeNode root, LinkedList<Integer> arr) {
          if (root == null) return arr;
          inorder(root.left, arr);
          arr.add(root.val);
          inorder(root.right, arr);
          return arr;
        }
    </code>
</td>
</tr>
<tr><td>DeleteBST(VImp)</td><td>Read the Comments</td></tr>
</table>