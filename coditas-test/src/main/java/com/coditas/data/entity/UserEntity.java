package com.coditas.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user" )
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;

    @Column(name="name", length=80)
    private String     name         ;

    @Column(name="email", nullable=false, length=50)
    private String     email        ;

    @Column(name="password", length=40)
    private String     password     ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date       createTime   ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_time")
    private Date       updateTime   ;

    @OneToMany(mappedBy="user", targetEntity=NoteEntity.class)
    private List<NoteEntity> listOfNote  ;

    public UserEntity() {
		super();
    }


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public List<NoteEntity> getListOfNote() {
		return listOfNote;
	}


	public void setListOfNote(List<NoteEntity> listOfNote) {
		this.listOfNote = listOfNote;
	}
    
   

}
