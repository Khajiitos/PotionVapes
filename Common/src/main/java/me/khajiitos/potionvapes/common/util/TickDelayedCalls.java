package me.khajiitos.potionvapes.common.util;

import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public class TickDelayedCalls {
    private static final List<DelayedCall> delayedCalls = new ArrayList<>();

    public static void addDelayedCall(int ticksFromNow, Runnable runnable) {
        delayedCalls.add(new DelayedCall(ticksFromNow, runnable));
    }

    public static void tick() {
        delayedCalls.removeIf(DelayedCall::tickMaybeCall);
    }

    private static class DelayedCall {
        protected int ticksFromNow;
        protected final Runnable runnable;

        public DelayedCall(int ticksFromNow, Runnable runnable) {
            this.ticksFromNow = ticksFromNow;
            this.runnable = runnable;
        }

        public boolean tickMaybeCall() {
            if (--ticksFromNow <= 0) {
                Minecraft.getInstance().doRunTask(this.runnable);
                return true;
            }

            return false;
        }
    }
}
