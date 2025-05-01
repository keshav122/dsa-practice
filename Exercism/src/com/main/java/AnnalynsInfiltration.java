package com.main.java;

//Booleans practice
public class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        // fast attack can be performed onlyif knight is sleeping
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        // They can be spied upon if atleast one of the group is awake
        return (knightIsAwake || archerIsAwake || prisonerIsAwake);
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return (prisonerIsAwake && !archerIsAwake);
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake,
            boolean petDogIsPresent) {
        return petDogIsPresent ? (!archerIsAwake) : (prisonerIsAwake && (!knightIsAwake && !archerIsAwake));
    }
}
