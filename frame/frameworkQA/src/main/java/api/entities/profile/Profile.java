package api.entities.profile;

import lombok.Data;

import java.util.Date;

@Data
public class Profile {
    private String login;
    private Integer id;
    private String node_id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private Boolean site_admin;
    private String name;
    private Object company;
    private String blog;
    private Object location;
    private Object email;
    private Object hireable;
    private String bio;
    private Object twitter_username;
    private Integer public_repos;
    private Integer public_gists;
    private Integer followers;
    private Integer following;
    private Date created_at;
    private Date updated_at;
    private Integer private_gists;
    private Integer total_private_repos;
    private Integer owned_private_repos;
    private Integer disk_usage;
    private Integer collaborators;
    private Boolean two_factor_authentication;
    private Plan plan;
}
