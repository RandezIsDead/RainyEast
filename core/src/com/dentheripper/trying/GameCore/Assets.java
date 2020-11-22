package com.dentheripper.trying.GameCore;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public static AssetManager assetManager = new AssetManager();
    public static Data data = new Data();

    public static final AssetDescriptor<Texture> controller = new AssetDescriptor<>("elements/controller.png", Texture.class);
    public static final AssetDescriptor<Texture> gameMap = new AssetDescriptor<>("screenAssets/map.png", Texture.class);
    public static final AssetDescriptor<Texture> flat = new AssetDescriptor<>("screenAssets/flat.png", Texture.class);
    public static final AssetDescriptor<Texture> playerRun = new AssetDescriptor<>("playerAssets/zeroMovement/playerRun.png", Texture.class);
    public static final AssetDescriptor<Texture> playerRunRev = new AssetDescriptor<>("playerAssets/zeroMovement/playerRunRev.png", Texture.class);
    public static final AssetDescriptor<Texture> playerStand = new AssetDescriptor<>("playerAssets/zeroMovement/playerStand.png", Texture.class);

    public static final AssetDescriptor<Texture> smartUniversal = new AssetDescriptor<>("smart/smartUniversal.png", Texture.class);
    public static final AssetDescriptor<Texture> musicSelect = new AssetDescriptor<>("smart/musicSelect.png", Texture.class);
    public static final AssetDescriptor<Texture> smartPass = new AssetDescriptor<>("smart/pass.png", Texture.class);
    public static final AssetDescriptor<Texture> smartphone = new AssetDescriptor<>("smart/smartphone.png", Texture.class);
    public static final AssetDescriptor<Texture> invExt = new AssetDescriptor<>("smart/invExt.png", Texture.class);
    public static final AssetDescriptor<Texture> comingSoon = new AssetDescriptor<>("smart/comingSoon.png", Texture.class);
    public static final AssetDescriptor<Texture> descWindow = new AssetDescriptor<>("smart/descriptionWindow.png", Texture.class);
    public static final AssetDescriptor<Texture> exception = new AssetDescriptor<>("smart/exception.png", Texture.class);
    public static final AssetDescriptor<Texture> smartGrid = new AssetDescriptor<>("smart/grid.png", Texture.class);
    public static final AssetDescriptor<Texture> batteryChips = new AssetDescriptor<>("smart/batteryChips.png", Texture.class);
    public static final AssetDescriptor<Texture> tabletSkill = new AssetDescriptor<>("smart/tablet_skill.png", Texture.class);
    public static final AssetDescriptor<Texture> branch1 = new AssetDescriptor<>("smart/skillBranches/branch1.png", Texture.class);
    public static final AssetDescriptor<Texture> branch2 = new AssetDescriptor<>("smart/skillBranches/branch2.png", Texture.class);
    public static final AssetDescriptor<Texture> branch3 = new AssetDescriptor<>("smart/skillBranches/branch3.png", Texture.class);
    public static final AssetDescriptor<Texture> branch4 = new AssetDescriptor<>("smart/skillBranches/branch4.png", Texture.class);
    public static final AssetDescriptor<Texture> shop1 = new AssetDescriptor<>("shop/shop1.png", Texture.class);
    public static final AssetDescriptor<Texture> white = new AssetDescriptor<>("smart/map.png", Texture.class);

