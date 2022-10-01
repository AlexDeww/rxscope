package com.alexdeww.rxscope.dispatcher

import com.alexdeww.rxscope.RxDispatcher
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

internal object MainRxDispatcher : RxDispatcher {

    override fun <R : Any> Observable<R>.applyDispatcher(): Observable<R> = this
        .subscribeOn(DefaultRxDispatcher.executionScheduler)
        .observeOn(AndroidSchedulers.mainThread())

    override fun <R : Any> Maybe<R>.applyDispatcher(): Maybe<R> = this
        .subscribeOn(DefaultRxDispatcher.executionScheduler)
        .observeOn(AndroidSchedulers.mainThread())

    override fun <R : Any> Single<R>.applyDispatcher(): Single<R> = this
        .subscribeOn(DefaultRxDispatcher.executionScheduler)
        .observeOn(AndroidSchedulers.mainThread())

    override fun Completable.applyDispatcher(): Completable = this
        .subscribeOn(DefaultRxDispatcher.executionScheduler)
        .observeOn(AndroidSchedulers.mainThread())

}
