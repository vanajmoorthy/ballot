package cs4303.p4._util;

import lombok.AllArgsConstructor;

public final class Constants {
    public static final class Screen {
        public static final int width = 1000;
        public static final int height = 600;

        public static final int minWidth = 500;
        public static final int minHeight = 500;

        public static final class GamePlay {
            public static final int infoPanelHeight = 60;
        }

        public static final class Base {
            @AllArgsConstructor
            public static final class SectionHitbox {
                public final int x;
                public final int y;
                public final int width;
                public final int height;
            }

            public static final int padding = 10;

            public static final SectionHitbox storage = new SectionHitbox(
                    padding,
                    padding,
                    500,
                    height - 2 * padding);

            public static final SectionHitbox selection = new SectionHitbox(
                    storage.width + 2 * padding,
                    padding,
                    width - storage.width - 3 * padding,
                    height - 2 * padding);
        }
    }

    public static final float gravity = 2F;
    public static final float airResistance = 0.75F;

    public static final int TILE_SIZE = 40;
    public static final float moveIncrement = 1.3f;
    public static final float speedCap = 2f;

    public enum PLAYER {
        INSTANCE;
        public final float JUMP_IMPULSE = 90F;
        public final int MASS = 15;
    }

}
