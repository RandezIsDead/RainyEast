package com.dentheripper.trying.View.OnScreen;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.Browser;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.Chat;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.Chips;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.FAQ;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.GameInventory;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.Home;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.MapOfEnvironment;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.MusicScr;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.Passport;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.Settings;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.Skills;
import com.dentheripper.trying.View.OnScreen.Tablet.Windows.Weapons;

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
