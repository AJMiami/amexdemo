package com.amex.accountservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.amex.accountservice.entity.AccountEntity;

/**
 * The Class AccountRepos implements crudrepository will handle basic CRUD operations
 * @author ajits
 *
 */
public interface AccountInfoRepository extends CrudRepository<AccountEntity, Long>{

}
