package com.ars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "register_admin")
public class Admin extends User{
    @Column(name = "admin_Name",length = 50)
	private String AName;
    @Column(length = 100)
	private String email;
}
