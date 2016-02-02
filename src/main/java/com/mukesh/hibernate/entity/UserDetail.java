package com.mukesh.hibernate.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private Date joinedDate;
    private String description;

    @ElementCollection
    @JoinTable(name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID"))

    @GenericGenerator(name="sequence-gen",strategy="sequence")
    @CollectionId(columns = {@Column(name="ADRESS_ID")},generator = "sequence-gen",type = @Type(type = "long"))
    private Collection<Address> listOfAddress = new ArrayList<Address>();

    public Collection<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Collection<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

    @Embedded
    /*@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
			@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PIN"))

	})*/
    //private Address home_address;

    //@Embedded
    //private Address office_address;
    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
