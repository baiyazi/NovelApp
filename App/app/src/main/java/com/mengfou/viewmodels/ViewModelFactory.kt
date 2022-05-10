package com.mengfou.viewmodels

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mengfou.ui.home.HomeListFragment
import kotlin.reflect.KProperty

/**
 * @author 梦否 on 2022/5/9
 * @blog https://mengfou.blog.csdn.net/
 */

//inline fun <reified T> getGenericType() = T::class.java

class ViewModelFactory<T:ViewModel>(owner: ViewModelStoreOwner, private val clazz: Class<T>) {

    private var _value: T? = null

    init {
        _value = ViewModelProvider(owner, ViewModelProvider.NewInstanceFactory())
            .get(clazz)
    }

    operator fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return _value ?: throw IllegalStateException("$clazz 获取实例失败！")
    }

    operator fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
        _value = value
    }
}

