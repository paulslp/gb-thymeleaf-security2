package ru.gb.gbthymeleafwinter.entity.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "AUTHORITY")
public class Authority implements GrantedAuthority {

    static final long serialVersionUID = -2324313849087772823L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permission")
    private String permission;

    @ManyToMany(mappedBy = "authorities")
    private Set<AccountRole> roles;

    @Override
    public String getAuthority() {
        return this.permission;
    }
}
