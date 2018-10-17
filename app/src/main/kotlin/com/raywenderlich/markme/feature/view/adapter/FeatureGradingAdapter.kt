package com.raywenderlich.markme.feature.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.raywenderlich.markme.R
import com.raywenderlich.markme.model.Student
import kotlinx.android.synthetic.main.card_feature_grading.view.*

class FeatureGradingAdapter(val dataList: List<Student>?, private var listener: (Student?) -> Unit)
    : RecyclerView.Adapter<FeatureGradingAdapter.ViewHolder>(), RwAdapter<Student> {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val labelName: TextView? = itemView.card_feat_grading__label__name
        val etGrade: TextView? = itemView.card_feat_grading__edittext__grade
    }

    override fun getItemCount(): Int = dataList?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewRow = LayoutInflater.from(parent.context).inflate(R.layout.card_feature_grading, parent, false)
        return ViewHolder(viewRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.labelName?.text = dataList?.let { it[position].name }
        holder.etGrade?.text = dataList?.let { it[position].grade.toString() }
        holder.itemView.setOnClickListener {
            listener(dataList?.get(position))
        }
    }

    override fun getData(): List<Student>? = dataList
}