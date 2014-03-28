package com.me.the_hoppening;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class TexturePacker {
    public static void main (String[] args) throws Exception {
    	TexturePacker2.process("assets/unpacked/bunny/", "assets/", "basedBunny");
    	TexturePacker2.process("assets/unpacked/bunny/", "../The_Hoppening-desktop/assets/data/", "basedBunny");
    	TexturePacker2.process("assets/unpacked/bunny/", "../The_Hoppening-android/assets/data/", "basedBunny");
    	TexturePacker2.process("assets/unpacked/mutantbunny/", "assets/", "basedMutantBunny");
    	TexturePacker2.process("assets/unpacked/mutantbunny/", "../The_Hoppening-desktop/assets/data/", "basedMutantBunny");
    	TexturePacker2.process("assets/unpacked/mutantbunny/", "../The_Hoppening-android/assets/data/", "basedMutantBunny");

    }
}
