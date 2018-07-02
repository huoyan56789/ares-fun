package datastructure.tree;

import utils.NumberUtils;

import java.util.Arrays;

/**
 * @author Ares
 * @date 2018/6/22 15:21
 */
public class AVL
{
    /**
     * 这是一种比BST高效的平衡二叉树(必定是BST)，高度为 h 的 AVL 树，
     * 节点数 N 最多2^h − 1； 最少N(h)=N(h− 1) +N(h− 2) + 1。
     */

    //根节点
    public static Node root = null;

    public static void main(String[] args)
    {

        root = addNode(root, 8);
        root = addNode(root, 4);
        root = addNode(root, 64);
        root = addNode(root, 5);
        System.out.println(root);

    }



    private static Node addNode(Node root, int value)
    {
        root = Node.addNode(root, value);
        if (root.flag)
        {
            balance(new Node(value));
        }
        return root;
    }

    /*
    * 平衡节点
    * 由于插入tempNode，树失去了平衡
    */
    private static void balance(Node tempNode)
    {
        //nodeImbalance是离插入节点最近的非平衡节点
        Node nodeImbalance = null;
        //node用来遍历AVL树
        Node node = root;
        //1.寻找离tempNode最近的非平衡点nodeImbalance
        while(null != node)
        {
            int heightLeft = Node.getHeight(node.leftNode);
            int heightRight = Node.getHeight(node.rightNode);
            if (Math.abs(heightRight - heightLeft) > 1)
            {
                //此节点是非平衡点,用nodeImbalance标记
                nodeImbalance = node;
            }
            if (tempNode.value < node.value)
            {
                node = node.leftNode;
            }
            else if (tempNode.value > node.value)
            {
                node = node.rightNode;
            }
            else
            {
                node = null;
            }
        }
        if (nodeImbalance == null)
        {
            //不存在非平衡点
            return;
        }

                /*2.判断属于哪种情况
            2.1 在nodeImbalance的左孩子的左子树中插入节点--  顺旋
            2.2 在nodeImbalance的左孩子的右子树中插入节点--  先逆再顺
            2.3 在nodeImbalance的右孩子的左子树中插入节点--  先顺再逆
            2.4 在nodeImbalance的右孩子的右子树中插入节点--  逆旋*/
        if (tempNode.value < nodeImbalance.value)
        {
            if (tempNode.value < nodeImbalance.leftNode.value)
            {
                //顺旋
                singleRotate(nodeImbalance, true);
            }
            else
            {
                //逆-顺，先逆旋后顺旋
                doubleRotate(nodeImbalance, true);
            }
        }
        else
        {
            if (tempNode.value > nodeImbalance.rightNode.value)
            {
                //逆旋
                singleRotate(nodeImbalance, false);
            }
            else
            {
                //顺-逆
                doubleRotate(nodeImbalance, false);
            }
        }

    }

    private static void doubleRotate(Node node, boolean flag)
    {
        if (flag)
        {
            //对左儿子做逆旋变为左左情形,然后做顺旋
            singleRotate(node.leftNode, false);
            singleRotate(node, true);
        }
        else
        {
            //对右儿子做顺旋变为右右情形,然后做逆旋
            singleRotate(node.rightNode, true);
            singleRotate(node, false);
        }
    }

    /*
    *   将以node为根的树单次旋转
    */
    private static void singleRotate(Node node, boolean isClockwise)
    {
        //顺旋
        if (isClockwise)
        {
            Node leftNode = node.leftNode;
            Node copyNode = Node.copy(node);
            copyNode.leftNode = leftNode.rightNode;
            node.leftNode = leftNode.leftNode;
            node.value = leftNode.value;
            node.rightNode = copyNode;
        }
        //逆旋
        else
        {
            Node rightNode = node.rightNode;
            Node copyNode = Node.copy(node);
            copyNode.rightNode = rightNode.leftNode;
            node.rightNode = rightNode.rightNode;
            node.value = rightNode.value;
            node.leftNode = copyNode;
        }
    }

}
