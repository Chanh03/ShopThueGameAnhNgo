package com.anhngo.shopthueaccanhngo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class AuthorityId implements java.io.Serializable {
    private static final long serialVersionUID = 1270460468330820824L;
    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Column(name = "Authority", nullable = false, length = 50)
    private String authority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AuthorityId entity = (AuthorityId) o;
        return Objects.equals(this.authority, entity.authority) &&
                Objects.equals(this.username, entity.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority, username);
    }

}