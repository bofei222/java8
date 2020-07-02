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
    public void whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        Comparator<Human> comparator = (final Human h1, final Human h2) -> h1.getName().compareTo(h2.getName());

        humans.sort(comparator);

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

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
