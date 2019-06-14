package org.demis27.comicbook.paging.range;

public class RangeException extends Exception {

    private final String reason;

    public RangeException(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
