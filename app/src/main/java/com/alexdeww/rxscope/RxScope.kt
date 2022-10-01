package com.alexdeww.rxscope

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlin.reflect.KClass

typealias RxLaunchBlock<R> = RxScope.() -> R

interface RxScope {

    val dispatcher: RxDispatcher

}

inline fun <reified R : Any> RxScope.launch(
    dispatcher: RxDispatcher? = null,
    noinline block: RxLaunchBlock<R>
): R = launch(R::class, dispatcher, block)

@Suppress("UNCHECKED_CAST")
@PublishedApi
internal fun <R : Any> RxScope.launch(
    clazz: KClass<R>,
    dispatcher: RxDispatcher?,
    block: RxLaunchBlock<R>
): R = with(dispatcher ?: this.dispatcher) {
    when (clazz) {
        Observable::class -> Observable
            .defer { block() as Observable<*> }
            .applyDispatcher() as R
        Maybe::class -> Maybe
            .defer { block() as Maybe<*> }
            .applyDispatcher() as R
        Single::class -> Single
            .defer { block() as Single<*> }
            .applyDispatcher() as R
        Completable::class -> Completable
            .defer { block() as Completable }
            .applyDispatcher() as R
        else -> block()
    }
}
