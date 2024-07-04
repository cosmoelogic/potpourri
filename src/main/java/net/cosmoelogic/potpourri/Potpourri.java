package net.cosmoelogic.potpourri;

import net.fabricmc.api.ModInitializer;

public class Potpourri implements ModInitializer {
    public static final String MOD_ID = "potpourri";


    @Override
    public void onInitialize() {
        net.cosmoelogic.potpourri.item.ModItems.registerItems();
        System.out.printf("%s: Thanks for using %n", MOD_ID);
    }
}
