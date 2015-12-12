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

import rx.functions.Action0;
import rx.functions.Action1;

public final class RxActions {
    public RxActions() {
    }

    public static <T> Action1<T> act(final Action1<T> action1, final Action1<T> action2) {
        return new Action1<T>() {
            @Override
            public void call(T t) {
                action1.call(t);
                action2.call(t);
            }
        };
    }

    public static <T> Action1<T> act(final Action1<T> action1, final Action1<T> action2,
            final Action1<T> action3) {
        return new Action1<T>() {
            @Override
            public void call(T t) {
                action1.call(t);
                action2.call(t);
                action3.call(t);
            }
        };
    }

    public static <T> Action1<T> act(final Action1<T> action1, final Action1<T> action2,
            final Action1<T> action3, final Action1<T> action4) {
        return new Action1<T>() {
            @Override
            public void call(T t) {
                action1.call(t);
                action2.call(t);
                action3.call(t);
                action4.call(t);
            }
        };
    }

    public static <T> Action1<T> act(final Action1<T> action1, final Action1<T> action2,
            final Action1<T> action3, final Action1<T> action4, final Action1<T> action5) {
        return new Action1<T>() {
            @Override
            public void call(T t) {
                action1.call(t);
                action2.call(t);
                action3.call(t);
                action4.call(t);
                action5.call(t);
            }
        };
    }

    public static <T> Action1<T> act(final Action1<T>... actions) {
        return new Action1<T>() {
            @Override
            public void call(T t) {
                for (Action1<T> action : actions) {
                    action.call(t);
                }
            }
        };
    }

    public static Action0 act(final Action0 action1, final Action0 action2) {
        return new Action0() {
            @Override
            public void call() {
                action1.call();
                action2.call();
            }
        };
    }

    public static Action0 act(final Action0 action1, final Action0 action2, final Action0 action3) {
        return new Action0() {
            @Override
            public void call() {
                action1.call();
                action2.call();
                action3.call();
            }
        };
    }

    public static Action0 act(final Action0 action1, final Action0 action2, final Action0 action3,
            final Action0 action4) {
        return new Action0() {
            @Override
            public void call() {
                action1.call();
                action2.call();
                action3.call();
                action4.call();
            }
        };
    }

    public static Action0 act(final Action0 action1, final Action0 action2, final Action0 action3,
            final Action0 action4, final Action0 action5) {
        return new Action0() {
            @Override
            public void call() {
                action1.call();
                action2.call();
                action3.call();
                action4.call();
                action5.call();
            }
        };
    }

    public static Action0 act(final Action0... actions) {
        return new Action0() {
            @Override
            public void call() {
                for (Action0 action : actions) {
                    action.call();
                }
            }
        };
    }
}
