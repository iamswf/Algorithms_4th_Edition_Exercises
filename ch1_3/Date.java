import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;

public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    public Date(String date) {
        String[] s = date.split("\\/");
        if (s.length != 3) {
            throw new IllegalArgumentException("Argument illegal: " + date);
        }
        month = Integer.parseInt(s[0]);
        day = Integer.parseInt(s[1]);
        year = Integer.parseInt(s[2]);
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Date that = (Date) x;
        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        if (this.year != that.year) return false;
        return true;
    }

    public static Date[] readDates(String s) {
        In in = new In(s);
        Queue<Date> q = new Queue<Date>();
        while (!in.isEmpty()) {
            q.enqueue(new Date(in.readString())); // in.readString()格式为 9/24/2016
        }
        int N = q.size();
        Date[] result = new Date[N];
        for (int i = 0; i < N; i++) {
            result[i] = q.dequeue();
        }
        return result;
    }

    // 测试用例
    public static void main(String[] args) {
        Date date1 = new Date("9/24/2016");
        Date date2 = new Date(8, 24, 2016);
        if (date1.equals(date2)) {
            StdOut.println("equal!");
        }
        else {
            StdOut.println("uequal!");
            StdOut.println(date1);
            StdOut.println(date2);
        }
    }

}