package br.com.candiolli.musiclibrary.model;

import lombok.Data;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Audited
@Entity
@Table
@AuditTable(value = "music_audit")
@Data
public class Music implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "time_duration", nullable = false)
    private Double timeDuration;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "album_id", nullable = false)
    @RestResource(exported = false)
    private Album album;

}
