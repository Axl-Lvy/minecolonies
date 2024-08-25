package com.minecolonies.core.blocks.huts;

import com.minecolonies.api.blocks.AbstractBlockHut;
import com.minecolonies.api.colony.buildings.ModBuildings;
import com.minecolonies.api.colony.buildings.registry.BuildingEntry;

/**
 * Hut for the kitchen. No different from {@link AbstractBlockHut}
 */
public class BlockHutKitchen extends AbstractBlockHut<BlockHutKitchen>
{
    @Override
    public BuildingEntry getBuildingEntry()
    {
        return ModBuildings.kitchen.get();
    }
}
