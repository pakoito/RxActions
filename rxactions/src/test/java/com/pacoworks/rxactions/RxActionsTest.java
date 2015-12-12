/*
 * Copyright (c) pakoito 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxactions;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class RxActionsTest {
    private int[] sum;

    private ArrayList<Throwable> arrayError;

    @Before
    public void setUp() throws Exception {
        sum = new int[] {
            0
        };
        arrayError = new ArrayList<Throwable>();
    }

    @Test
    public void testWarmup() throws Exception {
        Observable
                .just(1)
                .doOnNext(RxActions.act(doAction(sum), doAction(sum), doAction(sum)))
                .subscribe(
                        RxActions.act(doAction(sum), doAction(sum)),
                        RxActions.act(doError(arrayError), doError(arrayError),
                                doError(arrayError), doError(arrayError), doError(arrayError),
                                doError(arrayError)),
                        RxActions.act(doComplete(sum), doComplete(sum), doComplete(sum),
                                doComplete(sum)));
        Assert.assertEquals(9, sum[0]);
        Assert.assertEquals(6, arrayError.size());
    }

    private Action0 doComplete(final int[] sum) {
        return new Action0() {
            @Override
            public void call() {
                sum[0] += 1;
            }
        };
    }

    private Action1<Integer> doAction(final int[] sum) {
        return new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                sum[0] += 1;
            }
        };
    }

    private Action1<Throwable> doError(final ArrayList<Throwable> arrayError) {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                arrayError.add(throwable);
            }
        };
    }
}
