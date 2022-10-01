package com.alexdeww.rxscope

import com.alexdeww.rxscope.scope.MainRxScope

object RxScopes {

    private var mainScopeInternal: RxScope = MainRxScope

    @JvmStatic
    val mainScope: RxScope
        get() = mainScopeInternal

    @JvmStatic
    fun setMainScope(scope: RxScope) {
        mainScopeInternal = scope
    }

    @JvmStatic
    fun resetMainScope() {
        mainScopeInternal = MainRxScope
    }

}
