package com.github.annasperendio.states.service;

public final class Validation {

    // Método para validar as 5 regiões possíveis de serem cadastradas.
    public static String validation (String region) {
        if (region.equalsIgnoreCase("Norte") || region.equalsIgnoreCase("Sul") || region.equalsIgnoreCase("Nordeste")
            || region.equalsIgnoreCase("Sudeste") || region.equalsIgnoreCase("Centro-Oeste")){
            String cap = region.substring(0, 1).toUpperCase() + region.substring(1).toLowerCase();
            return cap;

        } else {
            throw new IllegalArgumentException("Região inválida");
        }
    }
}
