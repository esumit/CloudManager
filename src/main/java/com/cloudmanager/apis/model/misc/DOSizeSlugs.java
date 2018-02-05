package com.cloudmanager.apis.model.misc;


public enum DOSizeSlugs {
    HALFGB
     {
        @Override
        public String toString() {
            return "512mb";
        }
    },
    ONEGB{
        @Override
        public String toString() {
            return "1gb";
        }
    },
    TWOGB {
        @Override
        public String toString() {
            return "2gb";
        }
    },
    THREEGB{
        @Override
        public String toString() {
            return "3gb";
        }
    },
    FOURGB{
        @Override
        public String toString() {
            return "4gb";
        }
    },

    EIGHTGB{
        @Override
        public String toString() {
            return "8gb";
        }
    }
 }
