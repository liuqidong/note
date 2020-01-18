package com.liuqidong.utilities;

import com.google.common.base.Preconditions;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;



/**
 * @author liuqidong
 * @version 1.0.0
 * @ClassName PreconditionsTest.java
 * @Description TODO
 * @createTime 2020年01月19日 13:00:00
 */
public class PreconditionsTest {

    @Test(expected = NullPointerException.class)
    public void testCheckNotNull(){
        checkNotNull(null);
    }

    @Test(expected = NullPointerException.class)
    public void testCheckNotNullWithMessage(){
        try {
            checkNotNullWithMessage(null);
        }catch (NullPointerException e){
            assertThat(e,is(NullPointerException.class));
            assertThat(e.getMessage(),equalTo("The list should not be null"));
            throw e;
        }
    }


    private void checkNotNull(final List<String> list){
        Preconditions.checkNotNull(list);
    }

    private void checkNotNullWithMessage(final List<String> list){
        Preconditions.checkNotNull(list,"The list should not be null");
    }
}
