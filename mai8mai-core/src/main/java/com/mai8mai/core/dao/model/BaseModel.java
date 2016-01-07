package com.mai8mai.core.dao.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseModel implements Serializable {

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 1L;
    /**
     * @Fields id :
     */
    private Long id;

    @Id
    @Column(name = "id", length = 40)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
