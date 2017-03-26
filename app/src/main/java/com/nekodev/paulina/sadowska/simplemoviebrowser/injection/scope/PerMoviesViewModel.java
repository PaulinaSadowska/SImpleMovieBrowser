package com.nekodev.paulina.sadowska.simplemoviebrowser.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerMoviesViewModel {
}