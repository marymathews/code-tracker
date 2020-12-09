package com.mathews.codetracker.modules.viewSessionList.mvp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.RxView
import com.mathews.codetracker.R
import com.mathews.database_module.entities.SessionEntity
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_session.view.*
import javax.inject.Inject

class ViewSessionListRecyclerAdapter
@Inject constructor(private val activity: AppCompatActivity)
    : RecyclerView.Adapter<ViewSessionListRecyclerAdapter.ViewSessionListViewHolder>() {

    private var sessionsList = ArrayList<SessionEntity>()
    var sessionClickedSubject = PublishSubject.create<Int>()
    var deleteClickedSubject = PublishSubject.create<Int>()

    fun setData(sessionsList : ArrayList<SessionEntity>) {
        this.sessionsList = sessionsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewSessionListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_session, parent, false)
        return ViewSessionListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sessionsList.size
    }

    override fun onBindViewHolder(holder: ViewSessionListViewHolder, position: Int) {
        holder.populateSessionData(sessionsList[position])
    }

    inner class ViewSessionListViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private var tvTitle : TextView = view.tv_title
        private var tvDate : TextView = view.tv_date
        private var tvSite : TextView = view.tv_site

        init {
            RxView.clicks(view.cv_session_item)
                .map {
                    return@map adapterPosition
                }
                .subscribe(sessionClickedSubject)

            RxView.clicks(view.iv_delete)
                .map {
                    return@map adapterPosition
                }
                .subscribe(deleteClickedSubject)
        }

        fun populateSessionData(session : SessionEntity) {
            tvTitle.text = session.title
            tvSite.text = String.format(activity.getString(R.string.session_view_site), session.site)
            tvDate.text = String.format(activity.getString(R.string.session_view_date), session.date)
        }
    }
}