package com.liuqidong.utillites;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.io.Files;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JoinerTest {
    private final List<String> stringList = Arrays.asList("Java","C","Python","Ruby","Javscript","C++");
    private final List<String> stringListWithNullValue = Arrays.asList("Java","C","Python","Ruby","Javscript",null);
    private final String targetFileName = ".\\test.txt";
    private final String targetFileNameToMap = ".\\testMap.txt";

    private final Map<String,String> stringMap = ImmutableMap.of("hello","guava","java","scala");

    @Test
    public void testJoinOnJoin(){
        String strList = Joiner.on("#").join(stringList);
        System.out.println(strList);
        assertThat(strList,equalTo("Java#C#Python#Ruby#Javscript#C++"));
    }

    @Test(expected=NullPointerException.class)
    public void testJoinOnJoinWithNullValue(){
        String strList = Joiner.on("#").join(stringListWithNullValue);
        System.out.println(strList);
        assertThat(strList,equalTo("Java#C#Python#Ruby#Javscript#null"));
    }

    @Test
    public void testJoinOnJoinWithNullValueButSkip(){
        String strList = Joiner.on("#").skipNulls().join(stringListWithNullValue);
        System.out.println(strList);
        assertThat(strList,equalTo("Java#C#Python#Ruby#Javscript"));
    }

    @Test
    public void testJoin_On_Join_WithNullValue_UseDefaultValue(){
        String strList = Joiner.on("#").useForNull("Default").join(stringListWithNullValue);
        System.out.println(strList);
        assertThat(strList,equalTo("Java#C#Python#Ruby#Javscript#Default"));
    }

    @Test
    public void testJoin_On_Append_To_StringBuilder(){

        try (FileWriter writer = new FileWriter(new File(targetFileName))){
            Joiner.on("#").useForNull("Default").appendTo(writer,stringListWithNullValue);
            assertThat(Files.isFile().test(new File(targetFileName)),equalTo(true));
        }catch (IOException e){
            fail("append to the writer occur fetal error.");
        }
//        final StringBuilder builder = new StringBuilder();
//        StringBuilder resultBuilder = Joiner.on("#").useForNull("Default").appendTo(builder,stringListWithNullValue);
//        assertThat(resultBuilder,sameInstance(builder));
//        assertThat(resultBuilder.toString(),equalTo("Java#C#Python#Ruby#Javscript#Default"));
    }

    /**
     * java8 join
     */
    @Test
    public void testJoinningByStreamSkipNullValues(){
        String result = stringListWithNullValue.stream().filter(item -> item != null && !item.isEmpty()).collect(Collectors.joining("#"));
        assertThat(result,equalTo("Java#C#Python#Ruby#Javscript"));
    }

    /**
     * java8 join
     */
    @Test
    public void testJoinningByStreamWithDefaultValue1(){
        String result = stringListWithNullValue.stream().map(item -> item == null || item.isEmpty() ? "Default" : item)
                    .filter(item -> item != null && !item.isEmpty()).collect(Collectors.joining("#"));
        assertThat(result,equalTo("Java#C#Python#Ruby#Javscript#Default"));
    }

    /**
     * java8 join
     */
    @Test
    public void testJoinningByStreamWithDefaultValue2(){
        String result = stringListWithNullValue.stream().map(this::defaultValue)
                .filter(item -> item != null && !item.isEmpty()).collect(Collectors.joining("#"));
        assertThat(result,equalTo("Java#C#Python#Ruby#Javscript#Default"));
    }

    private String defaultValue(final String item){
        return item == null || item.isEmpty() ? "Default" : item;
    }

    @Test
    public void testJoinOnWithMap(){
        String result = Joiner.on("#").withKeyValueSeparator("=").join(stringMap);
        assertThat(result,equalTo("hello=guava#java=scala"));
    }

    @Test
    public void testJoinOnWithMapToAppendable(){
        try (FileWriter writer = new FileWriter(new File(targetFileNameToMap))){
            Joiner.on("#").withKeyValueSeparator("=").appendTo(writer,stringMap);
            assertThat(Files.isFile().test(new File(targetFileName)),equalTo(true));
        }catch (IOException e){
            fail("append to the writer occur fetal error.");
        }
    }
}
