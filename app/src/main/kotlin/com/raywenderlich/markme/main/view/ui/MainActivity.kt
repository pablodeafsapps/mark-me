/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.markme.main.view.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.raywenderlich.markme.R
import com.raywenderlich.markme.main.MainContract
import com.raywenderlich.markme.main.presenter.MainPresenter
import com.raywenderlich.markme.utils.ClassSection
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val cardAtt by lazy { activity_main__cardview__attendance }
    private val cardGrading by lazy { activity_main__cardview__grading }
    private val mainPresenter by lazy { MainPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardAtt.setOnClickListener {
            mainPresenter.onAttendanceOptionClick()
        }
        cardGrading.setOnClickListener {
            mainPresenter.onGradingOptionClick()
        }
    }

    override fun finishView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateTo(section: ClassSection) {
        when (section) {
            ClassSection.ATTENDANCE -> Log.d("Tag", "'Attendance' clicked")
            ClassSection.GRADING -> Log.d("Tag", "'Grading' clicked")
        }
    }
}
