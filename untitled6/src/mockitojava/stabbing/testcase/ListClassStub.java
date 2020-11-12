package mockitojava.stabbing.testcase;

//ListClassStub


import mockitojava.stabbing.logic.ListClass;
import mockitojava.stabbing.logic.ListService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListClassStub {
    static int counter = 0;

    @BeforeAll
    public static void setUp1() {
        counter = 1;
        System.out.println("Counter= " + counter);

    }

    @BeforeAll
    public static void setUp2() {
        counter = 2;
        System.out.println("Counter= " + counter);

    }

    @Test
    public void test() {
        ListService listServicestub = new ListServiceStub();

        ListClass list = new ListClass(listServicestub);

        List<String> retrievedList = list.getListMethod("Spring");
        System.out.println(retrievedList);
        System.out.println("Stub is working......");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("afterAll Method Counter value is" + counter);
    }

}
