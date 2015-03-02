import com.sun.istack.internal.NotNull;

import java.util.Calendar;

public class MyCalendarPrinter {

    private Integer year;
    private Integer month;

    private int[][] calendarMatrix = new int[6][7];
    private int startDay;
    private int lastDate;

    public MyCalendarPrinter(Integer year, Integer month) {
        this.year = year;
        this.month = month;
    }

    public void prepareFields(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        // 月の初めの曜日を求めます。
        calendar.set(year, month - 1, 1);
        startDay = calendar.get(Calendar.DAY_OF_WEEK);
        // 月末の日付を求めます。
//        あえて使いません
//        calendar.add(Calendar.MONTH, 1);
//        calendar.add(Calendar.DATE, -1);
//        lastDate = calendar.get(Calendar.DATE);
        // TODO: getLastDay を使う
        lastDate = 31;
        // カレンダー表を作成します。
        int row = 0;
        int column = startDay - 1;
        for (int date = 1; date <= lastDate; date++) {
            calendarMatrix[row][column] = date;
            if (column == 6) {
                row++;
                column = 0;
            } else {
                column++;
            }
        }
    }

    public String getTitle() {
        // TODO: create method
        return year + "年 " + month + "月\n";
    }

    public String getYearTitle() {
        // TODO: create method
        // toStringAllMonthの時だけ使う
        return "[calendar]";
    }

    @Override
    public String toString() {
        return this.toString(this.year, this.month);
    }

    public String toString(int month) {
        return this.toString(this.year, month);
    }

    public String toString(int year, int month) {
        prepareFields(year, month);
        StringBuffer sb = new StringBuffer();
        // TODO: insert title here
        sb.append(this.getTitle());
        loop: for (int i = 0; i < calendarMatrix.length; i++) {
            for (int j = 0; j < calendarMatrix[i].length; j++) {
                int day = calendarMatrix[i][j];
                if (day == 0) {
                    if (i != 0) {
                        // カレンダー表内の月末以降のセルに到達
                        break loop;
                    }
                    sb.append("   ");
                    continue;
                }
                sb.append(String.format(" %2d", day));
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public String toStringAllMonth() {
        // TODO: create method
        StringBuffer sb = new StringBuffer();
        sb.append(this.getYearTitle());
        sb.append("\r\n");
        return "[hoge年]";
    }

    public static Integer calcLastDate(Integer year, Integer month) {
        // TODO: create method
        return 31;
    }

    public static boolean isUru(Integer year) {
        // TODO: create method
        return true;
    }
}
