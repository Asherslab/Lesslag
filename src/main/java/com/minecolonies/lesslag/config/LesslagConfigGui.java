package com.minecolonies.lesslag.config;

import com.minecolonies.lesslag.LesslagMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class LesslagConfigGui extends GuiConfig
{
    public LesslagConfigGui(GuiScreen parentScreen)
    {
        super(parentScreen, getConfigElements(), LesslagMod.ID, false, false, "Lesslag Config");
    }

    private static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        list.add(new DummyConfigElement.DummyCategoryElement("lesslagCfg", "Lesslag general Config", GeneralEntry.class));
        return list;
    }

    /**
     * This custom list entry provides the General Settings entry on the Minecraft Forge Configuration screen.
     * It extends the base Category entry class and defines the IConfigElement objects that will be used to build the child screen.
     */
    public static class GeneralEntry extends GuiConfigEntries.CategoryEntry
    {
        public GeneralEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
        {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen()
        {
            // This GuiConfig object specifies the configID of the object and as such will force-save when it is closed. The parent
            // GuiConfig object's entryList will also be refreshed to reflect the changes.
            return new GuiConfig(this.owningScreen,
                                  (new ConfigElement(LesslagMod.getConfig().getCategory(Configuration.CATEGORY_GENERAL))).getChildElements(),
                                  this.owningScreen.modID, Configuration.CATEGORY_GENERAL, false,
                                  false,
                                  GuiConfig.getAbridgedConfigPath(LesslagMod.getConfig().toString()));
        }
    }
}
