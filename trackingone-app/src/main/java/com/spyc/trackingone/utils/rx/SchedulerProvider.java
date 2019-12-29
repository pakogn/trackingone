package com.spyc.trackingone.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Jorge Namitle on 18/03/2018.
 */

public interface SchedulerProvider {
    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
