package com.alexdeww.rxscope

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface RxDispatcher {

    fun <R : Any> Observable<R>.applyDispatcher(): Observable<R>

    fun <R : Any> Maybe<R>.applyDispatcher(): Maybe<R>

    fun <R : Any> Single<R>.applyDispatcher(): Single<R>

    fun Completable.applyDispatcher(): Completable

}
