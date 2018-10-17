package com.raywenderlich.markme.feature.presenter

import com.raywenderlich.markme.feature.FeatureContract
import com.raywenderlich.markme.model.Student
import com.raywenderlich.markme.repository.AppRepository

class FeaturePresenter(private var view: FeatureContract.View?) : FeatureContract.Presenter<Student> {

    private val repository: FeatureContract.Model<Student> by lazy { AppRepository }

    override fun onSave2PrefsClick(data: List<Student>?) {
        data?.let {
            repository.add2Prefs(items = data)
        }
    }

    override fun onSave2DbClick(data: List<Student>?) {
        data?.let {
            repository.add2Db(items = data)
        }
    }

    override fun onViewDestroyed() {
        view = null
    }
}