//    public static final AssetDescriptor<Music> hbfs = new AssetDescriptor<>("music/Daft Punk - HBFS.mp3", Music.class);
//    public static final AssetDescriptor<Music> alive = new AssetDescriptor<>("music/Krewella - Alive.mp3", Music.class);
//    public static final AssetDescriptor<Music> lftn = new AssetDescriptor<>("music/Krewella - Live for the Night.mp3", Music.class);
//    public static final AssetDescriptor<Music> ph = new AssetDescriptor<>("music/Krewella - Play Hard.mp3", Music.class);
//    public static final AssetDescriptor<Music> wao = new AssetDescriptor<>("music/Krewella - We Are One.mp3", Music.class);
//    public static final AssetDescriptor<Music> cagi = new AssetDescriptor<>("music/Krewella Come And Get It.mp3", Music.class);
//    public static final AssetDescriptor<Music> rm = new AssetDescriptor<>("music/roller_mobster.mp3", Music.class);
//    public static final AssetDescriptor<Music> redux = new AssetDescriptor<>("music/Killercats - Redux.mp3", Music.class);
//    public static final AssetDescriptor<Music> stronger = new AssetDescriptor<>("music/Kanye West - Stronger.mp3", Music.class);
//    public static final AssetDescriptor<Music> yr = new AssetDescriptor<>("music/yeah_right.mp3", Music.class);
//    public static final AssetDescriptor<Music> nightcall = new AssetDescriptor<>("music/Kavinsky-Nightcall.mp3", Music.class);
//    public static final AssetDescriptor<Music> ahit = new AssetDescriptor<>("music/P.A.T-A Hat in Time.mp3", Music.class);
//    public static final AssetDescriptor<Music> nocase = new AssetDescriptor<>("music/MaskedIntruder-NoCase.mp3", Music.class);
//    public static final AssetDescriptor<Music> hatt = new AssetDescriptor<>("music/DualCore-HackAllTheThings.mp3", Music.class);
//    public static final AssetDescriptor<Music> cr = new AssetDescriptor<>("music/LinkinPark-Crawling.mp3", Music.class);
//    public static final AssetDescriptor<Music> sb = new AssetDescriptor<>("music/Bassnectar-Speakerbox.mp3", Music.class);
//    public static final AssetDescriptor<Music> dfy = new AssetDescriptor<>("music/BoomBoomSatellites-DiveforYou.mp3", Music.class);
//    public static final AssetDescriptor<Music> pg = new AssetDescriptor<>("music/Deadmau5-ProfessionalGriefers.mp3", Music.class);
//    public static final AssetDescriptor<Music> gns = new AssetDescriptor<>("music/Deadmau5_feat._Rob_Swire_-_Ghosts_n_Stuff.mp3", Music.class);
//    public static final AssetDescriptor<Music> frme = new AssetDescriptor<>("music/DeathFromAbove1979-FreezeMe.mp3", Music.class);
//    public static final AssetDescriptor<Music> fire = new AssetDescriptor<>("music/Gemini-FireInside.mp3", Music.class);
//    public static final AssetDescriptor<Music> nis = new AssetDescriptor<>("music/LilSkies-NameintheSand.mp3", Music.class);
//    public static final AssetDescriptor<Music> monster = new AssetDescriptor<>("music/meg-dia-monster.mp3", Music.class);
//    public static final AssetDescriptor<Music> levitate = new AssetDescriptor<>("music/twenty-one-pilots-levitate.mp3", Music.class);

    public static void load() {
//        assetManager.load(hbfs);
//        assetManager.load(alive);
//        assetManager.load(lftn);
//        assetManager.load(ph);
//        assetManager.load(wao);
//        assetManager.load(cagi);
//        assetManager.load(rm);
//        assetManager.load(redux);
//        assetManager.load(stronger);
//        assetManager.load(yr);
//        assetManager.load(nightcall);
//        assetManager.load(nis);
//        assetManager.load(fire);
//        assetManager.load(ahit);
//        assetManager.load(nocase);
//        assetManager.load(levitate);
//        assetManager.load(monster);
//        assetManager.load(gns);
//        assetManager.load(pg);
//        assetManager.load(hatt);
//        assetManager.load(cr);
//        assetManager.load(sb);
//        assetManager.load(dfy);
//        assetManager.load(frme);

        assetManager.load(controller);
        assetManager.load(gameMap);
        assetManager.load(flat);
        assetManager.load(smartUniversal);
        assetManager.load(musicSelect);
        assetManager.load(smartPass);
        assetManager.load(smartphone);
        assetManager.load(descWindow);
        assetManager.load(invExt);
        assetManager.load(comingSoon);
        assetManager.load(exception);
        assetManager.load(smartGrid);
        assetManager.load(batteryChips);
        assetManager.load(tabletSkill);
        assetManager.load(branch1);
        assetManager.load(branch2);
        assetManager.load(branch3);
        assetManager.load(branch4);
        assetManager.load(shop1);
        assetManager.load(white);

        assetManager.load(playerRun);
        assetManager.load(playerRunRev);
        assetManager.load(playerStand);
    }

    public static void dispose() {
        assetManager.dispose();
    }
}
