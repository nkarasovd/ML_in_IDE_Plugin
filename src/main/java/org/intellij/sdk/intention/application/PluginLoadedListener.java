package org.intellij.sdk.intention.application;

import com.intellij.ide.plugins.DynamicPluginListener;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.refactoring.rename.RenameHandler;
import com.intellij.refactoring.rename.inplace.VariableInplaceRenameHandler;
import org.jetbrains.annotations.NotNull;


public class PluginLoadedListener implements DynamicPluginListener {

    @Override
    public void beforePluginUnload(@NotNull IdeaPluginDescriptor pluginDescriptor, boolean isUpdate) {
        DynamicPluginListener.super.beforePluginUnload(pluginDescriptor, isUpdate);
    }

    @Override
    public void pluginLoaded(@NotNull IdeaPluginDescriptor pluginDescriptor) {
        DynamicPluginListener.super.pluginLoaded(pluginDescriptor);
        RenameHandler.EP_NAME.getPoint().unregisterExtension(VariableInplaceRenameHandler.class);
    }
}
