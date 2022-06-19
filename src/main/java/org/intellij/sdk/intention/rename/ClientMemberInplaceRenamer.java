package org.intellij.sdk.intention.rename;

import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.refactoring.rename.NameSuggestionProvider;
import com.intellij.refactoring.rename.inplace.MemberInplaceRenamer;
import com.intellij.refactoring.rename.inplace.MyLookupExpression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashSet;

import static org.intellij.sdk.intention.utils.RenameUtils.addPredictionsIfPossible;
import static org.intellij.sdk.intention.utils.RenameUtils.notTypoRename;


public class ClientMemberInplaceRenamer extends MemberInplaceRenamer {

    public ClientMemberInplaceRenamer(@NotNull PsiNameIdentifierOwner elementToRename,
                                      @NotNull PsiElement substituted,
                                      @NotNull Editor editor) {
        super(elementToRename, substituted, editor);
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
