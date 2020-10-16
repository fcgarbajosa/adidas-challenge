package challenge.web.controllers;

import challenge.jpa.entities.Subscription;
import challenge.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/subscriptions")
    List<Subscription> findAll() {

        return subscriptionService.findAll();
    }

    @PostMapping("/subscription")
    Subscription newSubscription(@RequestBody Subscription subscription) {

        return subscriptionService.newSubscription(subscription);
    }

    @GetMapping("/subscription/{id}")
    Subscription getSubscriptionById(@PathVariable Long id) {

        return subscriptionService.getSubscriptionById(id);
    }

    @PutMapping("/subscription/{id}")
    Subscription updateSubscription(@RequestBody Subscription updatedSubscription, @PathVariable Long id) {

        return subscriptionService.updateSubscription(updatedSubscription, id);
    }

    @DeleteMapping("/subscription/{id}")
    Subscription deleteSubscription(@PathVariable Long id) {

        return subscriptionService.deleteSubscription(id);
    }

}
