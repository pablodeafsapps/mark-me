package com.raywenderlich.markme.repository

import com.raywenderlich.markme.feature.FeatureContract
import com.raywenderlich.markme.model.Student

object AppRepository : FeatureContract.Model<Student> {

    override fun add2Db(items: List<Student>) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add2Prefs(items: List<Student>) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun query(vararg params: String): List<Student> {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return listOf()
    }
}