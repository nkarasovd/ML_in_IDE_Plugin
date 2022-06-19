package org.intellij.sdk.intention.services.impl;

import com.intellij.psi.PsiNameIdentifierOwner;
import org.intellij.sdk.intention.services.ClientSuggestingService;
import org.intellij.sdk.model.impl.FastTextModel;
import org.intellij.sdk.model.impl.SimpleModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ClientSuggestingServiceImpl implements ClientSuggestingService {
    SimpleModel simpleModel = new SimpleModel();
//    FastTextModel fastTextModel = new FastTextModel();

    @Override
    public @NotNull List<String> suggestVariableName(@NotNull PsiNameIdentifierOwner variable) {
        return this.simpleModel.getCandidates(variable.getName(), 10);
//        return this.fastTextModel.getCandidates(variable.getName(), 10);

    }
}
