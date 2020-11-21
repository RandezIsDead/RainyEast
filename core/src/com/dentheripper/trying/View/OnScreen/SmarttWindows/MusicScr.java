package com.dentheripper.trying.View.OnScreen.SmarttWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.GameCore.Assets;

import java.util.ArrayList;

public class MusicScr extends SmartBase {

    private static ExtraWindow extraWindow;
    private static final ButtonBase stopPlay = new ButtonBase("Atlas/smart.txt", "pause", 700, 128, 96, 59);
    private static final ButtonBase previousButton = new ButtonBase("Atlas/smart.txt", "previous", 808, 128, 96, 59);
    private static final ButtonBase nextButton = new ButtonBase("Atlas/smart.txt", "next", 910, 128, 90, 59);
    private static final ButtonBase daftPunk = new ButtonBase("Atlas/smart.txt", "Daft Punk - HBFS", "ms", 700, 188,  300, 89);
    private static final ButtonBase alive = new ButtonBase("Atlas/smart.txt", "Krewella - Alive", "ms", 700, 276, 300, 89);
    private static final ButtonBase liveNight = new ButtonBase("Atlas/smart.txt", "Krewella - Live for the Night", "ms",  700, 363,300, 89);
    private static final ButtonBase playHard = new ButtonBase("Atlas/smart.txt", "Krewella - Play Hard", "ms", 700, 450, 300, 89);
    private static final ButtonBase wao = new ButtonBase("Atlas/smart.txt", "Krewella - We Are One", "ms", 700, 537, 300, 89);
    private static final ButtonBase cagi = new ButtonBase("Atlas/smart.txt", "Krewella - Come And Get It", "ms", 700, 624, 300, 89);
    private static final ButtonBase yr = new ButtonBase("Atlas/smart.txt", "Joji - Yeah Right", "ms", 700, 711, 300, 89);
    private static final ButtonBase rolmob = new ButtonBase("Atlas/smart.txt", "Carpenter Brut - Roller Mobster", "ms", 700, 798, 300, 89);
    private static final ButtonBase stronger = new ButtonBase("Atlas/smart.txt", "Kanye West - Stronger", "ms", 700, 188,  300, 89);
    private static final ButtonBase redux = new ButtonBase("Atlas/smart.txt", "Killercats - Redux", "ms", 700, 276, 300, 89);
    private static final ButtonBase spkbx = new ButtonBase("Atlas/smart.txt", "Bassnectar - Speakerbox", "ms",  700, 363,300, 89);
    private static final ButtonBase dfy = new ButtonBase("Atlas/smart.txt", "BoomBoomSatellites - Dive for You", "ms", 700, 537, 300, 89);
    private static final ButtonBase pg = new ButtonBase("Atlas/smart.txt", "Deadmau5 - Professional Griefers", "ms", 700, 624, 300, 89);
    private static final ButtonBase frme = new ButtonBase("Atlas/smart.txt", "DFA1979 - Freeze Me", "ms", 700, 711, 300, 89);
    private static final ButtonBase hatt = new ButtonBase("Atlas/smart.txt", "Dual Core - Hack All The Things", "ms", 700, 450, 300, 89);
    private static final ButtonBase fireInside = new ButtonBase("Atlas/smart.txt", "Gemini - Fire Insight", "ms", 700, 798, 300, 89);
    private static final ButtonBase nightcall = new ButtonBase("Atlas/smart.txt", "Kavinsky - Nightcall", "ms", 700, 188,  300, 89);
    private static final ButtonBase nis = new ButtonBase("Atlas/smart.txt", "Lil Skies - Name In The Sand", "ms",  700, 363,300, 89);
    private static final ButtonBase cr = new ButtonBase("Atlas/smart.txt", "Linkin Park - Crawling", "ms", 700, 450, 300, 89);
    private static final ButtonBase nocase = new ButtonBase("Atlas/smart.txt", "Musked Intruder - No Case", "ms", 700, 537, 300, 89);
    private static final ButtonBase monster = new ButtonBase("Atlas/smart.txt", "Monster(DotEXE Remix)", "ms", 700, 624, 300, 89);
    private static final ButtonBase ahit = new ButtonBase("Atlas/smart.txt", "Phantom Sage - Crystal Clouds", "ms", 700, 276, 300, 89);
    private static final ButtonBase levitate = new ButtonBase("Atlas/smart.txt", "Twenty One Pilots - Levitate", "ms", 700, 711, 300, 89);
    private static final ButtonBase gns = new ButtonBase("Atlas/smart.txt", "Deadmau5 - GhostsNStuff", "ms", 700, 798, 300, 89);
    public static Music music;
    private boolean isPlaying = false;

