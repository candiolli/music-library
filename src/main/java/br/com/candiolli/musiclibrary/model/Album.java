package br.com.candiolli.musiclibrary.model;

import lombok.Data;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;

@Audited
@Entity
@Table
@AuditTable(value = "album_audit")
@Data
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "productor_id", nullable = false)
    @RestResource(exported = false)
    private Productor productor;

    @Column(name = "dt_create", nullable = false)
    private String dateCreate;

}
