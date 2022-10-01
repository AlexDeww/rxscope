package com.alexdeww.rxscope.dispatcher

import com.alexdeww.rxscope.RxDispatcher
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

internal object UnconfinedRxDispatcher : RxDispatcher {

    override fun <R : Any> Observable<R>.applyDispatcher(): Observable<R> = this

    override fun <R : Any> Maybe<R>.applyDispatcher(): Maybe<R> = this

    override fun <R : Any> Single<R>.applyDispatcher(): Single<R> = this

    override fun Completable.applyDispatcher(): Completable = this

}
