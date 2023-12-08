package org.example.lab17.entities.card;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Card {
    private String id;
    private Badges badges;
    private ArrayList<Object> checkItemStates;
    private Boolean closed;
    private Boolean dueComplete;
    private Date dateLastActivity;
    private String desc;
    private DescData descData;
    private Object due;
    private Object dueReminder;
    private Object email;
    private String idBoard;
    private ArrayList<Object> idChecklists;
    private String idList;
    private ArrayList<Object> idMembers;
    private ArrayList<Object> idMembersVoted;
    private Integer idShort;
    private Object idAttachmentCover;
    private ArrayList<Object> labels;
    private ArrayList<Object> idLabels;
    private Boolean manualCoverAttachment;
    private String name;
    private Integer pos;
    private String shortLink;
    private String shortUrl;
    private Object start;
    private Boolean subscribed;
    private String url;
    private Cover cover;
    private Boolean isTemplate;
    private Object cardRole;
    private ArrayList<Object> attachments;
    private ArrayList<Object> stickers;
    private Limits limits;
}