    private final ArrayList<ButtonBase> musicButtonsOne = new ArrayList<>();
    private final ArrayList<ButtonBase> musicButtonsTwo = new ArrayList<>();
    private final ArrayList<ButtonBase> musicButtonsThree = new ArrayList<>();
    private int[] musicPages = new int[]{1, 0, 0};
    private final Skin skin;
    private final TextButton.TextButtonStyle smartButtonStyle;

    public MusicScr() {
        setImage(Assets.assetManager.get(Assets.smartUniversal));
        extraWindow = new ExtraWindow();
        extraWindow.setImage(Assets.assetManager.get(Assets.musicSelect), 700, 128, 300 ,763);
        music = Gdx.audio.newMusic(Gdx.files.internal("music/Daft Punk - HBFS.mp3"));
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("Atlas/smart.txt"));
        skin = new Skin();
        skin.addRegions(atlas);
        smartButtonStyle = new TextButton.TextButtonStyle();

        musicButtonsOne.add(daftPunk);
        musicButtonsOne.add(alive);
        musicButtonsOne.add(liveNight);
        musicButtonsOne.add(wao);
        musicButtonsOne.add(yr);
        musicButtonsOne.add(cagi);
        musicButtonsOne.add(playHard);
        musicButtonsOne.add(rolmob);

        musicButtonsTwo.add(stronger);
        musicButtonsTwo.add(redux);
        musicButtonsTwo.add(spkbx);
        musicButtonsTwo.add(hatt);
        musicButtonsTwo.add(dfy);
        musicButtonsTwo.add(pg);
        musicButtonsTwo.add(frme);
        musicButtonsTwo.add(fireInside);

