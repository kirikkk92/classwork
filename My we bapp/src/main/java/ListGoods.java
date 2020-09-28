import java.util.ArrayList;

public class ListGoods {
    static ArrayList<Good> goods = new ArrayList<>();

    public static ArrayList<Good> createListGoods() {
        goods.add(new Good("Mobile Phone",1000));
        goods.add(new Good("laptop",5000));
        goods.add(new Good("Tablet PC",3000));
        return goods;
    }
}
