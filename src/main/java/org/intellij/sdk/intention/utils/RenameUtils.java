package org.intellij.sdk.intention.utils;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiVariable;
import com.intellij.refactoring.rename.NameSuggestionProvider;
import com.intellij.spellchecker.quickfixes.DictionarySuggestionProvider;
import org.intellij.sdk.intention.services.ClientSuggestingService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class RenameUtils {

    public static void addPredictionsIfPossible(@NotNull LinkedHashSet<String> nameSuggestions,
                                                @NotNull PsiNamedElement elementToRename) {
        if (isVariableDeclaration(elementToRename)) {
            List<String> candidates = ClientSuggestingService.getInstance().suggestVariableName((PsiNameIdentifierOwner) elementToRename);
            nameSuggestions.addAll(candidates);
        }
    }

    public static boolean notTypoRename() {
        final DictionarySuggestionProvider provider = findDictionarySuggestionProvider();
        return provider == null || provider.shouldCheckOthers();
    }

    @Nullable
    private static DictionarySuggestionProvider findDictionarySuggestionProvider() {
        for (Object extension : NameSuggestionProvider.EP_NAME.getExtensionList()) {
            if (extension instanceof DictionarySuggestionProvider) {
                return (DictionarySuggestionProvider) extension;
            }
        }
        return null;
    }

    public static boolean isVariableDeclaration(@Nullable PsiElement element) {
        return element instanceof PsiNameIdentifierOwner && isVariableClass(element);
    }

    private static boolean isVariableClass(@NotNull PsiElement token) {
        return getVariableClasses().stream().anyMatch(cls -> cls.isInstance(token));
    }

    private static Collection<Class<? extends PsiNameIdentifierOwner>> getVariableClasses() {
        return List.of(PsiVariable.class);
    }
}
