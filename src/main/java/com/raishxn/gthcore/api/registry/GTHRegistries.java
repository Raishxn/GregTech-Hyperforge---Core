package com.raishxn.gthcore.api.registry;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.raishxn.gthcore.GTHCore;

public class GTHRegistries {

    // O Registrate é a ferramenta central para registrar conteúdo no GT Modern
    public static final GTRegistrate REGISTRATE = GTRegistrate.create(GTHCore.MOD_ID);

    // Método para inicializar (chamado na classe principal)
    public static void init() {
        // Futuros registros estáticos podem ser chamados aqui
    }
}