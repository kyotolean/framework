package org.example.lab17.entities.board;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Prefs{
    private String permissionLevel;
    private Boolean hideVotes;
    private String voting;
    private String comments;
    private String invitations;
    private Boolean selfJoin;
    private Boolean cardCovers;
    private Boolean isTemplate;
    private String cardAging;
    private Boolean calendarFeedEnabled;
    private ArrayList<Object> hiddenPluginBoardButtons;
    private ArrayList<SwitcherView> switcherViews;
    private String background;
    private String backgroundColor;
    private Object backgroundImage;
    private Boolean backgroundTile;
    private String backgroundBrightness;
    private Object backgroundImageScaled;
    private String backgroundBottomColor;
    private String backgroundTopColor;
    private Boolean canBePublic;
    private Boolean canBeEnterprise;
    private Boolean canBeOrg;
    private Boolean canBePrivate;
    private Boolean canInvite;
}
