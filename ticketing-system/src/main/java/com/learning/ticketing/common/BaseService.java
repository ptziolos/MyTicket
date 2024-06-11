package com.learning.ticketing.common;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public abstract class BaseService<T extends BaseEntity> {
  public abstract JpaRepository<T, Long> getRepository();

  @SafeVarargs
  public final List<T> createAll(final T... items) {
    return createAll(Arrays.asList(items));
  }

  public List<T> createAll(final List<T> items) {
    return getRepository().saveAll(items);
  }

  public T create(final T item) {
    return getRepository().save(item);
  }

  public void update(final T item) {
    getRepository().save(item);
  }

  public void delete(final T item) {
    final T itemFound = getRepository().getReferenceById(item.getId());
    getRepository().delete(itemFound);
  }

  public void deleteById(final Long id) {
    final T itemFound = getRepository().getReferenceById(id);
    getRepository().deleteById(id);
  }

  @Transactional(readOnly = true)
  public boolean exists(final T item) {
    return getRepository().existsById(item.getId());
  }

  @Transactional(readOnly = true)
  public T get(final Long id) {
    T item = getRepository().findById(id).orElseThrow();
    return item;
  }

  @Transactional(readOnly = true)
  public List<T> findAll() {
    return getRepository().findAll();
  }

  @Transactional(readOnly = true)
  public Long count() {
    return getRepository().count();
  }
}
