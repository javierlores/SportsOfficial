package example.example.com.data.entities;

import java.util.Calendar;

public class Date {
    private static final String[] MONTH_ABREV = {
            "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final int[] MONTH_DAYS = {
            31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    private int mYear;
    private int mMonth;
    private int mDay;

    public Date() {

    }

    public int getYear() {
        return mYear;
    }

    public int getMonth() {
        return mMonth;
    }

    public int getDay() {
        return mDay;
    }

    public void setYear(int year) {
        Calendar calendar = Calendar.getInstance();

        if (year >= calendar.get(Calendar.YEAR) && year < 3000) {
            mYear = year;
        }
    }

    public void setMonth(int month) {
        if (month > 1 && month < 13) {
            mMonth = month;
        }

        if (mDay > MONTH_DAYS[mMonth - 1]) {
            mDay = MONTH_DAYS[mMonth - 1];
        }
    }

    public void setDay(int day) {
        if (day > 0 && day < MONTH_DAYS[mMonth]) {
            mDay = day;
        }
    }

    @Override
    public String toString() {
        Calendar calendar = Calendar.getInstance();

        if (mYear > calendar.get(Calendar.YEAR)) {
            return MONTH_ABREV[mMonth - 1] + ", " + mDay + ", " + mYear;
        }
        else {
            return MONTH_ABREV[mMonth - 1] + ", " + mDay;
        }
    }
}
