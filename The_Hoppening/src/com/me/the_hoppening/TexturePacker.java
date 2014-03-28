package com.me.the_hoppening;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class TexturePacker {
    public static void main (String[] args) throws Exception {
    	TexturePacker2.process("assets/unpacked/bunny/", "assets/", "basedBunny");
    	TexturePacker2.process("assets/unpacked/bunny/", "../The_Hoppening-desktop/assets/data/", "basedBunny");
    	TexturePacker2.process("assets/unpacked/bunny/", "../The_Hoppening-android/assets/data/", "basedBunny");

    	TexturePacker2.process("assets/unpacked/bird/", "assets/", "basedbird");
    	TexturePacker2.process("assets/unpacked/bird/", "../The_Hoppening-desktop/assets/data/", "basedbird");
    	TexturePacker2.process("assets/unpacked/bird/", "../The_Hoppening-android/assets/data/", "basedbird");

    	TexturePacker2.process("assets/unpacked/projectile/", "assets/", "basedprojectile");
    	TexturePacker2.process("assets/unpacked/projectile/", "../The_Hoppening-desktop/assets/data/", "basedprojectile");
    	TexturePacker2.process("assets/unpacked/projectile/", "../The_Hoppening-android/assets/data/", "basedprojectile");


    }
}
