package entity;

/**
 * @author Ares
 * @date 2018/6/14 16:09
 */
public class Person
{
    private String name;
    private String gender;
    private int age;

    public Person(String name, String gender, int age)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

