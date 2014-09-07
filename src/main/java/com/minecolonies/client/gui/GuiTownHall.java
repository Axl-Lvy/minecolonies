package com.minecolonies.client.gui;

import com.minecolonies.MineColonies;
import com.minecolonies.entity.EntityBuilder;
import com.minecolonies.entity.EntityDeliveryman;
import com.minecolonies.lib.EnumGUI;
import com.minecolonies.network.messages.BuildRequestMessage;
import com.minecolonies.tileentities.TileEntityTownHall;
import com.minecolonies.util.LanguageHandler;
import com.minecolonies.util.Utils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.List;

public class GuiTownHall extends GuiBase
{
    private final int BUTTON_BUILD = 0, BUTTON_REPAIR = 1, BUTTON_RECALL = 2, BUTTON_SPECIALIZATION_TOGGLE = 3, BUTTON_RENAME = 4, BUTTON_INFORMATION = 5, BUTTON_ACTIONS = 6, BUTTON_SETTINGS = 7;
    private final TileEntityTownHall tileEntityTownHall;

    private final int PAGE_ACTIONS = 0, PAGE_INFORMATION = 1, PAGE_SETTINGS = 2;
    private int page = PAGE_ACTIONS;

    public GuiTownHall(TileEntityTownHall tileEntityTownHall, EntityPlayer player, World world, int x, int y, int z)
    {
        super(player, world, x, y, z);
        this.tileEntityTownHall = tileEntityTownHall;
    }

    @Override
    protected void addElements()
    {
        super.addElements();

        //Bottom navigation
        GuiButton infoButton = addBottomButton(BUTTON_INFORMATION, LanguageHandler.format("com.minecolonies.gui.workerHuts.information"), middleX - 76, 64, buttonHeight);
        GuiButton actionsButton = addBottomButton(BUTTON_ACTIONS, LanguageHandler.format("com.minecolonies.gui.townhall.actions"), middleX - 10, 44, buttonHeight);
        GuiButton settingsButton = addBottomButton(BUTTON_SETTINGS, LanguageHandler.format("com.minecolonies.gui.workerHuts.settings"), middleX + xSize / 2 - 50, 46, buttonHeight);


        if(page == PAGE_ACTIONS)
        {
            actionsButton.enabled = false;

            String currentSpec = LanguageHandler.format("com.minecolonies.gui.townhall.currentSpecialization");
            String spec = "<Industrial>"; //TODO replace with actual specialisation
            String currentTownhallName = LanguageHandler.format("com.minecolonies.gui.townhall.currTownhallName");
            String townhallName = tileEntityTownHall.getCityName();

            int y = labelSpan * 3;

            addCenteredLabel(currentTownhallName, topY + labelSpan / 2);
            addCenteredLabel(townhallName, topY + labelSpan + labelSpan / 2);
            addButton(BUTTON_BUILD, LanguageHandler.format("com.minecolonies.gui.townhall.build"), buttonMiddleX, topY + y, buttonWidth, buttonHeight);
            addButton(BUTTON_REPAIR, LanguageHandler.format("com.minecolonies.gui.townhall.repair"), buttonMiddleX, topY + (y += buttonHeight + buttonSpan), buttonWidth, buttonHeight);
            addButton(BUTTON_RECALL, LanguageHandler.format("com.minecolonies.gui.townhall.recall"), buttonMiddleX, topY + (y += buttonHeight + buttonSpan), buttonWidth, buttonHeight);
            addButton(BUTTON_SPECIALIZATION_TOGGLE, LanguageHandler.format("com.minecolonies.gui.townhall.togglespec"), buttonMiddleX, topY + (y += buttonHeight + buttonSpan), buttonWidth, buttonHeight);

            addCenteredLabel(currentSpec, topY + (y += buttonHeight + buttonSpan));
            addCenteredLabel(spec, topY + y + labelSpan);

            addButton(BUTTON_RENAME, LanguageHandler.format("com.minecolonies.gui.townhall.rename"), buttonMiddleX, topY + (y += buttonHeight + buttonSpan), buttonWidth, buttonHeight);
        }
        else if(page == PAGE_INFORMATION)
        {
            infoButton.enabled = false;

            int citizensSize = tileEntityTownHall.getCitizens().size();
            int workers = 0;
            int builders = 0, deliverymen = 0;
            List<Entity> citizens = Utils.getEntitiesFromID(world, tileEntityTownHall.getEntityIDs());
            if(citizens != null)
            {
                for(Entity citizen : citizens)
                {
                    if(citizen instanceof EntityBuilder)
                    {
                        builders++;
                    }
                    else if(citizen instanceof EntityDeliveryman)
                    {
                        deliverymen++;
                    }
                }
                workers = builders + deliverymen;
            }

            String numberOfCitizens = LanguageHandler.format("com.minecolonies.gui.townhall.population.totalCitizens", citizensSize, tileEntityTownHall.getMaxCitizens());
            String numberOfUnemployed = LanguageHandler.format("com.minecolonies.gui.townhall.population.unemployed", (citizensSize - workers));
            String numberOfBuilders = LanguageHandler.format("com.minecolonies.gui.townhall.population.builders", builders);
            String numberOfDeliverymen = LanguageHandler.format("com.minecolonies.gui.townhall.population.deliverymen", deliverymen);

            int y = topY + labelSpan;
            int x = getSameCenterX(numberOfCitizens, numberOfUnemployed, numberOfBuilders, numberOfDeliverymen);

            addLabel(numberOfCitizens, x, y);
            addLabel(numberOfUnemployed, x, y += labelSpan * 2);
            addLabel(numberOfBuilders, x, y += labelSpan);
            addLabel(numberOfDeliverymen, x, y += labelSpan);
        }
        else if(page == PAGE_SETTINGS)
        {
            settingsButton.enabled = false;
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton)
    {
        switch(guiButton.id)
        {
            case BUTTON_BUILD:
                MineColonies.network.sendToServer(new BuildRequestMessage(x, y, z, BuildRequestMessage.BUILD));
                break;
            case BUTTON_REPAIR:
                MineColonies.network.sendToServer(new BuildRequestMessage(x, y, z, BuildRequestMessage.REPAIR));
                break;
            case BUTTON_RECALL:
                break;
            case BUTTON_SPECIALIZATION_TOGGLE:
                break;
            case BUTTON_RENAME:
                player.openGui(MineColonies.instance, EnumGUI.TOWNHALL_RENAME.getID(), world, x, y, z);
                break;
            case BUTTON_INFORMATION:
                page = PAGE_INFORMATION;
                addElements();
                break;
            case BUTTON_ACTIONS:
                page = PAGE_ACTIONS;
                addElements();
                break;
            case BUTTON_SETTINGS:
                page = PAGE_SETTINGS;
                addElements();
                break;
        }
    }
}
