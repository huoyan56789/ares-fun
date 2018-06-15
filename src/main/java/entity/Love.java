package entity;

/**
 * @author Ares
 * @date 2018/4/25 10:36
 */
public class Love
{
    private String name;
    private Integer reason;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getReason()
    {
        return reason;
    }

    public void setReason(Integer reason)
    {
        this.reason = reason;
    }

    @Override
    public String toString()
    {
        return "entity.Love{" + "name='" + name + '\'' + ", reason=" + reason + '}';
    }
}
