package lambda;

import entity.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Ares
 * @date 2018/6/14 15:59
 */
public class PersonService
{

    public List<Person> findByName(List<Person> personList, String name)
    {
        return find(personList, p -> name.equals(p.getName()));
    }

    public List<Person> findByGender(List<Person> personList, String gender)
    {
        return find(personList, p -> gender.equals(p.getGender()));
    }

    public List<Person> find(List<Person> personList, Predicate<Person> predicate)
    {
        //filter内部其实是一个函数,
        return personList.stream().filter(p -> predicate.test(p)).collect(Collectors.toList());
    }

}

