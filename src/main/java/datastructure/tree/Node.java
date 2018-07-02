package datastructure.tree;

import java.util.LinkedList;
import java.util.List;


/**
 * @author Ares
 * 节点，用来构造树
 * @date 2018/6/22 12:28
 */

public final class Node
{
    public Node leftNode;
    public Node rightNode;

    public int value;
    //操作标识位
    public boolean flag;

    public Node(int value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "Node{" + "leftNode=" + leftNode + ", rightNode=" + rightNode + ", value=" + value + '}';
    }

    public static Node copy(Node node)
    {
        Node copyNode = new Node(node.value);
        copyNode.leftNode = node.leftNode;
        copyNode.rightNode = node.rightNode;
        return copyNode;
    }


    /**
     * 前序遍历BST，入参为root就是整个树
     */
    public static void preTravel(Node root)
    {
        if (null != root)
        {
            System.out.print(root.value + " ");
            preTravel(root.leftNode);
            preTravel(root.rightNode);
        }
    }

    /**
     * 中序遍历BST，入参为root就是整个树
     */
    public static void inorderTravel(Node root)
    {
        if (null != root)
        {
            inorderTravel(root.leftNode);
            System.out.print(root.value + " ");
            inorderTravel(root.rightNode);
        }
    }


    /**
     * 后序遍历BST，入参为root就是整个树
     */
    public static void postorderTravel(Node root)
    {
        if (null != root)
        {
            postorderTravel(root.leftNode);
            postorderTravel(root.rightNode);
            System.out.print(root.value + " ");
        }
    }


    /**
     * 二叉树的高度，即最大深度
     */
    public static int getHeight(Node root)
    {
        if (null == root)
        {
            return 0;
        }
        int heightLeft = getHeight(root.leftNode);
        int heightRight = getHeight(root.rightNode);
        return heightLeft > heightRight ? heightLeft + 1 : heightRight + 1;
    }

    /**
     * 二叉树的最小深度
     */
    public static int getMinDeath(Node root)
    {
        if (null == root)
        {
            return 0;
        }
        int heightLeft = getMinDeath(root.leftNode);
        int heightRight = getMinDeath(root.rightNode);
        return heightLeft < heightRight ? heightLeft + 1 : heightRight + 1;
    }

    /**
     * 求二叉树节点的个数
     */
    public static int countNode(Node root)
    {
        if (null == root)
        {
            return 0;
        }
        int leftNum = countNode(root.leftNode);
        int rightNum = countNode(root.rightNode);
        return leftNum + rightNum + 1;
    }


    /**
     * 求二叉树中叶子节点的个数
     */
    public static int countLeaf(Node root)
    {
        if (null == root)
        {
            return 0;
        }
        if (null == root.leftNode && null == root.rightNode)
        {
            return 1;
        }
        return countLeaf(root.leftNode) + countLeaf(root.rightNode);
    }

    /**
     * 求二叉树中第k层节点的个数
     */
    public static int countNodeInLevel(Node root, int k)
    {
        if (null == root || k < 1)
        {
            return 0;
        }
        if (k == 1)
        {
            return 1;
        }
        int leftCount = countNodeInLevel(root.leftNode, k - 1);
        int rightCount = countNodeInLevel(root.rightNode, k - 1);
        return leftCount + rightCount;
    }
/*
    *//**
 * 判断二叉树是否是平衡二叉树
 *//*
    public  static boolean isBalancedTree(Node node){
        if(null == node){
            return true;
        }
        int heightLeft = getHeight(node.leftNode);
        int heightRight = getHeight(node.rightNode);
        if(Math.abs(heightLeft - heightRight) >1 )
        {
            return false;
        }
        return isBalancedTree(node.leftNode)&& isBalancedTree(node.rightNode);
    }*/

    /**
     * 两个二叉树是否完全相同
     */
    public static boolean isSameTree(Node root, Node rootOther)
    {
        if (null == root && null == rootOther)
        {
            return true;
        }
        if (null == root || null == rootOther)
        {
            return false;
        }
        if (root.value != rootOther.value)
        {
            return false;
        }
        boolean leftIsSame = isSameTree(root.leftNode, rootOther.leftNode);
        boolean rightIsSame = isSameTree(root.rightNode, rootOther.rightNode);
        return leftIsSame && rightIsSame;
    }

    /**
     * 翻转二叉树or镜像二叉树
     */

    public static Node mirrorTree(Node root)
    {
        if (null == root)
        {
            return null;
        }
        Node leftNode = mirrorTree(root.leftNode);
        Node rightNode = mirrorTree(root.rightNode);
        root.leftNode = rightNode;
        root.rightNode = leftNode;
        return root;
    }

