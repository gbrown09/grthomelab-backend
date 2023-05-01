package com.grthomelab.backend.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.grthomelab.backend.models.BanModel;
import com.grthomelab.backend.repositories.BanRepository;

@Service
public class BanService {
    private final BanRepository banRepository;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public BanService(BanRepository banRepository) {
        this.banRepository = banRepository;
    }

    public List<BanModel> getAllBans() {
        LOG.info("Getting All Bans");
        return this.banRepository.findAll();
    }

}
