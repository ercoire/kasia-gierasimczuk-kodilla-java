package com.kodilla.patterns.strategy.social;


public sealed class User permits Millenials, YGeneration, ZGeneration {


    private final String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setSharingStrategy(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String sharePost(){
       return socialPublisher.share();
    }
}
