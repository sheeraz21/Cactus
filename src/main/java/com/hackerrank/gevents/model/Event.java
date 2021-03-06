package com.hackerrank.gevents.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@Column(name = "type")
    private String type;
	@Column(name = "isPublic")
    private Boolean isPublic;
	@Column(name = "repoId")
    private Integer repoId;
	@Column(name = "actorId")
    private Integer actorId;

    public Event() {

    }

    public Event(Integer id, String type, Boolean isPublic, Integer repoId, Integer actorId) {
        this.id = id;
        this.type = type;
        this.isPublic = isPublic;
        this.repoId = repoId;
        this.actorId = actorId;
    }

    public Event(String type, Boolean isPublic, Integer repoId, Integer actorId) {
        this.type = type;
        this.isPublic = isPublic;
        this.repoId = repoId;
        this.actorId = actorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getRepoId() {
        return repoId;
    }

    public void setRepoId(Integer repoId) {
        this.repoId = repoId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
}
