package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AvailableAppointment {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate(String DATE) {
        return date;
    }

    public String getDate() {
        return format.format(date);
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

    private Date date;
    private String time;
    // la clase simpledateformat nos ayuda a trabjar y formatear fechas
    SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");

    public  AvailableAppointment(String date, String time) {
        try {
            this.date = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.time = time;
    }



}
