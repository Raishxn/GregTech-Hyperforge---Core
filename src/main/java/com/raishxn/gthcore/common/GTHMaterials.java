package com.raishxn.gthcore.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.raishxn.gthcore.GTHCore;
import com.raishxn.gthcore.common.data.GTHElements; // Importante: Importar seus elementos

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;

public class GTHMaterials {

    public static Material Spacetime;
    public static Material Eternity;
    public static Material Infinity;
    public static Material Magmatter;

    public static void init() {

        // Tier UV - Spacetime
        Spacetime = new Material.Builder(GTHCore.id("spacetime"))
                .ingot()
                .fluid()
                .dust()
                .color(0x4B0082) // Roxo índigo
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL)
                .element(GTHElements.Spacetime) // Vincula ao elemento Spacetime
                .blastTemp(32000, BlastProperty.GasTier.HIGHEST)
                .buildAndRegister();

        // Tier UHV - Eternity
        Eternity = new Material.Builder(GTHCore.id("eternity"))
                .ingot()
                .fluid()
                .dust()
                .color(0xFFD700) // Dourado
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FINE_WIRE)
                .element(GTHElements.Eternity) // Vincula ao elemento Eternity
                .blastTemp(45000, BlastProperty.GasTier.HIGHEST)
                .buildAndRegister();

        // Tier UEV - Infinity
        Infinity = new Material.Builder(GTHCore.id("infinity"))
                .ingot()
                .fluid()
                .dust()
                .color(0xFFFFFF) // Branco Infinito
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_LENS)
                .element(GTHElements.Infinity) // Vincula ao elemento Infinity
                .blastTemp(65000, BlastProperty.GasTier.HIGHEST)
                .buildAndRegister();

        // Tier OpV - Magmatter
        Magmatter = new Material.Builder(GTHCore.id("magmatter"))
                .ingot()
                .fluid()
                .dust()
                .color(0xFF0000) // Vermelho Intenso
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, IS_MAGNETIC)
                .element(GTHElements.Magmatter) // Vincula ao elemento Magmatter
                .blastTemp(150000, BlastProperty.GasTier.HIGHEST)
                .buildAndRegister();
    }
}