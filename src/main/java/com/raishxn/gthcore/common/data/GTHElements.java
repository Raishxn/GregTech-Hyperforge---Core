package com.raishxn.gthcore.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

public class GTHElements {

    // Removemos 'final' e a inicialização imediata
    public static Element Spacetime;
    public static Element Eternity;
    public static Element Infinity;
    public static Element Magmatter;

    public static void init() {
        // A chamada createAndRegister deve ocorrer AQUI, dentro do evento de registro.

        // Tier UV - Spacetime (Elemento 130)
        Spacetime = GTElements.createAndRegister(130, 195, -1, null, "Spacetime", "St", false);

        // Tier UHV - Eternity (Elemento 145)
        Eternity = GTElements.createAndRegister(145, 230, -1, null, "Eternity", "Et", false);

        // Tier UEV - Infinity (Elemento 160)
        Infinity = GTElements.createAndRegister(160, 280, -1, null, "Infinity", "∞", false);

        // Tier OpV - Magmatter (Elemento 175)
        Magmatter = GTElements.createAndRegister(175, 350, -1, null, "Magmatter", "Mgm", false);
    }
}