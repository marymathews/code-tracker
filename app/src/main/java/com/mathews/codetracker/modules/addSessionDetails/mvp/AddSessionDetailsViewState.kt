package com.mathews.codetracker.modules.addSessionDetails.mvp

import javax.inject.Inject

class AddSessionDetailsViewState
@Inject constructor() {
    var problemTitle : String? = null
    var problemDescription : String? = null
    var site : String? = null
    var link : String? = null
    var level : String? = null
    var solutionDescription : String? = null
    var timeComplexity : String? = null
    var spaceComplexity : String? = null
    var date : String? = null
    var time : String? = null
    var isDataProcessingInProgress : Boolean = false
}