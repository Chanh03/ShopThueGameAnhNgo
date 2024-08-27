package com.anhngo.shopthueaccanhngo.repositories;

import com.anhngo.shopthueaccanhngo.entities.Download;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DownloadRepo extends JpaRepository<Download, Long> {
    @Query("SELECT d FROM Download d WHERE d.gameDetail.id  = :id")
    List<Download> findAllByGameDetailsId(String id);
}
