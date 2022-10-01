package com.alexdeww.rxscope.dispatcher

import com.alexdeww.rxscope.RxDispatcher
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

private const val THREAD_CORE_POOL_SIZE = 3
private const val THREAD_MAX_POOL_SIZE = 5
private const val THREAD_KEEP_ALIVE_TIME = 10L // Seconds

internal object DefaultRxDispatcher : RxDispatcher {

    private val threadPoolExecutor: ThreadPoolExecutor by lazy {
        ThreadPoolExecutor(
            THREAD_CORE_POOL_SIZE,
            THREAD_MAX_POOL_SIZE,
            THREAD_KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            LinkedBlockingQueue(),
            JobThreadFactory()
        )
    }
    internal val executionScheduler: Scheduler by lazy { Schedulers.from(threadPoolExecutor) }

    override fun <R : Any> Observable<R>.applyDispatcher(): Observable<R> = this
        .subscribeOn(executionScheduler)

    override fun <R : Any> Maybe<R>.applyDispatcher(): Maybe<R> = this
        .subscribeOn(executionScheduler)

    override fun <R : Any> Single<R>.applyDispatcher(): Single<R> = this
        .subscribeOn(executionScheduler)

    override fun Completable.applyDispatcher(): Completable = this
        .subscribeOn(executionScheduler)

    private class JobThreadFactory : ThreadFactory {
        private val counter = AtomicInteger(0)
        override fun newThread(runnable: Runnable): Thread = Thread(
            runnable,
            "${DefaultRxDispatcher::class.java.simpleName}_${counter.incrementAndGet()}"
        )
    }

}
