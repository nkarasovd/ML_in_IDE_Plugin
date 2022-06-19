package org.intellij.sdk.intention.application;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import com.intellij.refactoring.rename.RenameHandler;
import com.intellij.refactoring.rename.inplace.VariableInplaceRenameHandler;
import org.jetbrains.annotations.NotNull;

public class ProjectOpenCloseListener implements ProjectManagerListener {
    @Override
    public void projectOpened(@NotNull Project project) {
        RenameHandler.EP_NAME.getPoint().unregisterExtension(VariableInplaceRenameHandler.class);
    }
}
