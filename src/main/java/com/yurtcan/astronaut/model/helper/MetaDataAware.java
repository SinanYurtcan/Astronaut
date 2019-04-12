package com.yurtcan.astronaut.model.helper;

import java.util.Date;

public interface MetaDataAware {

  Date getCreationDate();

  void setCreationDate(Date creationDate);

  Date getModificationDate();

  void setModificationDate(Date modificationDate);

  Long getCreatedBy();

  void setCreatedBy(Long createdBy);

  Long getModifiedBy();

  void setModifiedBy(Long getModifiedBy);

}
