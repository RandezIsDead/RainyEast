package com.dentheripper.trying.View.OnScreen;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.Browser;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.Chat;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.Chips;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.FAQ;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.GameInventory;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.Home;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.MapOfEnvironment;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.MusicScr;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.Passport;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.Settings;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.Skills;
import com.dentheripper.trying.View.OnScreen.SmarttWindows.Weapons;

public class SmartRender {

    public static Home home = new Home();
    public static Passport passport = new Passport();
    public static Browser browser = new Browser();
    public static Settings settings = new Settings();
    public static MusicScr musicScr = new MusicScr();
    public static MapOfEnvironment moenv = new MapOfEnvironment();
    public static Skills skills = new Skills();
    public Chips chips = new Chips();
    public GameInventory gameInventory = new GameInventory();
    public static FAQ faq = new FAQ();
    public static Weapons weapons = new Weapons();
    public static Chat chat = new Chat();

    public void multiplexSmartScreens(InputMultiplexer multiplexer) {
        multiplexer.addProcessor(home.multiplexer);
        multiplexer.addProcessor(passport.multiplexer);
        multiplexer.addProcessor(settings.multiplexer);
        multiplexer.addProcessor(moenv.multiplexer);
        multiplexer.addProcessor(browser.multiplexer);
        multiplexer.addProcessor(musicScr.multiplexer);
        multiplexer.addProcessor(skills.multiplexer);
        multiplexer.addProcessor(chips.multiplexer);
        multiplexer.addProcessor(gameInventory.multiplexer);
        multiplexer.addProcessor(faq.multiplexer);
        multiplexer.addProcessor(weapons.multiplexer);
        multiplexer.addProcessor(chat.multiplexer);
    }

    public void addToStage(Stage stage) {
        stage.addActor(home);
        stage.addActor(passport);
        stage.addActor(settings);
        stage.addActor(moenv);
        stage.addActor(browser);
        stage.addActor(musicScr);
        stage.addActor(skills);
        stage.addActor(chips);
        stage.addActor(gameInventory);
        stage.addActor(faq);
        stage.addActor(chat);
        stage.addActor(weapons);
    }

    public void close() {
        home.close();
        passport.close();
        settings.close();
        moenv.close();
        browser.close();
        musicScr.close();
        skills.close();
        chips.close();
        gameInventory.close();
        faq.close();
        chat.close();
        weapons.close();
    }

    public void renderThis(InputMultiplexer multiplexer, Engine engine) {
        home.smartphoneRender(multiplexer);
        settings.settingsRender(home, engine);
        moenv.moenvRender(home);
        passport.statsRender(home);
        browser.browserRender(home);
        musicScr.musicRender(home);
        gameInventory.invRender(home);
        chips.chipsRender(home);
        skills.skillsRender(home);
        chat.chatRender(home);
        weapons.wpnRender(home);
        faq.faqRender(home);
    }
}