    /**
     * 两个二叉树是否互为镜像
     */
    public static boolean isMirror(Node root, Node rootOther)
    {
        Node mirrorNode = mirrorTree(root);
        return isSameTree(mirrorNode, rootOther);
    }

    /**
     * 添加节点,根据操作标识位判断操作是否进行，重复为false代表未插入
     */
    public static Node addNode(Node root, int value)
    {
        //BST 是空树
        if (null == root)
        {
            root = new Node(value);
            root.flag = true;
        }
        else
        {
            //回置操作标识
            root.flag = false;
            Node node = root;
            while(true)
            {
                //如果值重复，则不插入
                if (value == node.value)
                {
                    break;
                }
                else if (value < node.value)
                {
                    if (null == node.leftNode)
                    {
                        node.leftNode = new Node(value);
                        root.flag = true;
                        break;
                    }
                    node = node.leftNode;
                }
                else
                {
                    if (null == node.rightNode)
                    {
                        node.rightNode = new Node(value);
                        root.flag = true;
                        break;
                    }
                    node = node.rightNode;
                }
            }
        }

        return root;
    }

    /**
     * * 删除节点,返回值标识是删除成功还是该值在树中不存在
     * 叶子节点，直接删除
     * 非叶子节点
     * 1.只有左子树或者只有右子树，直接用左子树或者右子树代替待删除节点
     * 2.如果左右子树都存在，则将右子树接到左子树的最右边节点的右子树下(也可以将左子树接到右子树最左边的左子树下，这两者都可以保持有序)
     *
     * @param root
     * @param value
     *
     * @return
     */

    public static Node deleteNode(Node root, int value)
    {
        if(null == root){
            return null;
        }

        //是父节点的左节点(true)还是右节点(false)
        boolean isLeftNode = true;
        Node node = root;
        Node nodeFather = null;
        while(null != node)
        {
            //回置操作标识
            root.flag = false;
            if (value == node.value)
            {
                //node为叶子节点
                if (null == node.leftNode && null == node.rightNode)
                {
                    if (null == nodeFather)
                    {
                        root = null;
                        root.flag = true;
                        break;
                    }
                    else
                    {
                        if (isLeftNode)
                        {
                            nodeFather.leftNode = null;
                            root.flag = true;
                            break;
                        }
                        else
                        {
                            nodeFather.rightNode = null;
                            root.flag = true;
                            break;
                        }
                    }
                }
                else if (null == node.leftNode || null == node.rightNode)
                {
                    //左子树或者右子树为空
                    if (null == nodeFather)
                    {
                        root = null == node.leftNode ? node.rightNode : node.leftNode;
                        root.flag = true;
                        break;
                    }
                    else
                    {
                        if (isLeftNode)
                        {
                            nodeFather.leftNode = null == node.leftNode ? node.rightNode : node.leftNode;
                            root.flag = true;
                            break;
                        }
                        else
                        {
                            nodeFather.rightNode = null == node.leftNode ? node.rightNode : node.leftNode;
                            root.flag = true;
                            break;
                        }
                    }
                }
                else
                {
                    //左右子树都有
                    Node rightMost = node.leftNode;
                    while(rightMost.rightNode != null)
                    {
                        rightMost = rightMost.rightNode;
                    }
                    if (null == nodeFather)
                    {
                        rightMost.rightNode = node.rightNode;
                        root = node.leftNode;
                        root.flag = true;
                        break;
                    }
                    else
                    {
                        rightMost.rightNode = node.rightNode;
                        nodeFather.leftNode = node.leftNode;
                        root.flag = true;
                        break;
                    }
                }

            }
            else if (value < node.value)
            {
                nodeFather = node;
                node = node.leftNode;
                isLeftNode = true;
            }
            else
            {
                nodeFather = node;
                node = node.rightNode;
                isLeftNode = false;
            }
        }
        return root;
    }

    /**
     * 在树中检查值是否存在
     */
    public static boolean search(Node root, int value)
    {
        Node node = root;
        while(null != node)
        {
            if (node.value == value)
            {
                return true;
            }
            else if (value < node.value)
            {
                node = node.leftNode;
            }
            else
            {
                node = node.rightNode;
            }

        }
        return false;
    }

    /**
     * 二叉树的搜索区间
     */
    public static LinkedList searchNodes(Node root, int start, int end, LinkedList list)
    {
        if (null == root)
        {
            return null;
        }
        if (root.value > start)
        {
            searchNodes(root.leftNode, start, end, list);
        }
        if (root.value >= start && root.value <= end)
        {
            list.add(root.value);
        }
        if (root.value < end)
        {
            searchNodes(root.rightNode, start, end, list);
        }
        return list;
    }

}

