package com.bf.java8.compare;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @description:
 * @author: bofei
 * @date: 2020-07-02 16:52
 **/
public class Main {

    @Test
    public void
    givenInstanceMethod_whenSortingEntitiesByName_thenCorrectlySorted() {

        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        Collections.sort(
                humans, Comparator.comparing(Human::getName));
        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    /// 静态方法
    @Test
    public void
    givenMethodDefinition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {

        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        humans.sort(Human::compareByNameThenAge);
        Assert.assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }


    // 不定义类型
    //  Basic Sorting With No Type Definitions
    @Test
    public void givenLambdaShortForm_whenSortingEntitiesByName_thenCorrectlySorted() {

        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }


    // lambda
    // 引入lambda， 可以避开匿名内部类
    // With the introduction of Lambdas, we can now bypass the anonymous inner class and achieve the same result with simple, functional semantics:
    @Test
    public void whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        Comparator<Human> comparator = (final Human h1, final Human h2) -> h1.getName().compareTo(h2.getName());

        humans.sort(comparator);

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    // 非 lambda
    // Before Java 8, sorting a collection would involve creating an anonymous inner class for the Comparator used in the sort:
    @Test
    public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        Comparator<Human> comparator = new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        };

        Collections.sort(humans, comparator);
        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));

        humans.sort(comparator);
    }
}
