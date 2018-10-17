package com.raywenderlich.markme.feature

import com.raywenderlich.markme.model.Student

interface FeatureContract {
    interface View {
        fun showToastMessage(msg: String)
    }

    interface Presenter<T> {
        // User Actions
        fun onViewDestroyed()
        fun onSave2PrefsClick(data: List<T>?)
        fun onSave2DbClick(data: List<T>?)
    }

    interface Model<T> {
        fun add2Db(items: List<T>)
        fun add2Prefs(items: List<T>)
        fun query(vararg params: String): List<T>
    }
}