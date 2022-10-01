package com.alexdeww.rxscope

import com.alexdeww.rxscope.dispatcher.DefaultRxDispatcher
import com.alexdeww.rxscope.dispatcher.IoRxDispatcher
import com.alexdeww.rxscope.dispatcher.MainRxDispatcher
import com.alexdeww.rxscope.dispatcher.UnconfinedRxDispatcher

object RxDispatchers {

    @JvmStatic
    val main: RxDispatcher = MainRxDispatcher

    @JvmStatic
    val default: RxDispatcher = DefaultRxDispatcher

    @JvmStatic
    val IO: RxDispatcher = IoRxDispatcher

    @JvmStatic
    val unconfined: RxDispatcher = UnconfinedRxDispatcher

}
