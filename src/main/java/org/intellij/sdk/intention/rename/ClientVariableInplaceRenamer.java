package org.intellij.sdk.intention.rename;

import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.refactoring.rename.NameSuggestionProvider;
import com.intellij.refactoring.rename.inplace.MyLookupExpression;
import com.intellij.refactoring.rename.inplace.VariableInplaceRenamer;
import org.intellij.sdk.model.impl.FastTextModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashSet;

import static org.intellij.sdk.intention.utils.RenameUtils.addPredictionsIfPossible;
import static org.intellij.sdk.intention.utils.RenameUtils.notTypoRename;


public class ClientVariableInplaceRenamer extends VariableInplaceRenamer {
    public ClientVariableInplaceRenamer(@NotNull PsiNamedElement elementToRename, @NotNull Editor editor) {
        super(elementToRename, editor);
    }

    @Override
    public boolean performInplaceRefactoring(@Nullable LinkedHashSet<String> nameSuggestions) {
        if (nameSuggestions == null) nameSuggestions = new LinkedHashSet<>();
        if (notTypoRename()) addPredictionsIfPossible(nameSuggestions, myElementToRename);
        return super.performInplaceRefactoring(nameSuggestions);
    }

    @Override
    protected MyLookupExpression createLookupExpression(PsiElement selectedElement) {
        NameSuggestionProvider.suggestNames(myElementToRename, selectedElement, myNameSuggestions);
        return new MyLookupExpression(getInitialName(),
                myNameSuggestions,
                myElementToRename,
                selectedElement,
                shouldSelectAll(),
                myAdvertisementText);
    }
}
