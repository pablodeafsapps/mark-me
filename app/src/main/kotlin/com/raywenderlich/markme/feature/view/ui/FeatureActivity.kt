package com.raywenderlich.markme.feature.view.ui

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.raywenderlich.markme.R
import com.raywenderlich.markme.feature.FeatureContract
import com.raywenderlich.markme.feature.presenter.FeaturePresenter
import com.raywenderlich.markme.feature.view.adapter.FeatureAttendanceAdapter
import com.raywenderlich.markme.feature.view.adapter.FeatureGradingAdapter
import com.raywenderlich.markme.feature.view.adapter.RwAdapter
import com.raywenderlich.markme.main.view.ui.FEATURE_CATEGORY
import com.raywenderlich.markme.model.Student
import com.raywenderlich.markme.model.studentList
import com.raywenderlich.markme.utils.ClassSection
import kotlinx.android.synthetic.main.activity_feature.*
import timber.log.Timber

class FeatureActivity : AppCompatActivity(), FeatureContract.View {

    private val labelTitle: TextView? by lazy { activity_feature__label__category }
    private val rvItems: RecyclerView? by lazy { activity_feature__rv__list }
    private val btnSave2Prefs: Button? by lazy { activity_feature__btn__save_shared_prefs }
    private val btnSave2Db: Button? by lazy { activity_feature__btn__save_db }
    private val classList = studentList.map { Student(uid = null, name = it, grade = 0) }
    private val featurePresenter: FeatureContract.Presenter<Student> by lazy { FeaturePresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        btnSave2Prefs?.setOnClickListener {
            @Suppress("UNCHECKED_CAST")
            featurePresenter.onSave2PrefsClick((rvItems?.adapter as? RwAdapter<Student>)?.getData())
        }
        btnSave2Db?.setOnClickListener {
            @Suppress("UNCHECKED_CAST")
            featurePresenter.onSave2DbClick((rvItems?.adapter as? RwAdapter<Student>)?.getData())
        }
    }

    override fun onResume() {
        super.onResume()

        val featureType = intent.getParcelableExtra<ClassSection>(FEATURE_CATEGORY)
        featureType?.let { feature ->
            labelTitle?.text = feature.sectionName
            labelTitle?.background = ContextCompat.getDrawable(this, feature.color)

            rvItems?.apply {
                layoutManager = LinearLayoutManager(this@FeatureActivity, LinearLayout.VERTICAL, false)
                adapter = when (featureType) {
                    ClassSection.ATTENDANCE ->
                        FeatureAttendanceAdapter(dataList = classList,
                                listener = { student ->
                                    Timber.d("Student attendance for ${student?.name} clicked")
                                })
                    ClassSection.GRADING ->
                        FeatureGradingAdapter(dataList = classList,
                                listener = { student ->
                                    Timber.d("Student grading for ${student?.name} clicked")
                                })
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showToastMessage(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}