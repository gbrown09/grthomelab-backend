package com.grthomelab.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grthomelab.backend.models.BanModel;
import com.grthomelab.backend.services.BanService;

@RestController
@RequestMapping(value = "/bans")
public class BanController {
    private final BanService banService;

    public BanController(BanService banService) {
        this.banService = banService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<BanModel> getAllBans() {
        return this.banService.getAllBans();
    }

}
