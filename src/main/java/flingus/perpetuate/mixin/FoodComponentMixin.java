package flingus.perpetuate.mixin;

import flingus.perpetuate.index.ModSounds;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodComponent.class)
public class FoodComponentMixin {
    @Inject(method = "onConsume", at = @At("TAIL"))
    public void onConsume(World world, LivingEntity user, ItemStack stack, ConsumableComponent consumable, CallbackInfo ci) {
        if (user instanceof PlayerEntity playerEntity) {
            if(stack.isOf(Items.MOSS_BLOCK) || stack.isOf(Items.PALE_MOSS_BLOCK)) {
                // yummers
                playerEntity.playSound(ModSounds.MOSS_FANFARE);
            }
        }
    }
}
