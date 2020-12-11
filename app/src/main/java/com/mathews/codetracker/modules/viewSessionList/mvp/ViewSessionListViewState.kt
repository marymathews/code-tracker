package com.mathews.codetracker.modules.viewSessionList.mvp

import com.mathews.database_module.entities.SessionEntity
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class ViewSessionListViewState
@Inject constructor() {
    var sessionsList : ArrayList<SessionEntity> = ArrayList<SessionEntity>()
    var onConfirmDeletionClickedObservable = PublishSubject.create<Any>()
    var selectedSessionId : Int = -1
}