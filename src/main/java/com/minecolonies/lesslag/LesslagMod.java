package com.minecolonies.lesslag;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber
@Mod(modid = LesslagMod.ID, name = LesslagMod.NAME, version = "1.0", useMetadata = true)
public class LesslagMod
{
    public static final String ID = "lesslag";
    public static final String NAME = "Lesslag";

    /**
     * Event handler for forge pre init event.
     *
     * @param event the forge pre init event.
     */
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        System.out.println("TEST:" + !Boolean.valueOf(Launch.blackboard.get("fml.deobfuscatedEnvironment").toString()));

        final Configuration configuration = new Configuration(event.getSuggestedConfigurationFile());
        configuration.load();

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

}
