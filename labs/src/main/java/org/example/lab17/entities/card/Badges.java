package org.example.lab17.entities.card;

import lombok.Data;

@Data
public class Badges {
    public AttachmentsByType attachmentsByType;
    public Boolean location;
    public Integer votes;
    public Boolean viewingMemberVoted;
    public Boolean subscribed;
    public String fogbugz;
    public Integer checkItems;
    public Integer checkItemsChecked;
    public Object checkItemsEarliestDue;
    public Integer comments;
    public Integer attachments;
    public Boolean description;
    public Object due;
    public Boolean dueComplete;
    public Object start;
}
