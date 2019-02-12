package br.com.candiolli.musiclibrary.model;

import br.com.candiolli.musiclibrary.util.JsonDateDeserializer;
import br.com.candiolli.musiclibrary.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

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
@AuditTable(value = "music_audit")
@Data
public class Music implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column(name = "time_duration")
    private Double timeDuration;

    @Column(name = "dt_create")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private LocalDateTime dateCreate;

    @ManyToOne
    @JoinColumn(name = "music_id", nullable = false)
    private Album album;

}
