package com.alexdeww.rxscope.viewmodel

import androidx.lifecycle.ViewModel
import com.alexdeww.rxscope.RxScope
import com.alexdeww.rxscope.RxScopes

@Suppress("unused")
inline val ViewModel.rxScope: RxScope
    get() = RxScopes.mainScope
