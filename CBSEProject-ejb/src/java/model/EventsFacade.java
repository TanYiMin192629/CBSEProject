/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Events;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chaiq
 */
@Stateless
public class EventsFacade extends AbstractFacade<Events> {
    @PersistenceContext(unitName = "CBSEProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventsFacade() {
        super(Events.class);
    }
    
}
