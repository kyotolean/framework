package org.example.lab6.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "socialmedia")
@NoArgsConstructor
public class SocialMedia implements Serializable {
    public SocialMedia(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "socialMedia")
    private List<PersonEntity> personEntity;
}
