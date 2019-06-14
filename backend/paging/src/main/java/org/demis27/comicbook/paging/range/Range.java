package org.demis27.comicbook.paging.range;

import java.util.Objects;

public class Range {

    private int page;

    private int size;

    public Range(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return page == range.page &&
                size == range.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size);
    }
}
