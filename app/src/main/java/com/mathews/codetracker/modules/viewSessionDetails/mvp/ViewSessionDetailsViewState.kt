package com.mathews.codetracker.modules.viewSessionDetails.mvp

import com.mathews.database_module.entities.SessionEntity
import javax.inject.Inject

class ViewSessionDetailsViewState
@Inject constructor() {
    var sessionId : Long = 0L
    lateinit var session : SessionEntity
}