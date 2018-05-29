package algorithm.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ares
 * @date 2018/1/8 15:43
 */
public class Sorting
{
    public static void main(String[] args)
    {
        List<Products> products = new LinkedList<>();
        products.add(new Products("费罗列", 100, 30));
        products.add(new Products("love", 1000, 100));
        products.add(new Products("德芙", 10000000, 10));
        products.add(new Products("自行车", 10000, 899));
        products.add(new Products("行李箱", 8000, 569));
        products.add(new Products("泳衣", 100, 180));

        //定义比较器 按价格降序
        Comparator<Products> byPrice = new Comparator<Products>()
        {
            @Override
            public int compare(Products o1, Products o2)
            {
                return o1.compareTo(o2);
            }
        };

        //定义比较器 按销量降序
        Comparator<Products> byNum = new Comparator<Products>()
        {
            @Override
            public int compare(Products o1, Products o2)
            {
                return o1.getNum() < o2.getNum() ? -1 : o1.getNum() > o2.getNum() ? 1 : 0;
            }
        };

        //定义比较器 按销量降序   再按价格升序排列  当销量相等时不返回0 再继续比较单价
        Comparator<Products> byNumDes_price = new Comparator<Products>()
        {
            @Override
            public int compare(Products o1, Products o2)
            {
                if (o1.getNum() != o2.getNum())
                {
                    return -(o1.getNum() < o2.getNum() ? -1 : 1);
                }
                else
                {
                    return o1.getPrice() > o2.getPrice() ? 1 : o1.getPrice() < o2.getPrice() ? -1 : 0;
                }
            }
        };
        //不带参按默认重载的compareTo来排序
//        Collections.sort(products);
        Collections.sort(products, byPrice);
        for (Products product : products)
        {
            System.out.println(product);
        }
//        Collections.sort(products, byNum);
//        这句和上面那句等价Lambda表达式
//        Collections.sort(products, (o1, o2) -> {
//            return o1.getNum() < o2.getNum() ? -1 : o1.getNum() > o2.getNum() ? 1 : 0;
//        });
//        for (Products product : products)
//        {
//            System.out.println(product);
//        }
//        Collections.sort(products, byNumDes_price);
//        for (Products product : products)
//        {
//            System.out.println(product);
//        }
    }
}

class Products implements Comparable<Products>
{
    private String name;
    private int num;
    private Integer price;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNum()
    {
        return num;
    }


    public void setNum(int num)
    {
        this.num = num;
    }


    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }

    public Products(String name, int num, Integer price)
    {
        super();
        this.name = name;
        this.num = num;
        this.price = price;
    }


    @Override
    public String toString()
    {
        return "Products [name=" + name + ", num=" + num + ", price=" + price + "]\n";
    }


    public Products()
    {
        super();
    }


    @Override
    public int compareTo(Products o)
    {
        // 按价格升序排列
        //如果当前对象的价格小于参数对象的价格 返回-1
        //如果当前对象的价格等于。。。。。。返回0
        //如果当前对象的价格大于。。。。。。返回1
        return this.price < o.price ? -1 : this.price > o.price ? 1 : 0;
    }

}