package com.study.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void letsMockListSizeMethod(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    public void letsMockListSize_ReturnMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }


    @Test
    public void letsMockListGet(){
        List listMock = mock(List.class);
        // Argument Matcher
        when(listMock.get(0)).thenReturn("in28Minutes");

        assertEquals("in28Minutes", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void letsMockListGet_usingArgumentMatcher(){
        List listMock = mock(List.class);
        // Argument Matcher
        when(listMock.get(anyInt())).thenReturn("in28Minutes");

        assertEquals("in28Minutes", listMock.get(0));
        assertEquals("in28Minutes", listMock.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_throwAnException(){
        List listMock = mock(List.class);
        // Argument Matcher
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

        listMock.get(0);
    }

}
