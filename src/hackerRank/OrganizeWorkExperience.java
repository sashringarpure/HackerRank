package hackerRank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrganizeWorkExperience {

    public static void main(String[] args) {
        String[][] wkEx = { {"2012-02-23","2013-04-05"},
        {"2013-03-04","2014-01-01"},
        {"2014-06-05","2018-03-03"} };
        /*
        String[][] wkEx = { {"2014-03-21","2014-05-05"},
                //{"2014-05-05","2014-10-01"},
                //{"2012-06-05","2013-03-03"},
                //{"2012-12-01","2013-12-01"},
                {"2011-03-23","2012-07-10"}
                };
         */
        SortedSet<Date> start = new TreeSet<Date>();
        SortedSet<Date> end = new TreeSet<Date>();
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> x = new ArrayList<>();

        try {
            for (String[] s : wkEx) {
                start.add(new SimpleDateFormat("yyyy-MM-dd").parse(s[0]));
                end.add(new SimpleDateFormat("yyyy-MM-dd").parse(s[1]));
            }
        } catch(ParseException e) {
          e.printStackTrace();
        }
        Iterator<Date> startItr = start.iterator();
        Iterator<Date> endItr = end.iterator();

        Date fromDate = new Date();
        Date endDate = new Date();

        while ( startItr.hasNext() ) {
            fromDate = startItr.next();
            endDate = endItr.next();
            x.add(fromDate.toString());
            break;
        }

        while ( startItr.hasNext() ) {
            fromDate = startItr.next();
            while ( ! fromDate.after(endDate) && (startItr.hasNext() || endItr.hasNext() ) ) {
                if (endItr.hasNext())
                    endDate = endItr.next();
                if ( startItr.hasNext())
                    fromDate = startItr.next();
            }
            x.add(endDate.toString());
           if ( endItr.hasNext()) {
               endDate = endItr.next();
               x.add(fromDate.toString());
           }
        }
        if ( ( x.size() % 2 ) != 0 ) {
            x.add(endDate.toString());
        }
        result.add(x);
        System.out.println(result);
    }
}

