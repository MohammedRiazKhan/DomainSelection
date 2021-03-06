package com.amoo.repository.Impl.tickets;

import com.amoo.domain.Tickets.Ticket;
import com.amoo.repository.IRepository;

import java.util.Set;

public interface TicketsRepository extends IRepository<Ticket, Integer> {
    Set<Ticket> getAll();
}
