package challenge.service;

import challenge.jpa.entities.Subscription;
import challenge.jpa.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;


    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription newSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription getSubscriptionById(Long id) {

        return subscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public Subscription updateSubscription(Subscription updatedSubscription, Long id) {

        Optional<Subscription> optSubscription = subscriptionRepository.findById(id);

        if (optSubscription.isPresent()) {

            Subscription subscription = optSubscription.get();
            subscription.setEmail(updatedSubscription.getEmail());
            subscription.setFirstName(updatedSubscription.getFirstName());
            subscription.setGender(updatedSubscription.getGender());
            subscription.setDateOfBirth(updatedSubscription.getDateOfBirth());
            subscription.setFlagOfConsent(updatedSubscription.getFlagOfConsent());
            subscription.setIdCampaign(updatedSubscription.getIdCampaign());
            return subscriptionRepository.save(subscription);
        } else {
            return null;
        }
    }

    @Override
    public Subscription deleteSubscription(Long subscriptionId) {

        Optional<Subscription> optSubscription = subscriptionRepository.findById(subscriptionId);
        if (optSubscription.isPresent()) {
            subscriptionRepository.deleteById(subscriptionId);
            return optSubscription.get();
        } else return null;
    }
}
