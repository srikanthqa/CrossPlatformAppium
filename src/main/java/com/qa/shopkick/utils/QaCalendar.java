package com.qa.shopkick.utils;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mmadhusoodan on 10/22/15.
 */
public class QaCalendar {
    public static Logger log = Logger.getLogger(QaCalendar.class);

    private static SimpleDateFormat mmddFormat = new SimpleDateFormat("MM-dd");
    private static SimpleDateFormat mmddyyyyyHHMMFormat = new SimpleDateFormat("MM-dd-hh:mm");
    private static SimpleDateFormat hyphenDateFormat = new SimpleDateFormat("MM-dd-yyyy");
    private static SimpleDateFormat slashDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private static SimpleDateFormat mmddhhmm = new SimpleDateFormat("MM/dd_hh:mm");
    private static Calendar calendar = Calendar.getInstance();
    private static QaCalendar instance;

    public QaCalendar() {
    }

    public static synchronized QaCalendar getInstance() {

        if (instance == null) {
            instance = new QaCalendar();
        }

        return instance;
    }

    public static String getHumanReadableDateFromEpoch(long epochSec) {
        Date date = new Date(epochSec);

        return mmddyyyyyHHMMFormat.format(date);
    }

    public static String getSlashDateFromHyphenDate(String hyphenDate) {

        try {
            Date frmDate = hyphenDateFormat.parse(hyphenDate); // Handle the ParseException here
            String slashDateStr = slashDateFormat.format(frmDate);
            log.info(slashDateStr);
            return slashDateStr;

        } catch (Exception e) {
            log.error(e);
            return "";
        }


    }

    public String getCaptureTime() {

        final String captureDate = mmddyyyyyHHMMFormat.format(calendar.getTime());
        return captureDate;
    }

    public String getCurrentDateTime() {

        final String captureDate = mmddyyyyyHHMMFormat.format(calendar.getTime());
        return captureDate;
    }

    public String getCurrentDate() {

        final String captureDate = mmddFormat.format(calendar.getTime());
        return captureDate;
    }

    public String getDateTime() {

        final String captureDate = mmddhhmm.format(calendar.getTime());
        return captureDate;
    }

    public String getHHMMSSFromSeconds(int nSecondTime) {
        return LocalTime.MIN.plusSeconds(nSecondTime).toString();
    }
}
