package ru.stqa.pft.mantis.appmanager;

import org.subethamail.wiser.Wiser;

/**
 * Created by Sergey on 12.04.2017.
 */
public class MailHelper {
    private  ApplicationManager app;
    private final Wiser wiser;

    public MailHelper(ApplicationManager app){
        this.app = app;
        wiser = new Wiser();
    }

}
