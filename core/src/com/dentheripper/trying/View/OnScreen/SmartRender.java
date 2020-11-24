package com.dentheripper.trying.View.OnScreen;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.View.OnScreen.SmartWindows.Browser;
import com.dentheripper.trying.View.OnScreen.SmartWindows.Chat;
import com.dentheripper.trying.View.OnScreen.SmartWindows.Chips;
import com.dentheripper.trying.View.OnScreen.SmartWindows.FAQ;
import com.dentheripper.trying.View.OnScreen.SmartWindows.GameInventory;
import com.dentheripper.trying.View.OnScreen.SmartWindows.Home;
import com.dentheripper.trying.View.OnScreen.SmartWindows.MapOfEnvironment;
import com.dentheripper.trying.View.OnScreen.SmartWindows.MusicScr;
import com.dentheripper.trying.View.OnScreen.SmartWindows.Passport;
import com.dentheripper.trying.View.OnScreen.SmartWindows.Settings;
import com.dentheripper.trying.View.OnScreen.SmartWindows.Weapons;

public class SmartRender {

    public Home home;
    public Passport passport;
    public Browser browser;
    public Settings settings;
    public MusicScr musicScr;
    public MapOfEnvironment moenv;
    //    public Skills skills;
    public Chips chips;
    public GameInventory gameInventory;
    public FAQ faq;
    public Weapons weapons;
    public Chat chat;

    public SmartRender(Stage stage) {
        home = new Home(stage);
        passport = new Passport(stage);
        browser = new Browser(stage);
        settings = new Settings(stage);
        musicScr = new MusicScr(stage);
        moenv = new MapOfEnvironment(stage);
//        skills = new Skills(stage);
        chips = new Chips(stage);
        gameInventory = new GameInventory(stage);
        faq = new FAQ(stage);
        weapons = new Weapons(stage);
        chat = new Chat(stage);
    }

    public void multiplexSmartScreens(InputMultiplexer multiplexer) {
        multiplexer.addProcessor(home.multiplexer);
        multiplexer.addProcessor(passport.multiplexer);
        multiplexer.addProcessor(settings.multiplexer);
        multiplexer.addProcessor(moenv.multiplexer);
        multiplexer.addProcessor(browser.multiplexer);
        multiplexer.addProcessor(musicScr.multiplexer);
//        multiplexer.addProcessor(skills.multiplexer);
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
//        stage.addActor(skills);
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
//        skills.close();
        chips.close();
        gameInventory.close();
        faq.close();
        chat.close();
        weapons.close();
    }

    public void renderThis(InputMultiplexer multiplexer, Engine engine) {
        home.smartphoneRender(multiplexer);
        settings.settingsRender(home, engine, passport, musicScr);
        moenv.moenvRender(home, passport);
        passport.statsRender(home);
        browser.browserRender(home, passport);
        musicScr.musicRender(home, passport);
        gameInventory.invRender(home, passport);
        chips.chipsRender(home, passport);
//        skills.skillsRender(home, passport);
        chat.chatRender(home, passport);
        weapons.wpnRender(home, passport);
        faq.faqRender(home, passport);
    }
}
