package com.mathews.codetracker.modules.viewInsights.mvp

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.mathews.codetracker.R
import com.mathews.codetracker.app.AppConstants
import com.mathews.codetracker.app.ColourTemplate
import kotlinx.android.synthetic.main.activity_view_insights.view.*
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class ViewInsightsView
@Inject constructor(private val activity: AppCompatActivity, val state: ViewInsightsViewState)
    : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_view_insights, this)
    }

    fun renderTotalAndAverage() {
        if(state.totalNumberOfSessions != 0L) {
            tv_total_count.text = String.format(activity.getString(R.string.total_number), state.totalNumberOfSessions)
        } else {
            tv_total_count.visibility = GONE
            tv_avg_number_sessions.visibility = GONE
            divider_1.visibility = GONE
            tv_no_insights.visibility = View.VISIBLE
        }

        if(state.avgNumberOfSessions != 0.0) {
            tv_avg_number_sessions.text = String.format(activity.getString(R.string.avg_sessions), state.avgNumberOfSessions)
        } else {
            tv_avg_number_sessions.visibility = GONE
        }
    }

    fun renderSiteCount() {
        if(state.siteCountMap.isNotEmpty()) {
            val chart : PieChart = chart_site_count
            val entries = ArrayList<PieEntry>()
            for (site in state.siteCountMap) {
                entries.add(PieEntry(site.value.toFloat(), site.key))
            }
            createChart(entries, chart)
        } else {
            tv_site_count_header.visibility = GONE
            chart_site_count.visibility = GONE
        }
    }

    fun renderLevelCount() {
        if(state.levelCountMap.isNotEmpty()) {
            val chart : PieChart = chart_level_count
            val entries = ArrayList<PieEntry>()
            for (level in state.levelCountMap) {
                entries.add(PieEntry(level.value.toFloat(), level.key))
            }
            createChart(entries, chart)
        } else {
            tv_level_count_header.visibility = GONE
            chart_level_count.visibility = GONE
            divider_2.visibility = View.GONE
        }
    }

    fun renderLevelTime() {
        if(state.levelTimeMap.isNotEmpty()) {
            val chart : PieChart = chart_level_time
            val entries = ArrayList<PieEntry>()
            for (level in state.levelTimeMap) {
                entries.add(PieEntry(level.value.toFloat(), level.key))
            }
            createChart(entries, chart)
        } else {
            tv_level_time_header.visibility = GONE
            chart_level_time.visibility = GONE
            divider_3.visibility = GONE
        }
    }

    private fun createChart(entries : ArrayList<PieEntry>, chart : PieChart) {
        val dataSet = PieDataSet(entries.toMutableList(), "")
        val data = PieData(dataSet)

        chart.data = data
        dataSet.colors = ColourTemplate.ALTERNATE_COLOURS.toMutableList()
        dataSet.valueTypeface = ResourcesCompat.getFont(context, R.font.sharp_sans_no1_semibold)
        dataSet.valueTextSize = 20f
        dataSet.valueTextColor = Color.parseColor(AppConstants.CHART_TEXT_COLOUR)
        chart.setEntryLabelTypeface(ResourcesCompat.getFont(context, R.font.sharp_sans_no1_semibold))
        chart.setEntryLabelTextSize(20f)
        chart.description.isEnabled = false
        chart.legend.isEnabled = false
        chart.animateXY(1000,1000)
    }


    fun testView() {
        val chart : PieChart = chart_level_count
        val list1 = ArrayList<PieEntry>()

        list1.add(PieEntry(567f,"Easy"))
        list1.add(PieEntry(127f,"Medium"))
        list1.add(PieEntry(234f,"Hard"))

        val dataSet = PieDataSet(list1.toMutableList(), "Level")
        val data : PieData = PieData(dataSet)
        chart.data = data
        dataSet.colors = ColourTemplate.ALTERNATE_COLOURS.toMutableList()
        dataSet.valueTypeface = ResourcesCompat.getFont(context, R.font.sharp_sans_no1_semibold)
        dataSet.valueTextSize = 20f
        chart.animateXY(1000,1000)
        chart.legend.isEnabled = false
        chart.setEntryLabelTextSize(20f)
        chart.setEntryLabelTypeface(ResourcesCompat.getFont(context, R.font.sharp_sans_no1_semibold))
        dataSet.valueTextColor = Color.parseColor("#ffffff")
        chart.description.isEnabled = false
    }
}