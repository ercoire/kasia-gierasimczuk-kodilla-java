package com.kodilla.patterns.strategy;

public sealed interface BuyPredictor
permits AggressivePredictor, BalancedPredictor, ConservativePredictor {

    String predictWhatToBuy();
}
