package com.anhngo.shopthueaccanhngo.services;

import com.anhngo.shopthueaccanhngo.entities.Download;
import com.anhngo.shopthueaccanhngo.repositories.DownloadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownloadService {
    @Autowired
    private DownloadRepo downloadRepo;

    public List<Download> findAllByGameDetailsId(String id) {
        return downloadRepo.findAllByGameDetailsId(id);
    }
}
