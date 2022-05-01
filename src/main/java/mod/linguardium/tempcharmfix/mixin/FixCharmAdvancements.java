package mod.linguardium.tempcharmfix.mixin;

import com.google.common.collect.Maps;
import net.minecraft.advancement.Advancement;
import net.minecraft.network.packet.s2c.play.AdvancementUpdateS2CPacket;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Mixin(AdvancementUpdateS2CPacket.class)
public class FixCharmAdvancements {
	@Inject(at=@At("RETURN"),method="getAdvancementsToEarn",cancellable = true)
	private void fixcharm$hashmap_advacements(CallbackInfoReturnable<Map<Identifier, Advancement.Builder>> cir) {
		HashMap<Identifier, Advancement.Builder> mutableMap = Maps.newHashMap();
		mutableMap.putAll(cir.getReturnValue());
		cir.setReturnValue(mutableMap);
	}
}
