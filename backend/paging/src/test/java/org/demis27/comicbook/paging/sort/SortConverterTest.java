package org.demis27.comicbook.paging.sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortConverterTest {

    @Test
    public void sortAscendantParameterParsing() {
        List<Sort> sorts = SortConverter.parse("attribute");
        assertNotNull(sorts);
        assertEquals(sorts.size(), 1);
        Sort sort = sorts.get(0);
        assertNotNull(sort);
        assertEquals(sort.getProperty(), "attribute");
        assertEquals(sort.isAscending(), true);
    }

    @Test
    public void sortDescendantParameterParsing() {
        List<Sort> sorts = SortConverter.parse("-attribute");
        assertNotNull(sorts);
        assertEquals(sorts.size(), 1);
        Sort sort = sorts.get(0);
        assertNotNull(sort);
        assertEquals(sort.getProperty(), "attribute");
        assertEquals(sort.isAscending(), false);
    }

    @Test
    public void sortParametersParsing() {
        List<Sort> sorts = SortConverter.parse("-attribute1|attribute2");
        assertNotNull(sorts);
        assertEquals(sorts.size(), 2);

        Sort sort = sorts.get(0);
        assertNotNull(sort);
        assertEquals(sort.getProperty(), "attribute1");
        assertEquals(sort.isAscending(), false);

        sort = sorts.get(1);
        assertNotNull(sort);
        assertEquals(sort.getProperty(), "attribute2");
        assertEquals(sort.isAscending(), true);
    }

    @Test
    public void sortEmptyParameterParsing() {
        List<Sort> sorts = SortConverter.parse("-attribute1||attribute2");
        assertNotNull(sorts);
        assertEquals(sorts.size(), 2);

        Sort sort = sorts.get(0);
        assertNotNull(sort);
        assertEquals(sort.getProperty(), "attribute1");
        assertEquals(sort.isAscending(), false);

        sort = sorts.get(1);
        assertNotNull(sort);
        assertEquals(sort.getProperty(), "attribute2");
        assertEquals(sort.isAscending(), true);
    }

    @Test
    public void sortEmptyParameterFirstParsing() {
        List<Sort> sorts = SortConverter.parse("|-attribute1||attribute2|");
        assertNotNull(sorts);
        assertEquals(sorts.size(), 2);

        Sort sort = sorts.get(0);
        assertNotNull(sort);
        assertEquals(sort.getProperty(), "attribute1");
        assertEquals(sort.isAscending(), false);

        sort = sorts.get(1);
        assertNotNull(sort);
        assertEquals(sort.getProperty(), "attribute2");
        assertEquals(sort.isAscending(), true);
    }

    @Test
    public void sortParametersWithSpaceParsing() {
        List<Sort> sorts = SortConverter.parse(" - attribute1 | attribute2 ");
        assertNotNull(sorts);
        assertEquals(sorts.size(), 2);

        Sort sort = sorts.get(0);
        assertNotNull(sort);
        assertEquals(sort.getProperty(), "attribute1");
        assertEquals(sort.isAscending(), false);

        sort = sorts.get(1);
        assertNotNull(sort);
        assertEquals(sort.getProperty(), "attribute2");
        assertEquals(sort.isAscending(), true);
    }
}