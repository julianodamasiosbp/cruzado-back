package br.com.acme.cruzado.domain.model;

import br.com.acme.cruzado.domain.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = false)
    private RoleName roleName;

}
