package com.fastrackit.countriesapplication.exception;



import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private int entityId;       //retin id-ul de la inreg care a dat eroare/n-a fost gasita
    //se va apela la metoda GetById cand dau un id care nu exista
    public ResourceNotFoundException(String message, int entityId) {
        super(message);
        this.entityId = entityId;
    }
}