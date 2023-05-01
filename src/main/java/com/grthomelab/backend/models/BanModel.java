package com.grthomelab.backend.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Document("bans")
public class BanModel {
    private String user;

    private int multiplier;

    private int totalLifetime;

    private boolean pocketBan;

    private boolean oneTime;

}
