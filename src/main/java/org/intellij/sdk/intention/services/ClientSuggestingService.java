package org.intellij.sdk.intention.services;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public interface ClientSuggestingService {
    static ClientSuggestingService getInstance() {
        return ApplicationManager.getApplication().getService(ClientSuggestingService.class);
    }

    @NotNull List<String> suggestVariableName(@NotNull PsiNameIdentifierOwner variable);
}
