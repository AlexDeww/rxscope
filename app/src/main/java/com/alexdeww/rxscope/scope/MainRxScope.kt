package com.alexdeww.rxscope.scope

import com.alexdeww.rxscope.RxDispatcher
import com.alexdeww.rxscope.RxDispatchers
import com.alexdeww.rxscope.RxScope

internal object MainRxScope : RxScope {
    override val dispatcher: RxDispatcher = RxDispatchers.main
}
