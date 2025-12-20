package com.raishxn.gthcore;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import com.raishxn.gthcore.api.registry.GTHRegistries;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@SuppressWarnings("unused")
@GTAddon
public class GTHCOREAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return GTHRegistries.REGISTRATE;
    }

    @Override
    public void initializeAddon() {
        // Chamado quando o Addon é inicializado.
        // Ótimo lugar para inicializar itens/blocos customizados que não são materiais químicos.
        GTHCore.LOGGER.info("GregTech: Hyperforge Addon Initialized!");
    }

    @Override
    public String addonModId() {
        return GTHCore.MOD_ID;
    }

    @Override
    public void registerTagPrefixes() {
        // Registra prefixos de OreDict customizados se houver
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        // Registra receitas do Datagen (código -> json)
        // GTHRecipes.init(provider);
    }
}