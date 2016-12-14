package com.filters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ValidationTest {

    ValidationFilter validationFilter;

    @Before
    public void before() {
        validationFilter = new ValidationFilter();
    }

    @Test
    public void ageCheck() throws IOException {
        assertThat(validationFilter.validationAge(""), is(false));
        assertThat(validationFilter.validationAge("q"), is(false));

        assertThat(validationFilter.validationAge("-1"), is(false));
        assertThat(validationFilter.validationAge("0"), is(false));

        assertThat(validationFilter.validationAge("1"), is(true));
        assertThat(validationFilter.validationAge("10"), is(true));
        assertThat(validationFilter.validationAge("99"), is(true));

        assertThat(validationFilter.validationAge("100"), is(false));
    }

    @Test
    public void emailCheck() throws IOException {
        assertThat(validationFilter.validationEmail(""), is(false));
        assertThat(validationFilter.validationEmail("asd@asd"), is(false));
        assertThat(validationFilter.validationEmail("@asd.net"), is(false));
        assertThat(validationFilter.validationEmail("asd@asd.ua"), is(false));
        assertThat(validationFilter.validationEmail("asd@net"), is(false));

        assertThat(validationFilter.validationEmail("asd@a.org"), is(true));
        assertThat(validationFilter.validationEmail("asd@b.net"), is(true));
        assertThat(validationFilter.validationEmail("asd@c.com"), is(true));
    }

}
