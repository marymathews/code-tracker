package com.mathews.codetracker.modules.viewSessionList.mvp

import com.mathews.database_module.entities.SessionEntity
import javax.inject.Inject

class ViewSessionListViewState
@Inject constructor() {
    var sessionsList = ArrayList<SessionEntity>()
}