package br.com.candiolli.musiclibrary.model;

import br.com.candiolli.musiclibrary.util.JsonDateDeserializer;
import br.com.candiolli.musiclibrary.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
import java.time.LocalDateTime;

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

    @JsonFormat(pattern = "YYYY-MM-dd")
    @Column(name = "dt_create", nullable = false)
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private LocalDateTime dateCreate;

}
