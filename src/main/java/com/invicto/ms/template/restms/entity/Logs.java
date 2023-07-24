package com.invicto.ms.template.restms.entity;

import  javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOGS")
public class Logs{

    @Id
    public String id;
    public String api;
    public LocalDateTime localDateTime;




}