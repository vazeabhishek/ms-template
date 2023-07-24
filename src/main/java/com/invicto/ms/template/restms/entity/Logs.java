package com.invicto.ms.template.restms.entity;

import  javax.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "LOGS")
public class Logs{

    @Id
    public String id;
    public String api;
    @JsonIgnore
    public LocalDateTime localDateTime;




}