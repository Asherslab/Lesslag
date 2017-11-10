package com.minecolonies.lesslag.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

public class LesslagGuiFactory implements IModGuiFactory
{
    @Override
    public void initialize(final Minecraft minecraftInstance)
    {
    }

    @Override
    public boolean hasConfigGui()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public GuiScreen createConfigGui(final GuiScreen parentScreen)
    {
        return new LesslagConfigGui(parentScreen);
    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass()
    {
        return LesslagConfigGui.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
    {
        return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(final RuntimeOptionCategoryElement element)
    {
        return null;
    }
}