        musicButtonsThree.add(nightcall);
        musicButtonsThree.add(ahit);
        musicButtonsThree.add(nis);
        musicButtonsThree.add(cr);
        musicButtonsThree.add(nocase);
        musicButtonsThree.add(monster);
        musicButtonsThree.add(levitate);
        musicButtonsThree.add(gns);
    }

    @Override
    public void close() {
        super.close();
        stage.addAction(Actions.removeActor(extraWindow));
        stage.addAction(Actions.removeActor(nextButton));
        stage.addAction(Actions.removeActor(previousButton));
        stage.addAction(Actions.removeActor(stopPlay));
        multiplexer.removeProcessor(previousButton.stage);
        multiplexer.removeProcessor(nextButton.stage);
        multiplexer.removeProcessor(stopPlay.stage);
        for (int i = 0; i < musicButtonsOne.size(); i++) {
            stage.addAction(Actions.removeActor(musicButtonsOne.get(i)));
            stage.addAction(Actions.removeActor(musicButtonsTwo.get(i)));
            stage.addAction(Actions.removeActor(musicButtonsThree.get(i)));
            multiplexer.removeProcessor(musicButtonsOne.get(i).stage);
            multiplexer.removeProcessor(musicButtonsTwo.get(i).stage);
            multiplexer.removeProcessor(musicButtonsThree.get(i).stage);
        }
    }

    @Override
    public void show() {
        super.show();
        stage.addActor(extraWindow);
        stage.addActor(previousButton);
        stage.addActor(nextButton);
        stage.addActor(stopPlay);
        multiplexer.addProcessor(previousButton.stage);
        multiplexer.addProcessor(nextButton.stage);
        multiplexer.addProcessor(stopPlay.stage);
        for (int i = 0; i < musicButtonsOne.size(); i++) {
            stage.addActor(musicButtonsOne.get(i));
            multiplexer.addProcessor(musicButtonsOne.get(i).stage);
        }
    }

    private void showFirstPage() {
        for (int i = 0; i < musicButtonsOne.size(); i++) {
            stage.addActor(musicButtonsOne.get(i));
            multiplexer.addProcessor(musicButtonsOne.get(i).stage);
        }
        for (int i = 0; i < musicButtonsTwo.size(); i++) {
            stage.addAction(Actions.removeActor(musicButtonsTwo.get(i)));
            multiplexer.removeProcessor(musicButtonsTwo.get(i).stage);
        }
        for (int i = 0; i < musicButtonsThree.size(); i++) {
            stage.addAction(Actions.removeActor(musicButtonsThree.get(i)));
            multiplexer.removeProcessor(musicButtonsThree.get(i).stage);
        }
    }

    private void showSecondPage() {
        for (int i = 0; i < musicButtonsOne.size(); i++) {
            stage.addAction(Actions.removeActor(musicButtonsOne.get(i)));
            multiplexer.removeProcessor(musicButtonsOne.get(i).stage);
        }
        for (int i = 0; i < musicButtonsTwo.size(); i++) {
            stage.addActor(musicButtonsTwo.get(i));
            multiplexer.addProcessor(musicButtonsTwo.get(i).stage);
        }
        for (int i = 0; i < musicButtonsThree.size(); i++) {
            stage.addAction(Actions.removeActor(musicButtonsThree.get(i)));
            multiplexer.removeProcessor(musicButtonsThree.get(i).stage);
        }
    }

    private void showThirdPage() {
        for (int i = 0; i < musicButtonsOne.size(); i++) {
            stage.addAction(Actions.removeActor(musicButtonsOne.get(i)));
            multiplexer.removeProcessor(musicButtonsOne.get(i).stage);
        }
        for (int i = 0; i < musicButtonsTwo.size(); i++) {
            stage.addAction(Actions.removeActor(musicButtonsTwo.get(i)));
            multiplexer.removeProcessor(musicButtonsTwo.get(i).stage);
        }
        for (int i = 0; i < musicButtonsThree.size(); i++) {
            stage.addActor(musicButtonsThree.get(i));
            multiplexer.addProcessor(musicButtonsThree.get(i).stage);
        }
    }

    private void setBgMusic(String path) {
        music = Gdx.audio.newMusic(Gdx.files.internal(path));
        music.setVolume(Assets.data.getFloat("musicVol"));
        music.play();
        music.setLooping(true);
    }

    public void musicRender(Home home) {
        if (home.music.isClicked()) {
            home.close();
            show();
            Gdx.input.setInputProcessor(this.multiplexer);
            home.music.setClicked(false);
        }
        if (back.isClicked()) {
            close();
            home.show();
            musicPages = new int[]{1, 0, 0};
            Gdx.input.setInputProcessor(home.multiplexer);
            back.setClicked(false);
        }
        if (homeS.isClicked()) {
            close();
            home.show();
            musicPages = new int[]{1, 0, 0};
            Gdx.input.setInputProcessor(home.multiplexer);
            homeS.setClicked(false);
        }
        if (previousButton.isClicked()) {
            System.out.println("Previous");
            if (musicPages[0] == 1) {
                previousButton.setClicked(false);
            }
            if (musicPages[1] == 1) {
                showFirstPage();
                musicPages[1] = 0;
                musicPages[0] = 1;
            }
            if (musicPages[2] == 1) {
                showSecondPage();
                musicPages[2] = 0;
                musicPages[1] = 1;
            }
            previousButton.setClicked(false);
        }
        if (nextButton.isClicked()) {
            System.out.println("Next");
            if (musicPages[2] == 1) {
                nextButton.setClicked(false);
            }
            if (musicPages[1] == 1) {
                showThirdPage();
                musicPages[1] = 0;
                musicPages[2] = 1;
            }
            if (musicPages[0] == 1) {
                showSecondPage();
                musicPages[0] = 0;
                musicPages[1] = 1;
            }
            nextButton.setClicked(false);
        }
        if (stopPlay.isClicked()) {
            if (isPlaying) {
                music.pause();
                setPlaying(false);
            } else {
                music.play();
                setPlaying(true);
            }
            stopPlay.setClicked(false);
        }
        if (isPlaying) {
            smartButtonStyle.up = skin.getDrawable("pause");
            stopPlay.button.setStyle(smartButtonStyle);
        }
        if (!isPlaying) {
            smartButtonStyle.up = skin.getDrawable("play");
            smartButtonStyle.font = new BitmapFont();
            stopPlay.button.setStyle(smartButtonStyle);
        }
        if (daftPunk.isClicked()) {
            music.dispose();
            setBgMusic("music/Daft Punk - HBFS.mp3");
            daftPunk.setClicked(false);
            setPlaying(true);
        }
        if (alive.isClicked()) {
            music.dispose();
            setBgMusic("music/Krewella - Alive.mp3");
            alive.setClicked(false);
            setPlaying(true);
        }
        if (liveNight.isClicked()) {
            music.dispose();
            setBgMusic("music/Krewella - Live for the Night.mp3");
            liveNight.setClicked(false);
            setPlaying(true);
        }
        if (playHard.isClicked()) {
            music.dispose();
            setBgMusic("music/Krewella - Play Hard.mp3");
            playHard.setClicked(false);
            setPlaying(true);
        }
        if (wao.isClicked()) {
            music.dispose();
            setBgMusic("music/Krewella - We Are One.mp3");
            wao.setClicked(false);
            setPlaying(true);
        }
        if (cagi.isClicked()) {
            music.dispose();
            setBgMusic("music/Krewella Come And Get It.mp3");
            cagi.setClicked(false);
            setPlaying(true);
        }
        if (yr.isClicked()) {
            music.dispose();
            setBgMusic("music/yeah_right.mp3");
            yr.setClicked(false);
            setPlaying(true);
        }
        if (rolmob.isClicked()) {
            music.dispose();
            setBgMusic("music/roller_mobster.mp3");
            rolmob.setClicked(false);
            setPlaying(true);
        }
        if (nocase.isClicked()) {
            music.dispose();
            setBgMusic("music/MaskedIntruder-NoCase.mp3");
            nocase.setClicked(false);
            setPlaying(true);
        }
        if (hatt.isClicked()) {
            music.dispose();
            setBgMusic("music/DualCore-HackAllTheThings.mp3");
            hatt.setClicked(false);
            setPlaying(true);
        }
        if (cr.isClicked()) {
            music.dispose();
            setBgMusic("music/LinkinPark-Crawling.mp3");
            cr.setClicked(false);
            setPlaying(true);
        }
        if (spkbx.isClicked()) {
            music.dispose();
            setBgMusic("music/Bassnectar-Speakerbox.mp3");
            spkbx.setClicked(false);
            setPlaying(true);
        }
        if (dfy.isClicked()) {
            music.dispose();
            setBgMusic("music/BoomBoomSatellites-DiveforYou.mp3");
            dfy.setClicked(false);
            setPlaying(true);
        }
        if (pg.isClicked()) {
            music.dispose();
            setBgMusic("music/Deadmau5-ProfessionalGriefers.mp3");
            pg.setClicked(false);
            setPlaying(true);
        }
        if (gns.isClicked()) {
            music.dispose();
            setBgMusic("music/Deadmau5_feat._Rob_Swire_-_Ghosts_n_Stuff.mp3");
            gns.setClicked(false);
            setPlaying(true);
        }
        if (frme.isClicked()) {
            music.dispose();
            setBgMusic("music/DeathFromAbove1979-FreezeMe.mp3");
            frme.setClicked(false);
            setPlaying(true);
        }
        if (fireInside.isClicked()) {
            music.dispose();
            setBgMusic("music/Gemini-FireInside.mp3");
            fireInside.setClicked(false);
            setPlaying(true);
        }
        if (nis.isClicked()) {
            music.dispose();
            setBgMusic("music/LilSkies-NameintheSand.mp3");
            nis.setClicked(false);
            setPlaying(true);
        }
        if (monster.isClicked()) {
            music.dispose();
            setBgMusic("music/meg-dia-monster.mp3");
            monster.setClicked(false);
            setPlaying(true);
        }
        if (ahit.isClicked()) {
            music.dispose();
            setBgMusic("music/Phantom Sage - Crystal Clouds.mp3");
            ahit.setClicked(false);
            setPlaying(true);
        }
        if (levitate.isClicked()) {
            music.dispose();
            setBgMusic("music/twenty-one-pilots-levitate.mp3");
            levitate.setClicked(false);
            setPlaying(true);
        }
        if (redux.isClicked()) {
            music.dispose();
            setBgMusic("music/Killercats - Redux.mp3");
            redux.setClicked(false);
            setPlaying(true);
        }
        if (stronger.isClicked()) {
            music.dispose();
            setBgMusic("music/Kanye West - Stronger.mp3");
            stronger.setClicked(false);
            setPlaying(true);
        }
        if (nightcall.isClicked()) {
            music.dispose();
            setBgMusic("music/Kavinsky-Nightcall.mp3");
            nightcall.setClicked(false);
            setPlaying(true);
        }
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
