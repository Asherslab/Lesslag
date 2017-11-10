package com.minecolonies.lesslag;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

public class LesslagMod extends DummyModContainer
{
    public static final  String ID      = "lesslag";
    private static final String NAME    = "Lesslag";
    private static final String VERSION = "1.0";
    private static Configuration config;
    private static LesslagMod    instance;

    public LesslagMod()
    {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = ID;
        meta.name = NAME;
        meta.version = VERSION;
        meta.credits = "Sharkske for inspiration, and Oriondevelopment for the awesome ASM help =D";
        meta.authorList = Collections.singletonList("Asherslab");
        meta.description = "A simple Coremod for increasing FPS by reducing Terrain Animations.";
        meta.url = "http://minecolonies.com";
        meta.screenshots = new String[0];
        meta.logoFile = "";

        config = null;
        File cfgFile = new File(Loader.instance().getConfigDir(), "lesslag.cfg");
        config = new Configuration(cfgFile);

        syncConfig(true);

        instance = this;
    }

    private static void syncConfig(final boolean load)
    {

        List<String> propOrder = new ArrayList();

        if (!config.isChild && load)
        {
            config.load();
        }

        Property prop;

        prop = config.get(CATEGORY_GENERAL, "allAnimations", false);
        prop.setComment("Render this mod literally useless, I'd suggest not. but what-ever");
        propOrder.add(prop.getName());

        prop = config.get(CATEGORY_GENERAL, "waterAnimations", true);
        prop.setComment("Whether to allow Water Animations or not");
        propOrder.add(prop.getName());

        prop = config.get(CATEGORY_GENERAL, "lavaAnimations", true);
        prop.setComment("Whether to allow Lava Animations or not");
        propOrder.add(prop.getName());

        prop = config.get(CATEGORY_GENERAL, "clockAndCompassAnimations", true);
        prop.setComment("Whether to allow Clock and Compass Animations or not");
        propOrder.add(prop.getName());

        prop = config.get(CATEGORY_GENERAL, "portalAnimations", false);
        prop.setComment("Whether to allow Portal animations or not");
        propOrder.add(prop.getName());

        prop = config.get(CATEGORY_GENERAL, "fireAnimations", true);
        prop.setComment("Whether to allow Fire animations or not");
        propOrder.add(prop.getName());

        prop = config.get(CATEGORY_GENERAL, "glassAnimations", false);
        prop.setComment("Whether to allow glass animations or not");
        propOrder.add(prop.getName());

        prop = config.get(CATEGORY_GENERAL, "grassAnimations", false);
        prop.setComment("Whether to allow grass animations or not");
        propOrder.add(prop.getName());

        prop = config.get(CATEGORY_GENERAL, "snowAnimations", false);
        prop.setComment("Whether to allow snow animations or not");
        propOrder.add(prop.getName());

        prop = config.get(CATEGORY_GENERAL, "myceliumAnimations", false);
        prop.setComment("Whether to allow mycelium animations or not");
        propOrder.add(prop.getName());

        config.setCategoryPropertyOrder(CATEGORY_GENERAL, propOrder);

        if (config.hasChanged())
        {
            config.save();
        }
    }

    /**
     * By subscribing to the OnConfigChangedEvent we are able to execute code when our config screens are closed.
     * This implementation uses the optional configID string to handle multiple Configurations using one event handler.
     */
    @SubscribeEvent
    public void onConfigChanged(OnConfigChangedEvent event)
    {
        if (getMetadata().modId.equals(event.getModID()))
        {
            if (Configuration.CATEGORY_GENERAL.equals(event.getConfigID()))
            {
                syncConfig(false);
            }
        }
    }

    @Subscribe
    public void preInit(FMLPreInitializationEvent evt)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
        bus.register(this);
        return true;
    }

    @Override
    public void setEnabledState(final boolean enabled)
    {
        super.setEnabledState(enabled);
    }

    @Override
    public Disableable canBeDisabled()
    {
        return Disableable.NEVER;
    }

    public static Configuration getConfig()
    {
        return config;
    }

    public static LesslagMod getInstance()
    {
        return instance;
    }

    @Override
    public String getVersion()
    {
        return VERSION;
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    public String getModId()
    {
        return ID;
    }

    @Override
    public String getGuiClassName()
    {
        return "com.minecolonies.lesslag.config.LesslagGuiFactory";
    }
}
