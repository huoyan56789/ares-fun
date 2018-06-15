package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ares
 * @date 2018/5/28 14:14
 */
//属性为 空（""） 或者为 NULL 都不序列化，默认 值为null的属性不参与序列化
//@JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
//忽视pojo的属性，为一个列表，可放置多个属性
@JsonIgnoreProperties({"sex"})
public class Student {
    // @JsonIgnore加载属性和方法上，即可被忽略
    @JsonIgnore
    private String name;
    private Integer age;
    private String sex;
    @JsonProperty("firm")
    private String company;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    @Override
    public String toString()
    {
        return "entity.Student{" + "name='" + name + '\'' + ", age=" + age + ", sex='" + sex + '\'' + ", company='" + company + '\'' + '}';
    }
}


