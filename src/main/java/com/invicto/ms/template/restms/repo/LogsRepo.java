package com.invicto.ms.template.restms.repo;

import org.springframework.data.repository.CrudRepository;
import com.invicto.ms.template.restms.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepo extends CrudRepository<Logs,String>{

}