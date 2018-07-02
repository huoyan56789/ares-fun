package datastructure.tree;

import utils.NumberUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Ares
 * @date 2018/6/22 10:22
 */
public class BST
{
    /**
     * 二叉查找树
     * 节点值不允许重复,如果重复可以不插入或者抛异常，这里采取不插入的方式
     */
    //根节点
    public static Node root = null;


    public static void main(String[] args)
    {
        int[] values = NumberUtils.getIntArr(8, 5000);
        System.out.println(Arrays.toString(values));
        Arrays.stream(values).forEach(i -> {
            root = Node.addNode(root, i);
        });


        root = Node.addNode(root, 100);
        //        Node.preTravel(root);
        //        System.out.println();
        //        Node.inorderTravel(root);
        //        System.out.println();
        //        Node.postorderTravel(root);
        //        System.out.println();
        //
        //        int testNum = 2653;
        //        System.out.println(search(testNum));
        //        root = Node.addNode(root, testNum);
        //        System.out.println(search(testNum));
        //        Node.inorderTravel(root);
        //        System.out.println();
        //        deleteNode(testNum);
        //        System.out.println(search(testNum));
        //        Node.inorderTravel(root);
        //        System.out.println();

        //        LinkedList list = Node.searchNode(root, 2000, 3000, new LinkedList());
        //        System.out.println(list);

    }

}
