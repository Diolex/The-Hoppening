package com.me.the_hoppening;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class TexturePacker {
    public static void main (String[] args) throws Exception {
        TexturePacker2.process("assets/unpacked/", "assets/", "basedBunny");
    }
}
