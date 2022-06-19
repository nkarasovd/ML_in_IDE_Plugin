package com.github.nkarasovd.mlinideplugin.services

import com.intellij.openapi.project.Project
import com.github.nkarasovd.mlinideplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
