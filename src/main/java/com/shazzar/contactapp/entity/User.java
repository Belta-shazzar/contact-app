package com.shazzar.contactapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotBlank(message = "Name field cannot be blank")
    @Size(min = 3, max = 30)
    private String userName;

//    @Pattern()
    @NotNull(message = "field cannot be blank")
    @Column(unique = true)
    private String mobileNumber;

//    @Pattern()
    @NotNull(message = "Enter password")
    private String password;

//    @Pattern()
    @Transient
    @NotNull
    private String passwordVerify;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Contact> contact;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
