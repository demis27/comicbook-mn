package org.demis27.comicbook.paging.range;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RangeConverter {

    private static final Pattern pattern = Pattern.compile("resources[ ]*:[ ]*page[ ]*=[ ]*([0-9]*)[ ]*;[ ]*size[ ]*=[ ]*([0-9]*)");

    public static Range parse(String value) throws RequestedRangeUnsatisfiableException {
        Matcher matcher = pattern.matcher(value.trim());

        if (matcher.matches()) {
            return new Range(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        } else {
            throw new RequestedRangeUnsatisfiableException();
        }
    }
}
