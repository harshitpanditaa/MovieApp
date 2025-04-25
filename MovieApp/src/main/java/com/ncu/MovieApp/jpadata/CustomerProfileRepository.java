package com.ncu.MovieApp.jpadata;

import com.ncu.MovieApp.jpadata.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {

    List<CustomerProfile> findByLocation(String location);

    List<CustomerProfile> findByFullNameContaining(String keyword);

    @Query("SELECT c FROM CustomerProfile c WHERE c.email LIKE %:domain%")
    List<CustomerProfile> findByEmailDomain(@Param("domain") String domain);
}