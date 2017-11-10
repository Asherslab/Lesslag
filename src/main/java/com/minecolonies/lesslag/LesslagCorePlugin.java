package com.minecolonies.lesslag;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

@IFMLLoadingPlugin.TransformerExclusions({"com.minecolonies.lesslag"})
@IFMLLoadingPlugin.SortingIndex(1001)
@IFMLLoadingPlugin.MCVersion("1.11.2")
public class LesslagCorePlugin implements IFMLLoadingPlugin
{
    public LesslagCorePlugin()
    {
        MixinBootstrap.init();

        //-Dfml.coreMods.load=com.minecolonies.lesslag.LesslagCorePlugin

        // Retrieves the DEFAULT mixin environment
        MixinEnvironment.getDefaultEnvironment();

        Mixins.addConfiguration("mixins.lesslag.json");
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[] {};
    }

    @Override
    public String getModContainerClass()
    {
        return "com.minecolonies.lesslag.LesslagMod";
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(final Map<String, Object> data)
    {

    }

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }
}
