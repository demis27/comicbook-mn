package org.demis27.comicbook.paging.range;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeConverterTest {

    @Test
    public void rangeParsing() throws Exception {
        assertEquals(new Range(0,10), RangeConverter.parse("resources: page=0; size=10"));
        assertEquals(new Range(0,10), RangeConverter.parse("resources:page=0; size=10"));
        assertEquals(new Range(0,10), RangeConverter.parse("resources:page=0;size=10"));
        assertEquals(new Range(0,10), RangeConverter.parse("resources : page = 0 ; size = 10 "));
    }

}