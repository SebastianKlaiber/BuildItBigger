package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    CountDownLatch signal = null;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testTask() {
        String result = null;

        EndpointsAsyncTask task = new EndpointsAsyncTask(getContext(), null);
        task.execute();

        try {
            result = task.get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Time out");
        }

        assertNotNull(result);
    }

}