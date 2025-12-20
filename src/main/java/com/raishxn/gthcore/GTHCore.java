package com.raishxn.gthcore;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.sound.SoundEntry;
import com.raishxn.gthcore.api.registry.GTHRegistries;
import com.raishxn.gthcore.common.data.GTHElements;
import com.raishxn.gthcore.common.material.GTHMaterials;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GTHCore.MOD_ID)
public class GTHCore {

    public static final String MOD_ID = "gthcore";
    public static final Logger LOGGER = LogManager.getLogger();

    public GTHCore() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registra o Registrate (Isso inicializa a classe GTHRegistries estaticamente)
        GTHRegistries.REGISTRATE.registerEventListeners(modEventBus);

        // Listeners de Eventos GT/Forge
        modEventBus.addListener(this::addMaterialRegistries);
        modEventBus.addListener(this::addMaterials);
        modEventBus.addListener(this::modifyMaterials);

        // IMPORTANTE: Listener genérico para registrar Elementos no momento certo
        modEventBus.addListener(this::registerElements);

        modEventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        modEventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
        modEventBus.addGenericListener(SoundEntry.class, this::registerSounds);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    private void addMaterialRegistries(MaterialRegistryEvent event) {
        GTCEuAPI.materialManager.createRegistry(GTHCore.MOD_ID);
    }

    private void addMaterials(MaterialEvent event) {
        // Materiais são registrados APÓS os elementos, então isso é seguro.
        GTHMaterials.init();
    }

    private void modifyMaterials(PostMaterialEvent event) {
        // Modificações em materiais existentes
    }

    // Este método captura o evento de registro do Forge e verifica se é para Elementos
    private void registerElements(RegisterEvent event) {
        if (event.getRegistryKey().equals(GTRegistries.ELEMENTS)) {
            LOGGER.info("Registering GTH Elements...");
            GTHElements.init();
        }
    }

    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        // CustomRecipeTypes.init();
    }

    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        // CustomMachines.init();
    }

    public void registerSounds(GTCEuAPI.RegisterEvent<ResourceLocation, SoundEntry> event) {
        // CustomSounds.init();
    }
}