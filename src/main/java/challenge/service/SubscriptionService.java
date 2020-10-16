package challenge.service;

import challenge.jpa.entities.Subscription;

import java.util.List;

public interface SubscriptionService {
    public List<Subscription> findAll();
    public Subscription newSubscription(Subscription subscription);
    Subscription getSubscriptionById(Long id);
    public Subscription updateSubscription(Subscription updateSubscription, Long id);
    public Subscription deleteSubscription(Long subscriptionId);
}
