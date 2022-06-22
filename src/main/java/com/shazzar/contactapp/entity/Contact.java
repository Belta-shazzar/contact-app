package com.shazzar.contactapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "field cannot be blank")
    @Size(min = 3, max = 15)
    private String contactName;

    @Pattern(regexp = "(0)?[7-9](0|1)[0-9]{8}")
    @NotBlank(message = "field cannot be blank")
    private String mobileNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "User_id", referencedColumnName = "id")
    private User user;

    public Contact(String contactName, String mobileNumber) {
        this.contactName = contactName;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Contact contact = (Contact) o;
        return id != null && Objects.equals(id, contact.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
