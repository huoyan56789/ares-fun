package datastructure.linear;

import datastructure.tree.Node;

/**
 * 链表节点
 *
 * @author Ares
 * @date 2018/7/5 17:01
 */
public class StructNode
{
    private int data;
    private StructNode next;

    public StructNode(int data)
    {
        this.data = data;
    }

    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public StructNode getNext()
    {
        return next;
    }

    public void setNext(StructNode next)
    {
        this.next = next;
    }

    @Override
    public String toString()
    {
        return "StructNode{" + "data=" + data + ", next=" + next + '}';
    }

    public static StructNode reverseStruct(StructNode headNode){
        if(null == headNode||null == headNode.getNext())
        {
            return headNode;
        }
        StructNode reverseNode = reverseStruct(headNode.getNext());
        headNode.getNext().setNext(headNode);
        headNode.setNext(null);
        return reverseNode;
    }

    public static StructNode reverseStructWithLoop(StructNode headNode){
        if(null == headNode||null == headNode.getNext())
        {
            return headNode;
        }
        StructNode preNode = headNode;
        StructNode curNode = headNode.getNext();
        StructNode tempNode;
        while(null != curNode)
        {
            tempNode = curNode.getNext();
            curNode.setNext(preNode);

            preNode = curNode;
            curNode = tempNode;
        }
        headNode.setNext(null);

        return preNode;
    }
}
