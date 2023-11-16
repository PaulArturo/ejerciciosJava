/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repaso.ej4;

/**
 *
 * @author Usuario
 */
public enum operations {
    PIEDRA {
        public boolean beats(operations other) {
            return other == TIJERAS;
        }
    },
    PAPEL {
        public boolean beats(operations other) {
            return other == PIEDRA;
        }
    },
    TIJERAS {
        public boolean beats(operations other) {
            return other == PAPEL;
        }
    };

    public abstract boolean beats(operations other);
}
