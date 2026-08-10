package flingus.perpetuate;

import flingus.perpetuate.index.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class PerpetuateTheCycle implements ModInitializer {
	public static final String MOD_ID = "perpetuate";

	@Override
	public void onInitialize() {
        ModSounds.init();
        // even moss drinks water
        // perpetuate the cycle of life?
        DefaultItemComponentEvents.MODIFY.register(modifyContext -> {
            modifyContext.modify(Items.MOSS_BLOCK, builder -> {
                builder.add(DataComponentTypes.CONSUMABLE, ConsumableComponents.FOOD);
                builder.add(DataComponentTypes.FOOD, new FoodComponent(2, 2, true));
            });
        });
        // pale moss drinks water too.
        // perpetuate the cycle of existence?
        DefaultItemComponentEvents.MODIFY.register(modifyContext -> {
            modifyContext.modify(Items.PALE_MOSS_BLOCK, builder -> {
                builder.add(DataComponentTypes.CONSUMABLE, ConsumableComponents.FOOD);
                builder.add(DataComponentTypes.FOOD, new FoodComponent(2, 1, true));
            });
        });
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
