package com;

public enum Role {
    USER() {
        @Override
        public String toString() {
            return "User";
        }
    },
    ADMIN() {
        @Override
        public String toString() {
            return "Admin";
        }
    },
    ROOT() {
        @Override
        public String toString() {
            return "Root";
        }
    };



}
