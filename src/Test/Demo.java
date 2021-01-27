package Test;

import com.qfedu.dao.GoodsTypeDao;
import com.qfedu.dao.UserDao;
import com.qfedu.dao.impl.*;
import com.qfedu.entity.*;
import com.qfedu.until.BaseDao;

import java.sql.Connection;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
//        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
//        List<GoodsType> all = goodsTypeDao.getAll(1, 5);
//        System.out.println(all);
//        int dataCount = goodsTypeDao.getDataCount();
//        System.out.println(dataCount);
//        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
////        List<Goods> all = goodsDao.getAll(1, 6, "");
////        System.out.println(all);
////        int dataCount = goodsDao.getDataCount("");
////        System.out.println(dataCount);
        OrderDaoImpl orderDao = new OrderDaoImpl();
        List<Order> all = orderDao.getAll(1, 6, "");
        System.out.println(all);
        int dataCount = orderDao.getDataCount("");
        System.out.println(dataCount);
    }
}
