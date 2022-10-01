package com.alexdeww.rxscope.fragment

import androidx.fragment.app.Fragment
import com.alexdeww.rxscope.RxScope
import com.alexdeww.rxscope.RxScopes

@Suppress("unused")
inline val Fragment.rxScope: RxScope
    get() = RxScopes.mainScope
