package search_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 2.(选做)需求：请输入你想要查看的日期：（提示：请按照例如：）1990-2-5的格式）1990-2-5
 * 日	一	二	三	四	五	六
 * 				    1	2	3
 * 4	5*	6	7	8	9	10
 * 11	12	13	14	15	16	17
 * 18	19	20	21	22	23	24
 * 25	26	27	28
 *
 * */
public class SearchDateTest {
    public static void main(String[] args) {
        String dateFormatPattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatPattern);

        Scanner input = new Scanner(System.in);
        System.out.println("请按照形如“1990-2-5”的格式输入");
        Date searchDate = null;
        try {
            searchDate = sdf.parse(input.next());
        } catch (ParseException e) {
            System.out.println("日期格式有误！");
            e.printStackTrace();
        }

        outputFormatCalendar(searchDate);
    }

    public static void outputFormatCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //记录指定日期当前月的第几日
        int targetDay = calendar.get(Calendar.DAY_OF_MONTH);

        //将日期的日设置为当前月份的第一日
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        //获取当前月份的总天数
        // getActualMaximum 方法给定此 Calendar 的时间值，返回指定日历字段可能拥有的最大值。
        int totalDayInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("日\t一\t二\t三\t四\t五\t六");
        //先用 \t 格式化填充当前月历
        for (int i = 0; i < calendar.get(Calendar.DAY_OF_WEEK)-1; i++)
            System.out.print("\t");

        //输出当前月份的有效天数
        for (int i = 1; i < totalDayInMonth; i++) {
            System.out.print(calendar.get(Calendar.DAY_OF_MONTH));
            //标记原先指定的日期
            if (calendar.get(Calendar.DAY_OF_MONTH)==targetDay)
                System.out.print("*");
            System.out.print("\t");

            //每周换一次行
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if ((calendar.get(Calendar.DAY_OF_WEEK)-1)%7==0)
                System.out.println();
        }

    }
}
