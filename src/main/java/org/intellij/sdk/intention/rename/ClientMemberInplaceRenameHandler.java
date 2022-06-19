package org.intellij.sdk.intention.rename;

import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.refactoring.rename.inplace.MemberInplaceRenameHandler;
import com.intellij.refactoring.rename.inplace.MemberInplaceRenamer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClientMemberInplaceRenameHandler extends MemberInplaceRenameHandler {
    @Override
    protected @Nullable MemberInplaceRenamer createMemberRenamer(@NotNull PsiElement element,
                                                                 @NotNull PsiNameIdentifierOwner elementToRename,
                                                                 @NotNull Editor editor) {
        return new ClientMemberInplaceRenamer(elementToRename, element, editor);
    }
}
