package com.spyc.trackingone.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Jorge Namitle on 25/03/2018.
 */


@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerService {
}


