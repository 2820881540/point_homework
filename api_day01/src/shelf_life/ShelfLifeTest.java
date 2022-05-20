package shelf_life;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 1.需求：生产日期 :2020-07-21；保质期为：48天；保质期到期时间的前1个周的周四，是促销日
 *
 * */
public class ShelfLifeTest {
    public static void main(String[] args) {
        //生产日期
        int produceYear = 2020;
        int produceMonth = 7;
        int produceDate = 21;
        //保质期（天）
        int shelfLife = 48;
        //促销时间（星期几）
        int saleDayOfWeek = 4;
        //指定日期输出格式
        String dateFormatPattern = "yyyy年MM月dd日";

        getGoodsDates(produceYear, produceMonth, produceDate, shelfLife, saleDayOfWeek, dateFormatPattern);


    }

    public static void getGoodsDates(int produceYear, int produceMonth, int produceDate, int shelfLife, int saleDayOfWeek, String dateFormatPattern) {

        Calendar goodsCalendar = Calendar.getInstance();

        //设置生产日期（月份从 0 开始计）
        goodsCalendar.set(produceYear, produceMonth-1, produceDate);
        //格式化输出生产日期
        System.out.println("生产日期："+getFormatDate(goodsCalendar, dateFormatPattern));

        //设置过期时间
        goodsCalendar.add(Calendar.DAY_OF_MONTH, shelfLife);
        //格式化输出过期时间
        System.out.println("过期时间："+getFormatDate(goodsCalendar, dateFormatPattern));

        //设置促销日期
        goodsCalendar.add(Calendar.WEEK_OF_MONTH, -1);
        goodsCalendar.set(Calendar.DAY_OF_WEEK, saleDayOfWeek+1);//要求星期天数从星期一开始计
        //格式化输出促销日期
        System.out.println("促销日期："+getFormatDate(goodsCalendar, dateFormatPattern));
    }

    //格式化输出日期
    public static String getFormatDate(Calendar calendar, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(calendar.getTime());
    }
}
