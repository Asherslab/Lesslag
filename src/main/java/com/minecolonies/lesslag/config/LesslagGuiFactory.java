package com.minecolonies.lesslag.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

import java.util.Set;

public class LesslagGuiFactory implements IModGuiFactory
{
    @Override
    public void initialize(Minecraft minecraftInstance) {}

    @Override
    public boolean hasConfigGui() { return true; }

    @Override
    public GuiScreen createConfigGui(GuiScreen parent) { return new LesslagConfigGui(parent); }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() { return null; }
}
