package entity;

import java.io.Serializable;

/**
 * @author Ares
 * @date 2018/6/26 10:47
 */
public class Thing implements Cloneable, Serializable
{
    private int num;
    //transient型变量的值不包括在串行化的表示中,注意结构依然在只是值不在
    //transient private String difficulty;
    private String difficulty;
    private Person person;

    public Thing()
    {
        //此处的super写不写都行，不写也会默认super
        super();
    }

    public Thing(int num, String difficulty, Person person)
    {
        this.num = num;
        this.difficulty = difficulty;
        this.person = person;
    }

    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public String getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    @Override
    public String toString()
    {
        return "Thing{" + "num=" + num + ", difficulty='" + difficulty + '\'' + ", person=" + person + '}';
    }

    /**
     * 浅复制
     * 浅复制对于未引用的成员变量(person),直接复制整个引用，这使得被复制的对象
     * 和复制得到的对象对于该成员变量操作的是一个对象（引用是两个，但是指向同一个对象）。
     * @return
     *
     * @throws CloneNotSupportedException
     */
   /* public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }*/

    /**
     * 深复制(成员变量中的引用类型必须实现Cloneable中的clone方法)
     * 然后在实现clone方法中给其引用类型的成员变量重新赋值
     */

    public Object clone() throws CloneNotSupportedException
    {
        Thing thing = (Thing) super.clone();
        thing.person = (Person) person.clone();
        return thing;
    }
}
