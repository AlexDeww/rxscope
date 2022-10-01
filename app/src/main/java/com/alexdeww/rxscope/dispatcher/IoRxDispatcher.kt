package com.alexdeww.rxscope.dispatcher

import com.alexdeww.rxscope.RxDispatcher
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

internal object IoRxDispatcher : RxDispatcher {

    override fun <R : Any> Observable<R>.applyDispatcher(): Observable<R> = this
        .subscribeOn(Schedulers.io())

    override fun <R : Any> Maybe<R>.applyDispatcher(): Maybe<R> = this
        .subscribeOn(Schedulers.io())

    override fun <R : Any> Single<R>.applyDispatcher(): Single<R> = this
        .subscribeOn(Schedulers.io())

    override fun Completable.applyDispatcher(): Completable = this
        .subscribeOn(Schedulers.io())

}
