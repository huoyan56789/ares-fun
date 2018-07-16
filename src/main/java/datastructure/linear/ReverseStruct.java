package datastructure.linear;

/**
 * @author Ares
 * @date 2018/7/5 17:03
 */
public class ReverseStruct
{
    public static void main(String[] args)
    {
        StructNode tailNode = new StructNode(10);
        StructNode nodeOne = new StructNode(12);
        nodeOne.setNext(tailNode);
        StructNode nodeTwo = new StructNode(16);
        nodeTwo.setNext(nodeOne);
        StructNode headNode = new StructNode(1);
        headNode.setNext(nodeTwo);

        System.out.println(headNode);

        System.out.println(StructNode.reverseStruct(headNode));
        System.out.println(StructNode.reverseStructWithLoop(headNode));
    }

}
