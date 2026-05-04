package com.turkcell.library_cqrs.persistence.repository;

import java.util.UUID;

public interface BookCopyStatusView {

    UUID getId();
    String getStatus();
}
