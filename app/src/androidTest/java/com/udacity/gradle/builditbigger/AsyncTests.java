package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;

/**
 * Created by sklaiber on 18.10.15.
 */
public class AsyncTests extends AndroidTestCase {

    public void testAsync() {
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
