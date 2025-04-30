package com.allbadgi.rjugo.repository;

import com.allbadgi.rjugo.entity.Policy;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository
        extends JpaRepository<Policy, Long>, JpaSpecificationExecutor<Policy> {
}
